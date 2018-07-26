# JDApp-launcher
The Java standalone Dubbo App (JDApp) launcher base on jf and jf-ext3

# 配置
```
$ cp jdapp-launcher.sh.example jdapp-launcher.sh
$ cp jfinal-ext3/conf/jf-app-cfg.conf.example conf/jf-app-cfg.conf
$ cp conf/log4j.properties conf/log4j.properties
$ sh cplibs.sh
```

# JDApp 结构

```bash
.
├── conf
│   ├── jf-app-cfg.conf or contains in services.jar
│   ├── dubbo.properties
│   ├── log4j.properties or contains in services.jar
│   ├── application.jdapp
│   ├── jdapp-daemon{id}.pid
│   └── {jf-app-cfg.conf:app.name}-provider.xml or contains in services.jar
├── jdapp-launcher.sh
├── lib
│   ├── *dependency libs
│   ├── cglib-nodep-3.2.5.jar
│   ├── commons-collections-3.2.2.jar
│   ├── commons-lang3-3.1.jar
│   ├── commons-pool2-2.4.2.jar
│   ├── druid-1.1.10.jar
│   ├── guava-18.0.jar
│   ├── jdapp-launcher-0.0.1.jar
│   ├── jfinal-3.4.jar
│   ├── jfinal-ext3-3.0.6.jar
│   ├── log4j-1.2.17.jar
│   ├── mysql-connector-java-8.0.11.jar
│   └── protobuf-java-2.6.0.jar
└── services
    ├── service-1.jar
    ├── service-2.jar
    └── service-models.jar

```
# conf配置说明

- 方案一： service.jar不包含conf，那在conf目录下放入对应的jf-app-cfg.conf等配置文件;
- 方案二： service.jar包含conf，这样就不必在conf目录下发任何配合文件。【推荐：实际生产中，也很少只修改配置文件，涉及到修改时，也必定需要重新部署新的服务。】

# 运行 JDApp

``` sh jdapp-laucher.sh start|stop id```

# Demo

- download zookeper, ``` mv zoo_sample.cfg zoo.cfg```
- Provider: run DemoProvider.java
- Consumer: run DemoConsumer.java
