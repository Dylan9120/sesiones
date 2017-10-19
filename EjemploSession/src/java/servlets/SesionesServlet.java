package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SesionesServlet extends HttpServlet {
   
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {        
        //recuperamos los datos del formulario
        String nombre = request.getParameter("NOMBRE");
        String apellido = request.getParameter("APELLIDO");
         
        HttpSession sesion = request.getSession();
        sesion.setAttribute("claveSesion", nombre + apellido);

        response.setContentType("text/html");
        //Mostramos los  valores en el cliente
        PrintWriter out = response.getWriter();

//        out.println("<a href=\"/EjemploSession/catalogo.jsp\"> Valida la sesión por favor </a>");
//        out.println("<br>");
//        out.println("ID de la sesi&oacute;n: " + sesion.getId());
        
        //HttpSession sesion = request.getSession();
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
        //PrintWriter out = response.getWriter();
        out.println("¿Continua la Sesion y es valida?: " + pagina);
        out.println("<br>");
        out.println("ID de la sesi&oacute;n JSESSIONID: " + sesion.getId());
    }
}
