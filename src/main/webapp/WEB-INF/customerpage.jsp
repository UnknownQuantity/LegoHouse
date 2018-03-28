<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        
        <%
            User user = (User)session.getAttribute("user");
            %>
        
        <h3>Hello <%= user.getEmail()%> </h3>

        This is where you will input order

        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="ordered">
            <div class="height">
                <label> Length</label><input type="number" name="length" max="99" required value="1"/>
            </div>            
            <div class="length">
                <label> Width</label><input type="number" name="width" max="999" required value="1"/>
            </div>            
            <div class="width">
                <label> Height</label><input type="number" name="height" max="999" required value="1"/>
            </div>                        
                <input type="submit" value="Order">
            </form>

    </body>
</html>
