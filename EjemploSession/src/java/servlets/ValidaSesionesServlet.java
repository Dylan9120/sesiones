/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ValidaSesionesServlet extends HttpServlet {
   
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession sesion = request.getSession();
        String pagina;

        //Pedimos el atributo, y verificamos si existe
        String claveSesion = (String) sesion.getAttribute("claveSesion");

        if(claveSesion.equals("DylanVaca")){
          pagina = "<script>location.href = \"/EjemploSession/bien.jsp\"</script>";
        }
        else
        {
          pagina = "<script>location.href = \"/EjemploSession/mal.jsp\"</script>";
        }

        //Mostramos los  valores en el cliente
        PrintWriter out = response.getWriter();
        out.println("¿Continua la Sesion y es valida?: " + pagina);
        out.println("<br>");
        out.println("ID de la sesi&oacute;n JSESSIONID: " + sesion.getId());
    }
}
