import java.util.Random;

public class RandomCalcs
{
    public static int getRandomBuildingHeight()
    {
        Random random = new Random();
        int randomBuildingHeight = random.nextInt(5) + 1;
        return randomBuildingHeight;
    }

    public static boolean getRandomBoolean()
    {
        Random random = new Random();
        boolean randomBoolean = random.nextBoolean();
        return randomBoolean;
    }

    public static int selectRandomBuilding()
    {
        Random random = new Random();
        int randomBuildingNumber = random.nextInt(15) + 1;
        return randomBuildingNumber;
    }
}