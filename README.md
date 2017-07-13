# Grus Japonenis

标签（空格分隔）： MVVM RXJAVA LINT DEAGGER2

---

## 1,Lint
    Android Lint是Google提供给Android开发者的静态代码检查工具。使用Lint对Android工程代码进行扫描和检查，可以发现代码潜在的问题，提醒程序员及早修正。

### 1，原始的自定义Lint代码位于 **lib.lintrules** 目录，这是一个Java项目。

 1. Detector类负责扫描代码，发现问题并报告；
 2. Issue类由Detector发现并报告，是Android程序代码可能存在的bug；
 3. Category类指定问题的类别；
 4. IssueRegistry类提供需要被检测的Issue列表。

在project目录下执行 **gradlew lib.lintrules:assemble**（windows）或 **./gradlew lib.lintrules:assemble**（Linux）命令， 生成jar文件到 **lib.lintrules/build/libs/lib.lintrules.jar**路径。


### 2，**lib.lintrules-jar**是Android Library项目，负责将jar文件生成aar文件。

在project目录下执行 **gradlew lib.lintrules-jar:assemble**（windows）或 **./gradlew lib.lintrules-jar:assemble**（Linux）命令， 生成aar文件到 **lib.lintrules/build/outputs/aar/lib.lintrules-jar-release.aar**路径。

### 3，**lib.lintrules-aar**是导入aar库，其他module依赖这个库

将上面生成的aar文件复制到 **lib.lintrules-aar/lib.lintrules-jar-release.aar**路径。

```JAVA
dependencies {
    ...
    compile project(':lib.lintrules-aar')
    ...
}
```



