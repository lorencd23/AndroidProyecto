package DAO;

import java.util.ArrayList;

/**
 *
 * @author LorenzoGalveMuñoz
 */
public interface DAO<O,I> { //O=Object, I=Integer
    //GENEÉRICOS
    boolean add(O bean);
    void delete(I id);
    void update(O bean);
    //SELECT - RESULTSET --> ARRAYLIST --> JSON
    ArrayList<O> findAll(O bean);
    void find(I id);
}
