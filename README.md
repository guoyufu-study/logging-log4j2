# [Apache Log4j 2](https://logging.apache.org/log4j/2.x/)

Apache Log4j 2 是对 Log4j 的升级。对比其前身Log4j 1.x，它提供了重大的改进，并在修复了 Logback 体系结构中的一些固有问题的同时，提供了许多 Logback 中可用的改进。

[![Jenkins Status](https://img.shields.io/jenkins/s/https/builds.apache.org/job/Log4j%202.x.svg)](https://builds.apache.org/job/Log4j%202.x/)
[![Travis Status](https://travis-ci.org/apache/logging-log4j2.svg?branch=master)](https://travis-ci.org/apache/logging-log4j2)
[![Maven Central](https://img.shields.io/maven-central/v/org.apache.logging.log4j/log4j-api.svg)](http://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api)


## Pull Requests on Github

通过发送一个 pull 请求，您可以授予 Apache Software Foundation 足够的权限，以使用和发布 Apache 许可下提交的工作。您向 Apache Software Foundation 授予相同的权利（版权许可，专利许可等），就像您已签署了“贡献者许可协议”一样。 对于被认为是非凡的贡献，您将被要求实际签署贡献者许可协议。

## 用法

用户应该参考 Log4j 网站上的 [Maven, Ivy, Gradle, and SBT Artifacts](http://logging.apache.org/log4j/2.x/maven-artifacts.html)，来了解如何使用他们选择的构建工具，将 Log4j 包含到他们的项目中。

`Logger` API 的基本用法:

```java
package com.example;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Example {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String... args) {
        String thing = args.length > 0 ? args[0] : "world";
        LOGGER.info("Hello, {}!", thing);
        LOGGER.debug("Got calculated value only if debug enabled: {}", () -> doSomeCalculation());
    }

    private static Object doSomeCalculation() {
        // do some complicated calculation
    }
}
```

以及，一个`log4j2.xml`配置文件示例:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration>
  <Appenders>
    <Console name="Console" target="SYSTEM_OUT">
      <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
    </Console>
  </Appenders>
  <Loggers>
    <Logger name="com.example" level="INFO"/>
    <Root level="error">
      <AppenderRef ref="Console"/>
    </Root>
  </Loggers>
</Configuration>
```

## 文档

Log4j 2 用户指南可从[这里](https://logging.apache.org/log4j/2.x/manual/index.html)获得，也可下载[PDF](https://logging.apache.org/log4j/2.x/log4j-users-guide.pdf)。

## 必要条件

Log4j 2.4 及更高版本需要Java 7，版本 2.0-alpha1 到 2.3 需要Java 6.
某些功能需要可选的依赖项; 这些功能的文档指定了所需的依赖项。

## 许可

Apache Log4j 2 是在 [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)下发布的。

## 下载

[如何下载 Log4j](http://logging.apache.org/log4j/2.x/download.html),
和 [如何从 Maven, Ivy 和 Gradle 使用 Log4J](http://logging.apache.org/log4j/2.x/maven-artifacts.html).
您可以使用Maven存储库`https://repository.apache.org/snapshots`访问最新的开发快照, 
查看 [快照版构建](https://logging.apache.org/log4j/2.x/maven-artifacts.html#Snapshot_builds).

## 问题追踪

Issues, bugs, 和 feature requests 应该提交给[此项目的问题跟踪系统 JIRA ](https://issues.apache.org/jira/browse/LOG4J2).

Pull request on GitHub are welcome, but please open a ticket in the JIRA issue tracker first, and mention the 
JIRA issue in the Pull Request.

## 使用源码构建

Log4j requires Apache Maven 3.x. To build from source and install to your local Maven repository, execute the following:

```sh
mvn install
```

## 贡献

We love contributions! Take a look at
[our contributing page](https://github.com/apache/logging-log4j2/blob/master/CONTRIBUTING.md).
