How to change your `pom.xml` files to setup a Maven 2 dependency to OFC2.

# Repository #

Add the following section to the `<repositories>` node (just below the `<project>` node) :
```
    <repository>
        <id>jofc2.maven.repo</id>
        <name>JOFC2 GoogleCode.com Snapshot Repository</name>
        <url>http://jofc2.googlecode.com/svn/repository/snapshots/</url>
    </repository>
```

# Dependency #

Add the following section to the `<dependencies>` node (just bellow `<project>` node) :
```
    <dependency>
        <groupId>jofc2</groupId>
        <artifactId>jofc2</artifactId>
        <version>1.0.1-SNAPSHOT</version>
    </dependency>
```