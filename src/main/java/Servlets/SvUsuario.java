package Servlets;

import java.io.*;
import java.util.List;

import Persistencia.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/servlet-ejemplo")
public class SvUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Usuario> listaUsuarios = entityManager.createQuery("SELECT c.id, c.nombre, c.apellido FROM Usuario c", Usuario.class).getResultList();
        HttpSession sesion = request.getSession();


        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");


        for (Usuario usuario : listaUsuarios) {
            if (usuario.validar(nombre, apellido))
                response.sendRedirect("busqueda.jsp");
        }

        response.sendError(404);
    }
}