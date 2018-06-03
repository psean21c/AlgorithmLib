/=========================================================================================
Code Challenge for OverBond 

Author		: Simon Park
Date		: January-29-2017
Version: 1.0
=========================================================================================/

* Environment: This solution was tested on the Windows Machine 7 (JDK 1.8)

* Prerequisite : Must have Java (JDK 1.6) on the Testing machine
* Libray/frameworks : junit-4.10.jar for the Java unit Test

* input text file: 
- If anyone want to make his/her own input.txt file, 
  Keep in mind that input data are separated by tab '\t'

- Also below inputs in the text file are both acceptable by the program.
C1	corporate	10.3 years	5.30%
C1	corporate	10.3	5.30%

-------------------------------------------------------------------------------------------
Class Diagram of the Solution 
===========================================================================================
              Bond                                         
               |                
        -----------------
       |                 |                             
    CorporateBond  GovernmentBond   <---    BondManager <---  CalculateSpread (Main method)      
                                         ----------------------
                                         | readInput(File)       |
                                         | bondBenchMark()       |
                                         | bondCurve()           |       
                                         | spreadCurve()         |
                                         | printSpreadBenchmark()|
                                         | printSpreadCurve()    |
                                         -------------------------

-------------------------------------------------------------------------------------------
File layout 
===========================================================================================

* Let {overbond} be the conventional naming for the root path of woking directory
   i.e. C:\dev\Overbond\Overbond = {overbond} 

* Unzip the file and testers will see the files as below

{overbond}
   |-- README.txt
   |-- /src 
   |    |-- com
   |         |    (5 files)
   |         |- *.java (Bond.java, BondManager.java, CorporateBond.java, GovernmentBond.java, CalculateSpread.java )
   |
   |-- /bin
        |-- input*.txt (5 files)
        |-- BenchMarkTest.java
        |-- junit-4.10.jar (* Need to download and place here)

* In order to do Unit Test, it is necessary to download junit-4.10.jar in the link below.
(I initially included it to zip file, but for security reason I can't send this attached file through email.)
https://github.com/junit-team/junit4/wiki/Download-and-Install

* If tester download different version, junit-4.XX.jar,
it is necessary to update all command line corresponding to this file name in the following instruction.
   
-------------------------------------------------------------------------------------------
Run the program: DOS
===========================================================================================

1) Go to the root directory {overbond}
DOS> cd ..

2) run the command line to compile
DOS> javac -d ./bin -cp . ./src/com/Bond.java ./src/com/GovernmentBond.java ./src/com/CorporateBond.java ./src/com/BondManager.java ./src/com/CalculateSpread.java

3) Make sure if it created new folder /com and placed all java *.class files under /bin folder.

{overbond}
   |-- /src 
   |    |-- com
   |         |- *.java (Bond.java, BondManager.java, CorporateBond.java, GovernmentBond.java, CalculateSpread.java )
   |
   |-- /bin
   |    |-- com (*)  new folder and all class files should be in the folder after successfully compiling
   

4) Go to the  directory {overbond}/bin

5) run the command line to run the program (It is possible to change a different text file - input2.txt or input3.txt)
DOS> java -cp . com.CalculateSpread input.txt

 ... Below is the sample
===========Corporate=============
C1 10.3 5.3

===========Government=============
G1 9.4 3.7
G2 12.0 4.8
---------------------------------------------------------------
                 Report for Spread BenchMark
---------------------------------------------------------------
bond            benchmark       spread_to_benchmark
C1              G1              1.60%

---------------------------------------------------------------
                 Report for Spread Curve
---------------------------------------------------------------
bond            spread_to_curve
C1              1.22%

-------------------------------------------------------------------------------------------
Run the UnitTest : DOS
===========================================================================================

1) Prerequisite
 - Make sure if tester followed the previous running test - need java class files
 - Make sure if the prompt is in the right directory (at the same directory {overbond}\bin)

2) Move BenchMarTest.java from {overbond}/bin to {overbond}/bin/com
DOS> move BenchMarkTest.java ./com

3) Compile
DOS> javac -cp .;junit-4.10.jar ./com/BenchMarkTest.java

3) Test Run
DOS> java -cp .;junit-4.10.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore com.BenchMarkTest

 ... Below is the sample
JUnit version 4.10
..---------------------------------------------------------------
                 Report for Spread BenchMark
---------------------------------------------------------------
bond            benchmark       spread_to_benchmark
C1              G1              1.60%
C2              G2              3.50%

---------------------------------------------------------------
                 Report for Spread Curve
---------------------------------------------------------------
bond            spread_to_curve
C1              NaN%
C2              NaN%

..
Time: 0.017

OK (4 tests)

-------------------------------------------------------------------------------------------
Run the program: Eclipse
===========================================================================================
* Required to have a proper JDK-1.6 env. & some experience on tester's Eclipse

1) Create a new project

2) Copy the 5 java file under /src/com
3) Copy the 5 input files under the root project name

4) Create [test/com] folder and copy/save BenchMarkTest.java
{Project}
   |-- /src 
   |    |-- com
   |         |- *.java (Bond.java, BondManager.java, CorporateBond.java, GovernmentBond.java, CalculateSpread.java )
   |
   |-- /test
   |    |-- com
   |         |- BenchMarkTest.java
   |
   |-- input*.txt
   
5) Configure the test/ folder for the project
 - In properties for the project, right click > Java Build Path > (go to) Source tab
   Click on [Add Folders] and choose the folder /test
 
6) Add JAR file for the Unit Test:
 - Put junit-4.10.jar in specific folder and add it to the project.
 - In properties for the project, right click > Java Build Path > (go to) Libraries tab
   Click on [Add External JARs] and choose junit-4.10.jar

7) Run / Test   

-------------------------------------------------------------------------------------------
Other Considerations taken during the development
===========================================================================================
* What if G3 and G4 have the same term ?
 - Answered by the web site & Handled by solution

* What if G1 and C1 have the same term ?
 - Properly calculated by the formula

* What if C is out of all ranges in [G1..GN] ?
 - Handled by solution
/----------------------------
bond		spread_to_curve
C1		NaN%
C2		3.50%
----------------------------/


-- THE END --
