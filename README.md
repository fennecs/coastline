基于遥感影像的海岸线动态监测系统的服务端模块设计
==========================================================

本源码包括服务端和前端，服务端采用SpringBoot编写，前端使用jQuery和Bootstrap编写

# 建表
本项目使用mysql，建表语句在`src\main\resources\建表语句\area.sql`，目前只有一张表

# 运行环境
jdk8+

# 编译
1. 本项目为maven项目，编译前确认系统已安装maven
2. 本项目需要引用opencv-341.jar（已经由pom加载）
3. 本项目需要启动时链接dll库

确保当前路径在源码根目录，执行命令`mvn clean install -Dmaven.test.skip`进行打包, 生成的jar在当前target目录下
# 启动
运行项目只需运行jar包，内置tomcat,端口如不指定，默认80  
`java  -Djava.library.path=[opencv_java341.dll的目录路径] -jar [包路径] --server.port=80`
如：  
`java -Djava.library.path=C:\Users\39058\IdeaProjects\coastline\opencv\x64 -jar target\coastline-0.0.1-SNAPSHOT.jar --server.port=80
`