package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeePage extends Command {

    OrderMapper om = new OrderMapper();
    int id = 0;
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException{
        
            id = Integer.parseInt(request.getParameter("orderID")); 
            
            om.sendOrder(id);
            
        return "employeepage";
    }

}
