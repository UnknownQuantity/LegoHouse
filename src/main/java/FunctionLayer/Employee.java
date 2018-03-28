package FunctionLayer;

import DBAccess.OrderMapper;
import java.sql.SQLException;
import java.util.ArrayList;

public class Employee {

    OrderMapper om = new OrderMapper();
//   ArrayList<Integer> orderID = new ArrayList<>();
    ArrayList<String> orderID = new ArrayList<>();

    //public ArrayList<Integer> getOrderID() {
    public ArrayList<String> getOrderID() {
        return orderID;
    }

    public void idList() throws ClassNotFoundException, SQLException {
        for (int i = 0; i < om.getAllOrders().size(); i++) {
            if (om.isOrderSent(om.getAllOrders().get(i))) {
                orderID.add(om.getAllOrders().get(i).toString() + " - sent" + "<br>");
            } else {
                orderID.add(om.getAllOrders().get(i).toString() + " - not sent" + "<br>");
            }
        }
        //orderID = om.getAllOrders();
    }

    @Override
    public String toString() {
        return orderID + "<br>";
    }

}
