package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command extends HttpServlet{

    private static HashMap<String, Command> commands;

    private static void initCommands() throws ServletException, IOException {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "help", new Help() );
        commands.put( "ordered", new Ordered() );
        commands.put( "orderhistory", new OrderHistory() );
        commands.put( "customerpage", new CustomerPage() );
        commands.put("employeepage", new EmployeePage());
    }

    static Command from( HttpServletRequest request ) throws ServletException, IOException {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException, ClassNotFoundException, ServletException;;

}