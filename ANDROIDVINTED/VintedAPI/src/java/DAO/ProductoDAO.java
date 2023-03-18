package DAO;

import POJO.Products;
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
public class ProductoDAO implements DAO<Products, Integer>{
    private static final String SQL_SELECT = "SELECT * FROM PRODUCTOS WHERE 1=1 ";
    private static final String SQL_INSERT = "INSERT INTO PRODUCTOS VALUES (";

    private Motor motor = null;
    
    public ProductoDAO(String opcion) {
           this.motor = Factory.getInstance(opcion);
    }
    
    //RECIBIR TODOS LOS PRODUCTOS//

    public ArrayList<Products> findAll(Products bean) {
        String sql_filtro = "";
        String sql_final = "";
        ArrayList<Products> lstProductos = null;
        
        try {
            this.motor.connect();
            sql_final = SQL_SELECT + sql_filtro;
            ResultSet resultset = this.motor.executeQuery(sql_final);

            if(resultset!=null){
                lstProductos = new ArrayList();

                while(resultset.next()){
                    Products productos = new Products();
                    productos.setIdProducto(resultset.getInt(1));
                    productos.setName(resultset.getString(2));
                    productos.setPrize(resultset.getDouble(3));
                    productos.setDescription(resultset.getString(4));
                    productos.setExistences(resultset.getInt(5));
                    productos.setGenero(resultset.getString(6));
                    productos.setImg(resultset.getString(7));

                    lstProductos.add(productos);
                }
            }
            this.motor.disconnect();
            
        } catch (Exception ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstProductos;
    }
    
    public ArrayList<Products> findAllFiltro(Products bean, String filtro) {
        String sql_filtro = "";
        String sql_final = "";
        ArrayList<Products> lstProductos = null;
        
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
                lstProductos = new ArrayList();

                while(resultset.next()){
                    Products productos = new Products();
                    productos.setIdProducto(resultset.getInt(1));
                    productos.setName(resultset.getString(2));
                    productos.setPrize(resultset.getDouble(3));
                    productos.setDescription(resultset.getString(4));
                    productos.setExistences(resultset.getInt(5));
                    productos.setGenero(resultset.getString(6));
                    productos.setImg(resultset.getString(7));

                    lstProductos.add(productos);
                }
            }
            this.motor.disconnect();
            
        } catch (Exception ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstProductos;
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
    public boolean add(Products bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Products bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
