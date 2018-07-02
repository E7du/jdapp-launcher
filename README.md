# jf-standalone-launcher

# 配置
- launcher.sh.example -> launcher.sh
- cp jf-ext3 : jf-app-cfg.conf.example -> jf-app-cfg.conf
- cp jf-ext3: log4j.properties.example -> log4j.properties
- 确保 jf-app-cfg.conf中的app.name与 launcher.sh中的APP名字一致
- 运行 ``` sh cplibs.sh```

# Standalone App 结构

```bash
.
├── conf
│   ├── jf-app-cfg.conf
│   └── launcher-provider.xml
├── dubbo.properties
├── launcher.sh
├── lib
│   ├── *
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
├── log4j.properties
├── logging.properties
└── services
    ├── service-1.jar
    ├── service-2.jar
    └── service-models.jar

```
# 运行 Standalone App

``` sh laucher.sh start|stop id```
