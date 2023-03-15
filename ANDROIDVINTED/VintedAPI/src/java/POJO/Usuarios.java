
package POJO;

import java.util.ArrayList;

public class Usuarios {
    //ATRIBUTOS
    protected static int ID = 0;
    private int idProducto;
    private String name;
    private String mail;
    private String pass;
    
    //CONSTRUCOTRES
    public Usuarios() {
        ID++;
        this.idProducto = ID;
    }
    public Usuarios(String name, String mail, String pass) {
        this.name = name;
        this.mail = mail;
        this.pass = pass;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    

    @Override
    public String toString() {
        return "Products{" + "idProduct = " + idProducto + ", "
                + "Name = " + name + ", "
                + "Mail = " + mail + ", "
                + "Pass = " + pass + '}'; 
    }
    //SOBRE esto lo hace el json
    public static String fromArrayListToJson(ArrayList<Usuarios> lstProductos){
        String resp = "[";
        for (Usuarios productos : lstProductos) {
            resp+= "{" + 
                "\"ID\" :" + productos.getIdProducto()+ ", "
                + "\"NAME\" : '" + productos.getName()+ "', "
                + "\"MAIL\" : " + productos.getMail()+ ", "
                + "\"PASS\" : " + productos.getPass()+ "'}";
                resp+=",";
        }
        resp = resp.substring(0, resp.length()-1);
        resp+="]";
    return resp;
    }
    
}
