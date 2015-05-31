package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import Model.*;
import java.util.ArrayList;

/**
 *
 * @author Granfran
 */
public class ArchiveReader {

    private static String filepath = "C:\\Users\\Granfran\\Documents\\NetBeansProjects\\MerchantFlux\\modelo.dat";
    public static String archiveReader(File filepath) throws FileNotFoundException, IOException {
    BufferedReader br;
        br = new BufferedReader(new FileReader(filepath));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String everything = sb.toString();
        
        //PUERTOS
        PuertoLista PListasa = new PuertoLista();
        String delims = "#Puertos";
        String delims2 = "\t";
        String[] tokens = everything.split(delims);
        System.out.println(tokens[0]);
        System.out.println("------------------------------------------------");
        for (int i = 1; i < tokens.length-1; i++){
            String[] tokens3 = tokens[i].split(delims2);
            String[] tokens2 = new String[6];
            int k=0;
            for (int j=0; j <tokens3.length; j++){
                if(!"".equals(tokens3[j])){
                    tokens2[k]=tokens3[j];                   
                    k++;
                }
            }
            Puerto puertaso = new Puerto(tokens2[0],tokens2[1],tokens2[2],tokens2[3],tokens2[4],tokens2[5]);
            System.out.println(puertaso.getName()+ "\t" + puertaso.getP1() + "\t"+ puertaso.getP2() + "\t"+ puertaso.getP3() + "\t"+ puertaso.getP4() + "\t"+ puertaso.getP5());
            PListasa.add(puertaso);
        }
        
        //BARCOS
        BarcoLista Blistasa = new BarcoLista();
        delims = "#Barcos";
        delims2 = "\t";
        tokens = everything.split(delims);
        System.out.println(tokens[1]);
        System.out.println("------------------------------------------------");
        for (int i = 2; i < tokens.length-1; i++){
            String[] tokens3 = tokens[i].split(delims2);
            String[] tokens2 = new String[5];
            int k=0;
            for (int j=0; j <tokens3.length; j++){
                if(!"".equals(tokens3[j])){
                    tokens2[k]=tokens3[j];                   
                    k++;
                }
            }
            Barco barcaso = new Barco(tokens2[0],tokens2[1],tokens2[2],tokens2[3],tokens2[4]);
            System.out.println(barcaso.getName()+ "\t" + barcaso.getP1() + "\t"+ barcaso.getP2() + "\t"+ barcaso.getP3() + "\t"+ barcaso.getP4());
            Blistasa.add(barcaso);
        }

        //PUERTO <--> PUERTO
        delims = "#PUERTO <--> PUERTO";
        delims2 = "\t";
        tokens = everything.split(delims);
        System.out.println(tokens[1]);
        System.out.println("------------------------------------------------");
        for (int i = 2; i < tokens.length-1; i++){
            String[] tokens3 = tokens[i].split(delims2);
            String[] tokens2 = new String[5];
            int k=0;
            for (int j=0; j <tokens3.length; j++){
                if(!"".equals(tokens3[j])){
                    tokens2[k]=tokens3[j];                   
                    k++;
                }
            }
            String[] tokens4 = tokens2[1].split(" ");
            Puerto puertaso1 = new Puerto(tokens4[0],"","","","","");
            Puerto puertaso2 = new Puerto(tokens4[1],"","","","","");
            RelacionPuerto relacionasa = new RelacionPuerto(puertaso1,puertaso2,tokens2[2]);
            System.out.print(relacionasa.getId()+ "\t" + relacionasa.getDistancia());
            
            tokens4 = tokens2[3].split(" ");
            puertaso1 = new Puerto(tokens4[0],"","","","","");
            puertaso2 = new Puerto(tokens4[1],"","","","","");
            relacionasa = new RelacionPuerto(puertaso1,puertaso2,tokens2[4]);
            System.out.println(relacionasa.getId()+ " \t " + relacionasa.getDistancia());
        }
        
        //PUERTO <--> BARCO
        ArrayList<RelacionPB> PBlistasa =new ArrayList();
        delims = "#PUERTO <--> BARCO";
        delims2 = "\t";
        tokens = everything.split(delims);
        System.out.println(tokens[1]);
        System.out.println("------------------------------------------------");
        int bandera = 1;
        for (int i = 2; i < tokens.length-1; i++){
            if (!tokens[i].contains("param")){
                System.out.println("llegue" + i);
                String[] tokens3 = tokens[i].split(delims2);
                String[] tokens2 = new String[11];
                int k=0;
                for (int j=0; j <tokens3.length; j++){
                    if(!"".equals(tokens3[j])){
                        tokens2[k]=tokens3[j];                   
                        k++;
                    }
                }
                for(int j = 0; j<PListasa.size(); j++){
                    if(bandera==1){
                    RelacionPB relacionasa = new RelacionPB(PListasa.get(j),Blistasa.get(i-2), tokens2[j+1],"","");
                    PBlistasa.add(relacionasa);}
                    if(bandera==2){
                    PBlistasa.get((i-9)*(PListasa.size()) + j).setPropiedad2(tokens2[j+1]);}
                    if(bandera==3){
                    RelacionPB relacionasa=PBlistasa.get((i-16)*(PListasa.size()) + j);
                    relacionasa.setPropiedad3(tokens2[j+1]);
                    System.out.println(relacionasa.getId()+ "\t" + relacionasa.getPropiedad()+ "\t"+ relacionasa.getPropiedad2()+ "\t"+ relacionasa.getPropiedad3());} 
                }
                
            }else{bandera++; }
        }
    } finally {
        br.close();
    }
        return null;
    }
   
    
}
