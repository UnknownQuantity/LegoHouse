package FunctionLayer;

import DBAccess.BrickMapper;
import java.util.ArrayList;


public class Calculation 
{
    private BrickMapper b = new BrickMapper();
    private int bigL = 0; //is set to the size of the bricks
    private int mediumL = 0; // ^
    private int smallL = 0; // ^^
    private int big = 0;
    private int medium = 0;
    private int small = 0;
    
    private int totalCounterUneven = 0;
    private int totalCounterEven = 0;
    private int totalCounterUnevenWidth = 0;
    private int totalCounterEvenWidth = 0;
    
    private ArrayList<Integer> unevenLength = new ArrayList<>(); //bottom layer
    private ArrayList<Integer> evenLength = new ArrayList<>(); //above bottom
    private ArrayList<Integer> unevenWidth = new ArrayList<>();
    private ArrayList<Integer> evenWidth = new ArrayList<>();
    private ArrayList<Integer> lengthResult = new ArrayList<>();
    private ArrayList<Integer> widthResult = new ArrayList<>();
    private ArrayList<Integer> totalBricks = new ArrayList<>();
    
    

    public Calculation() throws ClassNotFoundException 
    {
        bigL = b.totalLength("big");
        mediumL = b.totalLength("medium");
        smallL = b.totalLength("small");
    }
        
    
    //1. Calculate the total of bricks to be used for the bottom layer 1-3-5-7 etc
    //2. Calculate the total of bricks to be used for the layer above bottom 2-4-6-8 etc
    //3. Calculate the total of bricks to be used as the width of 1-3-5-7 etc
    //4. Calculate the total of bricks to be used as the width of 2-4-6-8 etc
    //5. Calculation of the total amount of bricks used
    
    //To calculate the amount of bricks to be used, just calculate two of the sides, then * them with 2, to cover the last two 
    
    //1. The total of the length is calculated using the customers desired length and the length of the bricks chosen
    public ArrayList<Integer> brickUnevenLayerLength(int customerHouseLength) throws ClassNotFoundException
    {
        /*
        The length of the house will be a total of dots, so for example if a customer
        want the house to be 20 dots long, perhaps divide, or take modulus, the 
        customerHouseLength with first the big brick, then divide, or take the modulus, with 
        the remaining with the medium and etc....
        I have used while loops to check whether or not the usage of the different bricks is possible.
        The idea here is to start at the bottom layer, by starting with using the big briks, then medium bricks and etc.
        */
        int bigCounter = 0; //counts amount used
        int mediumCounter = 0;
        int smallCounter = 0;
        
        int total = customerHouseLength; //The length of the customer choice
        while(total != 0)
        {
            while(total >= 0 && total - bigL >= 0)
            {
                total -= bigL; //every time we use a brick we count down
                bigCounter++; //increment the usage of the brick
                System.out.println("big " + bigCounter); //debug checker
                
            }
            while(total >= 0 && total - mediumL >= 0)
            {
                total -= mediumL; //same as the while loop above
                mediumCounter++;
                System.out.println("medium " + mediumCounter);
                
            }
            while(total > 0)
            {
                total -= smallL;
                smallCounter++;
                System.out.println("small " + smallCounter);
            }        
        }
        totalCounterUneven += bigCounter + mediumCounter + smallCounter;
        System.out.println("Check counter one " + totalCounterUneven);
        unevenLength.add(bigCounter); //adds the amount to an arraylist to store the amount
        unevenLength.add(mediumCounter);
        unevenLength.add(smallCounter);
        return unevenLength; //returns the arraylist with the brick total
    }
    
    //2. Same as method above, only difference is that no big bricks is used
    public ArrayList<Integer> brickEvenLayerLength(int customerHouseLength)
    {
        int mediumCounter = 0;
        int smallCounter = 0;
        
        int total = customerHouseLength; //temp
        while(total != 0)
        {
            while(total >= 0 && total - mediumL >= 0)
            {
                total -= mediumL;
                mediumCounter++;
                System.out.println("medium " + mediumCounter);
                
            }
            while(total > 0)
            {
                total -= smallL;
                smallCounter++;
                System.out.println("small " + smallCounter);
            }        
        }
        totalCounterEven += mediumCounter + smallCounter;
        System.out.println("Check counter two " + totalCounterEven);
        evenLength.add(mediumCounter);
        evenLength.add(smallCounter);
        return evenLength;
    }
    
