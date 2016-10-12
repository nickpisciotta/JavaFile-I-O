Sales Taxes Calculator Application Instructions
*This was my first attempt at creating a Java application and getting experience with File IO in Java.
Getting used to using an IDE (NetBeans) and learning the Java language was challenging, but I found that
being very expressive and declaring variable types was helpful to keep track of variables. 

BUILD APP IN COMMAND LINE
* In the root level of the project directory in the command line, enter commands in the following order:
	$ brew install maven
	$ mvn clean install
	$ javac src/main/java/*.java

RUN APP FROM COMMAND LINE
* From the root directory enter:
  $ java -cp target/classes salestaxes.FileInput [text File Path]

  Example:
  $ java -cp target/classes salestaxes.FileInput src/test/resources/Input1.txt

  NOTE: Receipt output can be found in receipts directory

RUN TESTS FROM COMMAND LINE
* From the root directory enter:
  $ mvn clean test


ASSUMPTIONS
* Each input file will create an output file
* Sales tax calculations are rounded up to the nearest tenth decimal place. Anything
greater than 0.4 will be rounded upwards.
* Including a file path when you execute the program is needed, or else the application cannot run.
* The entry point for this application begins in the FileInput class, which creates the cart item objects
and adds them to the cart objects. This same file will initiate the printing of the receipt.

TOOLS
The implementation of this program utilized the following:
	* JDK 1.8
	* NetBeans editor
	* Apache Maven build tool
	* JUnit testing framework
