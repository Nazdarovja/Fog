/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import java.util.logging.Logger;

/**
 *
 * @author Orchi
 */
public class Configuration {
    public static final boolean PRODUCTION = true;
    public static final String LOGFILEPATH = ""; // PATH TO UBUNTU!!!
    private static Logger myLogger = Logger.getLogger("");
    public static Logger getMyLogger() {
        return myLogger;
    }
}
