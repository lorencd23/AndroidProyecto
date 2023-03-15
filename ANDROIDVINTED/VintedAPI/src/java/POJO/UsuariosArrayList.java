package POJO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class UsuariosArrayList {

    private ArrayList<Usuarios> listaUsuarios;
    private Usuarios usuario;
    private static UsuariosArrayList usuariosArrayList;

    public UsuariosArrayList(ArrayList<Usuarios> listaUsuarios) {
        this.listaUsuarios = new ArrayList<>();
        this.listaUsuarios = listaUsuarios;
    }
//    /*PATRÓN SOFTWARE -> SINGLETON */
//    public static ProductosArrayList getInstance(){
//        if (productosArrayList == null){
//            productosArrayList = new ProductosArrayList();
//        }
//        return productosArrayList;
//    }

    public ArrayList<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    //JSON
    public String toArrayJSon() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(listaUsuarios);

        return resp;
    }

    public String toArrayXML() {
        int contador = 0;
        String cadena = "<USUARIOS> ";
        for (Usuarios usuarios : listaUsuarios) {
            int totalItems = listaUsuarios.size();

            cadena += "\n\t<Usuario>"
                    + "\n\t\t<Id>" + usuarios.getIdProducto() + "</Id>"
                    + "\n\t\t<Nombre>" + usuarios.getName() + "</Nombre>"
                    + "\n\t\t<Mail>" + usuarios.getMail()+ "</Mail>"
                    + "\n\t\t<Pass>" + usuarios.getPass()+ "</Pass>"
                    + "\n\t</Usuario>";
            contador++;

        }
        cadena += "\n</USUARIOS>";
        return cadena;
    }

    //String
    public String toJSON() {
        int contador = 0;
        String cadena = "{\n'usuarios': [";
        for (Usuarios usuarios : listaUsuarios) {
            int totalItems = listaUsuarios.size();

            cadena += "\n{ 'ID':" + usuarios.getIdProducto()
                    + ", 'NAME':" + usuarios.getName()
                    + ", 'MAIL':" + usuarios.getMail()
                    + ", 'PASS':" + usuarios.getPass()
                    + "}";
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
