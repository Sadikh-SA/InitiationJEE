package controller;

import model.Employe;
import model.Service;
import service.EmployeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "employe", urlPatterns = "/employe")
public class EmployeServlet extends HttpServlet {
    EmployeDAO employeDAO = new EmployeDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        switch (action){

            case "add":
                req.setAttribute("services",employeDAO.findService());
                getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String action=req.getParameter("action");
        switch (action) {
            case "add":
                String matricule = req.getParameter("matricule");
                String nomComplet = req.getParameter("nomComplet");
                String tel = req.getParameter("tel");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate ddn = LocalDate.parse(req.getParameter("ddn"));
                double salaire = Double.parseDouble(req.getParameter("salaire"));
                int idService = Integer.parseInt(req.getParameter("idService"));
                Service service = new Service();
                service.setId(idService);
                Employe employe = new Employe();
                employe.setMatricule(matricule);
                employe.setNomComplet(nomComplet);
                employe.setDdn(ddn);
                employe.setTel(tel);
                employe.setSalaire(salaire);
                employe.setIdService(service);
                try {
                    employeDAO.addEmploye(employe);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                req.setAttribute("services", employeDAO.findService());
                getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(req, resp);
                break;
        }
    }
}
