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
public class ActualizarDif1 extends HttpServlet {

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
            String facil = request.getParameter("facil");
            String dificil = request.getParameter("dificil");
            String actividad = request.getParameter("actividad");
            String bloque = request.getParameter("bloque");
            int id = Integer.parseInt(request.getParameter("id"));
            int id2 = 0;
            String phishing = "phishing";
            String spamming = "spamming";
            String ejecutables = "ejecutables";
            String links = "links";
            System.out.println(facil);
            System.out.println(dificil);
            System.out.println(id);
            System.out.println(actividad);
            System.out.println(bloque);
            if(facil!=null){
                if(actividad.equals(phishing)){
                    if(id==1){
                        id2=1;
                        System.out.println(id2+" id2");
                        //Administrador.CambioDif_tb_dificultades(facil, id);
                        Administrador.CambioDifGen(bloque, actividad, facil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, facil, id2);
                        System.out.println("Actulizado a facil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp");
                    }else if(id==2){
                        id2=2;
                        System.out.println(id2+" id2");
                        //Administrador.CambioDif_tb_dificultades(facil, id);
                        Administrador.CambioDifGen(bloque, actividad, facil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, facil, id2);
                        System.out.println("Actulizado a facil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp");
                    }
                }
                else if(actividad.equals(spamming)){
                    if(id==1){
                        id2=3;
                        System.out.println(id2+" id2");
                        //Administrador.CambioDif_tb_dificultades(facil, id);
                        Administrador.CambioDifGen(bloque, actividad, facil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, facil, id2);
                        System.out.println("Actulizado a facil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp");
                    }else if(id==2){
                        id2=4;
                        System.out.println(id2+" id2");
                        //Administrador.CambioDif_tb_dificultades(facil, id);
                        Administrador.CambioDifGen(bloque, actividad, facil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, facil, id2);
                        System.out.println("Actulizado a facil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp");
                    }
                }
                else if(actividad.equals(ejecutables)){
                    if(id==1){
                        id2=5;
                        System.out.println(id2+" id2");
                        //Administrador.CambioDif_tb_dificultades(facil, id);
                        Administrador.CambioDifGen(bloque, actividad, facil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, facil, id2);
                        System.out.println("Actulizado a facil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp");
                    }else if(id==2){
                        id2=6;
                        System.out.println(id2+" id2");
                        //Administrador.CambioDif_tb_dificultades(facil, id);
                        Administrador.CambioDifGen(bloque, actividad, facil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, facil, id2);
                        System.out.println("Actulizado a facil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp");
                    }
                }
                else if(actividad.equals(links)){
                    if(id==1){
                        id2=7;
                        System.out.println(id2+" id2");
                        //Administrador.CambioDif_tb_dificultades(facil, id);
                        Administrador.CambioDifGen(bloque, actividad, facil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, facil, id2);
                        System.out.println("Actulizado a facil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp");
                    }else if(id==2){
                        id2=8;
                        System.out.println(id2+" id2");
                        //Administrador.CambioDif_tb_dificultades(facil, id);
                        Administrador.CambioDifGen(bloque, actividad, facil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, facil, id2);
                        System.out.println("Actulizado a facil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp");
                    }
                }
            }else if (dificil!=null){
                if(actividad.equals(phishing)){
                    if(id==1){
                        id2=1;
                        //Administrador.CambioDif_tb_dificultades(dificil, id);
                        System.out.println(id2+" id2");
                        Administrador.CambioDifGen(bloque, actividad, dificil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, dificil, id2);
                        System.out.println("Actulizado a dificil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp");
                    }
                    else if (id==2){
                        id2=2;
                        //Administrador.CambioDif_tb_dificultades(dificil, id);
                        System.out.println(id2+" id2");
                        Administrador.CambioDifGen(bloque, actividad, dificil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, dificil, id2);
                        System.out.println("Actulizado a dificil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp");
                    }
                }
                else if(actividad.equals(spamming)){
                    if(id==1){
                        id2=3;
                        //Administrador.CambioDif_tb_dificultades(dificil, id);
                        Administrador.CambioDifGen(bloque, actividad, dificil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, dificil, id2);
                        System.out.println("Actulizado a dificil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp");   
                    }else if(id==2){
                        id2=4;
                        //Administrador.CambioDif_tb_dificultades(dificil, id);
                        Administrador.CambioDifGen(bloque, actividad, dificil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, dificil, id2);
                        System.out.println("Actulizado a dificil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp"); 
                    }
                }
                else if(actividad.equals(ejecutables)){
                    if(id==1){
                        id2=5;
                        //Administrador.CambioDif_tb_dificultades(dificil, id);
                        System.out.println(id2+" id2");
                        Administrador.CambioDifGen(bloque, actividad, dificil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, dificil, id2);
                        System.out.println("Actulizado a dificil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp");
                    }
                    else if (id==2){
                        id2=6;
                        //Administrador.CambioDif_tb_dificultades(dificil, id);
                        System.out.println(id2+" id2");
                        Administrador.CambioDifGen(bloque, actividad, dificil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, dificil, id2);
                        System.out.println("Actulizado a dificil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp");
                    }
                }
                else if(actividad.equals(links)){
                    if(id==1){
                        id2=7;
                        //Administrador.CambioDif_tb_dificultades(dificil, id);
                        System.out.println(id2+" id2");
                        Administrador.CambioDifGen(bloque, actividad, dificil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, dificil, id2);
                        System.out.println("Actulizado a dificil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp");
                    }
                    else if (id==2){
                        id2=8;
                        //Administrador.CambioDif_tb_dificultades(dificil, id);
                        System.out.println(id2+" id2");
                        Administrador.CambioDifGen(bloque, actividad, dificil, id2);
                        Administrador.CambioDifGenADM(bloque, actividad, dificil, id2);
                        System.out.println("Actulizado a dificil la actividad "+actividad+" de id_dif "+id+" del bloque "+bloque+"\n");
                        //response.sendRedirect("newjsp.jsp");
                        response.sendRedirect("MenuAdm2.jsp");
                    }
                }
            }else{
                System.out.println("Error al actualizar dificultad aa");
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
