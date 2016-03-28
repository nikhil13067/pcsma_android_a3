package coplus.example.provenlogic1.googleplus_connect;

import java.util.List;

/**
 * Created by nikhil on 13/3/16.
 */
public class Quiz {

    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private Student user;

    private String course_name;

    private List<Question> questions;

    public Quiz(long id, String name, String course_name, List<Question> questions) {
        this.id = id;
        this.name = name;
        this.course_name = course_name;
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", course_name='" + course_name + '\'' +
                ", questions=" + questions +
                '}';
    }

    public Quiz() {
    }

    public Student getUser() {
        return user;
    }

    public void setUser(Student user) {
        this.user = user;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
