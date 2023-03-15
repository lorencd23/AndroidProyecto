package DAO;

import POJO.Usuarios;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Motor_SQL.MotorSQL;
import Factory.Motor;
import Factory.Factory;

/**
 *
 * @author LorenzoGalveMuñoz
 */
public class UsuarioDAO implements DAO<Usuarios, Integer>{
    private static final String SQL_SELECT = "SELECT * FROM USUARIOS WHERE 1=1 ";
    private static final String SQL_INSERT = "INSERT INTO USUARIOS VALUES (";

    private Motor motor = null;
    
    public UsuarioDAO(String opcion) {
           this.motor = Factory.getInstance(opcion);
    }
    
    //RECIBIR TODOS LOS PRODUCTOS//

    public ArrayList<Usuarios> findAll(Usuarios bean) {
        String sql_filtro = "";
        String sql_final = "";
        ArrayList<Usuarios> lstUsuarios = null;
        
        try {
            this.motor.connect();
            sql_final = SQL_SELECT + sql_filtro;
            ResultSet resultset = this.motor.executeQuery(sql_final);

            if(resultset!=null){
                lstUsuarios = new ArrayList();

                while(resultset.next()){
                    Usuarios usuarios = new Usuarios();
                    usuarios.setIdProducto(resultset.getInt(1));
                    usuarios.setName(resultset.getString(2));
                    usuarios.setMail(resultset.getString(3));
                    usuarios.setPass(resultset.getString(4));

                    lstUsuarios.add(usuarios);
                }
            }
            this.motor.disconnect();
            
        } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstUsuarios;
    }
    
    public ArrayList<Usuarios> findAllFiltro(Usuarios bean, String filtro) {
        String sql_filtro = "";
        String sql_final = "";
        ArrayList<Usuarios> lstUsuarios = null;
        
        //APLICA FILTROS A LOS PRODUCTOS
        switch (filtro) {
            case ("MENU"):
                sql_filtro = "";
                break;
                
            case ("DRINKS"):
                sql_filtro = " AND TIPO_PRODUCTO LIKE '%CAFE%' OR TIPO_PRODUCTO LIKE '%AFFOGATO%' OR TIPO_PRODUCTO LIKE '%SMOOTHIE%' OR TIPO_PRODUCTO LIKE '%TEAS%'";
                break;
                
            case ("DESSERTS"):
                sql_filtro = " AND TIPO_PRODUCTO LIKE '%REPOSTERIA%'";
                break;
                
            case ("COFFEES"):
                sql_filtro = " AND TIPO_PRODUCTO LIKE '%CAFE%'";
                break;
                
            case ("SMOOTHIES"):
                sql_filtro = " AND TIPO_PRODUCTO LIKE '%SMOOTHIE%'";
                break;
                
            case ("AFFOGATO"):
                sql_filtro = " AND TIPO_PRODUCTO LIKE '%AFFOGATO%'";
                break;
                
            case ("TEAS"):
                sql_filtro = " AND TIPO_PRODUCTO LIKE '%TEAS%'";
                break;
                
            default:
                sql_filtro = "";
        }
        
        try {
            this.motor.connect();
            sql_final = SQL_SELECT + sql_filtro;
            ResultSet resultset = this.motor.executeQuery(sql_final);

            if(resultset!=null){
                lstUsuarios = new ArrayList();

                while(resultset.next()){
                    Usuarios usuarios = new Usuarios();
                    usuarios.setIdProducto(resultset.getInt(1));
                    usuarios.setName(resultset.getString(2));
                    usuarios.setMail(resultset.getString(3));
                    usuarios.setPass(resultset.getString(4));
                    
                    lstUsuarios.add(usuarios);
                }
            }
            this.motor.disconnect();
            
        } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstUsuarios;
    }
    
    public boolean add(ArrayList<String> insercion){
        boolean añadido = false;
        String sql_final;
        for(String producto:insercion){
            
            sql_final = SQL_INSERT;
            
            
            
        }
            
        
        return añadido;
    }
    
//    /*PRUEBAS UNITARIAS*/
//    public static void main(String[] args){
//        ProductoDAO productoDAO = new ProductoDAO();
//        ArrayList<Products> lstProducts;
//        
//        /*1º Test: Listar todos*/
//        lstProducts = productoDAO.findAll(null);
//        
//        /*for (Pelicula pelicula : lstPeliculas) {
//            System.out.println(pelicula.toString());
//        }*/ //Test correcto
//        
//        /*******************/
//        /*Generar JSON A MANO*/
//        System.out.println(Products.fromArrayListToJson(lstProducts));
//        /*******************/
//        
//        /*******************/
//        /*Generar JSON CON LIBRERÍA GSON*/
//        //System.out.println(Products.fromArrayListToJson(lstProducts));
//        /*******************/
//        
//        
//      
//        /*2º Test: Filtro por sinopsis*/
//        /*Pelicula pelicula = new Pelicula();
///        pelicula.setSinopsis("Wallace");
///        lstPeliculas =  peliculaDAO.findAll(pelicula);
///        for (Pelicula pelicula1 : lstPeliculas) {
///            System.out.println(pelicula1.toString());
//       }*///Test correcto
//        
//       /* 3º Test: Título + Sinopsis */
//        /*Lo dejo pendiente*/
//        
//    }
    /*FIN PRUEBAS UNITARIAS*/

    @Override
    public void find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Usuarios bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Usuarios bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
