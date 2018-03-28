package Temporary;

public class Bricks 
{
    private int id;
    private String type;
    private int length;
    private int width;
    private int height;

    public Bricks() 
    {
    }

    public Bricks(int id, String type, int length) 
    {
        this.id = id;
        this.type = type;
        this.length = length;
    }

    public Bricks(int id, String type, int length, int width, int height) 
    {
        this.id = id;
        this.type = type;
        this.length = length;
        this.width = width;
        this.height = height;
    }  

    public Bricks(int length) 
    {
        this.length = length;
    }
    
    public int getId() 
    {
        return id;
    }

    public String getType() 
    {
        return type;
    }

    public int getLength() 
    {
        return length;
    }

    public int getWidth() 
    {
        return width;
    }

    public int getHeight() 
    {
        return height;
    }

    public void setLength(int length) 
    {
        this.length = length;
    }
    
    @Override
    public String toString() 
    {
        return "BrickID: " + id + "\nBricktype: " + type + "\nBricklength: " + length 
                + "\nBrickwidth:" + width + "\nBrickheight: " + height + "\n";
    }
}
