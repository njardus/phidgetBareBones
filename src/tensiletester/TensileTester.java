/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tensiletester;

import com.phidgets.PhidgetException;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NardusG
 */
public class TensileTester {
    
    /* MAGIC NUMBERS */
    
    /* VARIABLES */
    private static String logPath;
    
    /* CONSTANTS */
    private static final String logFolderName = "C:\\TensileTesterLogs\\";
    private static final String logFileName = "log-" + LogHandler.cleanNow(Instant.now()) + ".log";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialize logs:
        logPath = LogHandler.createLog(Instant.now(),
                logFolderName, 
                logFileName);
        
        // Initialize variables:
        
        
        // Initialize Phidgets:
        initPhidgets();
    }

    private static void initPhidgets() {
        LogHandler.log(Instant.now(), "Entering " + LogHandler.getMethodName(), getLogPath());
            
        try {
            // Create:
            
            // phidgetVariable = new typePhidget();
            
            LogHandler.log(Instant.now(), "Phidgets created.", getLogPath());
        } catch (PhidgetException ex) {
            LogHandler.log(Instant.now(), "Phidgets creation failed", getLogPath());
            Logger.getLogger(TensileTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Open:
        try {
            LogHandler.log(Instant.now(), "Attempting to open phidget", getLogPath());
//            phidgetVariable.openAny();
        } catch (PhidgetException ex) {
            Logger.getLogger(TensileTester.class.getName()).log(Level.SEVERE, null, ex);
        }

        LogHandler.log(Instant.now(), "Phidgets opened.", getLogPath());

        try {
            // Attach:
            
//            phidgetVariable.waitForAttachment(PHIDGETTIMEOUT);
            
        } catch (PhidgetException ex) {
            Logger.getLogger(TensileTester.class.getName()).log(Level.SEVERE, null, ex);
            LogHandler.log(Instant.now(), "Attachin phidgets failed", getLogPath());
        }

        try {
            
//            if (phidgetVariable.isAttached())
//            {
//                Phidget startup settings
//            }
        } catch (PhidgetException ex) {
            Logger.getLogger(TensileTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LogHandler.log(Instant.now(), "Leaving " + LogHandler.getMethodName(), getLogPath());
    }

    private static void killPhidgets() {
        LogHandler.log(Instant.now(), "Entering " + LogHandler.getMethodName(), getLogPath());
        
        try {
//            if (phidgetVariable.isAttached())
//            {
//                phidgetVariable.close();
//            }
        } catch (PhidgetException ex) {
            Logger.getLogger(TensileTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LogHandler.log(Instant.now(), "Leaving " + LogHandler.getMethodName(), getLogPath());
    }

    /**
     * @return the logPath
     */
    public static String getLogPath() {
        return logPath;
    }
    
}
