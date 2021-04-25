package Reports;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Reports {
  public List<ExamResult> getExamResults(String firstName, String lastName, Session sess) {
    String query = "select new Reports.ExamResult(s.lastName, sj.name, e.grade) " +
        "from Exam e, Student s, Subject sj " +
        "where e.student.id = s.id and e.subject.id = s.id " +
        "and s.firstName = :firstName and s.lastName = :lastName";
    Query q = sess.createQuery(query);
    q.setParameter("firstName", firstName);
    q.setParameter("lastName", lastName);

    return q.getResultList();

  }


}
