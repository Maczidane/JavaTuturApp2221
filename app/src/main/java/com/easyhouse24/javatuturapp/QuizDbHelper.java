package com.easyhouse24.javatuturapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.easyhouse24.javatuturapp.QuizContract.QuestionsTable;

import java.util.ArrayList;


public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "JAVAAPP.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;


    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT, " +
                QuestionsTable.COLUMN_SOLUTION + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {

        set1();
        set2();
        set3();
        set4();
        set5();
        set6();
        set8();
        set7();
        set9();

    }

    private void set1() {

        Question q1 = new Question("Which version of Java introduced annotation?", "Java 5", "Java 6", "Java 7", "Java 8", 1, Question.DIFFICULTY_SET1, "Answer 1 is correct. No explanation");
        Question q2 = new Question(" What is the range of short data type in Java?", "-128 to 127", "-32768 to 32767", "-2147483648 to 2147483647", "None of the mentioned", 2, Question.DIFFICULTY_SET1, "Answer 2 is correct. No explanation");
        Question q3 = new Question("Which of these can be returned by the operator &?", "Integer", "Boolean", "Character", "Integer or Boolean", 4, Question.DIFFICULTY_SET1, "Answer 4 is correct. No explanation");
        Question q4 = new Question("Which of these can not be used for a variable name in Java?", "identifier", "keyword", "identifier & keyword", "none of the mentioned", 2, Question.DIFFICULTY_SET1, "Answer 2 is correct. No explanation");
        Question q5 = new Question("Which of these is an incorrect string literal?", "“Hello World”", "“Hello\\nWorld”", "“\\”Hello World\\””", "\"Hello\n" +
                "  world\"", 4, Question.DIFFICULTY_SET1, "Answer 4 is correct. No explanation");

        Question q6 = new Question("What is correct syntax for main method of a java class?", "public static int main(String[] args)", "public int main(String[] args)", "public static void main(String[] args)", "None of the above.", 3, Question.DIFFICULTY_SET1, "Correct syntax is public static void main(String[] args).");

        Question q7 = new Question("What is the size of long variable?", "8 bit", "16 bit", "32 bit", "64 bit ", 4, Question.DIFFICULTY_SET1, "The long data type is represented by 64-bit two's complement integer.\n" +
                "\n" +
                "Minimum value: -263\n" +
                "\n" +
                "Maximum value: 263-1");

        Question q8 = new Question("What is the default value of int variable?", "0", "0.0", "null", "not defined", 1, Question.DIFFICULTY_SET1, "int variable has default value of 0 if defined as an instance/static variable.");

        Question q9 = new Question("What is the default value of Object variable?", "undefined", "0", "null", "not defined", 3, Question.DIFFICULTY_SET1, "Object variable has default value of null if defined as an instance/static variable.");

        Question q10 = new Question("What kind of variables a class can consist of?", "class variables, instance variables", "class variables, local variables, instance variables", "class variables", "class variables, local variables", 2, Question.DIFFICULTY_SET1, "A class consist of Local variable, instance variables and class variables.");

        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);
        addQuestion(q6);
        addQuestion(q7);
        addQuestion(q8);
        addQuestion(q9);
        addQuestion(q10);

    }

    private void set2() {
        Question q1 = new Question("Method Overloading is an example of", "Static Binding.", "Dynamic Binding.", "Both of the above.", "None of the above.", 1, Question.DIFFICULTY_SET2, "Method Overloading is example of static binding.");
        Question q2 = new Question("which operator is considered to be with highest precedence?", "() , []", "=", "?:", "%", 1, Question.DIFFICULTY_SET2, "Postfix operators i.e () [] . is at the highest precedence.");
        Question q3 = new Question("Which of these have highest precedence?", "++", "()", ">>", "*", 2, Question.DIFFICULTY_SET2, "Order of precedence is (highest to lowest) a -> b -> c -> d.");
        Question q4 = new Question(" What is the output of this program?\n\n" +
                " class average {\n" +
                "        public static void main(String args[])\n" +
                "        {\n" +
                "            double num[] = {5.5, 10.1, 11, 12.8, 56.9, 2.5};\n" +
                "            double result;\n" +
                "            result = 0;\n" +
                "            for (int i = 0; i < 6; ++i) \n" +
                "                result = result + num[i];\n" +
                "\t    System.out.print(result/6);\n" +
                "                \t\n" +
                "        } \n" +
                "    }", "16.34", "16.46666666666666", "16.46666666666667", "16.566666644", 3, Question.DIFFICULTY_SET2, "Output\n\n" +
                "$ javac average.java\n" +
                "$ java average\n" +
                "16.46666666666667");
        Question q5 = new Question("How to identify if a timezone is eligible for DayLight Saving?", "useDaylightTime() of Date class", "useDaylightTime() of DateTime class", "useDaylightTime() of TimeZone class", "useDaylightTime() of Time class", 3, Question.DIFFICULTY_SET2, "public abstract boolean useDaylightTime() is provided in TimeZone class.");

        Question q6 = new Question("What will this code print?\n" +
                "    int arr[] = new int [5];\n" +
                "    System.out.print(arr);\n", "Class name@ hashcode in hexadecimal form)", "0", "00000", "value stored in arr[0].", 1, Question.DIFFICULTY_SET2, "If we trying to print any reference variable internally, toString() will be called which is implemented to return the String in following form:\n" +
                "classname@hashcode in hexadecimal form.");

        Question q7 = new Question("Which of these is long data type literal?", "0x99fffa", "99671246", "ABCDEFG", "0x99fffL", 4, Question.DIFFICULTY_SET2, "" + "Data type long literals are appended by an upper or lowercase L. 0x99fffL is hexadecimal long literal.");

        Question q8 = new Question("What is the order of variables in Enum?", "Random order", "depends on the order() method", "Ascending order", "Descending order", 3, Question.DIFFICULTY_SET2, "The compareTo() method is implemented to order the variable in ascending order.");

        Question q9 = new Question("What is the output of this program?\n" +
                "\n" +
                "    class operators \n" +
                "    {\n" +
                "        public static void main(String args[]) \n" +
                "        {    \n" +
                "             int x = 8;\n" +
                "             System.out.println(++x * 3 + \" \" + x);\n" +
                "        } \n" +
                "    }", "24 9", "24 8", "27 8", "27 9", 4, Question.DIFFICULTY_SET2, "Operator ++ has higher precedence than multiplication operator, *, x is incremented to 9 than multiplied with 3 giving 27.\n" +
                "output:\n" +
                "$ javac operators.java\n" +
                "$ java operators\n" +
                "27 9");

        Question q10 = new Question("Can 8 byte long data type be automatically type cast to 4 byte float data type?", "True", "False", "It depends", "All of the above", 1, Question.DIFFICULTY_SET2, "Both data types have different memory representation that's why 8-byte integral data type can be stored to 4-byte floating point data type.");

        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);
        addQuestion(q6);
        addQuestion(q7);
        addQuestion(q8);
        addQuestion(q9);
        addQuestion(q10);

    }

    private void set3() {
        Question q1 = new Question("Which of these is necessary condition for automatic type conversion in Java?", "The destination type can be larger or smaller than source type", "None of the mentioned", "The destination type is larger than source type", "The destination type is smaller than source type", 3, Question.DIFFICULTY_SET3, "Answer 3 is correct. No explanation");
        Question q2 = new Question("Where is array stored in memory?", "heap space and stack space", "first generation memory", "heap space", "stack space", 2, Question.DIFFICULTY_SET3, "Array is stored in heap space. Whenever an object is created, it's always stored in the Heap space and stack memory contains the reference to it.");
        Question q3 = new Question("What is the output of this program?\n" +
                "\n" +
                "    class mainclass {\n" +
                "        public static void main(String args[]) \n" +
                "        {\n" +
                "            char a = 'A';\n" +
                "            a++;\n" +
                "\t    System.out.print((int)a);\n" +
                "        } \n" +
                "    }", "65", "67", "64", "66", 4, Question.DIFFICULTY_SET3, "ASCII value of 'A' is 65, on using ++ operator character value increments by one.\n" +
                "output:\n" +
                "$ javac mainclass.java\n" +
                "$ java mainclass\n" +
                "66");
        Question q4 = new Question("How to get difference between two dates?", "Date diffInMilli = java.time.Duration.between(dateTime1, dateTime2).toMillis();", "long diffInMilli = java.time.Duration.between(dateTime1, dateTime2).toMillis();", "Time diffInMilli = java.time.Duration.between(dateTime1, dateTime2).toMillis();", "long diffInMilli = java.time.difference(dateTime1, dateTime2).toMillis();", 2, Question.DIFFICULTY_SET3, "Java 8 provides a method called between which provides Duration between two times.");
        Question q5 = new Question("Which of the following is not a valid jump statement?", "return", "break", "goto", "continue", 3, Question.DIFFICULTY_SET3, " break, continue and return transfer control to another part of the program and returns back to caller after execution. However, goto is marked as not used in Java.");

        Question q6 = new Question("Which of the following has the highest memory requirement?", "Stack", "Class", "JVM", "Heap", 3, Question.DIFFICULTY_SET3, "JVM is the super set which contains heap, stack, objects, pointers, etc.");

        Question q7 = new Question("What is true about do statement?", "do statement executes the code more than once always", "do statement does not get execute if condition is not matched in the first iteration", "do statement checks the condition at the beginning of the loop", "do statement executes the code of a loop at least once ", 4, Question.DIFFICULTY_SET3, "Do statement checks the condition at the end of the loop. Hence, code gets executed at least once.");

        Question q8 = new Question("Which of the following is used with the switch statement?", "Exit", "Continue", "do", "break", 4, Question.DIFFICULTY_SET3, "Break is used with a switch statement to shift control out of switch.");

        Question q9 = new Question(" Which keyword is used by the method to refer to the object that invoked it?", "this", "catch", "import", "abstract", 1, Question.DIFFICULTY_SET3, "this keyword can be used inside any method to refer to the current object. this is always a reference to the object on which the method was invoked.");

        Question q10 = new Question("Which of the following statements are incorrect?", "Every string is an object of class String", "Strings in java are mutable", "Java defines a peer class of String, called StringBuffer, which allows string to be altered", "String is a class", 2, Question.DIFFICULTY_SET3, " Strings in Java are immutable that is they can not be modified.");

        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);
        addQuestion(q6);
        addQuestion(q7);
        addQuestion(q8);
        addQuestion(q9);
        addQuestion(q10);

    }

    private void set4() {

        Question q1 = new Question("Which of these methods return a class object given its name?", "getSystemClass()", "findSystemClass()", "findClass()", "getClass()", 2, Question.DIFFICULTY_SET4, "findSystemClass() returns a class object given its name.");
        Question q2 = new Question("Which of these process occur automatically by the java runtime system?", "Garbage collection", "All of the mentioned", "File Filtering", "Serialization", 4, Question.DIFFICULTY_SET4, "Serialization and deserialization occur automatically by java runtime system, Garbage collection also occur automatically but is done by CPU or the operating system not by the java runtime system.");
        Question q3 = new Question("What is the output of this program?\n" +
                "\n" +
                " \n" +
                "    import java.net.*;\n" +
                "    class networking \n" +
                "    {\n" +
                "        public static void main(String[] args) throws UnknownHostException \n" +
                "        {\n" +
                "            InetAddress obj1 = InetAddress.getByName(\"sanfoundary.com\");\n" +
                "            InetAddress obj2 = InetAddress.getByName(\"sanfoundary.com\");\n" +
                "            boolean x = obj1.equals(obj2); \n" +
                "            System.out.print(x);\n" +
                "        }\n" +
                "    }", "1", "true", "0", "false", 2, Question.DIFFICULTY_SET4, "Output:\n" +
                " \n" +
                "$ javac networking.java\n" +
                "$ java networking \n" +
                "true");
        Question q4 = new Question("If member does not implement serialization, which exception would be thrown?", "NotSerializableException", "SerializableException", "UnSerializedException", "RuntimeException", 1, Question.DIFFICULTY_SET4, "JIf member of a class does not implement serialization, NotSerializationException will be thrown.");
        Question q5 = new Question("What will be printed to the output and written to the file, in the below program?\n" +
                "\n" +
                " \n" +
                "import java.io.FileOutputStream;  \n" +
                "public class FileOutputStreamExample\n" +
                "{  \n" +
                "    public static void main(String args[])\n" +
                "    {    \n" +
                "           try\n" +
                "           {    \n" +
                "             FileOutputStream fout=new FileOutputStream(\"D:\\\\sanfoundry.txt\");    \n" +
                "             String s=\"Welcome to Sanfoundry.\";    \n" +
                "             byte b[]=s.getBytes();//converting string into byte array    \n" +
                "             fout.write(b);    \n" +
                "             fout.close();    \n" +
                "             System.out.println(\"Success\");    \n" +
                "            }  catch(Exception e){System.out.println(e);}    \n" +
                "      }    \n" +
                "}", "only \"Welcome to Sanfoundry\" to the file", "No Output", "compile time error", "\"Success\" to the output and \"Welcome to Sanfoundry\" to the file", 4, Question.DIFFICULTY_SET4, "First, it will print \"Success\" and besides that it will write \"Welcome to Sanfoundry\" to the file sanfoundry.txt.");

        Question q6 = new Question("What is the output of this program?\n" +
                "\n" +
                "   \n" +
                "    class Output\n" +
                "    {\n" +
                "        public static void main(String args[])\n" +
                "        {\n" +
                "\t    char a = (char) 98;\n" +
                "            a = Character.toUpperCase(a);\n" +
                "            System.out.print(a);\n" +
                "        }\n" +
                "    }", "b", "B", "C", "c", 2, Question.DIFFICULTY_SET4, "Output:\n" +
                " \n" +
                "$ javac Output.java\n" +
                "$ java Output\n" +
                "B");

        Question q7 = new Question("What is the output of this program?\n" +
                "\n" +
                " \n" +
                "    class Output \n" +
                "    {\n" +
                "         public static void main(String args[])\n" +
                "         {\n" +
                "             char a[] = {'a', '5', 'A', ' '};   \n" +
                "             System.out.print(Character.isDigit(a[0])+ \" \");\n" +
                "             System.out.print(Character.isWhitespace(a[3])+ \" \");\n" +
                "             System.out.print(Character.isUpperCase(a[2]));\n" +
                "        }\n" +
                "    }", "false false false", "true true false", "false true true", "true false true", 3, Question.DIFFICULTY_SET4, "Character.isDigit(a[0]) checks for a[0], whether it is a digit or not, since a[0] i:e 'a' is a character false is returned. a[3] is a whitespace hence Character.isWhitespace(a[3]) returns a true. a[2] is an uppercase letter i:e 'A' hence Character.isUpperCase(a[2]) returns true.");

        Question q8 = new Question(" Which of these method of MimeHeader is used to return the string equivalent of the values stores on MimeHeader?", "string()", "toString()", "convertString()", "getString()", 2, Question.DIFFICULTY_SET4, " toString() does the reverse of parse() method, it is used to return the string equivalent of the values stores on MimeHeader.");

        Question q9 = new Question(" Which of these method converts radians to degrees?", "toDegree()", "converDegree()", "convertRadian()", "toRadian()", 1, Question.DIFFICULTY_SET4, "Answer one is correct");

        Question q10 = new Question("Which of the following exceptions is thrown by every method of Runtime class?", "IOException", "SecurityException", "RuntimeException", "SystemException", 2, Question.DIFFICULTY_SET4, "Every method of Runtime class throws SecurityException.");

        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);
        addQuestion(q6);
        addQuestion(q7);
        addQuestion(q8);
        addQuestion(q9);
        addQuestion(q10);
    }

    private void set5() {

        Question q1 = new Question("Which of these is a method of ObjectOutput interface used to finalize the output state so that any buffers are cleared?", "fflush()", "close()", "clear()", "flush()", 4, Question.DIFFICULTY_SET5, "Answer four is correct");
        Question q2 = new Question("How an object can become serializable?", "If a class implements java.io.Serializable class", "If a class or any superclass implements java.io.Serializable interface", "No object is serializable", "Any object is serializable", 2, Question.DIFFICULTY_SET5, "A Java object is serializable if class or any its superclass implements java.io.Serializable or its subinterface java.io.Externalizable.");
        Question q3 = new Question("What is the output of this program?\n" +
                "\n" +
                "   \n" +
                "    class Output \n" +
                "    {\n" +
                "        public static void main(String args[]) \n" +
                "        {\n" +
                "            double x = 3.14;  \n" +
                "            int y = (int) Math.toRadians(x);\n" +
                "            System.out.print(y);\n" +
                "        }\n" +
                "    }", "3", "0", "3.1", "3.0", 2, Question.DIFFICULTY_SET5, "Output:\n" +
                " \n" +
                "$ javac Output.java\n" +
                "$ java Output\n" +
                "0");
        Question q4 = new Question("What is the output of this program?\n" +
                "\n" +
                " \n" +
                "    import java.net.*;\n" +
                "    class networking \n" +
                "    {\n" +
                "        public static void main(String[] args) throws MalformedURLException \n" +
                "        {\n" +
                "            URL obj = new URL(\"https://www.sanfoundry.com/javamcq\");\n" +
                "            System.out.print(obj.toExternalForm());\n" +
                "        }\n" +
                "    }", "sanfoundry", "www.sanfoundry.com", "https://www.sanfoundry.com/javamcq", "sanfoundry.com", 3, Question.DIFFICULTY_SET5, "toExternalForm() is used to know the full URL of an URL object.\n" +
                "Output:\n" +
                " \n" +
                "$ javac networking.java\n" +
                "$ java networking \n" +
                "https://www.sanfoundry.com/javamcq");
        Question q5 = new Question("Which of these is a method of ObjectInput interface used to deserialize an object from a stream?", "void close()", "int read()", "Object WriteObject()", "Object readObject()", 4, Question.DIFFICULTY_SET5, "Answer four is correct");

        Question q6 = new Question("Which of these transfer protocol must be used so that URL can be accessed by URLConnection class object?", "Any Protocol can be used", "None of the mentioned", "http", "https", 3, Question.DIFFICULTY_SET5, "For a URL to be accessed from remote location http protocol must be used.");

        Question q7 = new Question("What is the output of this program?\n" +
                "\n" +
                " \n" +
                "    import java.util.*;\n" +
                "    class Bitset \n" +
                "    {\n" +
                "        public static void main(String args[])\n" +
                "        {\n" +
                "            BitSet obj = new BitSet(5);\n" +
                "            for (int i = 0; i < 5; ++i)\n" +
                "                obj.set(i);\n" +
                "            obj.clear(2);\n" +
                "            System.out.print(obj.length() + \" \" + obj.size());\n" +
                "        }\n" +
                "    }", "4 128", "4 64", "5 128", "5 64", 4, Question.DIFFICULTY_SET5, "obj.length() returns the length allotted to object obj at time of initialization and obj.size() returns the size of current object obj, each BitSet element is given 16 bits therefore the size is 4 * 16 = 64, whereas length is still 5.\n" +
                "Output:\n" +
                " \n" +
                "$ javac Bitset.java\n" +
                "$ java Bitset\n" +
                "5 64");

        Question q8 = new Question("How to externally synchronize hashmap?", "HashMap a = new HashMap();\n" +
                "a.synchronize();", "Collections.synchronizedMap(new HashMap<String, String>());", "Collections.synchronize(new HashMap<String, String>());", "HashMap.synchronize(HashMap a);", 2, Question.DIFFICULTY_SET5, " Collections.synchronizedMap() synchronizes entire map. ConcurrentHashMap provides thread safety without synchronizing entire map.");

        Question q9 = new Question("When two threads access the same ArrayList object what is the outcome of the program?", "ConcurrentModificationException is thrown", "One thread is able to access the object and second thread will wait till control is passed to the second one", "One thread is able to access the object and second thread gets Null Pointer exception", "Both are able to access the object", 1, Question.DIFFICULTY_SET5, "ArrayList is not synchronized. Vector is the synchronized data structure.");

        Question q10 = new Question("What happens if two threads simultaneously modify TreeSet?", "FailFastException is thrown", "IteratorModificationException is thrown", "ConcurrentModificationException is thrown", "Both threads can perform action successfully", 3, Question.DIFFICULTY_SET5, "TreeSet provides fail-fast iterator. Hence when concurrently modifying TreeSet it throws ConcurrentModificationException.");

        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);
        addQuestion(q6);
        addQuestion(q7);
        addQuestion(q8);
        addQuestion(q9);
        addQuestion(q10);

    }

    private void set6() {
        Question q1 = new Question("Which function of pre defined class Thread is used to check weather current thread being checked is still running?", "isRunning()", "Join()", "Alive()", "isAlive()", 4, Question.DIFFICULTY_SET6, "isAlive() function is defined in class Thread, it is used for implementing multithreading and to check whether the thread called upon is still running or not.");
        Question q2 = new Question("Which of the following operators is used to generate instance of an exception which can be thrown using throw?", "new", "thrown", "alloc", "malloc", 1, Question.DIFFICULTY_SET6, "new operator is used to create instance of an exception. Exceptions may have parameter as a String or have no parameter.");
        Question q3 = new Question("Which of these methods return localized description of an exception?", "obtainLocalizedMessage()", "printLocalizedMessage()", "getMessage()", "getLocalizedMessage()", 4, Question.DIFFICULTY_SET6, "Answer four is correct");
        Question q4 = new Question("Which of these keywords are used to implement synchronization?", "synch", "synchronized", "synchronize", "syn", 2, Question.DIFFICULTY_SET6, "Answer two is correct");
        Question q5 = new Question("Which of these handles the exception when no catch is used?", "Java run time system", "finally", "Default handler", "throw handler", 3, Question.DIFFICULTY_SET6, "Answer three is correct");

        Question q6 = new Question(" What requires less resources?", "Neither Thread nor Process", "Process", "Thread", "Thread and Process", 3, Question.DIFFICULTY_SET6, "Thread is a lightweight and requires less resources to create and exist in the process. Thread shares the process resources.");

        Question q7 = new Question("What is the name of the thread in output of this program?\n" +
                "\n" +
                " \n" +
                "    class multithreaded_programing\n" +
                "    {\n" +
                "        public static void main(String args[])\n" +
                "        {\n" +
                "            Thread t = Thread.currentThread();\n" +
                "            System.out.println(t);        \n" +
                "        }\n" +
                "    }", "None of the mentioned", "Thread", "main", "System", 3, Question.DIFFICULTY_SET6, "The output of program is Thread[main,5,main], Since we have not explicitly named the thread they are named by the group to they belong i:e main method. Hence they are named 'main'.\n" +
                "Output:\n" +
                "$ javac multithreaded_programing.java\n" +
                "$ java multithreaded_programing\n" +
                "Thread[main,5,main]");

        Question q8 = new Question("Which of this interface must contain a unique element?", "Array", "Collection", "Set", "List", 3, Question.DIFFICULTY_SET6, "Set interface extends collection interface to handle sets, which must contain unique elements.");

        Question q9 = new Question("Which of these is true about unmodifiableCollection() method?", "unmodifiableCollection() returns a collection that cannot be modified", "none of the mentioned", "unmodifiableCollection() method is available only for List and Set", "unmodifiableCollection() is defined in Collection class", 3, Question.DIFFICULTY_SET6, "unmodifiableCollection() is available for al collections, Set, Map, List etc.");

        Question q10 = new Question("What is multithreaded programming?", "It’s a process in which a single process can access information from many sources", "It’s a process in which many different process are able to access same information", "It’s a process in which two or more parts of same process run simultaneously", "It’s a process in which two different processes run simultaneously", 3, Question.DIFFICULTY_SET6, "Multithreaded programming a process in which two or more parts of the same process run simultaneously.");

        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);
        addQuestion(q6);
        addQuestion(q7);
        addQuestion(q8);
        addQuestion(q9);
        addQuestion(q10);

    }

    private void set7() {
        Question q1 = new Question("Which of these methods is used to notify observer the change in observed object?", "update()", "check()", "notify()", "observed()", 1, Question.DIFFICULTY_SET7, "Answer one is correct");
        Question q2 = new Question(" What is the output of this program?\n" +
                "\n" +
                " \n" +
                "    import java.util.*;\n" +
                "    class LOCALE_CLASS\n" +
                "    {\n" +
                "        public static void main(String args[])\n" +
                "        {\n" +
                "            Locale obj = new Locale(\"INDIA\") ;\n" +
                "            System.out.print(obj.getCountry());\n" +
                "        }", "Nothing is displayed", "INDIA", "Compilation Error", "India", 1, Question.DIFFICULTY_SET7, "Output:\n" +
                "$ javac LOCALE_CLASS.java\n" +
                "$ java LOCALE_CLASS");
        Question q3 = new Question(" Which of these events is generated when the window is closed?", "WindowEvent", "MouseEvent", "TextEvent", "FocusEvent", 1, Question.DIFFICULTY_SET7, " A WindowEvent is generated when a window is opened, close, activated or deactivated.");
        Question q4 = new Question(" Which of these methods is used to get x coordinate of the mouse?", "getXCoordinate()", "getCoordinateX()", "getPointX()", "getX()", 4, Question.DIFFICULTY_SET7, "getX() and getY() are used to obtain X AND Y coordinates of the mouse.");
        Question q5 = new Question("Which of these is a type of stream in Java?", "Short stream", "Integer stream", "Byte stream", "Long stream", 3, Question.DIFFICULTY_SET7, "Java defines only two types of streams - Byte stream and character stream.");

        Question q6 = new Question("Which of these method of Locale class can be used to obtain country of operation?", "whichCountry()", "getCountry()", "getDisplayCountry()", "DisplayCountry()", 3, Question.DIFFICULTY_SET7, "Answer three is correct ");

        Question q7 = new Question("Which of the following matches nonword character using regular expression in java?", "\\W", "\\s", "\\S", "\\w", 1, Question.DIFFICULTY_SET7, "\\W matches nonword characters. [0-9], [A-Z] and _ (underscore) are word characters. All other than these characters are nonword characters.");

        Question q8 = new Question(" What is the signature of Math.random() method?", "public void int random()", "public static int random()", "public void double random()", "public static double random()", 4, Question.DIFFICULTY_SET7, "public static double random() is the utility method provided by Math class which returns double.");

        Question q9 = new Question("Which of these classes can schedule task for execution in future?", "Observer", "Timer", "System", "Thread", 2, Question.DIFFICULTY_SET7, "Timer and TimerTask are the classes that support the ability to schedule tasks for execution at some future time.");

        Question q10 = new Question(" Which of these modifiers can be used for a variable so that it can be accessed from any thread or parts of a program?", "transient", "No modifier is needed", "global", "volatile", 4, Question.DIFFICULTY_SET7, "The volatile modifier tells the compiler that the variable modified by volatile can be changed unexpectedly by other part of the program. Specially used in situations involving multithreading.");

        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);
        addQuestion(q6);
        addQuestion(q7);
        addQuestion(q8);
        addQuestion(q9);
        addQuestion(q10);


    }

    private void set8() {
        Question q1 = new Question("Which of these interfaces handles the event when a component is added to a container?", "ContainerListener", "InputListener", "FocusListener", "ComponentListener", 1, Question.DIFFICULTY_SET8, "The ContainerListener defines methods to recognize when a component is added to or removed from a container.");
        Question q2 = new Question(" What is the range of numbers returned by Math.random() method?", "0 to 100", "-1.0 to 1.0", "-1 to 1", "0.0 to 1.0", 4, Question.DIFFICULTY_SET8, "Math.random() returns only double value greater than or equal to 0.0 and less than 1.0.");
        Question q3 = new Question("What is the output of this program?\n" +
                "\n" +
                " \n" +
                "    class output\n" +
                "    {\n" +
                "        public static void main(String args[])\n" +
                "        { \n" +
                "           StringBuffer s1 = new StringBuffer(\"Hello\");\n" +
                "           s1.setCharAt(1,x);\n" +
                "           System.out.println(s1);\n" +
                "        }\n" +
                "    }", "xello", "Hexlo", "xxxxx", "Hxllo", 4, Question.DIFFICULTY_SET8, "Output:\n" +
                "$ javac output.java\n" +
                "$ java output\n" +
                "Hxllo");
        Question q4 = new Question("Which of these is used to read a string from the input stream?", "get()", "getLine()", "readLine()", "read()", 4, Question.DIFFICULTY_SET8, "Answer four is correct");
        Question q5 = new Question("What is the output of this program?\n" +
                "\n" +
                "    \n" +
                "    class output\n" +
                "    {\n" +
                "        public static void main(String args[])\n" +
                "        {\n" +
                "            String a=\"hello i love java\";\n" +
                "            System.out.println(indexof('i')+\" \"+indexof('o')+\" \"+lastIndexof('i')+\" \"+lastIndexof('o') ));\n" +
                "        }\n" +
                "    }", "6 4 6 9", "7 8 8 9", "4 3 6 9", "5 4 5 9", 1, Question.DIFFICULTY_SET8, "indexof('c') and lastIndexof('c') are pre defined function which are used to get the index of first and last occurrence of\n" +
                "the character pointed by c in the given array.\n" +
                "Output:\n" +
                "$ javac output.java\n" +
                "$ java output\n" +
                "6 4 6 9");

        Question q6 = new Question("Which of these method returns an instance of DateFormat that can format time information?", "getDateFormatinstance()", "getTime()", "getTimeInstance()", "getTimeDateinstance()", 3, Question.DIFFICULTY_SET8, "getTimeInstance() method returns an instance of DateFormat that can format time information.");

        Question q7 = new Question(" Which of these methods is used to write() into a file?", "putFile()", "write()", "put()", "writeFile()", 2, Question.DIFFICULTY_SET8, "Answer two is correct");

        Question q8 = new Question("Which of these methods are used to register a keyboard event listener?", "addKistener()", "KeyListener()", "eventKeyboardListener()", "addKeyListener()", 4, Question.DIFFICULTY_SET8, "Answer four is correct");

        Question q9 = new Question("Which of these methods are used to register a mouse motion listener?", "addMouseMotionListner()", "addMouseListener()", "eventMouseMotionListener()", "addMouse()", 1, Question.DIFFICULTY_SET8, "Answer one is correct");

        Question q10 = new Question("Which of these classes are used by Byte streams for input and output operation?", "All of the mentioned", "InputStream", "InputOutputStream", "Reader", 2, Question.DIFFICULTY_SET8, "Byte stream uses InputStream and OutputStream classes for input and output operation.");

        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);
        addQuestion(q6);
        addQuestion(q7);
        addQuestion(q8);
        addQuestion(q9);
        addQuestion(q10);


    }

    private void set9() {
        Question q1 = new Question("Which of these methods can be used to determine the type of adjustment event?", "getType()", "getAdjustmentType()", "getEventType()", "getEventObjectType()", 2, Question.DIFFICULTY_SET9, "Answer two is correct");
        Question q2 = new Question("What would be the output of following code snippet?\n" +
                "\n" +
                "int a = random.nextInt(7) + 4;", "Random number between 4 to 7, including 4 and 7", "Random number between 4 to 10, excluding 4 and 10", "Random number between 4 to 10, including 4 and 10", "Random number between 4 to 7, excluding 4 and 7", 3, Question.DIFFICULTY_SET9, "random.nextInd(7) + 4; returns random numbers between 4 to 10 including 4 and 10. it follows \"nextInt(max - min +1) + min\" formula.");
        Question q3 = new Question("Which of these methods can be used to get reference to a component that was removed from a container?", "getComponentChild()", "getContainerComponent()", "getchild()", "getComponent()", 3, Question.DIFFICULTY_SET9, "The getChild() method returns a reference to the component that was added to or removed from the container.");
        Question q4 = new Question("Which of these packages contains all the classes and methods required for even handling in Java?", "java.applet", "java.awt.event", "java.event", "java.awt", 2, Question.DIFFICULTY_SET9, "Most of the event to which an applet response is generated by a user. Hence they are in Abstract Window Kit package, java.awt.event.");
        Question q5 = new Question("What is used to inject mock fields into the tested object automatically?", "@Inject", "@InjectMockObject", "@InjectMocks", "@Mock", 3, Question.DIFFICULTY_SET9, "@InjectMocks annotation is used to inject mock fields into the tested object automatically.\n" +
                "@InjectMocks\n" +
                "MyDictionary dic = new MyDictionary();");

        Question q6 = new Question("Which of these is an correct way of defining generic class?", "class name(T1, T2, ..., Tn) { /* ... */ }", "class name[T1, T2, ..., Tn] { /* ... */ }", "class name{T1, T2, ..., Tn} { /* ... */ }", "class name { /* ... */ }", 4, Question.DIFFICULTY_SET9, "The type parameter section, delimited by angle brackets (<>), follows the class name. It specifies the type parameters (also called type variables) T1, T2, ..., and Tn.");

        Question q7 = new Question("Which method can be used to check fileAccessiblity?", "isReadable(path), isWritable(path), and isExecutable(path)", "isWritable(path)", "isExecutable(path)", "isReadable(path)", 1, Question.DIFFICULTY_SET9, " File accessibilty can be checked using isReadable(Path), isWritable(Path), and isExecutable(Path).");

        Question q8 = new Question("Which of the following is a best practice to measure time taken by a process for execution?", "System.nanoTime()", "System.getCurrentTime()", "System.currentTimeMillis()", "System.getProcessingTime()", 1, Question.DIFFICULTY_SET9, "System.nanoTime takes around 1/100000 th of a second whereas System.currentTimeMillis takes around 1/1000th of a second.");

        Question q9 = new Question("Which of these is an correct way of defining generic method?", "public <T1, T2, ..., Tn> name { /* ... */ }", "class <T1, T2, ..., Tn> name[T1, T2, ..., Tn] { /* ... */ }", "<T1, T2, ..., Tn> name(T1, T2, ..., Tn) { /* ... */ }", "<T1, T2, ..., Tn> name{T1, T2, ..., Tn} { /* ... */ }", 1, Question.DIFFICULTY_SET9, "The syntax for a generic method includes a type parameter, inside angle brackets, and appears before the method's return type. For static generic methods, the type parameter section must appear before the method's return type.");

        Question q10 = new Question("Which of these type parameters is used for a generic class to return and accept a number?", "T", "N", "V", "K", 2, Question.DIFFICULTY_SET9, "N is used for Number.");

        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);
        addQuestion(q6);
        addQuestion(q7);
        addQuestion(q8);
        addQuestion(q9);
        addQuestion(q10);


    }


    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        cv.put(QuestionsTable.COLUMN_SOLUTION, question.getSolution());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestion() {
        ArrayList<Question> questionsList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();

                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setSolution(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_SOLUTION)));

                questionsList.add(question);
            }
            while (c.moveToNext());
        }

        c.close();
        return questionsList;
    }


    public ArrayList<Question> getQuestion(String difficulty) {
        ArrayList<Question> questionsList = new ArrayList<>();
        db = getReadableDatabase();
        String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_DIFFICULTY +
                " =?", selectionArgs);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();

                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setSolution(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_SOLUTION)));


                questionsList.add(question);
            }
            while (c.moveToNext());
        }

        c.close();
        return questionsList;
    }
}
