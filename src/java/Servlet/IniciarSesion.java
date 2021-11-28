/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Control.Administrador;
import Control.accionesUsu;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author illum
 */
public class IniciarSesion extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String correo=request.getParameter("email");
            String contra=request.getParameter("password");

            accionesUsu au=new accionesUsu();
            Administrador ad=new Administrador();
            if(au.inicioSesion(correo, contra)){

                try {
                    HttpSession session = request.getSession(true);
                    String NomUsu = au.getNameByEmail(correo);
                    au.AsignarSimulaciones();
                    //System.out.println(NomUsu);
                    session.setAttribute("Usuario", NomUsu);
                    response.sendRedirect("MenUsuario.jsp");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
                else if(ad.inicioSesion(correo, contra)){              
                try {
                    HttpSession session = request.getSession(true);
                    String NomUsu = ad.getAdminName(correo);
                    //System.out.println(NomUsu);
                    session.setAttribute("Admin", NomUsu);

                    response.sendRedirect("MenuAdm.jsp");
                }catch (SQLException ex) {
                        Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                }
            else{
                HttpSession session = request.getSession(true);
                session.setAttribute("Error","Direccion invalida");
                response.sendRedirect("IniciarSesion.jsp");
                response.getWriter().write("<script>alert('Correo o contraseña incorrectos !');window.history.back();</script>");
                System.out.println("El correo o contraseña no están registrados en la base de datos");
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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