    public ArrayList<Integer> combinedLength(ArrayList<Integer> uneven, ArrayList<Integer> even) {
        for (int i = 0; i < uneven.size(); i++) {
            if (i == 0) {
                lengthResult.add(uneven.get(i));
            } else lengthResult.add(uneven.get(i) + even.get(i-1));
        }
        return lengthResult;
    }
    
    
    //3. Follows same idea as number 1
    public ArrayList<Integer> brickUnevenLayerWidth(int customerHouseWidth) throws ClassNotFoundException
    {
        int bigCounter = 0; //counts amount used
        int mediumCounter = 0;
        int smallCounter = 0;
        
        int total = customerHouseWidth; //The length of the customer choice
        while(total != 0)
        {
            while(total >= 0 && total - bigL >= 0)
            {
                total -= bigL; //every time we use a brick we count down
                bigCounter++; //increment the usage of the brick
                System.out.println("big " + bigCounter); //debug checker
                
            }
            while(total >= 0 && total - mediumL >= 0)
            {
                total -= mediumL; //same as the while loop above
                mediumCounter++;
                System.out.println("medium " + mediumCounter);
                
            }
            while(total > 0)
            {
                total -= smallL;
                smallCounter++;
                System.out.println("small " + smallCounter);
            }        
        }
        totalCounterUnevenWidth += bigCounter + mediumCounter + smallCounter;
        System.out.println("Check counter three " + totalCounterUnevenWidth);
        unevenWidth.add(bigCounter); //adds the amount to an arraylist to store the amount
        unevenWidth.add(mediumCounter);
        unevenWidth.add(smallCounter);
        return unevenWidth; //returns the arraylist with the brick total
    }
    
    //4. Follows same idea as number 2
    public ArrayList<Integer> brickEvenLayerWidth(int customerHouseWidth)
    {
        int mediumCounter = 0;
        int smallCounter = 0;
        
        int total = customerHouseWidth; //temp
        while(total != 0)
        {
            while(total >= 0 && total - mediumL >= 0)
            {
                total -= mediumL;
                mediumCounter++;
                System.out.println("medium " + mediumCounter);
                
            }
            while(total > 0)
            {
                total -= smallL;
                smallCounter++;
                System.out.println("small " + smallCounter);
            }        
        }
        totalCounterEvenWidth += mediumCounter + smallCounter;
        System.out.println("Check counter four " + totalCounterEvenWidth);
        evenWidth.add(mediumCounter);
        evenWidth.add(smallCounter);
        return evenWidth;
    }
    
    public ArrayList<Integer> combinedWidth(ArrayList<Integer> uneven, ArrayList<Integer> even) {
        for (int i = 0; i < uneven.size(); i++) {
            if (i == 0) {
                widthResult.add(uneven.get(i));
            } else widthResult.add(uneven.get(i) + even.get(i-1));
        }
        return widthResult;
    }
    //5. Calculates total amount of bricks, using input from the customer of 3 int parameters
    public int totalBricks(PreOrder ord) throws ClassNotFoundException
    {
        int total = 0; //brick total
        
        brickUnevenLayerLength(ord.getLength());
        brickEvenLayerLength(ord.getLength()); //add the total of these two above together somehow^, OBS see added here below
        combinedLength(unevenLength, evenLength);
        
        brickUnevenLayerWidth(ord.getWidth());
        brickEvenLayerWidth(ord.getWidth());
        combinedWidth(unevenWidth, evenWidth);
        
        int brickCountLength = 0;
        brickCountLength += totalCounterEven + totalCounterUneven; //added here
        System.out.println("Brick count length " + brickCountLength);
        
        int brickCountWidth = 0;
        brickCountWidth += totalCounterEvenWidth + totalCounterUnevenWidth; 
        System.out.println("Brick count width " + brickCountWidth);
        
        total += (brickCountLength *  ord.getHeight() * brickCountWidth) * 2; //adds everything together
        System.out.println("What is total: " + total);
        
        //Store the total
        totalBricks.add(total);
        
        return total;
    }

    public int getBig() {
        return big;
    }

    public int getMedium() {
        return medium;
    }

    public int getSmall() {
        return small;
    }

    public ArrayList<Integer> getUnevenLength() 
    {
        return unevenLength;
    }

    public ArrayList<Integer> getEvenLength() 
    {
        return evenLength;
    }

    public ArrayList<Integer> getUnevenWidth() 
    {
        return unevenWidth;
    }

    public ArrayList<Integer> getEvenWidth() 
    {
        return evenWidth;
    }

    public ArrayList<Integer> getTotalBricks() 
    {
        return totalBricks;
    }

    public ArrayList<Integer> getLengthResult() {
        return lengthResult;
    }

    public ArrayList<Integer> getWidthResult() {
        return widthResult;
    }
}
