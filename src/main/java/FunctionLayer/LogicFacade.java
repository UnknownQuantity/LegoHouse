package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static User getUser(int id) throws ClassNotFoundException {
        return UserMapper.getUser(id);
    }

    public static PreOrder createOrder(PreOrder o) //Not sure if this is correct and if it works??
    {
        PreOrder order = new PreOrder(o.getLength(), o.getWidth(), o.getHeight());
        OrderMapper.createOrder(order);
        return order;
    }
     
    public static List<PreOrder> orderHistory(int i) {
        return OrderMapper.orderHistory(i);
    }

    public static Calculation Calculate(PreOrder order) throws ClassNotFoundException {
        Calculation c = new Calculation();
        c.totalBricks(order);
        return c;
    }
}
