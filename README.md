#Sudoku.java
This repository features the solution for a sudoku puzzle validator and solver ,
The algorithms used are iterative and recursive backtracking algorithms  -  

-Interaction with the software is performed through the terminal ; 
Note:
Java 11 or any subsequent version  of java should be installed on the system ; 
Maven 3.0.0 version is supported ; 
-In order to use the Validator or the solver  ; 

-Visit the terminal 
- change directories  to the root directory of the project ;
-compile the project with the following  command  ;
-mvn  clean compile  ;
-Package the project to a Jar file with the following command ;
-Mvn package

  -Change directories  to the target folder  ; 
-Run the  jar file  with the following command to validate a puzzle ;
java  -cp  sudoku-2.2.jar  com.moderneinstein.logical.algorithms.Source  Terminal [[5,3,0,0,7,0,0,0,0].[6,0,0,1,9,5,0,0,0].[0,9,8,0,0,0,0,6,0].[8,0,0,0,6,0,0,0,3].
[4,0,0,8,0,3,0,0,1].[7,0,0,0,2,0,0,0,6].[0,6,0,0,0,0,2,8,0].[0,0,0,4,1,9,0,0,5].[0,0,0,0,8,0,0,7,9]]   Validate


-Run the following command to solve a puzzle ;

- java  -cp  sudoku-2.2.jar  com.moderneinstein.logical.algorithms.Source  Terminal
- [[5,3,0,0,7,0,0,0,0].[6,0,0,1,9,5,0,0,0].[0,9,8,0,0,0,0,6,0].[8,0,0,0,6,0,0,0,3]
- .[4,0,0,8,0,3,0,0,1].[7,0,0,0,2,0,0,0,6].[0,6,0,0,0,0,2,8,0].[0,0,0,4,1,9,0,0,5].[0,0,0,0,8,0,0,7,9]] Solve
- 
