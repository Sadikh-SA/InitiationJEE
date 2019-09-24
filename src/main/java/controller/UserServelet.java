package controller;

import model.Utilisateur;
import service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "user", urlPatterns = "/user")
public class UserServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().println("Bonjour Maven TomCat");
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserDao userDao = new UserDao();
        Utilisateur user = userDao.logon(login,password);
        if (user != null){
            HttpSession session = req.getSession(true);
            //Signifie partout ou je vais je pourrait l'amener
            session.setAttribute("connectedUser", user);
            if (user.getProfil().equalsIgnoreCase("user")){
                getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(req,resp);
            }else {
                getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(req,resp);
            }
        }else {
            req.setAttribute("error","Login ou Mot de Passe Incorrecte");
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
        }
    }
}
