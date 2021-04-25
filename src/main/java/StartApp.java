import Entity.Exam;
import Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Set;

public class StartApp {
  public static void main(String[] args) {
    SessionFactory sfact = new Configuration()
        .configure()
        .buildSessionFactory();

    Session sess = sfact.openSession();
    Transaction trans = sess.beginTransaction();

    /*Student s = new Student();
    s.setFirstName("Igor");
    s.setLastName("Grigoryev");
    s.setAge(47);
    sess.save(s);*/


    Student z = sess.get(Student.class, 3);
    Set<Exam> exams = z.getExams();
    System.out.println(z);
    System.out.println(exams);



    trans.commit();

    sess.close();
    sfact.close();
  }
}