
Assuming you are in the directory:
From the folder: aditya_mhamunkar\registrationScheduler\src

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
ant run -Darg0=<reg-preference-file-name> -Darg0=<add-drop-file-name> -Darg1=<outputfilename> -Darg2=<number-of-threads> -Darg3=<logger level>

Example:
ant run -Darg0=reg-input.txt -Darg1=add-drop.txt -Darg2=output.txt -Darg3=2 -Darg4=0

The files are read/written from/to here:
	john_doe/registrationScheduler/reg-input.txt
	john_doe/registrationScheduler/add-drop.txt
	john_doe/registrationScheduler/output.txt
will run 2 threads
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

[Date: 3-7-2017]  

-----------------------------------------------------------------------

A note about the code:

I have called the startWorkers() two times from the Diver class. Once 
for preference-input file and next for add-drop file.
If the number of threads is given as 3, thes, 3 threads execute for the
first call, and next 3 threads execute for the second call.

-----------------------------------------------------------------------

Justification for Data Structures used:


The data structurs used for this project are:
1. Collection -> List -> ArrayList
2. Collection -> Map -> HashMap

1. ArrayList

The ArrayList used in this project, is a list of Student objects used
to store the details of each student.

The number of students given are 80. But, in future, the number may 
grow or shrink. The java arrays are of fixed length and once created 
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


2. HashMap

For the storage of data in Results, and the storage of the course and 
the availability of it's seats, a key-value data structure was required.
Thus HashMap is used. The need was to access, and update the values 
frequently for this project.
The execution time for the basic methods like put() and get() is 
constant. Thus, the time complexity for this is often O(1).



-----------------------------------------------------------------------

List of citations (urls, etc.) from where code is taken (if any).
- Understood the syntax and use for DecimalFormat class from stackoverflow.com


 