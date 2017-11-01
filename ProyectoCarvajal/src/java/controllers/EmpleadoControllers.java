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
import models.Empleados;
import models.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Samsung
 */
public class EmpleadoControllers extends HttpServlet {

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

        if (action.equalsIgnoreCase("create")) {
            Registrar(request, response);
        } else if (action.equalsIgnoreCase("admin")) {
            Admin(request, response);

        } else if (action.equalsIgnoreCase("update")) {
            Actualizar(request, response);
        } else if (action.equalsIgnoreCase("eliminar")) {
            Eliminar(request, response);
        }
    }

    private void Registrar(HttpServletRequest request, HttpServletResponse response) {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String documento = request.getParameter("documento");
        String correo = request.getParameter("email");
        String contrasena = request.getParameter("password");
        String prefil = request.getParameter("perfil");

        Empleados empleado = new Empleados(nombre, apellido, documento, correo, contrasena, prefil);

        /*Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        sesion.save(empleado);
        sesion.getTransaction().commit();
        sesion.close();*/
        try {
            response.sendRedirect("EmpleadoControllers?action=admin");//Se pierde la información
        } catch (IOException ex) {
            Logger.getLogger(EmpleadoControllers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void Admin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code.
            out.println("Entro al metodo");
            
        }*/
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query qemp = sesion.createQuery("FROM Empleados");
        //Query q = sesion.createQuery("FROM Odontologos WHERE especialidad = 'General'"); Con el WHERE para condición
        ArrayList listaObjetos = (ArrayList) qemp.list();
        sesion.close();
        ArrayList<Empleados> Arrayempleados = new ArrayList<>();

        for (Object Obj : listaObjetos) {
            Empleados empleado = (Empleados) Obj;
            Arrayempleados.add(empleado);
        }
        request.setAttribute("ArrayEmpleados", Arrayempleados);
        
        try {
            request.getRequestDispatcher("AdminEmpleados.jsp").forward(request, response);//Redirecionar                    
        } catch (ServletException ex) {
            Logger.getLogger(EmpleadoControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Empleados empleado = (Empleados) sesion.get(Empleados.class, Integer.parseInt(request.getParameter("id")));
        if (request.getMethod().equalsIgnoreCase("GET")) {
            request.setAttribute("empleado", empleado);

            try {
                request.getRequestDispatcher("EditarEmpleado.jsp").forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(EmpleadoControllers.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(EmpleadoControllers.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            empleado.setNombres(request.getParameter("nombre"));
            empleado.setApellidos(request.getParameter("apellido"));
            empleado.setDocumento(request.getParameter("documento"));
            empleado.setCorreo(request.getParameter("email"));
            empleado.setContrasena(request.getParameter("password"));
            empleado.setPerfil(request.getParameter("perfil"));

            /*try (PrintWriter out = response.getWriter()) {            
            out.println("Editar");}*/
            sesion.beginTransaction();
            sesion.saveOrUpdate(empleado);
            sesion.getTransaction().commit();
            sesion.close();

            try {
                response.sendRedirect("EmpleadoControllers?action=admin");
            } catch (IOException ex) {
                Logger.getLogger(EmpleadoControllers.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void Eliminar(HttpServletRequest request, HttpServletResponse response) {

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Empleados empleado = (Empleados) sesion.get(Empleados.class, Integer.parseInt(request.getParameter("id")));
        sesion.beginTransaction();
        sesion.delete(empleado);
        sesion.getTransaction().commit();
        sesion.close();        
        try {
            response.sendRedirect("EmpleadoControllers?action=admin");
        } catch (IOException ex) {
            Logger.getLogger(EmpleadoControllers.class.getName()).log(Level.SEVERE, null, ex);
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
