package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bini
 */
public class RelacionPuerto {
    private Puerto puerto;
    private Puerto puerto2;
    private String distancia;
    private String id;

    public RelacionPuerto(Puerto puerto, Puerto puerto2, String distancia) {
        this.puerto = puerto;
        this.puerto2 = puerto2;
        this.distancia = distancia;
        this.id= puerto.getName() + " --> "+  puerto2.getName();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Puerto getPuerto() {
        return puerto;
    }

    public Puerto getPuerto2() {
        return puerto2;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setPuerto(Puerto puerto) {
        this.puerto = puerto;
    }

    public void setPuerto2(Puerto puerto2) {
        this.puerto2 = puerto2;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }
    
}
