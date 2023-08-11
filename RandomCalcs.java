// Static class to return random integers and booleans as required by the game  
// Author: David Sharp
// Version: 1.0

import java.util.Random;

public class RandomCalcs
{
    // method returns a value between 1 and 5, mainly for randomising building heights 
    public static int getRandomBuildingHeight()
    {
        Random random = new Random();
        int randomBuildingHeight = random.nextInt(5) + 1;
        return randomBuildingHeight;
    }

    // method returns a random boolean, used to help randomise aspects of the game 
    public static boolean getRandomBoolean()
    {
        Random random = new Random();
        boolean randomBoolean = random.nextBoolean();
        return randomBoolean;
    }

    // selects a building from 1-15 for web trap, fuel cell and freeze condition  
    public static int selectRandomBuilding()
    {
        Random random = new Random();
        int randomBuildingNumber = random.nextInt(15) + 1;
        return randomBuildingNumber;
    }
}