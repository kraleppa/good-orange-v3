package model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int answerId;

    @NotNull
    private String text;

    @NotNull
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;


    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    public Answer() {
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
