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
@Setter
@Getter
@NoArgsConstructor
@Table(name = "Quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int quizId;

    @NotNull
    private String quizTitle;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<Question>();;

    public Quiz(String title){
        this.quizTitle = title;
    }

    public void addQuestion(Question question){
        question.setQuiz(this);
        this.questions.add(question);
    }
}
