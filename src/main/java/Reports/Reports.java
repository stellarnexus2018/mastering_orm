package Reports;

import Entity.Exam;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class Reports {
  public List<ExamResult> getExamResults(String firstName, String lastName, Session sess) {
    String query = "select new Reports.ExamResult(s.lastName, sj.name, e.grade) " +
        "from Exam e, Student s, Subject sj " +
        "where e.student.id = s.id and e.subject.id = sj.id " +
        "and s.firstName = :firstName and s.lastName = :lastName";
    Query q = sess.createQuery(query);
    q.setParameter("firstName", firstName);
    q.setParameter("lastName", lastName);

    return q.getResultList();

  }

  public List<ExamResult> getExamResultsSimple(String firstName, String lastName, Session sess) {
    String query = "select new Reports.ExamResult(e.student.lastName, e.subject.name, e.grade) " +
        "from Exam e " +
        "where e.student.firstName = :firstName and e.student.lastName = :lastName";
    Query q = sess.createQuery(query);
    q.setParameter("firstName", firstName);
    q.setParameter("lastName", lastName);

    return q.getResultList();
  }

  public List<Exam> getExamResultsCrit(String firstName, String lastName, Session sess) {
    Criteria cr = sess.createCriteria(Exam.class);

    cr.setMaxResults(10);
    cr.createAlias("student", "s");
    cr.add(Restrictions.and(
        Restrictions.eq("s.firstName", firstName),
        Restrictions.eq("s.lastName", lastName)
    ));
    return cr.list();
  }






}