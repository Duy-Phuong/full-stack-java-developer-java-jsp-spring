## Để build được Web project trong eclipse chúng ta tiến hành cài đặt môi trường như sau:

+Setting JDK cho eclipse
Trên Preferences chon “Java/Installed JREs” click button Add
C:\Program Files (x86)\Java\jdk1.6.0_30 Check vào JDK vừa chọn và click OK
C:\Program Files (x86)\Java\jre6

### a) Setting JDK cho Tomcat

Trên Preferences chon “Tomcat/JVM Setting” trên JVM Setting chọn JDK đã setting .

### b) Chọn version Tomcat

Ở đây ta chọn Tomcat version 5 (apache-tomcat-5.5.33)
Cấu hình file web.xml (Lưu ý : file web.xml phải được đặt trong thư mục WEB-INF)

- Định nghĩa Context cho Server Tomcat
  Click phải vào project Sample_Servlet_JSP chọn “Tomcat project/Update context definition”

- Kiểm Tra file Context vừa định nghĩa
  Vào thư mục tomcat chọn folder “conf/Catalina/localhost” , kiểm tra xem có file Sample_Servlet_JSP.xml không, nếu có thì tiếp tục thực hiện bước tiếp theo

- Run project Tomcat
  Trên trình duyệt gõ : http://localhost:8080/Sample_Servlet_JSP/WelcomePW để thực thi servlet

## Training Servlet-JSP phần 2 , tài liệu này bao gồm :

- JSP scripting elements
- Cách thức để Servlet nhận tham số từ JSP
- Phân biệt giữa getParameter() và getAttribute() của đối tượng HttpRequest
- Các biến có sẵn trong trang JSP
- Các Action chuẩn trong JSP
- Quy ước của JavaBean,sử dụng JavaBean trong JSP
- Sử dụng HttpSession

### 1. JSP Scripting Element

    Các scripting element trong JSP cho phép chúng ta chèn các mã vào serlvet mà sẽ được phát sinh từ trang jsp. Có ba dạng sau :

- Biểu thức có dạng <%=expression%>
- Scriplet có dạng <% code %>
- Khai báo có dạng <%! Code %>

#### 1.1 Sample <%=expression%>

HIển thị ngày tháng năm trên jsp:

```java
          <%= new java.util.Date()%>

```

#### 1.2 Sample <% code %>

Xử lý vòng lặp for và in ra 5 button trên trang jsp

```java
          <%
              for(int i = 0 ; i < 5 ; i++){  // mở vòng lặp for
          %>
              <input type=”button”/>
          <%
          }   //đóng vòng lặp for
          %>

```

#### 1.3 Sample <%! Code %>

Khai báo biến a kiểu Integer trên trang jsp

          <%! private int a = 1 ; %>

### 2. Cách thức để Servlet nhận tham số từ JSP

    Để Servlet nhận tham số từ JSP thì ta sử dụng đối tượng HttpRequest cụ thể:
    rquest.getParameter(tên tham số);
    Chúng ta viết một sample nhập giá trị vào textbox trên jsp và truyền giá trị vừa nhập lên cho servlet.

#### 2.1 Tạo trang jsp với nội dung :

```html
<form action="servlet" cần gọi” method="get">
  <input type="text" name="txtInput" />
  <input type="submit" value="Click" here” />
</form>
```

#### 2.2 Tạo 1 servlet sử dụng phương thức get:

```java
String str = request.getParameter(“txtInput”); // thực hiện lấy tham số từ jsp

```

### 3. Phân biệt giữa request.getParameter() và request.getAttribute() của đối tượng HttpRequest

Phần hướng dẫn này cần thiết khi các bạn cần truyền và nhận tham số giữa JSP và Servlet , cụ thể phân biệt như sau:

#### 3.1 request.getParameter()

