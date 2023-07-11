package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sid = request.getParameter("id");
        String sname = request.getParameter("name");
        String phone = request.getParameter("phone");
        String marks = request.getParameter("marks");
        String branch = request.getParameter("branch");

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/igt_exam", "root", "admin");

            // Prepare the SQL statement
            PreparedStatement statement = con.prepareStatement("insert into student values(?,?,?,?,?)");
            statement.setString(1, sid);
            statement.setString(2, sname);
            statement.setString(3, phone);
            statement.setString(4, marks);
            statement.setString(5, branch);

            // Execute the statement
            int row = statement.executeUpdate();
            statement.close();
            con.close();

            if (row > 0) {
                // Show success message using Request Dispatcher
                request.setAttribute("message", "Congrats, you are successfully registered!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Success.html");
                dispatcher.forward(request, response);
            } else {
                // Show error message using Request Dispatcher
                request.setAttribute("message", "Error: Registration failed!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Error.html");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
