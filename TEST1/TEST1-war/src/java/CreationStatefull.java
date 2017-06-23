/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import version1.TestEJB;
import version1.TestEJBLocal;
import version1.TestEJBLocal2;
import version1.testStatefull;

/**
 *
 * @author Super
 */
@WebServlet(urlPatterns = {"/CreationStatefull"})
public class CreationStatefull extends HttpServlet {
@EJB
TestEJBLocal testejbLocal;

@EJB
TestEJBLocal2 testejbLocal2;

//@EJB
@Inject
testStatefull compter;
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
        HttpSession sess=request.getSession(true);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletTest</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Creation de la session " + request.getContextPath() + "</h1>");
            
            
            TestEJBLocal2 stf=(TestEJBLocal2)InitialContext.doLookup("java:app/TEST1-ejb/TestEJB!version1.TestEJBLocal2"); 
            out.println(testejbLocal.tester()+"</br>");
            out.println(testejbLocal2.tester2()+"</br>");
            out.println("Via JNDI:"+stf.tester2()+"</br>"); 
       /*   if (sess.getAttribute("invoc")==null){
              sess.setAttribute("invoc", compter);
              out.println("</br>Connection"); 
            }
          else{
              out.println("Deja connecte");
          }*/ 
             
            sess.removeAttribute("invoc");
            sess.setAttribute("invoc", compter); 
            
            testStatefull good=(testStatefull)sess.getAttribute("invoc");
         //   out.println("good:"+good.plus1()); 
            
//            out.println(compter.plus1()); 
             
            out.println("</body>");
            out.println("</html>"); 
        }
        catch(javax.ejb.NoSuchObjectLocalException ex){
             sess.setAttribute("invoc", compter);
             response.getWriter().println("</br>Reconection");
        } catch (NamingException ex) {
        Logger.getLogger(CreationStatefull.class.getName()).log(Level.SEVERE, null, ex);
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
