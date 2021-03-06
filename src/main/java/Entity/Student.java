package Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "age")
  private int age;

  @Embedded
  private StudentAddress studentAddress;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
  private Set<Exam> exams;

  public Set<Exam> getExams() {
    return exams;
  }

  public void setExams(Set<Exam> exams) {
    this.exams = exams;
  }

  public StudentAddress getStudentAddress() {
    return studentAddress;
  }

  public void setStudentAddress(StudentAddress studentAddress) {
    this.studentAddress = studentAddress;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", age=" + age +
        '}';
  }
}