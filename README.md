# easywork
日常使用，简化开发



在项目中使用 util jar包
(1)在pom.xml里增加
<repositories>
    <repository>
        <!-- A unique identifier for a repository. -->
        <id>github-repo</id>
        <url>https://raw.githubusercontent.com/fengjiening/mvn-repo/master</url>
        <releases>
            <enabled>true</enabled>
            <checksumPolicy>warn</checksumPolicy>
        </releases>
        <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
            <checksumPolicy>warn</checksumPolicy>
        </snapshots>
    </repository>
</repositories>

(1)在pom.xml </dependencies> 里增加
<dependency>
    <groupId>org.fengjiening</groupId>
    <artifactId>util</artifactId>
    <version>0.0.4-SNAPSHOT</version>
</dependency>