package DAO;

import POJO.Products;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Motor_SQL.MotorSQL;
import Factory.Motor;
import Factory.Factory;
import java.sql.PreparedStatement;

/**
 *
 * @author LorenzoGalveMuñoz
 */
public class ProductoDAO implements DAO<Products, Integer>{
    private static final String SQL_SELECT = "SELECT * FROM PRODUCTOS WHERE 1=1 ";
    private static final String SQL_INSERT = "INSERT INTO PRODUCTOS (ID_PRODUCTO, NOMBRE_PRODUCTO, PRECIO, DESCRIPCION, EXISTENCIAS, GENERO, IMAGEN) VALUES (";

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
            case ("{Vaqueros}"):
                sql_filtro = " AND NOMBRE_PRODUCTO LIKE '%VAQUEROS%'";
                break;
                
            case ("{Camiseta}"):
                sql_filtro = " AND NOMBRE_PRODUCTO LIKE '%CAMISETA%'";
                break;
                
            case ("{Chaqueta}"):
                sql_filtro = " AND NOMBRE_PRODUCTO LIKE '%CHAQUETA%'";
                break;
                
            case ("{Zapatillas}"):
                sql_filtro = " AND NOMBRE_PRODUCTO LIKE '%ZAPATILLAS%'";
                break;
                
            case ("{Jersey}"):
                sql_filtro = " AND NOMBRE_PRODUCTO LIKE '%JERSEY%'";
                break;
                
            case ("{Pantalón}"):
                sql_filtro = " AND NOMBRE_PRODUCTO LIKE '%PANTALÓN%'";
                break;
                
            case ("{Gorro}"):
                sql_filtro = " AND NOMBRE_PRODUCTO LIKE '%GORRO%'";
                break;
            case ("{Hombre}"):
                sql_filtro = " AND GENERO LIKE '%Hombre%'";
                break;
            case ("{Mujer}"):
                sql_filtro = " AND GENERO LIKE '%Mujer%'";
                break;
            case ("{Niño/a}"):
                sql_filtro = " AND GENERO LIKE '%Niño/a%'";
                break;
                
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
    
    public boolean add(Products product){
        boolean añadido = false;
        String sql_final = "";
        ArrayList<Products> lstProductos = null;
        
        try {
            this.motor.connect();
            sql_final = SQL_INSERT;
            //ResultSet resultset = this.motor.executeQuery(sql_final);
         
            lstProductos = new ArrayList();

            Products productos = new Products();
            productos.setIdProducto(product.getIdProducto());
            productos.setName(product.getName());
            productos.setPrize(product.getPrize());
            productos.setDescription(product.getDescription());
            productos.setExistences(product.getExistences());
            productos.setGenero(product.getGenero());
            productos.setImg(product.getImg());

            lstProductos.add(productos);
            /*sql_final = sql_final + product.getIdProducto()
                    + ", '" + product.getName()
                    + "', " + product.getPrize()
                    + ", '" + product.getDescription()
                    + "', " + product.getExistences()
                    + ", '" + product.getGenero()
                    + "', " + product.getImg() + ")";*/
            sql_final = sql_final + "0, 'Gorro', 10, 'Gorro rechulo', 100, 'Hombre', 'https')";
            int rowsInserted = this.motor.executeUpdate(sql_final);

            if (rowsInserted > 0) {
                añadido = true;
            }
                
            añadido = true;
            this.motor.disconnect();
        
            
        } catch (Exception ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        try {
            this.motor.connect();
            String sql = "INSERT INTO productos (nombre, precio, descripcion, existencias, imagen) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = this.motor.getConnection(sql_final).prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrize());
            statement.setString(3, product.getDescription());
            statement.setInt(4, product.getExistences());
            statement.setString(5, product.getImg());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                añadido = true;
            }

            this.motor.disconnect();
            
        } catch (Exception ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */
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
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Products bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
