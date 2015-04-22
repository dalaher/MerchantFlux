
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
public class ArchiveWriter {
    private String filepath = "C:\\Users\\Granfran\\Documents\\NetBeansProjects\\MerchantFlux\\b.txt";
    public String archiveWriter() throws FileNotFoundException, IOException {
        try {
            String content = "This is the content to write into file";
            File file = new File(filepath);
	// if file doesnt exists, then create it
            if (!file.exists()) {
		file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            return ("Done");
	} finally {
        System.out.print("Llegué aquí");
    }
    }
}