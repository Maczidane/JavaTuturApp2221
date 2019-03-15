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


    }

    private void set1() {

        Question q1 = new Question("Which version of Java introduced annotation?", "Java 5", "Java 6", "Java 7", "Java 8", 1, Question.DIFFICULTY_SET1,"Answer 1 is correct. No explanation");
        Question q2 = new Question(" What is the range of short data type in Java?", "-128 to 127", "-32768 to 32767", "-2147483648 to 2147483647", "None of the mentioned", 2, Question.DIFFICULTY_SET1,"Answer 2 is correct. No explanation");
        Question q3 = new Question("Which of these can be returned by the operator &?", "Integer", "Boolean", "Character", "Integer or Boolean", 4, Question.DIFFICULTY_SET1,"Answer 4 is correct. No explanation");
        Question q4 = new Question("Which of these can not be used for a variable name in Java?", "identifier", "keyword", "identifier & keyword", "none of the mentioned", 2, Question.DIFFICULTY_SET1,"Answer 2 is correct. No explanation");
        Question q5 = new Question("Which of these is an incorrect string literal?", "“Hello World”", "“Hello\\nWorld”", "“\\”Hello World\\””", "\"Hello\n" +
                "  world\"", 4, Question.DIFFICULTY_SET1,"Answer 4 is correct. No explanation");

        Question q6 = new Question("What is correct syntax for main method of a java class?", "public static int main(String[] args)", "public int main(String[] args)", "public static void main(String[] args)", "None of the above.", 3, Question.DIFFICULTY_SET1,"Correct syntax is public static void main(String[] args).");

        Question q7 = new Question("What is the size of long variable?", "8 bit", "16 bit", "32 bit", "64 bit ", 4, Question.DIFFICULTY_SET1,"The long data type is represented by 64-bit two's complement integer.\n" +
                "\n" +
                "Minimum value: -263\n" +
                "\n" +
                "Maximum value: 263-1");

        Question q8 = new Question("What is the default value of int variable?", "0", "0.0", "null", "not defined", 1, Question.DIFFICULTY_SET1,"int variable has default value of 0 if defined as an instance/static variable.");

        Question q9 = new Question("What is the default value of Object variable?", "undefined", "0", "null", "not defined", 3, Question.DIFFICULTY_SET1,"Object variable has default value of null if defined as an instance/static variable.");

        Question q10 = new Question("What kind of variables a class can consist of?", "class variables, instance variables", "class variables, local variables, instance variables", "class variables", "class variables, local variables", 2, Question.DIFFICULTY_SET1,"A class consist of Local variable, instance variables and class variables.");

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
        Question q1 = new Question("Method Overloading is an example of", "Static Binding.", "Dynamic Binding.", "Both of the above.", "None of the above.", 1, Question.DIFFICULTY_SET2,"Method Overloading is example of static binding.");
        Question q2 = new Question("which operator is considered to be with highest precedence?", "() , []", "=", "?:", "%", 1, Question.DIFFICULTY_SET2,"Postfix operators i.e () [] . is at the highest precedence.");
        Question q3 = new Question("Which of these have highest precedence?", "++", "()", ">>", "*", 2, Question.DIFFICULTY_SET2,"Order of precedence is (highest to lowest) a -> b -> c -> d.");
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
                "    }", "16.34", "16.46666666666666", "16.46666666666667", "16.566666644", 3, Question.DIFFICULTY_SET2,"Output\n\n" +
                "$ javac average.java\n" +
                "$ java average\n" +
                "16.46666666666667");
        Question q5 = new Question("How to identify if a timezone is eligible for DayLight Saving?", "useDaylightTime() of Date class", "useDaylightTime() of DateTime class", "useDaylightTime() of TimeZone class", "useDaylightTime() of Time class", 3, Question.DIFFICULTY_SET2,"public abstract boolean useDaylightTime() is provided in TimeZone class.");

        Question q6 = new Question("What will this code print?\n" +
                "    int arr[] = new int [5];\n" +
                "    System.out.print(arr);\n", "Class name@ hashcode in hexadecimal form)", "0", "00000", "value stored in arr[0].", 1, Question.DIFFICULTY_SET2,"If we trying to print any reference variable internally, toString() will be called which is implemented to return the String in following form:\n" +
                "classname@hashcode in hexadecimal form.");

        Question q7 = new Question("Which of these is long data type literal?", "0x99fffa", "99671246", "ABCDEFG", "0x99fffL", 4, Question.DIFFICULTY_SET2,"" +"Data type long literals are appended by an upper or lowercase L. 0x99fffL is hexadecimal long literal.");

        Question q8 = new Question("What is the order of variables in Enum?", "Random order", "depends on the order() method", "Ascending order", "Descending order", 3, Question.DIFFICULTY_SET2,"The compareTo() method is implemented to order the variable in ascending order.");

        Question q9 = new Question("What is the output of this program?\n" +
                "\n" +
                "    class operators \n" +
                "    {\n" +
                "        public static void main(String args[]) \n" +
                "        {    \n" +
                "             int x = 8;\n" +
                "             System.out.println(++x * 3 + \" \" + x);\n" +
                "        } \n" +
                "    }", "24 9", "24 8", "27 8", "27 9", 4, Question.DIFFICULTY_SET2,"Operator ++ has higher precedence than multiplication operator, *, x is incremented to 9 than multiplied with 3 giving 27.\n" +
                "output:\n" +
                "$ javac operators.java\n" +
                "$ java operators\n" +
                "27 9");

        Question q10 = new Question("Can 8 byte long data type be automatically type cast to 4 byte float data type?", "True", "False", "It depends", "All of the above", 1, Question.DIFFICULTY_SET2,"Both data types have different memory representation that's why 8-byte integral data type can be stored to 4-byte floating point data type.");

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
        Question q1 = new Question("Which of these is necessary condition for automatic type conversion in Java?", "The destination type can be larger or smaller than source type", "None of the mentioned", "The destination type is larger than source type", "The destination type is smaller than source type", 3, Question.DIFFICULTY_SET3,"Answer 3 is correct. No explanation");
        Question q2 = new Question("Where is array stored in memory?", "heap space and stack space", "first generation memory", "heap space", "stack space", 2, Question.DIFFICULTY_SET3,"Array is stored in heap space. Whenever an object is created, it's always stored in the Heap space and stack memory contains the reference to it.");
        Question q3 = new Question("What is the output of this program?\n" +
                "\n" +
                "    class mainclass {\n" +
                "        public static void main(String args[]) \n" +
                "        {\n" +
                "            char a = 'A';\n" +
                "            a++;\n" +
                "\t    System.out.print((int)a);\n" +
                "        } \n" +
                "    }", "65", "67", "64", "66", 4, Question.DIFFICULTY_SET3,"ASCII value of 'A' is 65, on using ++ operator character value increments by one.\n" +
                "output:\n" +
                "$ javac mainclass.java\n" +
                "$ java mainclass\n" +
                "66");
        Question q4 = new Question("How to get difference between two dates?", "Date diffInMilli = java.time.Duration.between(dateTime1, dateTime2).toMillis();", "long diffInMilli = java.time.Duration.between(dateTime1, dateTime2).toMillis();", "Time diffInMilli = java.time.Duration.between(dateTime1, dateTime2).toMillis();", "long diffInMilli = java.time.difference(dateTime1, dateTime2).toMillis();", 2, Question.DIFFICULTY_SET3,"Java 8 provides a method called between which provides Duration between two times.");
        Question q5 = new Question("Which of the following is not a valid jump statement?", "return", "break", "goto", "continue", 3, Question.DIFFICULTY_SET3," break, continue and return transfer control to another part of the program and returns back to caller after execution. However, goto is marked as not used in Java.");

        Question q6 = new Question("Which of the following has the highest memory requirement?", "Stack", "Class", "JVM", "Heap", 3, Question.DIFFICULTY_SET3,"JVM is the super set which contains heap, stack, objects, pointers, etc.");

        Question q7 = new Question("What is true about do statement?", "do statement executes the code more than once always", "do statement does not get execute if condition is not matched in the first iteration", "do statement checks the condition at the beginning of the loop", "do statement executes the code of a loop at least once ", 4, Question.DIFFICULTY_SET3,"Do statement checks the condition at the end of the loop. Hence, code gets executed at least once.");

        Question q8 = new Question("Which of the following is used with the switch statement?", "Exit", "Continue", "do", "break", 4, Question.DIFFICULTY_SET3,"Break is used with a switch statement to shift control out of switch.");

        Question q9 = new Question(" Which keyword is used by the method to refer to the object that invoked it?", "this", "catch", "import", "abstract", 1, Question.DIFFICULTY_SET3,"this keyword can be used inside any method to refer to the current object. this is always a reference to the object on which the method was invoked.");

        Question q10 = new Question("Which of the following statements are incorrect?", "Every string is an object of class String", "Strings in java are mutable", "Java defines a peer class of String, called StringBuffer, which allows string to be altered", "String is a class", 2, Question.DIFFICULTY_SET3," Strings in Java are immutable that is they can not be modified.");

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

    }

    private void set5() {

    }

    private void set6() {

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
