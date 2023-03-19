/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import DAO.ProductoDAO;
import POJO.ProductosArrayList;
import POJO.Products;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author S1-PC59
 */
@Path("productos")
public class APIproductos {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VintedAPI
     */
    public APIproductos() {
    }

    /**
     * Retrieves representation of an instance of api.VintedAPI
     * @param filtro
     * @return an instance of java.lang.String
     */
    @GET
    
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        String opcion = "1";
        ProductoDAO productoDAO = new ProductoDAO(opcion);
        ArrayList<Products> lstProducts;
        
        lstProducts = productoDAO.findAll(null);

        
        ProductosArrayList productosArrayList = new ProductosArrayList(lstProducts);
        
        String jsonRespuesta = productosArrayList.toArrayJSon();
        //IMPORTANTE ARRIBA CONVIERTE A JSON
        System.out.println("datos de respuesta" + jsonRespuesta);
        
        return jsonRespuesta;
    }
    
    
    @GET
    @Path("/{filtro}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductosFiltrados(@PathParam("filtro") String filtro) {
        String opcion = "1";
        ProductoDAO productoDAO = new ProductoDAO(opcion);
        ArrayList<Products> lstProducts;
        filtro = "{" + filtro + "}";
        if(filtro == "{}"){
            lstProducts = productoDAO.findAll(null);
        }else{
            lstProducts = productoDAO.findAllFiltro(null, filtro);
        }
        
        ProductosArrayList productosArrayList = new ProductosArrayList(lstProducts);
        
        String jsonRespuesta = productosArrayList.toArrayJSon();
        //IMPORTANTE ARRIBA CONVIERTE A JSON
        System.out.println("datos de respuesta" + jsonRespuesta);
        
        return jsonRespuesta;
    }
    
    
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean agregarProducto(Products producto) {
        String opcion = "1";
        ProductoDAO productoDAO = new ProductoDAO(opcion);
        
        return productoDAO.add(producto);
    }
    

    /**
     * PUT method for updating or creating an instance of VintedAPI
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
