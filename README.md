Boilerpipe and language detect api server
=========================================

 * Boilerpipe - http://code.google.com/p/boilerpipe/
 * Language detect - http://code.google.com/p/language-detection/

Boilerpipe and language detect HTTP API server. Integrates both packages in single place as API server.


Compilation
=

In order to compile execute:
> javac -cp ".:boilerpipe-1.2.0.jar:lib/nekohtml-1.9.13.jar:lib/xerces-2.9.1.jar:lib/langdetect.jar:lib/jsonic-1.2.8.jar" ExampleProgram.java

Running
=
Server listens on 8080 localhost port.

To run service execute:
> java -Dfile.encoding=UTF8 -cp .:boilerpipe-1.2.0.jar:lib/nekohtml-1.9.13.jar:lib/xerces-2.9.1.jar:lib/langdetect.jar:lib/jsonic-1.2.8.jar ExampleProgram

To run HTTP service as daemon:
> nohup java -Dfile.encoding=UTF8 -cp .:boilerpipe-1.2.0.jar:lib/nekohtml-1.9.13.jar:lib/xerces-2.9.1.jar:lib/langdetect.jar:lib/jsonic-1.2.8.jar ExampleProgram &

How to use
=

See examples folder content.
