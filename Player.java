// Player Class - stores Player data 
// Author: David Sharp
// Version: 1.0

public class Player
{
    private String playerName;
    private int fuelCellsFound;

    // default constructor
    public Player()
    {
        this.playerName = "Unknown";
        this.fuelCellsFound = 0;
    }

    // non-default constructor 
    public Player(String name, int onBuilding, int fuelCellsFound)
    {
        this.playerName = name;
        this.fuelCellsFound = fuelCellsFound;
    }

    // display method 
    public String display()
    {
        return ("Player Name: " + this.playerName + "; Player Fuel Cells Found: " + this.fuelCellsFound);
    }

    // retrieve how many fuel cells the player has found 
    public int getFuelCellsFound()
    {
        return this.fuelCellsFound;
    }

    // retrieve the player's name 
    public String getPlayerName()
    {
        return this.playerName;
    }

    // Key method - gets the player name and validates for correct entry 
    public String inputPlayerName()
    {
        String name = "";
        try 
        {
            name = Input.acceptStringInput("Enter Player Name:");
        } 
        catch (Exception e) 
        {
            Log.addToErrorLog(getClass() + ": Error getting player name: " + e.getMessage());
            name = "";
        }
        if (Validation.isNameLengthOK(name, 3, 12) == true)
        {
            this.playerName = name;
        }
        else
        {
            do
            {
                System.out.println("\nPlease enter a name of 3 to 12 characters!\n");
                try 
                {
                    name = Input.acceptStringInput("Enter Player Name:");
                } 
                catch (Exception e) 
                {
                    Log.addToErrorLog(getClass() + ": Error getting player name: " + e.getMessage());
                    name = "";
                }
                if (Validation.isNameLengthOK(name, 3, 12) == true)
                    this.playerName = name;
            } while (playerName == "");
        }
        System.out.println("Welcome " + playerName + "!");
        return playerName;
    }


    // set how many fuel cells the player has found 
    public void setFuelCellsFound(int fuelCellsFound)
    {
        this.fuelCellsFound = fuelCellsFound;
    }

    // set the player's name 
    public void setPlayerName(String name)
    {
        this.playerName = name;
    }
}