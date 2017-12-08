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
        commands.put("QuickBuild", new QuickBuild());
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("calculate", new Calculate());
        commands.put("sendInquiry", new SendInquiry());
        commands.put("viewinquiries", new ViewInquiries());
        commands.put("viewbom", new ViewBoM());
        commands.put("viewcustomers", new ViewCustomers());
        commands.put("inquiry", new ViewLatestInquiry());
        commands.put("saveInquiry", new SaveInquiry());
        commands.put("newInquiry", new NewInquiry());
        commands.put("chooseInquiry", new ChooseInquiry());

    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }

        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response) throws Exception; // might change this
}
