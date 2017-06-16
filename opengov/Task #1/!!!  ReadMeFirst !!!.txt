Hello Konstantin, 
Before you start checking my code, let me provide some comments:

(!!! IMPORTANT) 0.  To start the test runs MainTest.java

(!!! IMPORTANT) 1.  CSV adress I wrote in the package "pages" class - Base, line #35, CHANGE IT or error.  I didn't create variable because it is already to much of lines of code for such a small test

2. I designed CSV structure both person reading and JUNit params with mapper=CsvWithHeaderMapper.class reading also

3. If you want to see how it show mistake and write it into CSV file, just change any selector, and you can see it both in the console and CSV

4. The project consists of for main classes in 2 packages. I used MAVEN, because we just studied it at my White box course and I wanted to practice

5. All general variables and 3 functions that can be used in all similar tests of other pages are written in the Base

6. OperatinPage inherit Page and all general methods of (test steps) are written there, We use object of OperatinPage only

7. In BaseTest (Junit )could be cancelled, I planned to put there some variable but then decided to leave only 2 records, and close driver

8. MainTest(Junit) inherits BaseTest and perform all methods of test, and initiate creation of csv. 

9. В CSV 4 Колонка как бы закрашена иксами, это сделал для того чтобы отделить колонку 5 от остальных, т.к она к ним не относится 

10. I know that experienced guy can do it pretty and more understandable, but it works good even with poor E-connection

11. The size of code could be less but no much functionality we had

12. Если по каким то  причинам не сожете запустить или  что-то пойдет не так, сообщите, я сделаю и вышлю вам видео как оно работает у меня, p.s У меня работает стабильно, как часы.

