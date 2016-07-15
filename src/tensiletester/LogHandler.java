package tensiletester;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

/**
 *
 * @author nardusG
 */
class LogHandler {

    /**
     * Write data to the log.
     * @param now The timestamp which the log will use in the log-line.
     * @param logData The log line, whatever you want logged.
     * @param logLocation The complete location of the log-file.
     */
    static void log(Instant now, String logData, String logLocation) {
        System.out.println(now.toString() + " " + logData);
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(logLocation, true)))) 
        {
            out.println(now.toString() + " " + logData);
        }
        catch (IOException e) 
        {
            System.err.println(e);
        }
    }

    /**
     * cleanNow return a cleaned up version of the date-time given by and 
     * Instant. This makes it ideal for use in a file name.
     * @param now The Instant that needs cleaning up.
     * @return A string containing the cleaned up version of the input argument 
     * now.
     */
    static String cleanNow(Instant now)
    {
        return Instant.now().toString().replace(":", "-").replace("T", "-").replace("Z", "").replace(".","-") + ".txt";
    }
    
    /**
     * getMethodName returns the name of the method or function that called it 
     * in String format. This is useful when logging to determine where a 
     * function call originated.
     * 
     * Usage example: 
     * log(Instant.now(), "Function entered: " + getMethodName(), logLocation);
     * 
     * @return A string of the calling function's name.
     */
    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    } 
    
    /**
     * Creates the log file at logFolderLocation + logFileName
     * @param now An Instant (typically Instant.now()) that will be used as 
     * input to the initial loglines, or to generate filenames if none are 
     * provided.
     * @param logFolderLocation The folder where the log file should be created.
     * @param logFileName The filename of the log file.
     * @return logPath A file location where the log file was created, for use
     * by the main program.
     */
    static String createLog(Instant now, String logFolderLocation, String logFileName) {
        String logPath;
        if ((logFolderLocation != null) && (logFileName != null))
        {
            // Create folder
            File dir = new File(logFolderLocation);

            if (!dir.exists())
            {
                dir.mkdirs();
            }

            // Create log file
            try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(logFolderLocation + logFileName, true)))) 
            {
                out.println(now.toString() + " App started.");
                out.println(now.toString() + " Log file created.");
            }
            catch (IOException e) 
            {
                System.err.println(e);
            }
        }
        else
        {
            // Either the log folder or filename was not populated, so we use the defaults
            logFolderLocation = "C:\\logs-" + cleanNow(now) + "\\";
            logFileName = "log-" + cleanNow(now) + ".log";
            createLog(now, logFolderLocation, logFileName);
        }
        
        // Return the file/folder name we used, so that the main program can store it.
        logPath = logFolderLocation + logFileName;
        return logPath;
    }

}
