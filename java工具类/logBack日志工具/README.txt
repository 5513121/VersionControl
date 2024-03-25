Java012-Logback日志框架下载、使用以及日志级别
一、Logback下载
一般情况，Logback日志框架只需要下载slf4j-api、logback-core、logback-classic这三个jar包即可。

（一）快捷下载方法
slf4j-api-1.7.26.jar官网下载链接：
https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.26/
logback-core-1.2.3.jar官网下载链接：
https://repo1.maven.org/maven2/ch/qos/logback/logback-core/1.2.3/
logback-classic-1.2.3.jar官网下载链接：
https://repo1.maven.org/maven2/ch/qos/logback/logback-classic/1.2.3/

（二）具体下载方法
Logback官网：https://logback.qos.ch/
二、Logback简单使用
1）在项目下新建文件夹lib，导入Logback的相关jar包到该文件夹下，并添加到项目依赖库中去。
右键点击模块名，点击new，点击Directory，新建文件夹lib（lib与src并列）；
将下载到的三个jar包全部赋值粘贴到lib文件夹中；

全选这三个jar包，右键，点击Add as Library…

成功添加jar包到项目依赖库中，会出现这种箭头。


2）将Logback的核心配置文件logback.xml直接拷贝到src目录下（必须是src目录下）。
若已有logback.xml文档，则直接拷贝到src目录下；
若没有logback.xml文档，则创建一个即可，具体方法如下：在桌面新建一个文档；
打开新建文本文档，将以下内容复制粘贴到文档中（其中，日志文件的输出地址需修改成自己的）

将新建文本文档.txt改名为logback.xml


3）在代码中获取日志的对象与使用
获取日志对象Logger logger = LoggerFactory.getLogger(“类名”); 一般在类名后加.class

    //一般将日志对象定义成常量
    public static final Logger LOGGER = LoggerFactory.getLogger("LogbackTest.class");//类名一般写类名.class
    public static void main(String[] args) {
        LOGGER.error("出错啦error");
        LOGGER.warn("警告！warn");
        LOGGER.info("收账啦info");
        LOGGER.debug("没出错！debug");
        LOGGER.trace("跟踪中trace");
    }
1
2
3
4
5
6
7
8
9
4）使用日志对象输出日志信息
在控制台中输出

在日志文件中输出


三、日志输出级别
level可等于TRACE、DEBUG、INFO、WARN、ERROR、ALL、OFF或不写。
作用：用于控制系统中哪些日志级别是可输出的。
规则：
1）级别：TRACE<DEBUG<INFO<WARN<ERROR（可以忽略大小写）；
2）默认级别是debug（即可不写level=“DEBUG”）；
3）只输出不低于当前级别的日志；
4）ALL和OFF分别是打开全部日志和关闭全部日志。
————————————————

                            版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
                        
原文链接：https://blog.csdn.net/xinlovechan/article/details/128160442