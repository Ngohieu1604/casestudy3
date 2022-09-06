package service;

import model.Student;

import java.util.List;

public interface IStudentDAO {
    public List<Student> findAll();

    public List<Student> findByName(String name);

    public void save(Student student);

    public void edit(int id, Student student);

    public void delete(Student student);
}
