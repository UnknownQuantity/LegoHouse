/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.Calculation;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.PreOrder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Ordered extends Command {

    OrderMapper om = new OrderMapper();
    int userID = 0;
    int length = 0;
    int width = 0;
    int height = 0;

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ClassNotFoundException {

        HttpSession session = request.getSession();
        userID = (int) session.getAttribute("id");
        length = Integer.parseInt(request.getParameter("length"));
        width = Integer.parseInt(request.getParameter("width"));
        height = Integer.parseInt(request.getParameter("height"));
        PreOrder pre = new PreOrder(userID, length, width, height);
        session.setAttribute("pre", pre);        

        Calculation c = LogicFacade.Calculate(pre); //not sure if works

        session.setAttribute("1x2 Length ", c.getLengthResult().get(2)); //save this in session
        session.setAttribute("1x2 Width ", c.getWidthResult().get(2)); //save this in session
        session.setAttribute("1x2 Length total bricks ", (c.getLengthResult().get(2) * 2) * height/2); //save this in session
        session.setAttribute("1x2 Width total bricks ", (c.getWidthResult().get(2) * 2) * height/2); //save this in session
        session.setAttribute("1x2 total bricks ", ((c.getWidthResult().get(2) * 2) + (c.getLengthResult().get(2) *2)) * height/2); //save this in session
        
        session.setAttribute("2x2 Length ", c.getLengthResult().get(1)); //save this in session
        session.setAttribute("2x2 Width ", c.getWidthResult().get(1)); //save this in session
        session.setAttribute("2x2 Length total bricks ", (c.getLengthResult().get(1) * 2) * height/2); //save this in session
        session.setAttribute("2x2 Width total bricks ", (c.getWidthResult().get(1) * 2) * height/2); //save this in session
        session.setAttribute("2x2 total bricks ", ((c.getWidthResult().get(1) * 2) + (c.getLengthResult().get(1) *2)) * height/2); //save this in session
        
        session.setAttribute("4x2 Length ", c.getLengthResult().get(0)); //save this in session
        session.setAttribute("4x2 Length total bricks ", (c.getLengthResult().get(0) * 2) * height/2); //save this in session
        session.setAttribute("4x2 Width ", c.getWidthResult().get(0)); //save this in session
        session.setAttribute("4x2 Width total bricks ", (c.getWidthResult().get(0) * 2) * height/2); //save this in session
        session.setAttribute("4x2 total bricks ", ((c.getWidthResult().get(0) * 2) + (c.getLengthResult().get(0) *2)) * height/2); //save this in session
        

        om.createPreOrder(pre);
        return "ordered";
    }

}
