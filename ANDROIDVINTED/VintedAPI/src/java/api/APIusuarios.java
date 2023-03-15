/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import DAO.UsuarioDAO;
import POJO.UsuariosArrayList;
import POJO.Usuarios;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author S1-PC59
 */
@Path("usuarios")
public class APIusuarios {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VintedAPI
     */
    public APIusuarios() {
    }

    /**
     * Retrieves representation of an instance of api.VintedAPI
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        String opcion = "1";
        UsuarioDAO usuarioDAO = new UsuarioDAO(opcion);
        ArrayList<Usuarios> lstUsuarios;
        lstUsuarios = usuarioDAO.findAll(null);
        
        UsuariosArrayList usuariosArrayList = new UsuariosArrayList(lstUsuarios);
        
        String jsonRespuesta = usuariosArrayList.toArrayJSon();
        //IMPORTANTE ARRIBA CONVIERTE A JSON
        System.out.println("datos de respuesta" + jsonRespuesta);
        
        return jsonRespuesta;
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
