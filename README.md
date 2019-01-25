# @todo

+ 当前通过Feign调用的事务并没有在服务之间进行传递


# 0.1.0版本使用问题

在自己分支中，修改了相关代码。（代码细节还不是很熟）

[fescar-krt](https://github.com/kiterunner-t/fescar.git)

+ fescar在SelectForUpdateExecutor中ResultSet类型异常，应为Boolean。
+ fescar拦截了所有底层异常Throwable，导致异常信息丢失。

其他问题

+ fescar使用来的druid 1.1.12版本，而我的项目中使用了更低版本，运行过程中代码不兼容报空指针异常。
+ fescar目前不支持SQL别名。
+ fescar目前不支持表有多个主键。


# 使用

+ 创建mysql数据库fescar-spring-cloud
+ 初始化数据库 doc/db/init.sql
+ 运行下面模块
    + fescar-server
    + eureka
    + equipment

启动之前，需要在equipment模块下的application.conf配置fescar-server的地址。（不修改的话，使用默认地址即可）。fescar的服务发现，貌似还不支持Eureka，因此，这里通过静态文件配置。

通过swagger-ui就可以访问接口。

http://127.0.0.1:8098/swagger-ui.html

在swagger界面输入，可以试试。

```
hmiId            1
equipmentIdList	 [1]
```

