package DBAccess;

import FunctionLayer.PreOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class OrderMapper 
{
    public void createPreOrder(PreOrder ord) //To test in main
    {
        int orderId = 0;
        try 
        {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO preOrders (userID, length, width, height) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS ); 
            ps.setInt(1, ord.getUserId()); //user id
            ps.setInt(2, ord.getLength());
            ps.setInt(3, ord.getWidth());
            ps.setInt(4, ord.getHeight());

            System.out.println("Check sql order " + SQL);

            int check = ps.executeUpdate();
            if(check == 1)
            {
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                orderId = ids.getInt( 1 );

                System.out.println("Debug " + orderId);

            }
        } catch ( SQLException | ClassNotFoundException ex ) { //temporary error
            throw new Error( ex.getMessage() );
        }
    }
    
    public static void createOrder(PreOrder ord) //to use in logcfacade
    {
        int orderId = 0;
        try 
        {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO preOrders (userID, length, width, height) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS ); 
            ps.setInt(1, ord.getUserId()); //user id
            ps.setInt(2, ord.getLength());
            ps.setInt(3, ord.getWidth());
            ps.setInt(4, ord.getHeight());

            System.out.println("Check sql order " + SQL);

            int check = ps.executeUpdate();
            if(check == 1)
            {
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                orderId = ids.getInt( 1 );

                System.out.println("Debug " + orderId);

            }
        } catch ( SQLException | ClassNotFoundException ex ) { //temporary error
            throw new Error( ex.getMessage() );
        }
    }
    
    public List<PreOrder> History(PreOrder order)
    {
        List<PreOrder> history = new ArrayList<>();
        PreOrder ord = null;
        try 
        {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM useradmin.preorders where userID = " + order.getUserId();
            
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next())
            {   
                int id = resultset.getInt("id");
                int userID = resultset.getByte("userID");
                int length = resultset.getInt("length");
                int width = resultset.getInt("width");
                int height = resultset.getInt("height");
                
                if(userID == order.getUserId())
                {
                    ord = new PreOrder(userID, length, width, height);
                    history.add(ord);
                }
            }
            System.out.println("sql syntax ok? " + SQL);
            
        } catch ( SQLException | ClassNotFoundException ex ) { //temporary error
            throw new Error( ex.getMessage() );
        }
        
        return history;
    }
    public static List<PreOrder> orderHistory(int ID)
    {
        List<PreOrder> history = new ArrayList<>();
        PreOrder ord = null;
        try 
        {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM useradmin.preorders where userID = " + ID;
            
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next())
            {   
                int id = resultset.getInt("id");
                int userID = resultset.getByte("userID");
                int length = resultset.getInt("length");
                int width = resultset.getInt("width");
                int height = resultset.getInt("height");
                
                if(userID == ID)
                {
                    ord = new PreOrder(userID, length, width, height);
                    history.add(ord);
                }
            }
            System.out.println("sql syntax ok? " + SQL);
            
        } catch ( SQLException | ClassNotFoundException ex ) { //temporary error
            throw new Error( ex.getMessage() );
        }
        
        return history;
    }
    
    public ArrayList<Integer> getAllOrders() throws ClassNotFoundException, SQLException {
         ArrayList<Integer> ids = new ArrayList<>();
         
         try {
             Connection con = Connector.connection();
             String sql = "Select id from preorders order by id"; //useradmin.preorders
             
             PreparedStatement ps = con.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
             
             ResultSet resultset = ps.executeQuery(sql);

            while (resultset.next()) {
                int orderId = resultset.getInt("id");
                ids.add(orderId);
            }
             
         } catch (SQLException e) {
             e.printStackTrace();
         }        
         return ids;
     } 
    
    public boolean isOrderSent(int id) throws ClassNotFoundException {
            int sent = 0;
        try {
             Connection con = Connector.connection();
             String sql = "Select orderConfirmed from preorders where id= '" + id +"'"; //useradmin.preorders
             
             PreparedStatement ps = con.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
             
             ResultSet resultset = ps.executeQuery(sql);

            while (resultset.next()) {
                sent = resultset.getInt("orderConfirmed");                
            }
            if (sent == 1) return true;
                
             
         } catch (SQLException e) {
             e.printStackTrace();
         }        
         return false;
     } 
    
     
     public void sendOrder(int id) {
         
        try 
        {
            Connection con = Connector.connection();
            String SQL = "update preorders set orderConfirmed= '1' where id= '"+id+"'";
            
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS ); 
           // ps.setInt(1, user.getId()); //user id
            
            System.out.println("Check sql order " + SQL);
            
            ps.executeUpdate();
            } catch( SQLException | ClassNotFoundException ex) {
        throw new Error( ex.getMessage() );
}


         
     }
     
}