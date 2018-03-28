/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Calculation;
import FunctionLayer.LogicFacade;
import FunctionLayer.PreOrder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Calculator extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException
    {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        PreOrder po = new PreOrder(length, width, height);
        
        Calculation c = LogicFacade.Calculate(po); //not sure if works
        
        HttpSession session = request.getSession();
        session.setAttribute("evenLegoPieces one ", c.getEvenLength()); //save this in session
        session.setAttribute("unevenLegoPieces two ", c.getUnevenLength()); //save this in session
        session.setAttribute("evenLegoPieces three ", c.getEvenWidth()); //save this in session
        session.setAttribute("evenLegoPieces four ", c.getUnevenWidth()); //save this in session
        
        return null;
    }
}
