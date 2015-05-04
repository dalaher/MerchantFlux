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
public class RelacionPBE {
    private Puerto puerto;
    private Barco barco;
    private String id;
    private String Propiedad;
    private String Propiedad2;
    private String Propiedad3;
    private String Propiedad4;
    private String Propiedad5;
    private String Propiedad6;

    public RelacionPBE(Puerto puerto, Barco barco, String Propiedad, String Propiedad2, String Propiedad3, String Propiedad4, String Propiedad5, String Propiedad6) {
        this.puerto = puerto;
        this.barco = barco;
        this.Propiedad = Propiedad;
        this.Propiedad2 = Propiedad2;
        this.Propiedad3 = Propiedad3;
        this.Propiedad4 = Propiedad4;
        this.Propiedad5 = Propiedad5;
        this.Propiedad6 = Propiedad6;
        this.id= puerto.getName() + " <--> "+  barco.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPropiedad4() {
        return Propiedad4;
    }

    public String getPropiedad5() {
        return Propiedad5;
    }

    public String getPropiedad6() {
        return Propiedad6;
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

    public void setPropiedad4(String Propiedad4) {
        this.Propiedad4 = Propiedad4;
    }

    public void setPropiedad5(String Propiedad5) {
        this.Propiedad5 = Propiedad5;
    }

    public void setPropiedad6(String Propiedad6) {
        this.Propiedad6 = Propiedad6;
    }
    
    
}
