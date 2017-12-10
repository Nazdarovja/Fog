/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Orchi
 */
public class Logging {
    
    public static void setUp() {
        Configuration.getMyLogger().addHandler(new ConsoleHandler());
        if(Configuration.PRODUCTION) {
            try {
                FileHandler fileHandler = new FileHandler(Configuration.LOGFILEPATH);
                fileHandler.setFormatter(new SimpleFormatter());
                Configuration.getMyLogger().addHandler(fileHandler);
            } catch (IOException ex) {
                Logger.getLogger(Logging.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(Logging.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
