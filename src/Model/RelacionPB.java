/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Bini
 */
public class RelacionPB {
    private Puerto puerto;
    private Barco barco;
    private String Propiedad;
    private String Propiedad2;
    private String Propiedad3;

    public RelacionPB(Puerto puerto, Barco barco, String Propiedad, String Propiedad2, String Propiedad3) {
        this.puerto = puerto;
        this.barco = barco;
        this.Propiedad = Propiedad;
        this.Propiedad2 = Propiedad2;
        this.Propiedad3 = Propiedad3;
    }

    public Puerto getPuerto() {
        return puerto;
    }

    public Barco getBarco() {
        return barco;
    }

    public String getPropiedad() {
        return Propiedad;
    }

    public String getPropiedad2() {
        return Propiedad2;
    }

    public String getPropiedad3() {
        return Propiedad3;
    }

    public void setPuerto(Puerto puerto) {
        this.puerto = puerto;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public void setPropiedad(String Propiedad) {
        this.Propiedad = Propiedad;
    }

    public void setPropiedad2(String Propiedad2) {
        this.Propiedad2 = Propiedad2;
    }

    public void setPropiedad3(String Propiedad3) {
        this.Propiedad3 = Propiedad3;
    }
    
    
}
