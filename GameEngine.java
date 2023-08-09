// Class to house game logic components and their properties 
// including Building, JumpCalcs, Player and JumpPack 
// Replaces and makes obsolete: Buildings 
// Author: David Sharp
// Version: 2.0
import java.lang.Math;
public class GameEngine 
{
    private Building[] buildings;
    private JumpCalcs jumpCalcs;
    private JumpPack jumpPack;
    private Player player;
    private int gameTurn;
    private int playerOnBuilding;
    


    // default constructor - set size to 16, 1x null, 15x buildings 
    public GameEngine()
    {
        this.buildings = new Building[16];
        this.jumpCalcs = new JumpCalcs();
        this.jumpPack = new JumpPack(10);
        this.player = new Player();
        this.gameTurn = 1;
        this.playerOnBuilding = 1;
    }

    // non-default constructor, directly pass in Building[]
    public GameEngine(Building[] buildings)
    {
        this.buildings = buildings;
        this.player = new Player();
        this.jumpPack = new JumpPack(10);
        this.jumpCalcs = new JumpCalcs();
        this.gameTurn = 1;
        this.playerOnBuilding = 1;
    }

    public void createBuildingArray()
    {
        // create building 0
        buildings[0] = new Building();
        String buildingFileContents = "";
        try 
        {
            buildingFileContents = FileIO.readFile("buildings.txt");
        } 
        catch (Exception e) 
        {
            Log.addToErrorLog(getClass() + ": Error reading buildings.txt");
        }
        
        String[] parsedFileContents = buildingFileContents.split("\n");
        for (int i = 1; i <= 15; i++)
        {
            buildings[i] = new Building();
            buildings[i].setNumber(i);
            buildings[i].setHeight(Integer.parseInt(parsedFileContents[i - 1].split(",")[0]));
            buildings[i].setHasExitPortal(Boolean.parseBoolean(parsedFileContents[i - 1].split(",")[1]));
            buildings[i].setHasFuelCell(Boolean.parseBoolean(parsedFileContents[i - 1].split(",")[2]));
            buildings[i].setHasPoliceWeb(Boolean.parseBoolean(parsedFileContents[i - 1].split(",")[3]));
            buildings[i].setHasFrozen(Boolean.parseBoolean(parsedFileContents[i - 1].split(",")[4]));
            // System.out.println(buildings[i].display());
        }
    }

    // method to display "usable" buildings 1-15, not building 0
    public String displayBuildings()
    {
        String returnString = "";
        for (int i = 1; i < this.buildings.length; i++)
        {
            returnString += this.buildings[i].display() + "\n";
            // System.out.println(this.buildings[i].display());
        }
        return returnString;
    }

    // method to display contents of entire building array, incl Building 0  
    public String displayEntireBuildingArray()
    {
        String returnString = "";
        for (int i = 0; i < this.buildings.length; i++)
        {
            returnString += this.buildings[i].display() + "\n";
        }
        return returnString;
    }

    // method to display a single building 
    public String displayOneBuilding(int index)
    {
        return (this.buildings[index].display());
    }

    public void doJumpCalculations()
    {
        int currentBuilding = this.playerOnBuilding;
        int currentHeight = this.buildings[playerOnBuilding].getHeight();
        // can only jump left to building 1 and not past it 
        if ((currentBuilding - currentHeight) < 1)
            // this.canJumpLeft = false;
            jumpCalcs.setCanJumpLeft(false);
        else if ((currentBuilding - currentHeight) >= 1)
            // this.canJumpLeft = true;
            jumpCalcs.setCanJumpLeft(true);

        // can only jump right to building 15 and not past it
        if ((currentBuilding + currentHeight) > 15)
            // this.canJumpRight = false;
            jumpCalcs.setCanJumpRight(false);
        else if ((currentBuilding + currentHeight) <= 15)
            // this.canJumpRight = true;
            jumpCalcs.setCanJumpRight(true);
        // jump distance is building height
        // this.jumpDistance = currentHeight;
        jumpCalcs.setJumpDistance(currentHeight);
        
        // calculate fuel burn - absolute value of (bldA height - bldB height)
        
        int jumpLeftFuelNeeded = 0;
        int jumpRightFuelNeeded = 0;
        
        if (buildings[playerOnBuilding].getHasPoliceWeb() == true)
        {
            jumpLeftFuelNeeded += 5;
            jumpRightFuelNeeded += 5;
        }

        try 
        {
            // // bldToLeftHeight = buildings.getAllBuildings()[currentBuilding - currentHeight].getHeight();
            // int leftTargetBuilding = playerOnBuilding - buildings[playerOnBuilding].getHeight();
            // int bldToLeftHeight = buildings[leftTargetBuilding].getHeight();
            // jumpLeftFuelNeeded += bldToLeftHeight;
            // // int bldToLeftHeight = buildings[playerOnBuilding - buildings[playerOnBuilding].getHeight()]

            int currentBuildingHeight = buildings[playerOnBuilding].getHeight();
            int targetBuildingNumber = playerOnBuilding - buildings[playerOnBuilding].getHeight();
            int targetBuildingHeight = buildings[targetBuildingNumber].getHeight();
            int heightDiff = Math.abs(targetBuildingHeight - currentBuildingHeight);
            jumpLeftFuelNeeded += heightDiff;
        } 
        catch (Exception e) 
        {
            Log.addToErrorLog("JumpCalcs Left Target Building - Array Probably Out of Bounds: " + e.getMessage());
            // canJumpLeft = false;
            jumpCalcs.setCanJumpLeft(false);
        }

        try 
        {
            int currentBuildingHeight = buildings[playerOnBuilding].getHeight();
            int targetBuildingNumber = playerOnBuilding - buildings[playerOnBuilding].getHeight();
            int targetBuildingHeight = buildings[targetBuildingNumber].getHeight();
            int heightDiff = Math.abs(targetBuildingHeight - currentBuildingHeight);
            jumpRightFuelNeeded += heightDiff;
            // int bldToRightHeight = buildings.getAllBuildings()[currentBuilding + currentHeight].getHeight();
        } 
        catch (Exception e) 
        {
            Log.addToErrorLog("JumpCalcs Right Target Building - Array Probably Out of Bounds: " + e.getMessage());
            jumpCalcs.setCanJumpRight(false);
        }

        
        // player can't move if on frozen building
        if (buildings[playerOnBuilding].getHasFrozen() == true)
        {
            // this.canJumpAtAll = false;
            jumpCalcs.setCanJumpAtAll(false);
        }
        else if (buildings[playerOnBuilding].getHasFrozen() == false)
        {
            // this.canJumpAtAll = true;
            jumpCalcs.setCanJumpAtAll(true);
        }
        // log at end 
        Log.addToFullLog("JumpCalculations: " + jumpCalcs.display());
    }

