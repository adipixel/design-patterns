
Assuming you are in the directory:
From the folder: aditya_mhamunkar\spreadsheetUpdates\src

-----------------------------------------------------------------------

## To clean:
ant clean

-----------------------------------------------------------------------
## To compile: 
ant all
ant prepare

-----------------------------------------------------------------------
## To Run Instructions: 

Syntax:
ant run -Darg0=<input-file-name> -Darg1=<output-file-name> -Darg2=<logger level>

Example:
ant run -Darg0=input.txt -Darg1=output.txt -Darg2=0

The files are read/written from/to here:
	aditya_mhamunkar/spreadsheetUpdates/input.txt
	aditya_mhamunkar/spreadsheetUpdates/output.txt
will use Logger for debug level 0

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 4-2-2017]  

-----------------------------------------------------------------------

Justification for Data Structures used:


The data structurs used for this project are:
1. Collection -> List -> ArrayList
2. Multi-Dimentional Array

1. ArrayList

The ArrayList used in this project, is a list of Cell (Observers) objects used
to store the details of each student.

The number instructions may grow or shrink. 
The java arrays are of fixed length and once created 
cannot be updated dynamically. Thus, this dynamic, re-sizable-array 
implementation of List interface - ArrayList is used.

The dynamic data structure like LinkedList would also be suitable for
this project. But, it is slower and can have higher time complexity 
than ArrayList.
The methods get() and add(), from the ArrayList has a 'constant' time
complexity - O(1). This is because ArrayList uses random read access
(Implements RandomAccess interface). While, the method contains() 
has time complexity of O(n) which is rarely used. 
Whereas, the method get(), contains() in LinkedList has time 
complexity of O(n). While, method remove() in LinkedList has time 
complexity of O(1). But, there is no requirement of remove() method in
the project. Mostly, method get() is used.


2. Multi Dimentional Array of Cell objects

This was used to resemble the spreadsheet format of given problem.
It was necessary to have a structure which can accomodate the rows and 
columns of a spreadsheet. Multi Dimentional array was the best fit for 
it.

NOTE:
Cycle selection algorithm is designed by me.

-----------------------------------------------------------------------

List of citations (urls, etc.) from where code is taken (if any).
-none
 