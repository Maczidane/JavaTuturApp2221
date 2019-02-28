package com.easyhouse24.javatuturapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.easyhouse24.javatuturapp.QuizContract.QuestionsTable;

import java.util.ArrayList;


public class QuizDbHelper extends SQLiteOpenHelper {

    private  static final String DATABASE_NAME = "JAVAAPP.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;



    public QuizDbHelper( Context context) {
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
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" + ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable(){
        Question q1 = new Question("Which version of Java introduced annotation?","Java 5","Java 6","Java 7","Java 8",1);
        Question q2 = new Question(" What is the range of short data type in Java?","-128 to 127","-32768 to 32767","-2147483648 to 2147483647","None of the mentioned",2);
        Question q3 = new Question("Which of these can be returned by the operator &?","Integer","Boolean","Character","Integer or Boolean",4);
        Question q4 = new Question("Which of these can not be used for a variable name in Java?","identifier","keyword","identifier & keyword","none of the mentioned",2);
        Question q5 = new Question("Which of these is an incorrect string literal?","“Hello World”","“Hello\\nWorld”","“\\”Hello World\\””","\"Hello\n" +
                "  world\"",4);
        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);

    }

    private void addQuestion(Question question)
    {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4,question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME,null,cv);
    }

    public ArrayList<Question> getAllQuestion(){
       ArrayList <Question> questionsList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c  = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME,null);

        if (c.moveToFirst()){
            do{
                Question question = new Question();

                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));

                questionsList.add(question);
            }
            while (c.moveToNext());
        }

        c.close();
        return  questionsList;
    }
}
