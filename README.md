libedax4j
==========

libedax4j is a Java wrapper for libedax. To use libedax4j, you need libedax (c-library) together.

https://github.com/lavox/edax-reversi/tree/libedax

API Documents
--------------
See docs folder. And see examples in example folder.

Usage
------
To execute your java application, you must set;

* classpath to the following two libraries;
    * libedax4j.jar
    * jna-4.5.1.jar
* path to libedax.dylib or libedax-x86.dll as VM argument "jna.library.path".

Windows:
```sh
set CLASSPATH=.;C:¥libedax¥lib¥libedax4j.jar;C:¥libedax¥lib¥jna-4.5.1.jar
java -Djna.library.path=C:¥libedax¥bin Example1
```

OSX
```sh
export CLASSPATH=.:~/libedax/lib/libedax4j.jar:~/libedax/lib/jna-4.5.1.jar
java -Djna.library.path=~/libedax/bin Example1
```
