/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Control.Administrador;
import Modelo.Dificultades;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author illum
 */
public class ActualizarBlo extends HttpServlet {

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
            throws ServletException, IOException, SQLException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String act = request.getParameter("actividad");
            String virus = request.getParameter("Virus");
            String estafas = request.getParameter("Estafas");
            //int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(act);
            System.out.println(virus);
            System.out.println(estafas);
            if(estafas!=null){
                //Administrador.CambioDif_tb_dificultades(facil, id);
                Administrador.CambioBloque(estafas, act);
                Administrador.CambioBloqueADM(estafas, act);
                System.out.println("Actulizado al bloque "+estafas);
                //response.sendRedirect("newjsp.jsp");
                response.sendRedirect("MenuAdm2.jsp");
            }else if (virus!=null){
                //Administrador.CambioDif_tb_dificultades(dificil, id);
                Administrador.CambioBloque(virus, act);
                Administrador.CambioBloqueADM(virus, act);
                System.out.println("Actulizado al bloque "+virus);
                //response.sendRedirect("newjsp.jsp");
                response.sendRedirect("MenuAdm2.jsp");
            }
            else{
                System.out.println("Error al actualizar bloque");
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
            Logger.getLogger(ActualizarDif1.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ActualizarDif1.class.getName()).log(Level.SEVERE, null, ex);
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
