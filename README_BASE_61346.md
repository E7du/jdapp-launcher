# JDApp-launcher
The Java standalone Dubbo App (JDApp) launcher base on jf and jf-ext3

# 配置
```
$ cp jdapp-launcher.sh.example jdapp-launcher.sh
$ cp conf.bak/jf-app-cfg.conf conf/jf-app-cfg.conf
$ cp conf/log4j.properties conf/log4j.properties
$ sh cplibs.sh
```

# JDApp 结构

```bash
.
├── conf
│   ├── jf-app-cfg.conf
│   ├── dubbo.properties
│   ├── log4j.properties
│   ├── application.jdapp
│   ├── jdapp-daemon{id}.pid
│   └── {jf-app-cfg.conf:app.name}-provider.xml
├── jdapp-launcher.sh
├── lib
│   ├── *dependency libs
│   ├── cglib-nodep-3.2.5.jar
│   ├── commons-collections-3.2.2.jar
│   ├── commons-lang3-3.1.jar
│   ├── commons-pool2-2.4.2.jar
│   ├── cos-2017.5.jar
│   ├── druid-1.1.10.jar
│   ├── guava-18.0.jar
│   ├── jf-standalone-launcher-0.0.1.jar
│   ├── jfinal-3.4.jar
│   ├── jfinal-ext3-3.0.2-SNAPSHOT.jar
│   ├── log4j-1.2.17.jar
│   ├── mysql-connector-java-8.0.11.jar
│   └── protobuf-java-2.6.0.jar
└── services
    ├── service-1.jar
    ├── service-2.jar
    └── service-models.jar

```
# 运行 JDApp

``` sh jdapp-laucher.sh start|stop id```

# Demo

- download zookeper, ``` mv zoo_sample.cfg zoo.cfg```
- Provider: run DemoProvider.java
- Consumer: run DemoConsumer.java
