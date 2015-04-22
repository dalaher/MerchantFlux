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
public class PuertoEspLista extends ArrayList<Puerto>{
    ArrayList<Puerto> barcoList = new ArrayList<Puerto>();
    public PuertoEspLista() {
    }
/*    public void addBarco (Barco barco){
        barcoList.add(barco);
    }
    */
    public void deletePuerto (String barco){
        barcoList.remove(barco);
    }
}