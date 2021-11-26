/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Control.accionesUsu;
import Modelo.UsuarioConsulta;
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
public class AumentarProgresoHD extends HttpServlet {

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
 HttpSession session = request.getSession(false);
            String progreso = "100";
            String dificultad = "dificil";
            String bloque = "Estafas";
            String actividad = "phishing";
            String nombre = String.valueOf(session.getAttribute("Usuario"));
            System.out.println("el nombre es: "+nombre);
            UsuarioConsulta usucon = new UsuarioConsulta();
            usucon.setNom_usu(nombre);
            usucon.setNom_blo(bloque);
            usucon.setNom_act(actividad);
            usucon.setDif_dif(dificultad);
            usucon.setPro_dif_dif2(progreso);
            System.out.println("el progreso es: "+usucon.getPro_dif_dif2());
            if(nombre == null){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Sesión expirada, vuelva a ingresar');");
                out.println("location='index.html';");
                out.println("</script>");
            }
            int estatus = accionesUsu.AumentarProgresoHD(usucon);
            if (estatus > 0){
                response.sendRedirect("MenUsuario.jsp");
            }else{
                System.out.println("Error al guardar el progreso");
                System.out.println(estatus);
                response.sendRedirect("error.jsp");
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
            Logger.getLogger(AumentarProgresoHD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AumentarProgresoHD.class.getName()).log(Level.SEVERE, null, ex);
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
