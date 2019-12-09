## Config liferay

https://portal.liferay.dev/docs/7-0/tutorials/-/knowledge_base/t/installing-liferay-ide
https://liferay.dev/project/-/asset_publisher/TyF2HQPLV1b5/content/ide-installation-instructions
drag
cai tomcat 7 admin admin
add server => link jdk
start time 9000
https://www.youtube.com/watch?v=QzGSAsYnFYM

Liferay MVC Portlet
https://portal.liferay.dev/docs/7-0/tutorials/-/knowledge_base/t/liferay-mvc-portlet
https://portal.liferay.dev/docs/7-0/tutorials/-/knowledge_base/t/setting-proxy-requirements-for-liferay-ide

https://docs.liferay.com/ce/portal/7.0-latest/definitions/liferay-portlet-app_7_0_0.dtd.html#instanceable

https://www.youtube.com/watch?v=EMeIwChHByo

https://portal.liferay.dev/docs/7-0/tutorials/-/knowledge_base/t/creating-modules-with-liferay-ide

- Component live in modules, just implement form interface
- register a service as an OSGi service

https://viblo.asia/p/introduce-liferay-portal-aRBvXnaaeWE
https://proliferay.com/writing-your-first-osgi-service-in-liferay-7/
https://www.sitepoint.com/how-to-inject-osgi-dependencies-in-custom-portlets-in-liferay-7/
https://www.journaldev.com/5103/liferay-tutorial-portal-portlet
http://roufid.com/liferay/

---

## download

Must install Java

https://www.liferay.com/downloads-community

https://portal.liferay.dev/docs/7-0/tutorials/-/knowledge_base/t/installing-liferay-ide

https://liferay.dev/project/-/asset_publisher/TyF2HQPLV1b5/content/ide-installation-instructions

![](../../root/img/2019-12-09-20-27-10.png)

![](../../root/img/2019-12-09-20-30-14.png)

![](../../root/img/2019-12-09-20-39-02.png)

![](../../root/img/2019-12-09-20-39-28.png)

![](../../root/img/2019-12-09-20-40-12.png)

![](../../root/img/2019-12-09-20-40-38.png)

![](../../root/img/2019-12-09-20-40-53.png)

![](../../root/img/2019-12-09-20-42-14.png)

![](../../root/img/2019-12-09-20-42-34.png)

![](../../root/img/2019-12-09-20-43-02.png)

![](../../root/img/2019-12-09-20-43-56.png)

![](../../root/img/2019-12-09-20-44-22.png)

File new liferay modules project
sample-portlet -> choose Maven

com.vn
![](../../root/img/2019-12-09-20-45-23.png)

![](../../root/img/2019-12-09-20-48-20.png)

![](../../root/img/2019-12-09-20-51-15.png)

Set 9000: click dup
![](../../root/img/2019-12-09-20-52-19.png)

Drag and drop project to run
vao web/ add/ widget/ see Project Sample

![](../../root/img/2019-12-09-21-00-04.png)

![](../../root/img/2019-12-09-21-00-29.png)

Create schema: liferay_test

jdbc:mysql://localhost/liferay_test?characterEncoding=UTF-8&dontTrackOpenResources=true&holdResultsOpenOverStatementClose=true&serverTimezone=GMT&useFastDateParsing=false&useUnicode=true
com.mysql.jdbc.Driver
root - 1234
![](../../root/img/2019-12-09-21-14-38.png)

https://liferay.dev/forums/-/message_boards/message/2291883
portal-ext.properties

```.properties
jdbc.default.driverClassName=com.mysql.jdbc.Driver
jdbc.default.url=jdbc:mysql://localhost/liferay52?useUnicode=true&characterEncoding=UTF-8&useFastDateParsing=false
jdbc.default.username=root
jdbc.default.password=password (not the real one)
```

Download mysql connector java
https://dev.mysql.com/downloads/connector/j/5.1.html

![](../../root/img/2019-12-09-22-40-59.png)

Create service
![](../../root/img/2019-12-09-22-56-18.png)

![](../../root/img/2019-12-09-22-58-46.png)

![](../../root/img/2019-12-09-22-58-57.png)
Gom api and sevice
file service.xml add entities
![](../../root/img/2019-12-09-23-03-53.png)
