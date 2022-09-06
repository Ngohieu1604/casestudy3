package servlet;

import model.Student;
import service.IStudentDAO;
import service.StudentDao;

import java.io.*;

import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentServlet", value = "/manager")
public class StudentServlet extends HttpServlet {
    IStudentDAO studentDAO = new StudentDao();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                break;
            case "delete":

                break;
            default:
                showAllStudent(request,response);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.getRequestDispatcher("student/create.jsp").forward(request,response);
    }

    private void showAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Student> studentList = studentDAO.findAll();
        request.setAttribute("list",studentList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createStudent(req, resp);
                break;
            case "edit":
                break;
            case "delete":

                break;
            default:
                showAllStudent(req, resp);
                break;
        }
    }

private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
    String name = req.getParameter("name");
    Date birth = Date.valueOf(req.getParameter("birth"));
    String address = req.getParameter("address");
    String phone = req.getParameter("phone");
    String email = req.getParameter("email");
    int class_id = Integer.parseInt(req.getParameter("class_id")) ;
    Student student = new Student(name,birth,address,phone,email,class_id);
    studentDAO.save(student);
    req.setAttribute("mess","Thanh Cong");
    req.getRequestDispatcher("student/create.jsp").forward(req,resp);
}
}
