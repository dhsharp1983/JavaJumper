// Player Class - for Player object 
// Author: David Sharp
// Version: 1.0

public class Player
{
    private String playerName;
    private int onBuilding;
    private int fuelCellsFound;

    // default constructor
    public Player()
    {
        this.playerName = "Unknown";
        this.onBuilding = 1;
        this.fuelCellsFound = 0;
    }

    // non-default constructor 
    public Player(String name, int onBuilding, int fuelCellsFound)
    {
        this.playerName = name;
        this.onBuilding = onBuilding;
        this.fuelCellsFound = fuelCellsFound;
    }

    // display method 
    public String display()
    {
        return ("Player Name: " + this.playerName + "; Player On Building: " + this.onBuilding + "; Player Fuel Cells Found: " + this.fuelCellsFound);
    }

    // retrieve how many fuel cells the player has found 
    public int getFuelCellsFound()
    {
        return this.fuelCellsFound;
    }

    // retrieve which building the player is on 
    public int getOnBuilding()
    {
        return this.onBuilding;
    }

    // retrieve the player's name 
    public String getPlayerName()
    {
        return this.playerName;
    }

    // set how many fuel cells the player has found 
    public void setFuelCellsFound(int fuelCellsFound)
    {
        this.fuelCellsFound = fuelCellsFound;
    }

    // set which building the player is on 
    public void setOnBuilding(int onBuilding)
    {
        this.onBuilding = onBuilding;
    }

    // set the player's name 
    public void setPlayerName(String name)
    {
        this.playerName = name;
    }
}
