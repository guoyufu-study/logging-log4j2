# [Apache Log4j 2](https://logging.apache.org/log4j/2.x/)

Apache Log4j 2 是对 Log4j 的升级。对比其前身Log4j 1.x，它提供了重大的改进，并在修复了 Logback 体系结构中的一些固有问题的同时，提供了许多 Logback 中可用的改进。

[![Jenkins Status](https://img.shields.io/jenkins/s/https/builds.apache.org/job/Log4j%202.x.svg)](https://builds.apache.org/job/Log4j%202.x/)
[![Travis Status](https://travis-ci.org/apache/logging-log4j2.svg?branch=master)](https://travis-ci.org/apache/logging-log4j2)
[![Maven Central](https://img.shields.io/maven-central/v/org.apache.logging.log4j/log4j-api.svg)](http://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api)


## Pull Requests on Github

通过发送一个 pull 请求，您可以授予 Apache Software Foundation 足够的权限，以使用和发布 Apache 许可下提交的工作。您向 Apache Software Foundation 授予相同的权利（版权许可，专利许可等），就像您已签署了“贡献者许可协议”一样。 对于被认为是非凡的贡献，您将被要求实际签署贡献者许可协议。

## Usage

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

## Documentation

The Log4j 2 User's Guide is available [here](https://logging.apache.org/log4j/2.x/manual/index.html) or as a downloadable
[PDF](https://logging.apache.org/log4j/2.x/log4j-users-guide.pdf).
Log4j 2 用户指南可从[这里](https://logging.apache.org/log4j/2.x/manual/index.html)获得，也可下载[PDF](https://logging.apache.org/log4j/2.x/log4j-users-guide.pdf)。

## Requirements

Log4j 2.4 and greater requires Java 7, versions 2.0-alpha1 to 2.3 required Java 6.
Some features require optional dependencies; the documentation for these features specifies the dependencies.

## License

Apache Log4j 2 is distributed under the [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).

## Download

[How to download Log4j](http://logging.apache.org/log4j/2.x/download.html),
and [how to use it from Maven, Ivy and Gradle](http://logging.apache.org/log4j/2.x/maven-artifacts.html).
You can access the latest development snapshot by using the Maven repository `https://repository.apache.org/snapshots`, 
see [Snapshot builds](https://logging.apache.org/log4j/2.x/maven-artifacts.html#Snapshot_builds).

## Issue Tracking

Issues, bugs, and feature requests should be submitted to the 
[JIRA issue tracking system for this project](https://issues.apache.org/jira/browse/LOG4J2).

Pull request on GitHub are welcome, but please open a ticket in the JIRA issue tracker first, and mention the 
JIRA issue in the Pull Request.

## Building From Source

Log4j requires Apache Maven 3.x. To build from source and install to your local Maven repository, execute the following:

```sh
mvn install
```

## Contributing

We love contributions! Take a look at
[our contributing page](https://github.com/apache/logging-log4j2/blob/master/CONTRIBUTING.md).
