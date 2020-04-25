package model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
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
}
