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

https://portal.liferay.dev/download

http://serwis.kampus.uj.edu.pl/cds/books/Liferay.in.Action.pdf
http://trip.sk/books/practical-liferay-java-based-portal-applications-development.9781430218470.46790.pdf
https://riptutorial.com/Download/liferay.pdf
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

## Connect db

Create schema: liferay_test

jdbc:mysql://localhost/liferay_test?characterEncoding=UTF-8&dontTrackOpenResources=true&holdResultsOpenOverStatementClose=true&serverTimezone=GMT&useFastDateParsing=false&useUnicode=true
com.mysql.jdbc.Driver
root - 1234
![](../../root/img/2019-12-09-21-14-38.png)

https://liferay.dev/forums/-/message_boards/message/2291883
portal-ext.properties

```.properties
jdbc.default.driverClassName=com.mysql.jdbc.Driver
jdbc.default.url=jdbc:mysql://localhost/liferay_test?useUnicode=true&characterEncoding=UTF-8&useFastDateParsing=false
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

Chi check o local sevice
![](../../root/img/2019-12-09-23-06-56.png)

input table name => add columns

input namespace
employservice/ buildService

vao file gradle cua portlet them

```
	compile group: 'org.osgi', name: 'org.osgi.core', version: '4.3.0'

	compile project: ("modules:employeeservice:employeeservice-api")

```

![](../../root/img/2019-12-12-01-53-57.png)
CTRL F5

build maven: https://books.sonatype.com/m2eclipse-book/reference/running-sect-running-maven-builds.html

clean install
![](../../root/img/2019-12-09-23-10-57.png)

## liferay 7.0 DXP

https://www.youtube.com/watch?v=SIZEJpTFNDU&list=PL_WCPOWW_gJFx8atHLNCGmOc6iVbnxv7E&index=3

Start server
Use gradle to deloy portlet
move file jar in bundles to deloy folder of server

Go go shell command
![](../../root/img/2019-12-11-21-47-53.png)
control panel/ turn on telnet
![](../../root/img/2019-12-11-21-48-57.png)
telnet localhost 11311
help
lb
stop 32
start 32
osgi service lifecycle

Resolve bundle: https://mvnrepository.com/artifact/org.osgi/org.osgi.core/4.3.0

Add:

```.gradle
// https://mvnrepository.com/artifact/org.osgi/org.osgi.core
compile group: 'org.osgi', name: 'org.osgi.core', version: '4.3.0'
// xem C:\Users\phuong\.gradle\caches\modules-2\files-2.1\org.osgi\org.osgi.core
```

hello/build/ chon build gradle

Add class

```java
package com.vn.portlet;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class HelloActivator implements BundleActivator{

	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Start======");

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Stop=======");

	}

}

```

![](../../root/img/2019-12-11-23-21-07.png)  
Xong r deloy lai
D:\Source\Spring\liferaywork\sample-work\bundles\osgi\modules neu tao moi
hay nam trong hello/build/lib/ hello.1.0.0 neu nam trong work space
hay Right click trong eclipe r open go go shell tai tab server

Workspace
https://portal.liferay.dev/download

Connect to db
![](../../root/img/2019-12-12-00-54-33.png)

**Auto deloy**
gradle.properties

```
liferay.workspace.home.dir=D://Source//Spring//liferay-ce-portal-7.2.1-ga2
```

vao servicetest buildService trong gradle

## Lifecycle

https://www.journaldev.com/4732/portlet-lifecycle
https://livebook.manning.com/book/portlets-in-action/chapter-2/36
https://www.opensource-techblog.com/2014/12/introduction-to-portlet-phases-and.html

Full:
https://www.opensource-techblog.com/complete-liferay-guide

## Definition

1. Portlet :- its web component just like servlet, provide specific functionality. It is rendered small portion of page to form complete composite web page.

### Portlet Phases

Following methods represents these portlet phases. These methods are known as Lifecycle of Portlet.

init()
This method will be called when portlet is deployed and instantiated by portlet container.
render()
This method will be called to render the content. Represent Render phase.
processAction()
This method will be called when any action performed.
processEvent()
This method will be called when any event is triggered.
serveResource()
This method will be called when any resource is served with resource URL.
destroy()
This method will be called when portlet is un-deployed by portlet container.

Before moving further, I would like to share some brief characteristics of portlet.

1. Mode :- Portlet has various modes like View,Edit and Help. Portlet renders its output inView mode.
2. Phase:- Portlet has various phases like Render phase, Action phase, Serve Resource phase, Event phase etc.
