package controller;

import model.Answer;
import model.Question;
import model.Quiz;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class DBController {
    private final Configuration config;
    private final SessionFactory factory;
    private static DBController instance;

    public static DBController getInstance(){
        if (instance == null){
            instance = new DBController();
        }
        return instance;
    }

    private DBController() {
        this.config = new Configuration();
        this.config.configure("hibernate.cfg.xml");
        this.factory = config.buildSessionFactory();
    }

    public void saveQuiz(Quiz quiz){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(quiz);
        transaction.commit();
        session.close();
    }

    public List<Quiz> getAllQuizzes(){
        Session session = factory.openSession();

        List<Quiz> result = session.createQuery("FROM Quiz", Quiz.class).getResultList();

        session.close();
        return result;
    }
}
