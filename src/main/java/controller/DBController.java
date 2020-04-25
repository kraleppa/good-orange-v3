package controller;

import model.Answer;
import model.Question;
import model.Quiz;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DBController {
    Configuration config;
    SessionFactory factory;

    public DBController() {
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
}
