### Document

http://courses.coreservlets.com/Course-Materials/struts.html
https://people.apache.org/~germuska/struts-taglib/docs/tlddoc/bean/tld-summary.html
https://people.apache.org/~germuska/struts-taglib/docs/tlddoc/logic/tld-summary.html
http://javaonlineguide.net/2014/06/beandefine-tag-in-struts-with-example.html
https://www.mkyong.com/struts/struts-logic-iterate-example/

---

### taglib

```ts
<logic:notEmpty name="KICS021Form" property="errorMsg">
KICS021Form => Jsp bean
errorMsg => the property (of the bean specified by the name attribute
https://people.apache.org/~germuska/struts-taglib/docs/tlddoc/logic/notEmpty.html

https://people.apache.org/~germuska/struts-taglib/docs/tlddoc/html/tld-summary.html
<html:hidden property="errorMsg" write="true" />
the hidden element is created.

<bean:define id="empty" value="true" />
Create a new attribute (in the scope specified by the toScope property, if any), and a corresponding scripting variable
https://people.apache.org/~germuska/struts-taglib/docs/tlddoc/bean/define.html
http://javaonlineguide.net/2014/06/beandefine-tag-in-struts-with-example.html

<bean:define id=”uid” value=”admin” type=”java.lang.String” toScope=”request” />

to write/print the  value of uid
<bean:write name=”uid” />
or
<%=uid%>

<html:hidden property="Status" />
Status: the name of the corresponding bean property

https://docs.liferay.com/portal/7.0-ga7/
https://docs.liferay.com/portal/7.0-ga7/taglibs/util-taglib/
```
