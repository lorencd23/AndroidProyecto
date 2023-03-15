package Controller;

import DAO.*;
import POJO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LorenzoGalveMuñoz
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String action = request.getParameter("ACTION");
        
        String arrayAction[] = action.split("\\.");//PARTE ACTION EN 2
            String objeto = arrayAction[0];//PRODUCTOS DESDE EL VISUAL
            String method = arrayAction[1];//FIND_ALL DESDE EL VISUAL
            
        switch(objeto){//SEGUN LA CLASE
            case "PRODUCTOS":
                String opcion = request.getParameter("TIPO_BASE");
                ProductoDAO productoDAO = new ProductoDAO(opcion);
                ArrayList<Products> lstProducts;
                Products producto;
                
                switch(method) {//SEGUN LA FUNCION
                    case "FIND_ALL"://Recibir productos                       
                        String filtro = request.getParameter("TIPO_PRODUCTO");                        
                        
                        if (filtro.equals("")) {
                            //Coge todos los productos
                            lstProducts = productoDAO.findAll(null);
                        } else {
                            lstProducts = productoDAO.findAllFiltro(null, filtro);
                        }

                        //Convierte el array en string
                        ProductosArrayList productosArrayList = new ProductosArrayList(lstProducts);
                        
                        String jsonRespuesta = productosArrayList.toArrayJSon();
                        //IMPORTANTE ARRIBA CONVIERTE A JSON
                        System.out.println("datos de respuesta" + jsonRespuesta);
                        
                        //DEVUELVE A VISUAL
                        PrintWriter out = response.getWriter();
                        
                        out.print(jsonRespuesta);
                        
                    break; 
                    
                    case "EXPORTAR":
                        String filtro2 = request.getParameter("TIPO_PRODUCTO");                        
                        
                        if (filtro2.equals("")) {
                            //Coge todos los productos
                            lstProducts = productoDAO.findAll(null);
                        } else {
                            lstProducts = productoDAO.findAllFiltro(null, filtro2);
                        }

                        //Convierte el array en string
                        ProductosArrayList productosArrayList2 = new ProductosArrayList(lstProducts);
                        
                        String xmlRespuesta2 = productosArrayList2.toArrayXML();
                        String jsonRespuesta2 = productosArrayList2.toArrayJSon();
                        
                        try{
                            PrintWriter writerXML = new PrintWriter("D:/prueba.xml", "UTF-8");
                            PrintWriter writerJSON = new PrintWriter("D:/prueba.json", "UTF-8");
                            writerXML.println(xmlRespuesta2);
                            writerJSON.println(jsonRespuesta2);
                            writerXML.close();
                            writerJSON.close();
                        } catch(Exception e){
                            e.printStackTrace();
                        }
                        
                    break;
                }
            break; 

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
