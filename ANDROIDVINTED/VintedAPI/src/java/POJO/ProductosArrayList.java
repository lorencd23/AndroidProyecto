package POJO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class ProductosArrayList {

    private ArrayList<Products> listaProductos;
    private Products producto;
    private static ProductosArrayList productosArrayList;

    public ProductosArrayList(ArrayList<Products> listaProductos) {
        this.listaProductos = new ArrayList<>();
        this.listaProductos = listaProductos;
    }
//    /*PATRÓN SOFTWARE -> SINGLETON */
//    public static ProductosArrayList getInstance(){
//        if (productosArrayList == null){
//            productosArrayList = new ProductosArrayList();
//        }
//        return productosArrayList;
//    }

    public ArrayList<Products> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Products> listaProductos) {
        this.listaProductos = listaProductos;
    }

    //JSON
    public String toArrayJSon() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(listaProductos);

        return resp;
    }

    public String toArrayXML() {
        int contador = 0;
        String cadena = "<PRODUCTOS> ";
        for (Products productos : listaProductos) {
            int totalItems = listaProductos.size();

            cadena += "\n\t<Producto>"
                    + "\n\t\t<Id>" + productos.getIdProducto() + "</Id>"
                    + "\n\t\t<Nombre>" + productos.getName() + "</Nombre>"
                    + "\n\t\t<Precio>" + productos.getPrize() + "</Precio>"
                    + "\n\t\t<Descripcion>" + productos.getDescription() + "</Descripcion>"
                    + "\n\t\t<Existencias>" + productos.getExistences() + "</Existencias>"
                    + "\n\t\t<Imagen>" + productos.getImg() + "</Imagen>"
                    + "\n\t</Producto>";
            contador++;

        }
        cadena += "\n</PRODUCTOS>";
        return cadena;
    }

    //String
    public String toJSON() {
        int contador = 0;
        String cadena = "{\n'prodcutos': [";
        for (Products productos : listaProductos) {
            int totalItems = listaProductos.size();

            cadena += "\n{ 'ID':" + productos.getIdProducto()
                    + ", 'NAME':" + productos.getName()
                    + ", 'PRIZE':" + productos.getPrize()
                    + ", 'DESCRIPTION':" + productos.getDescription()
                    + ", 'EXISTENCES':" + productos.getExistences()
                    + ", 'IMG':" + productos.getImg() + "}";
            contador++;

            if (contador != totalItems) {
                cadena += ",";
            }
            // Si es i-1
        }
        cadena += "\n]\n}";
        return cadena;
    }
}