Khi một trang JSP truyền tham số đi thì tại Servlet hoặt một trang JSP khác muốn nhận tham số đó thì phải sử dụng:
request.getParameter(“tên tham số”);
Xem phần (2. Cách thức để Servlet nhận tham số từ JSP) và một ví dụ khác sau đây

##### 3.1.1 Tạo một trang “index.jsp” với nội dung sau:

```html
<form action="test.jsp" method="get">
  <input type="text" name="txtInput" />
  <input type="submit" value="Click" here” />
</form>
```

##### 3.1.2 Tạo một trang “test.jsp” để nhận tham số

```html
<body>
  <% String str = request.getParameter(“txtInput”); %> <%=str%> //in tham số vừa
  lấy được
</body>
```

#### 3.2 request.getAttribute()

Khi một Servlet muốn truyền tham số (sử dụng request.setAttribute()) thì tại trang JSP hoặc một Servlet khác muốn nhận tham số thì phải sử dụng :
Request.getAttribute(“tên tham số”);
Hãy làm một ví dụ sau : Tạo ra một servlet truyền tham số và một trang JSP nhận tham số

##### 3.2.1 Tạo ra một servlet với nội dung sau :

```java
request.setAttribute(“param”,”Welcome”); // truyền tham số “param” với giá trị là “Value”
request.getRequestDispatcher(“index.jsp”).forward(request,response)

```

##### 3.2.2 Tạo trang “index.jsp” để lấy tham số.

```html
<body>
  <% String str = request.getAttribute(“param”); %> <%=str%> //in tham số vừa
  lấy được
</body>
```

### 4. Các biến có sẵn trong trang JSP

Nhiều bạn thắc mắc tạo sao trong trang JSP mình không có khai báo biến request và response nhưng vẫn sử dụng được như trên Servlet. Thực chất đó là các biến có sẵn trong JSP,để đơn giản hóa mã trong các biểu thức hay scriptlets trong JSP người ta đã cung cấp cho chúng ta 9 đối tượng đã định nghĩa trước đó

- request
  Biến này có kiểu là javax.servlet.http.HttpServletRequest
- response
  Biến này có kiểu là javax.servlet.http.HttpServletResponse
- out
  Biến này có kiểu là javax.servlet.jsp.JspWriter (giống PrintWriter mà chúng ta sử dụng)
- session
  Biến này có kiểu là javax.servlet.http.HttpSession
- application
  Biến này có kiểu là javax.servlet.ServletContext
- config
  Biến này có kiểu là javax.servlet.ServletConfig
- pageContext
  Biến này có kiểu là javax.servlet.jsp.PageContext
- page
  Biến này giống như biến “this” để chỉ trang hiện tại đang thao tác
- exception
  Biến này có kiểu java.lang.Throwable

Trong trang JSP chúng ta thường sử dụng nhất là các biến như : request , response,session.

### 5. Các Action chuẩn trong JSP

Actions là các elements được định nghĩa trong bản đặc tả của JSP và luôn có sẵn trong các file JSP mà không cần import vào bất cứ thứ gì.Ta có tổng cộng 9 action chuẩn:

    + jsp:include
    + jsp:useBean
    + jsp:setProperty
    + jsp:getProperty
    + jsp:plugin
    + jsp:forward
    + jsp:fallback
    + jsp:prarams
    + jsp:param

Sau đây là các sample về các Action chuẩn thường được sử dụng nhiều nhất

#### 5.1 Sample jsp:include

Dùng để include các file khác vào thời điểm request (chẳng hạn như các file JSP khác).
Hãy làm 1 sample sau : tạo 1 trang “index.jsp” và include 2 trang “File1.jsp” và File2.jsp“”

##### 5.1.1 Tạo trang “index.jsp” với nội dung sau:

        <h3>Đây là trang Index.jsp</h3>
        <jsp:include page=”File1.jsp”/>
        <jsp:include page=”File2.jsp”/>

##### 5.1.2 Tạo trang “File1.jsp” với nội dung sau:

```html
<h5>Đây là trang File1.jsp</h5>
```