    // method to retrieve Building[]
    public Building[] getAllBuildings()
    {
        return buildings;
    }

    // method to access a single building in the array 
    public Building getBuilding(int index)
    {
        return buildings[index];
    }

    public JumpCalcs getJumpCalcs()
    {
        return this.jumpCalcs;
    }

    public JumpPack getJumpPack()
    {
        return this.jumpPack;
    }

    public Player getPlayer()
    {
        return this.player;
    }

    public int getGameTurn()
    {
        return this.gameTurn;
    }

    public int getPlayerOnBuilding()
    {
        return this.getPlayerOnBuilding();
    }

    // method to move the Frozen condition to a random building, get input paramater from RandomCalcs.selectRandomBuilding
    public void moveFrozenBuilding(int targetBuilding)
    {
        for (int i = 1; i < this.buildings.length; i++)
        {
            this.buildings[i].setHasFrozen(false);
        }
        this.buildings[targetBuilding].setHasFrozen(true);
        Log.addToFullLog(getClass() + ": Frozen Building moved to " + this.buildings[targetBuilding]);
    }

    // method to move the web trap to a random building, get input paramater from RandomCalcs.selectRandomBuilding
    public void moveWebTrap(int targetBuilding)
    {
        boolean continueLoop = true;
        for (int i = 1; i < this.buildings.length; i++)
        {
            this.buildings[i].setHasPoliceWeb(false);
        }
        this.buildings[targetBuilding].setHasPoliceWeb(true);
        // do
        // {
        //     if (this.buildings[targetBuilding].getHasFrozen() == false)
        //     {
        //         this.buildings[targetBuilding].setHasPoliceWeb(true);
        //         continueLoop = false;
        //     }

        // } while (continueLoop = true);
        Log.addToFullLog(getClass() + ": Police web moved to " + this.buildings[targetBuilding]);
    }

    // method to respawn fuel cells on every third turn. 
    // loops through array to reset FuelCell flag to false
    // then, picks 3x random unique buildings, sets the flag on those buildings to true.
    public void respawnFuelCells(int turn)
    {
        if (turn % 3 == 0)
        {
            int targetBuilding2 = 0;
            int targetBuilding3 = 0;
            int targetBuilding1 = RandomCalcs.selectRandomBuilding();
            do
            {
                targetBuilding2 = RandomCalcs.selectRandomBuilding();
                targetBuilding3 = RandomCalcs.selectRandomBuilding();
                System.out.println(targetBuilding1 + " " + targetBuilding2 + " " + targetBuilding3);
            } while ((targetBuilding1 == targetBuilding2) || (targetBuilding1 == targetBuilding3) || (targetBuilding2 == targetBuilding3));
            for (int i = 1; i < this.buildings.length; i++)
            {
                this.buildings[i].setHasFuelCell(false);
            }
            this.buildings[targetBuilding1].setHasFuelCell(true);
            this.buildings[targetBuilding2].setHasFuelCell(true);
            this.buildings[targetBuilding3].setHasFuelCell(true);
            Log.addToFullLog(getClass() + ": Fuel Cells added to buildings " + targetBuilding1 + " " + targetBuilding2 + " " + targetBuilding3);
        }
    }

    // method to change the building heights following a turn 
    public void randomiseBuildingHeights()
    {
        for (int i = 1; i < this.buildings.length; i++)
        {
            this.buildings[i].setHeight(RandomCalcs.getRandomBuildingHeight());
        }
    }

    // method to set Building[]
    public void setAllBuildings(Building[] buildings)
    {
        this.buildings = buildings;
    }

    // method to set a single building
    public void setBuilding(Building building, int index)
    {
        this.buildings[index] = building;
    }

    public void setJumpCalcs(JumpCalcs jumpCalcs)
    {
        this.jumpCalcs = jumpCalcs;
    }

    public void setJumpPack(JumpPack jumpPack)
    {
        this.jumpPack = jumpPack;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public void setGameTurn(int gameTurn)
    {
        this.gameTurn = gameTurn;
    }

    public void setPlayerOnBuilding(int playerOnBuilding)
    {
        this.playerOnBuilding = playerOnBuilding;
    }
}

