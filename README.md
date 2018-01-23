libedax4j
==========

libedax4j is a Java wrapper for libedax. To use libedax4j, you need libedax (c-library) together.

https://github.com/lavox/edax-reversi/releases

API Documents
--------------
https://lavox.github.io/libedax4j/javadoc/

Also, see examples in example folder.

Usage
------
To execute your java application, you must set;

* classpath to the following two libraries;
    * libedax4j.jar
    * jna-4.5.1.jar
* path to libedax.dylib or libedax-x86.dll as VM argument "jna.library.path".

You can specify book file and eval file with `libedax_initialize()` function.

Example
--------
Windows:
```
C:¥
+-- libedax¥
    +-- bin¥
    |   +-- libedax-x86.dll
    +-- lib¥
    |   +-- libedax4j.jar
    |   +-- jna-4.5.1.jar
    +-- data¥
    |   +-- book.dat
    |   +-- eval.dat
    +-- Example1.java
```
If directory structure is as above, execute the following commands in `C:¥libedax` directory.
```sh
set CLASSPATH=.;C:¥libedax¥lib¥libedax4j.jar;C:¥libedax¥lib¥jna-4.5.1.jar
javac Example1.java
java -Djna.library.path=C:¥libedax¥bin Example1
```

OSX:
```
HOME_DIRECTORY
+-- libedax/
    +-- bin/
    |   +-- libedax.dylib
    +-- lib/
    |   +-- libedax4j.jar
    |   +-- jna-4.5.1.jar
    +-- data/
    |   +-- book.dat
    |   +-- eval.dat
    +-- Example1.java
```
If directory structure is as above, execute the following commands in `HOME_DIRECTORY/libedax` directory.
```sh
export CLASSPATH=.:~/libedax/lib/libedax4j.jar:~/libedax/lib/jna-4.5.1.jar
javac Example1.java
java -Djna.library.path=~/libedax/bin Example1
```
