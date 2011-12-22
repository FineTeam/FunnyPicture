@java -cp "hsqldb.jar;h2-1.2.144.jar;%H2DRIVERS%;%CLASSPATH%" org.h2.tools.Console %*
@if errorlevel 1 pause