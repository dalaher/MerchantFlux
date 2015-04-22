
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
    private String filepath = "C:\\Users\\Bini\\Documents\\NetBeansProjects\\Barquito\\a.txt";
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
        return everything;
    } finally {
        br.close();
    }
    }
    
}
