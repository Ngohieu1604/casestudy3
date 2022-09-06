package service;

import connection.ConnectionDB;

import model.Student;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class StudentDao implements IStudentDAO{
    private Connection connection = ConnectionDB.getInstance().getConnect();


    private final String SELECT_ALL_STUDENT = "select * from student where status  = 'on'; ";
    private final String SELECT_STUDENT_BY_NAME = "select * from student where name like ?;";
    private final String INSERT_STUDENT = "insert into student (name, birth, address, phone, email, class_id) values (?,?,?,?,?,?);";
    private final String DELETE_STUDENT = "update student set status = 'off' where id = ?;";
    private final String EDIT_STUDENT = "update student set name = ?, birth = ?,address = ?,phone=?,email=?,class_id=? where id = ?;";

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STUDENT);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date birth = rs.getDate("birth");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                int class_id = rs.getInt("class_id");
                Student student = new Student(id,name,birth,address,phone,email,class_id);
                studentList.add(student);
                System.out.println("Hien thi thanh cong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }

    @Override
    public void save(Student student) {
        try{
            PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT);
            statement.setString(1,student.getName());
            statement.setDate(2, (Date) student.getbirth());
            statement.setString(3,student.getAddress());
            statement.setString(4,student.getPhonenumber());
            statement.setString(5,student.getEmail());
            statement.setInt(6,student.getClassID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(int id, Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Disable Customer Successfull !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Student student) {

    }
}
