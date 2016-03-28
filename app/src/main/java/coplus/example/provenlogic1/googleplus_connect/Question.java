package coplus.example.provenlogic1.googleplus_connect;

/**
 * Created by nikhil on 13/3/16.
 */
public class Question {
    private String name;
    private String option1;
    private int option1_count;
    private String option2;
    private int option2_count;
    private String option3;
    private int option3_count;
    private String option4;
    private int option4_count;
    private int correct_option;

    public Question(String name, String option1, String option2, String option3, String option4, int correct_option) {
        this.name = name;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option1_count = 0;
        this.option2_count = 0;
        this.option3_count = 0;
        this.option4_count = 0;
        this.correct_option = correct_option;

    }

    @Override
    public String toString() {
        return "Question{" +
                "name='" + name + '\'' +
                ", option1='" + option1 + '\'' +
                ", option1_count=" + option1_count +
                ", option2='" + option2 + '\'' +
                ", option2_count=" + option2_count +
                ", option3='" + option3 + '\'' +
                ", option3_count=" + option3_count +
                ", option4='" + option4 + '\'' +
                ", option4_count=" + option4_count +
                ", correct_option=" + correct_option +
                '}';
    }

    //Introducing the dummy constructor
    public Question() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public int getOption1_count() {
        return option1_count;
    }

    public void setOption1_count(int option1_count) {
        this.option1_count = option1_count;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public int getOption2_count() {
        return option2_count;
    }

    public void setOption2_count(int option2_count) {
        this.option2_count = option2_count;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getOption3_count() {
        return option3_count;
    }

    public void setOption3_count(int option3_count) {
        this.option3_count = option3_count;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getOption4_count() {
        return option4_count;
    }

    public void setOption4_count(int option4_count) {
        this.option4_count = option4_count;
    }


    public int getCorrect_option() {
        return correct_option;
    }

    public void setCorrect_option(int correct_option) {
        this.correct_option = correct_option;
    }
}
