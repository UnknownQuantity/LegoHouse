

<%@page import="DBAccess.OrderMapper"%>
<%@page import="FunctionLayer.Employee"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orderhistory</title>
    </head>
    <body>
                <%
            User user = (User)session.getAttribute("user");
            OrderMapper om = new OrderMapper();
            %>
        <h1>Show orderhistory here</h1>
        
        <%=om.orderHistory(user.getId()).toString().replace("[","").replace("]","").replace(",","").replace("Orderhistory","<br>Orderhistory")+"<br>"%><br>
                
        
    </body>
</html>
