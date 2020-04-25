package model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;

    @NotNull
    String text;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<Answer>();;

    @ManyToOne
    @JoinColumn(name = "quizId", nullable = false)
    private Quiz quiz;

    public Question(String text){
        this.text = text;
    }

    public void addAnswer(Answer answer){
        answer.setQuestion(this);
        this.answers.add(answer);
    }
}
