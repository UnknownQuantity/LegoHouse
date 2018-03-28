package DBAccess;

import FunctionLayer.Bricks;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BrickMapper 
{
    public List<Bricks> getAllBottoms() throws ClassNotFoundException 
    {
        List<Bricks> brick = new ArrayList<>();
        try 
        {
            Connection con = Connector.connection();

            String sql = "SELECT * FROM useradmin.brickinfo";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultset = ps.executeQuery();
            
            while (resultset.next()) {
                String name = resultset.getString("type");
                int length = resultset.getInt("length");
                int lego_id = resultset.getInt("id");
                int width = resultset.getInt("width");                
                int height = resultset.getInt("height");
                
                Bricks b = new Bricks(lego_id, name, length, width, height);
                
                brick.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brick;
    }
    
    public int totalLength(String type) throws ClassNotFoundException
    {
        Bricks b = new Bricks();
        int total = 0;

        try 
        {
            Connection con = Connector.connection();

            String sql = "SELECT * FROM useradmin.brickinfo";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultset = ps.executeQuery();

            while(resultset.next()) 
            {
                String name = resultset.getString("type");
                int length = resultset.getInt("length");
                int width = resultset.getInt("width");
                int height = resultset.getInt("height");
                b.setLength(length);
                if(name.equals(type))
                {
                    b = new Bricks(length);
                    total = b.getLength();
                    break;
                }
            }
            
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return total;
    }
}
