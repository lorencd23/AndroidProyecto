
package POJO;

import java.util.ArrayList;

public class Products {
    //ATRIBUTOS
    protected static int ID = 0;
    private int idProducto;
    private String name;
    private double prize;
    private String description;
    private int existences;
    private String genero;
    private String img;
    
    //CONSTRUCOTRES
    public Products() {
        ID++;
        this.idProducto = ID;
    }
    public Products(String name, double prize, String description, int existences, String genero, String img) {
        this.name = name;
        this.prize = prize;
        this.description = description;
        this.existences = existences;
        this.genero = genero;
        this.img=img;
    }

    //MÉTODOS
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getExistences() {
        return existences;
    }

    public void setExistences(int existences) {
        this.existences = existences;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }  

    @Override
    public String toString() {
        return "Products{" + "idProduct = " + idProducto + ", "
                + "Name = " + name + ", "
                + "Prize = " + prize + ", "
                + "Description = " + description + ", "
                + "Existences = " + existences + ", "
                + "Genero = " + genero + ", "
                + "Imagen = " + img + '}'; 
    }
    //SOBRE esto lo hace el json
    public static String fromArrayListToJson(ArrayList<Products> lstProductos){
        String resp = "[";
        for (Products productos : lstProductos) {
            resp+= "{" + 
                "\"ID\" :" + productos.getIdProducto()+ ", "
                + "\"NAME\" : '" + productos.getName()+ "', "
                + "\"PRIZE\" : " + productos.getPrize()+ ", "
                + "\"DESCRIPTION\" : " + productos.getDescription()+ ", "
                + "\"EXISTENCES\" : " + productos.getExistences()+ ", "
                + "\"GENERO\" : " + productos.getGenero()+ ", "
                + "\"IMAGEN\" : '" + productos.getImg() + "'}";
                resp+=",";
        }
        resp = resp.substring(0, resp.length()-1);
        resp+="]";
    return resp;
    }
    
}
