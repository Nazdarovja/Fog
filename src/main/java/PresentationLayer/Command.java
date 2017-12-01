/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Orchi
 */
public abstract class Command {
      private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "register", new Register() );
        commands.put( "QuickBuild", new QuickBuild());
        commands.put( "calculate", new Calculate());
        commands.put( "sendinquiry", new SendInquiry());
        commands.put( "viewinquiries", new ViewInquiries() );
        commands.put( "viewbom", new ViewBoM() );
        commands.put( "viewcustomers" , new ViewCustomers() );
        commands.put( "inquiry" , new ViewLatestInquiry() );
        
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) 
            initCommands();
        
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) throws Exception; // might change this
}
