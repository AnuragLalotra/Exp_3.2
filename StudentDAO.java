package com.example.hibernatecrud;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;
public class StudentDAO {
    private SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    public void saveStudent(Student s) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(s);
        tx.commit();
        session.close();
    }
    public List<Student> getStudents() {
        Session session = factory.openSession();
        List<Student> list = session.createQuery("from Student", Student.class).list();
        session.close();
        return list;
    }
    public void updateStudent(int id, double marks) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Student s = session.get(Student.class, id);
        s.setMarks(marks);
        session.update(s);
        tx.commit();
        session.close();
    }
    public void deleteStudent(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Student s = session.get(Student.class, id);
        session.delete(s);
        tx.commit();
        session.close();
    }
}
