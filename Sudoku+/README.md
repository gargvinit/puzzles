SudokuPlus
====


To use this, there are two preferred approaches:

mvn clean install exec:java  -Dexec.args=Directory where you have files

or 

mvn package 

cd target

java -jar SudokuPlus-0.1.0.jar ../src/test/resources/

You can provide your choice of directory here as well

You can provide one or more files individually as well.
