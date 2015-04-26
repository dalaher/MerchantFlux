
import Model.Puerto;
import Model.Barco;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bini
 */
public class ArchiveReader {
    private String filepath = "C:\\Users\\Bini\\Documents\\NetBeansProjects\\MerchantFlux\\a.txt";
    public String archiveReader() throws FileNotFoundException, IOException {
    BufferedReader br = new BufferedReader(new FileReader(filepath));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String everything = sb.toString();
        String delims = "#token";
        String[] tokens = everything.split(delims);
        System.out.println(tokens[0]);
        for (int i = 1; i < tokens.length; i++){
            System.out.println("------------------------------------------------");
            String delims2 = " ";
            String[] tokens2 = tokens[i].split(delims2);
            Puerto puertaso = new Puerto (tokens2[0],tokens2[1],tokens2[2],tokens2[3],tokens2[4],tokens2[5]);
        }
        delims = "#Barcos";
        tokens = everything.split(delims);
        for (int i = 1; i < 3; i++){
            System.out.println("------------------------------------------------");
            String delims2 = " ";
            String[] tokens2 = tokens[i].split(delims2);
            Barco barcaso = new Barco (tokens2[0],tokens2[1],tokens2[2],tokens2[3],tokens2[4]);
            System.out.print("Estoy imprimiendo el barcaso: " + " PN: " + barcaso.getName() + " PRPT:" + barcaso.getP1()+ " " + barcaso.getP2()+ " " + barcaso.getP4());
        }
        //}
    } finally {
        br.close();
    }
        return null;
    }
    
}/*
String filepath = "C:\\Users\\Bini\\Documents\\NetBeansProjects\\MerchantFlux\\a.txt";

    BufferedReader br = new BufferedReader(new FileReader(filepath));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String everything = sb.toString();
        String delims = "#token";
        String[] tokens = everything.split(delims);
        System.out.println(tokens[0]);
        for (int i = 1; i < tokens.length; i++){
            System.out.println("------------------------------------------------");
            String delims2 = " ";
            String[] tokens2 = tokens[i].split(delims2);
            Puerto puertaso = new Puerto (tokens2[0],tokens2[1],tokens2[2],tokens2[3],tokens2[4],tokens2[5]);
            System.out.print("Estoy imprimiendo el puertaso: " + " PN: " + puertaso.getName() + " PRPT:" + puertaso.getP1()+ " " + puertaso.getP2()+ " " + puertaso.getP5());
            }
        //}
    } finally {
        br.close();
    }*/
