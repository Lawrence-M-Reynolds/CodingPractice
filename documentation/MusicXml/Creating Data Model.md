#Generating  model for musicXML
##Reference 
- [how to customize JAXB binding](https://docs.oracle.com/cd/E17802_01/webservices/webservices/docs/1.5/tutorial/doc/JAXBUsing4.html)
- [xjc command](https://www.oracle.com/technetwork/articles/javase/index-140168.html#introjb)

##Instructions
- Download the schema files from [MusicXML on GitHub](https://github.com/w3c/musicxml/releases/tag/v3.1).
- You will need to set up a local server that serves the schema files so that the files can be served from the
expected URLs - e.g. "http://www.musicxml.org/xsd/musicxml.xsd". This will require adding a host file entry:
````
127.0.0.1			www.musicxml.org
````
- From the root directory of the project:
````
xjc -nv -verbose http://www.musicxml.org/xsd/musicxml.xsd -d .\src\main\java -b .\src\main\resources\musicxml-3.1\LR_CustomBindings.xjb -p com.reynolds.lawrence.musicxml.generatedModel
````

Note that the binding conflict issues had to be resolved with the customised binding file "LR_CustomBindings.xjb".