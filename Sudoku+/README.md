====
SudokuPlus
======
To use this, there are two preferred approaches:
======
mvn clean install exec:java  -Dexec.args=Directory where you have files
======
or 
======
mvn package 
=====
java -jar SudokuPlus-0.1.0.jar "Directory where you have files to verify" 
======
You can provide one or more files individually as well.
