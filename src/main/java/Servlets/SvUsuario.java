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
        //Sesion que se crea automáticamente al entrar a la web por el usuario
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Usuario> listaCompradores = entityManager.createQuery("SELECT c.id, c.nombre, c.apellido FROM Usuario c", Usuario.class).getResultList();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaCompradores", listaCompradores);
        response.sendRedirect("busqueda.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id_usuario");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");

        Usuario comprador = new Usuario();
        comprador.setNombre(nombre);
        comprador.setApellido(apellido);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(comprador);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        response.sendRedirect("index.jsp");
    }
}