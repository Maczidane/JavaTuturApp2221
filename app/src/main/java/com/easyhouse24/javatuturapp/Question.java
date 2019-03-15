package com.easyhouse24.javatuturapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable {
    private String question;

    public static final String DIFFICULTY_SET1 = "set1";
    public static final String DIFFICULTY_SET2 = "set2";
    public static final String DIFFICULTY_SET3 = "set3";
    public static final String DIFFICULTY_SET4 = "set4";
    public static final String DIFFICULTY_SET5 = "set5";
    public static final String DIFFICULTY_SET6 = "set6";
    public static final String DIFFICULTY_SET7 = "set7";
    public static final String DIFFICULTY_SET8 = "set8";
    public static final String DIFFICULTY_SET9 = "set9";
    public static final String SOLUTION = "solution";



    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private String difficulty;
    private String solution;

    private int answerNr;

    public Question()
    {

    }

    public Question(String question, String option1, String option2, String option3, String option4, int answerNr,String difficulty,String solution) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNr = answerNr;
        this.difficulty = difficulty;
        this.solution = solution;
    }

    protected Question(Parcel in) {
        question = in.readString();
        option1 = in.readString();
        option2 = in.readString();
        option3 = in.readString();
        option4 = in.readString();
        answerNr = in.readInt();
        difficulty = in.readString();
        solution = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(option1);
        dest.writeString(option2);
        dest.writeString(option3);
        dest.writeString(option4);
        dest.writeInt(answerNr);
        dest.writeString(difficulty);
        dest.writeString(solution);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    public static String[] getAllDifficultyLevels()
    {
        return  new  String[]{
                DIFFICULTY_SET1,
                DIFFICULTY_SET2,
                DIFFICULTY_SET3,
                DIFFICULTY_SET4,
                DIFFICULTY_SET5,
                DIFFICULTY_SET6,
                DIFFICULTY_SET7,
                DIFFICULTY_SET8,
                DIFFICULTY_SET9
        };

    }
}
