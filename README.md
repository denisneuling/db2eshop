# db2eshop

Maven project, which contains the HTW DB2 evidence project "db2eshop"

### Requirements
---

You will need following:

- [Java JRE 1.6+](http://www.oracle.com/technetwork/java/javase/downloads) ([Download page](http://www.oracle.com/technetwork/java/javase/downloads/jre6-downloads-1637595.html))
- [Java JDK 1.6+](http://www.oracle.com/technetwork/java/javase/downloads) ([Download page](http://www.oracle.com/technetwork/java/javase/downloads/jdk6-downloads-1637591.html))
- [Apache Maven 3.0+](http://maven.apache.org/)

Install via your package manager, otherwise get the libraries.

Descriptions can be found here:

For Maven: [Building a Project with Maven](http://maven.apache.org/run-maven/index.html)


### How to setup this project?
---

1. Clone the [db2eshop](https://github.com/denisneuling/db2eshop.git) project

        $ git clone https://github.com/denisneuling/db2eshop.git

2. Switch into the directory:

        $ cd db2eshop

3. Run maven:

        $ mvn install # fetch all dependencies and build the project

4. Start hacking.


### How to run this project?
---

1. Execute the dist.sh

        $ ./dist.sh

2. Run the JAR

        $ java -jar dist/db2eshop-0.0.1-SNAPSHOT-executable.jar 
