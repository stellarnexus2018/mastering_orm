import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StartApp {


  public static void main(String[] args) {
    SessionFactory sfact = new Configuration()
        .configure()
        .buildSessionFactory();

    Session sess = sfact.openSession();
    //Transaction trans = sess.beginTransaction();








    //trans.commit();




    sess.close();
    sfact.close();



  }



}
