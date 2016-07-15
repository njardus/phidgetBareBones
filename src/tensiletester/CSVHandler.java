package tensiletester;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NardusG
 */
class CSVHandler {

    static void createCSV(String testFileLocation) {
        try {
            PrintWriter pw;
            pw = new PrintWriter(new File(testFileLocation));
            StringBuilder sb = new StringBuilder();
            sb.append("");
            
            pw.write(sb.toString());
            pw.close();       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void writeToCSV(String testFileLocation, String testMsg) {
        try {
            PrintWriter pw;
            pw = new PrintWriter(new File(testFileLocation));
            StringBuilder sb = new StringBuilder();
            sb.append(testMsg);
            
            pw.write(sb.toString());
            pw.close();       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
