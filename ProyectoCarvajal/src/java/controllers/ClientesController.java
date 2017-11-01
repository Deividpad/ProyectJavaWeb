/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Clientes;
import models.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Samsung
 */
public class ClientesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        switch (action) {

            case "create":
                registrar(request, response);
                break;

            case "admin":
                administrar(request, response);
                break;

            case "update":
                actualizar(request, response);

                break;

            case "delete":
                eliminar(request, response);

                break;

        }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {
        String razonsocial = request.getParameter("razonsocial");
        String nit = request.getParameter("nit");
        String ciudad = request.getParameter("ciudad");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String contrasena = request.getParameter("contrasena");

        //CREAMOS EL OBJETO CON DATOS EN ELE FORMULARIO
        Clientes clientes = new Clientes(razonsocial, nit, ciudad, direccion, telefono, contrasena);
        //GUARDAMOS EBJETO EN BD
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(clientes);
        session.getTransaction().commit();
        session.close();
        
        try {
            response.sendRedirect("ClientesController?action=admin");
        } catch (IOException ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }      

    }
    

    private void administrar(HttpServletRequest request, HttpServletResponse response) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("FROM Clientes");
        ArrayList listaObjetos = (ArrayList) q.list();
        session.close();
        ArrayList<Clientes> clien = new ArrayList<>();

        for (Object clientes : listaObjetos) {
            Clientes cli = (Clientes) clientes;
            clien.add(cli);
        }

        request.setAttribute("LISTAR", clien);

        try {
            request.getRequestDispatcher("AdminClientes.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Clientes clientes = (Clientes) session.get(Clientes.class, Integer.parseInt(request.getParameter("id")));

        request.setAttribute("clientess", clientes);

        if (request.getMethod().equalsIgnoreCase("GET")) {
            try {

                request.getRequestDispatcher("EditarClientes.jsp").forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            clientes.setRazonSocial(request.getParameter("razonsocial"));
            clientes.setNit(request.getParameter("nit"));
            clientes.setCiudad(request.getParameter("ciudad"));
            clientes.setDireccion(request.getParameter("direccion"));
            clientes.setTelefono(request.getParameter("telefono"));
            clientes.setContrasena(request.getParameter("contrasena"));

            session.beginTransaction();
            session.save(clientes);
            session.getTransaction().commit();
            session.close();

            try {
                response.sendRedirect("ClientesController?action=admin");
            } catch (IOException ex) {
                Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void eliminar(HttpServletRequest request, HttpServletResponse response) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Clientes clientes = (Clientes) session.get(Clientes.class, Integer.parseInt(request.getParameter("id")));
        session.beginTransaction();
        session.delete(clientes);
        session.getTransaction().commit();
        session.close();

        try {
            response.sendRedirect("ClientesController?action=admin");
        } catch (IOException ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
