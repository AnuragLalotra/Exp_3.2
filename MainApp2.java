package com.example.hibernatecrud;
import java.util.*;
public class MainApp {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Student s = new Student();
        s.setName("Ravi");
        s.setDept("CSE");
        s.setMarks(88.5);
        dao.saveStudent(s);
        List<Student> list = dao.getStudents();
        list.forEach(st -> System.out.println(st.getId() + " " + st.getName() + " " + st.getDept() + " " + st.getMarks()));
        dao.updateStudent(s.getId(), 90.0);
        dao.deleteStudent(s.getId());
    }
}