##### 5.1.3 Tạo trang “File2.jsp” với nội dung sau:

```html
<h5>Đây là trang File2.jsp</h5>
```

Hãy chạy trang index.jsp sẽ hiển thị luôn cả thông tin của 2 trang File1.jsp và File2.jsp

#### 5.2 Sample jsp:useBean , jsp:setProperty , jsp:getProperty

Chúng ta sẽ xem trình bày ở phần “6 . Quy ước của JavaBean , sử dụng JavaBean trong JSP ”

#### 5.3 Sample jsp:forward

Khi bạn muốn di chuyển từ trang “index.jsp” đến trang “welcome.jsp” bạn sẽ sử dụng jsp:forward trên trang “index.jsp” cụ thể:

```html
<jsp:forward page="welcome.jsp" />
```

#### 5.4 Sample jsp:params , jsp:param

Thường thì jsp:param được dùng trong các action như jsp:include,jsp:forward để truyền tham số đến những trang jsp khác
Chúng ta hãy làm 1 sample là : tại trang “index.jsp” sẽ include trang “File1.jsp” và truyền tham số cho trang này

##### 5.4.1 Tạo trang “index.jsp” với nội dung như sau

```html
<jsp:include page=”File1.jsp”>
<jsp:param name=”param1” value=”value1”/>
<jsp:param name=”param2” value=”value2”/>
</jsp:include page=”File1.jsp”>

```

##### 5.4.2 Tạo trang “File1.jsp” với nội dung như sau

<%=request.getParameter(“param1”)%>
<%=request.getParameter(“param2”)%>
Hãy chạy ứng dụng màn hình sẽ hiển thị giá trị của 2 tham số

### 6. Quy ước của JavaBean , sử dụng JavaBean trong JSP

Bean cũng là class Java thông thường và JSP có thể tương tác với các class java này.
Khi định nghĩa 1 bean ta cần tuân theo các quy tắc:

- Tên class Bean phải có tiếp ngữ là Bean (ví dụ :UserBean).Thật sự quy tắc này cũng không bắt buộc + Một Bean phải có hàm tạo không có đối số
- Bean không nên có bất kỳ thể hiện nào là public
- Các giá trị được truy cập thông qua phương thức getXxx,setXxx
  Chúng ta làm một sample sau : tạo 1 class JavaBean , cho 1 jsp thay đổi giá trị của một thuộc tính trong class JavaBean và in ra lại trên màn hình

#### 6.1 Tạo ra một class SinhVien.java(java bean) với nôi dung sau

```java
package sample.bean
public class SinhVien {
private String nameSV;
//tạo thêm các phương thức get và set cho nameSV
}

```

#### 6.2 Tạo ra một trang “index.jsp” với nội dung sau

```html
<jsp:useBean id="sv" class="sample.bean.SinhVien" scope="request">
  <jsp:setProperty name=”sv” property=”nameSV” value=”Ta la Ma”
</jsp:useBean>
//Hiển thị thông tin vừa thay đổi (cách 1)
<jsp:getProperty name="sv" property="nameSV" />
//Hiển thị thông tin vừa thay đổi (cách 2) <%=sv.getNameSV%>
```

### 7. Sử dụng HttpSession

    Những bạn lập trình Web có lẽ đã quen với khái niệm về Session.Trong Java để tạo và lấy thông tin session ta sẽ thực hiện như sau

#### 7.1 Tạo Session

        HttpSession session = request.getSession(true);
        session.setAttribute(“param”,”value”);

#### 7.2 lấy thông tin trên session

        session.getAttribute(“param”);

**Lời kết**: những thông tin và sample trên chỉ là những phần cơ bản, các anh chị có thể dựa trên đó để tìm hiểu thêm.Chúc thuận lợi

https://www.javatpoint.com/jsp-action-tags-forward-action
https://beginnersbook.com/2013/05/jsp-tutorial-introduction/
https://www.studytonight.com/jsp/jsp-action-element.php
