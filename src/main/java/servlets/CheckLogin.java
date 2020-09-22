package servlets;

import models.UserModel;
import tools.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name= "CheckLogin", urlPatterns = {"/login/CheckLogin"})
public class CheckLogin extends AbstractAppServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String userName = request.getParameter("uname");
        String password = request.getParameter("password");

        String passwordFromDB = UserRepository.getUserName(userName);

        if (passwordFromDB.equals(password)) {
            int userID = UserRepository.getInt("otra.users", "User_email", userName, "User_id");
            Cookie ck=new Cookie("UID",String.valueOf(userID));//deleting value of cookie
            ck.setMaxAge(2700000);//changing the maximum age to 0 seconds
            ck.setPath("/");
            response.addCookie(ck);

            Integer userRole = UserRepository.getInt("otra.users", "User_email", userName, "User_role");
            if (userRole == 0) {
                response.sendRedirect("../UtoverDash");
            }else if (userRole == 1) {
                response.sendRedirect("../TrenerDash");
            }else if (userRole == 2) {
                response.sendRedirect("../UtoverDash");
            }
        }
    }

    @Override
    protected void writeBody(HttpServletRequest request, PrintWriter out) {

    }
}
