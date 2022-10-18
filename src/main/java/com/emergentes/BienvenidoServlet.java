/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BienvenidoServlet", urlPatterns = {"/BienvenidoServlet"})
public class BienvenidoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int contador =0;
        
        Cookie[] cukis=request.getCookies();
        if(cukis !=null){
            for(Cookie c : cukis){
                if(c.getName().equals("visitas")){
                    contador=Integer.parseInt(c.getValue());
                }
            }
        }
        contador++;
        //Antes de la Asignacion se convierte
        Cookie c = new Cookie("visitas",Integer.toString(contador));
        
        c.setMaxAge(100);
        response.addCookie(c);
        //Genrar contador a partir del servlet
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        if(contador==1){
        out.println("Bienvenido a nuestro Sitio Web ");
        }else{
                out.println("Grasias por visitarnos nuevamente ");
               
            }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
