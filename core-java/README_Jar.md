###

File structure
```
./com/App.java
```

```java

package com;
public class App {
  public static void main(String[] args) {
    System.out.println("Spring App started !!");
    System.out.println("Finished . Spring Context will be closed");
  }
}
```

```
# Steps

$ javac com/App.java
$ echo Main-Class: com.App > manifest.txt
$ jar cvfm AppDB.jar manifest.txt com/*.class
$ java -jar AppDB.jar 

```



### Reference


```
sample 
```
[Remote Debug sample](http://javapapers.com/core-java/java-remote-debug-with-eclipse/)

[Oracle Official : Jar](http://docs.oracle.com/javase/tutorial/deployment/jar/downman.html)


[IBM sample + theory](http://www.ibm.com/developerworks/library/os-eclipse-javadebug/index.html)


[Remote debug tip](https://muhammadkhojaye.blogspot.ca/2010/02/java-remote-debugging.html)
