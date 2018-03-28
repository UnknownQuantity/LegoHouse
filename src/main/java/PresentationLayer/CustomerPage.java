/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.PreOrder;
import FunctionLayer.User;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dorte
 */
public class CustomerPage extends Command {
    OrderMapper om = new OrderMapper();
    int userID = 0;
    int length = 0;
    int width = 0;
    int height = 0;
            
    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
            HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        userID = user.getId();
        length = Integer.parseInt(request.getParameter("length"));
        width = Integer.parseInt(request.getParameter("width"));
        height = Integer.parseInt(request.getParameter("height"));

        PreOrder pre = new PreOrder(userID, length, width, height);
        
        om.createPreOrder(pre);
        return "ordered";
}

}

