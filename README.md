基于遥感影像的海岸线动态监测系统的服务端模块设计
==========================================================

本源码包括服务端和前端，服务端采用SpringBoot编写，前端使用jQuery和Bootstrap编写

# 建表
本项目建表语句在`src\main\resources\建表语句\area.sql`，目前只有一张表

# 编译
1. 本项目为maven项目，编译前确认系统已安装maven
2. 本项目需要引用opencv-341.jar（已经由pom加载）
3. 本项目需要启动时链接dll库

执行命令`mvn package -Dmaven.test.skip`进行打包
# 启动
运行项目只需运行jar包，内置tomcat,端口如不指定，默认80
`java -jar -[包路径] --server.port=80 --dll.dir=[opencv_java341.dll的路径]`