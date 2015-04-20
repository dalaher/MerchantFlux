/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Bini
 */
public class BarcoLista extends ArrayList<Barco>{
    ArrayList<Barco> barcoList = new ArrayList<Barco>();
    public BarcoLista() {
    }
/*    public void addBarco (Barco barco){
        barcoList.add(barco);
    }
    */
    public void deleteBarco (String barco){
        barcoList.remove(barco);
    }
}
