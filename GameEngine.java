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

    // Key Method: executable method that creates the building array, run this in Main 
    public void createBuildingArray()
    {
        // create building 0 - used to avoid Index 0 in the array 
        buildings[0] = new Building(); 

        // read in buildings.txt
        String buildingFileContents = "";
        try 
        {
            buildingFileContents = FileIO.readFile("buildings.txt");
        } 
        catch (Exception e) 
        {
            Log.addToErrorLog(getClass() + ": Error reading buildings.txt");
        }
        
        // parse contents 
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
        String mystring = displayBuildings();
        Log.addToFullLog(mystring);
    }

    // method to display "usable" buildings 1-15, exclude building 0
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

    // method to display details of Jump Pack 
    public String displayJumpPack()
    {
        return this.jumpPack.display();
    }

    // method to display details of the Player 
    public String displayPlayer()
    {
        return this.player.display();
    }

    // method to display details of the Jump Calculations 
    public String displayJumpCalcs()
    {
        return this.jumpCalcs.display();
    }

    // method to display some key game stats 
    public String displayGameStats()
    {
        String returnString = "Turn:" + gameTurn + ";  PlayerOnBuilding:" + playerOnBuilding + ";  jumpPackCharge:" + jumpPack.getBatteryLevel();
        return returnString;
    }

    // key method - performs jump calculations and saves them in jumpCalcs
    public void doJumpCalculations()
    {
        int currentBuilding = this.playerOnBuilding;
        int currentHeight = this.buildings[playerOnBuilding].getHeight();
        int leftTargetBuildingNumber;
        int leftTargetBuildingHeight;
        int rightTargetBuildingHeight;
        int rightTargetBuildingNumber;
        int jumpLeftHeightDiff;
        int jumpRightHeightDiff;
        int jumpLeftFuelNeeded = 0;
        int jumpRightFuelNeeded = 0;

        // can only jump left to building 1 and not past it 
        if ((currentBuilding - currentHeight) < 1)
            jumpCalcs.setCanJumpLeft(false);
        else if ((currentBuilding - currentHeight) >= 1)
            jumpCalcs.setCanJumpLeft(true);

        // can only jump right to building 15 and not past it
        if ((currentBuilding + currentHeight) > 15)
            jumpCalcs.setCanJumpRight(false);
        else if ((currentBuilding + currentHeight) <= 15)
            jumpCalcs.setCanJumpRight(true);
        
        
        // calculate fuel burn - absolute value of (bldA height - bldB height)
        jumpLeftFuelNeeded = 0;
        jumpRightFuelNeeded = 0;
        if (buildings[playerOnBuilding].getHasPoliceWeb() == true)
        {
            jumpLeftFuelNeeded += 5;
            jumpRightFuelNeeded += 5;
        }

        // calculate parameters for jumping LEFT & set values. 
        // check battery has enough fuel left for jump. 
        try 
        {
            leftTargetBuildingNumber = playerOnBuilding - buildings[playerOnBuilding].getHeight();
            leftTargetBuildingHeight = buildings[leftTargetBuildingNumber].getHeight();
            jumpLeftHeightDiff = Math.abs(leftTargetBuildingHeight - currentHeight);
            jumpLeftFuelNeeded += jumpLeftHeightDiff;
            jumpCalcs.setJumpLeftFuelNeeded(jumpLeftFuelNeeded);
            jumpCalcs.setJumpLeftTargetBuilding(leftTargetBuildingNumber);
            jumpCalcs.setJumpLeftBuildingHeight(leftTargetBuildingHeight);
            jumpCalcs.setJumpLeftHeightDiff(jumpLeftHeightDiff);
            jumpCalcs.setJumpLeftDistance(currentHeight);
            // if (jumpLeftFuelNeeded <= jumpPack.getBatteryLevel())
            // {
            //     jumpCalcs.setJumpLeftFuelNeeded(jumpLeftFuelNeeded);
            //     jumpCalcs.setJumpLeftTargetBuilding(leftTargetBuildingNumber);
            //     jumpCalcs.setJumpLeftBuildingHeight(leftTargetBuildingHeight);
            //     jumpCalcs.setJumpLeftHeightDiff(jumpLeftHeightDiff);
            //     jumpCalcs.setJumpLeftDistance(currentHeight);
            // }
            if (jumpLeftFuelNeeded > jumpPack.getBatteryLevel())
            {
                jumpCalcs.setCanJumpLeft(false);
                // jumpCalcs.setJumpLeftFuelNeeded(0);
                // jumpCalcs.setJumpLeftTargetBuilding(0);
                // jumpCalcs.setJumpLeftBuildingHeight(0);
                // jumpCalcs.setJumpLeftHeightDiff(0);
                // jumpCalcs.setJumpLeftDistance(0);
            }
        } 
        catch (Exception e) 
        {
            Log.addToErrorLog("Turn " + gameTurn + " - JumpCalcs Left Target Building - Array Probably Out of Bounds: " + e.getMessage());
            jumpCalcs.setCanJumpLeft(false);
            jumpCalcs.setJumpLeftFuelNeeded(0);
            jumpCalcs.setJumpLeftTargetBuilding(0);
            jumpCalcs.setJumpLeftBuildingHeight(0);
            jumpCalcs.setJumpLeftHeightDiff(0);
            jumpCalcs.setJumpLeftDistance(0);
        }

        // calculate parameters for jumping RIGHT
        // check battery has enough fuel left for jump. 
        try 
        {
            rightTargetBuildingNumber = playerOnBuilding + buildings[playerOnBuilding].getHeight();
            rightTargetBuildingHeight = buildings[rightTargetBuildingNumber].getHeight();
            jumpRightHeightDiff = Math.abs(rightTargetBuildingHeight - currentHeight);
            jumpRightFuelNeeded += jumpRightHeightDiff;
            jumpCalcs.setJumpRightFuelNeeded(jumpRightFuelNeeded);
            jumpCalcs.setJumpRightTargetBuilding(rightTargetBuildingNumber);
            jumpCalcs.setJumpRightBuildingHeight(rightTargetBuildingHeight);
            jumpCalcs.setJumpRightHeightDiff(jumpRightHeightDiff);
            jumpCalcs.setJumpRightDistance(currentHeight);
            // if (jumpRightFuelNeeded <= jumpPack.getBatteryLevel())
            // {
            //     jumpCalcs.setJumpRightFuelNeeded(jumpRightFuelNeeded);
            //     jumpCalcs.setJumpRightTargetBuilding(rightTargetBuildingNumber);
            //     jumpCalcs.setJumpRightBuildingHeight(rightTargetBuildingHeight);
            //     jumpCalcs.setJumpRightHeightDiff(jumpRightHeightDiff);
            //     jumpCalcs.setJumpRightDistance(currentHeight);
            // }
            if (jumpRightFuelNeeded > jumpPack.getBatteryLevel())
            {
                jumpCalcs.setCanJumpRight(false);
                // jumpCalcs.setJumpRightFuelNeeded(0);
                // jumpCalcs.setJumpRightTargetBuilding(0);
                // jumpCalcs.setJumpRightBuildingHeight(0);
                // jumpCalcs.setJumpRightHeightDiff(0);
                // jumpCalcs.setJumpRightDistance(0);            
            }

        } 
        catch (Exception e) 
        {
            Log.addToErrorLog("Turn " + gameTurn + " - JumpCalcs Right Target Building - Array Probably Out of Bounds: " + e.getMessage());
            jumpCalcs.setCanJumpRight(false);
            jumpCalcs.setJumpRightFuelNeeded(0);
            jumpCalcs.setJumpRightTargetBuilding(0);
            jumpCalcs.setJumpRightBuildingHeight(0);
            jumpCalcs.setJumpRightHeightDiff(0);
            jumpCalcs.setJumpRightDistance(0);
        }

        
        // player can't move if on frozen building
        if (buildings[playerOnBuilding].getHasFrozen() == true)
        {
            // this.canJumpAtAll = false;
            jumpCalcs.setCanJumpAtAll(false);
        }
        else if (buildings[playerOnBuilding].getHasFrozen() != true)
        {
            // this.canJumpAtAll = true;
            jumpCalcs.setCanJumpAtAll(true);
        }

        // log at end 
        Log.addToFullLog("Game Engine doJumpCalcs(): \n" + jumpCalcs.display());
    }

    // key method - executes jump, moves player, depletes battery, picks up fuel cell
    public void executeJump(String userMove)
    {
        // jump left 
        if ((userMove.equals("left")) && (buildings[playerOnBuilding].getHasFrozen() == false) && (jumpCalcs.getCanJumpAtAll() == true) && (jumpCalcs.getCanJumpLeft() == true))
        {
            playerOnBuilding = jumpCalcs.getJumpLeftTargetBuilding();
            jumpPack.depleteBattery(jumpCalcs.getJumpLeftFuelNeeded());
            if (buildings[jumpCalcs.getJumpLeftTargetBuilding()].getHasFuelCell() == true)
            {
                jumpPack.chargeBattery(5);
                buildings[jumpCalcs.getJumpLeftTargetBuilding()].setHasFuelCell(false);
                player.setFuelCellsFound((player.getFuelCellsFound() + 1));
            }
        Log.addToFullLog("executeJump(left): " + displayGameStats());
        }

        // jump right 
        else if ((userMove.equals("right")) && (buildings[playerOnBuilding].getHasFrozen() == false) && (jumpCalcs.getCanJumpAtAll() == true) && (jumpCalcs.getCanJumpRight() == true))
        {
            playerOnBuilding = jumpCalcs.getJumpRightTargetBuilding();
            jumpPack.depleteBattery(jumpCalcs.getJumpRightFuelNeeded());
            if (buildings[jumpCalcs.getJumpRightTargetBuilding()].getHasFuelCell() == true)
            {
                jumpPack.chargeBattery(5);
                buildings[jumpCalcs.getJumpRightTargetBuilding()].setHasFuelCell(false);
                player.setFuelCellsFound((player.getFuelCellsFound() + 1));
            }
            Log.addToFullLog("executeJump(right): " + displayGameStats());
        }

        // skip turn - calls secondary method 
        else if (userMove.equals("skip"))
        {
            skipTurn();
            Log.addToFullLog("executeJump(skip): " + displayGameStats());
        }
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

    // retrieve jumpCalcs object 
    public JumpCalcs getJumpCalcs()
    {
        return this.jumpCalcs;
    }

    // retrieve jumpPack object 
    public JumpPack getJumpPack()
    {
        return this.jumpPack;
    }

    // retrieve player object 
    public Player getPlayer()
    {
        return this.player;
    }

    // retreive game turn integer 
    public int getGameTurn()
    {
        return this.gameTurn;
    }

    // retreive which building the player is on 
    public int getPlayerOnBuilding()
    {
        return this.playerOnBuilding;
    }

    // method to move the Frozen condition to a random building, get input paramater from RandomCalcs.selectRandomBuilding
    public void moveFrozenBuilding(int targetBuilding)
    {
        for (int i = 1; i < this.buildings.length; i++)
        {
            this.buildings[i].setHasFrozen(false);
        }
        this.buildings[targetBuilding].setHasFrozen(true);
        Log.addToFullLog(getClass() + ": Frozen Building moved to " + this.buildings[targetBuilding].display());
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
        Log.addToFullLog(getClass() + ": Police web moved to " + this.buildings[targetBuilding].display());
    }

    // method to respawn fuel cells every 3rd turn and place on new building 
    public void respawnFuelCells()
    {
        if (this.gameTurn % 3 == 0)
        {
            int targetBuilding2 = 0;
            int targetBuilding3 = 0;
            int targetBuilding1 = RandomCalcs.selectRandomBuilding(); // set random value to building 1
            do
            {
                targetBuilding2 = RandomCalcs.selectRandomBuilding(); // set random value to building 2
                targetBuilding3 = RandomCalcs.selectRandomBuilding(); // set random value to building 3, and loop until unique
            } while ((targetBuilding1 == targetBuilding2) || (targetBuilding1 == targetBuilding3) || (targetBuilding2 == targetBuilding3));
            for (int i = 1; i < this.buildings.length; i++)
            {
                this.buildings[i].setHasFuelCell(false);
            }
            this.buildings[targetBuilding1].setHasFuelCell(true);
            this.buildings[targetBuilding2].setHasFuelCell(true);
            this.buildings[targetBuilding3].setHasFuelCell(true);
            Log.addToFullLog(getClass() + "respawnFuelCells(): Fuel Cells added to buildings " + targetBuilding1 + " " + targetBuilding2 + " " + targetBuilding3);
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

    // sets jumpcalcs object 
    public void setJumpCalcs(JumpCalcs jumpCalcs)
    {
        this.jumpCalcs = jumpCalcs;
    }

    // sets jumpPack ojbect 
    public void setJumpPack(JumpPack jumpPack)
    {
        this.jumpPack = jumpPack;
    }

    // sets player object 
    public void setPlayer(Player player)
    {
        this.player = player;
    }

    // sets game turn integer 
    public void setGameTurn(int gameTurn)
    {
        this.gameTurn = gameTurn;
    }

    // sets which building the player is on 
    public void setPlayerOnBuilding(int playerOnBuilding)
    {
        this.playerOnBuilding = playerOnBuilding;
    }

    // skips a turn 
    public void skipTurn()
    {
        jumpPack.depleteBattery(1);
        Log.addToFullLog("skipTurn(): " + displayGameStats());
    }

    public String userFeedbackMessage()
    {
        String returnString = "";
        int bldWithPoliceWeb = 0;
        int bldWithFrozenCondition = 0;
        for (int i = 1; i < buildings.length; i++)
        {
            if (buildings[i].getHasPoliceWeb() == true) {bldWithPoliceWeb = i;}
        }
        if (bldWithPoliceWeb == playerOnBuilding)
        {
            returnString += "You hit the police web! Extra fuel is required to jump. ";
        }
        for (int i = 1; i < buildings.length; i++)
        {
            if (buildings[i].getHasFrozen() == true) {bldWithFrozenCondition = i;}
        }
        if (bldWithFrozenCondition == playerOnBuilding)
        {
            returnString += "You hit the frozen building! You must skip a turn. ";
        }
        if (jumpCalcs.getJumpLeftFuelNeeded() > jumpPack.getBatteryLevel())
        {
            returnString += "You don't have enough fuel to jump Left. ";
        }
        if (jumpCalcs.getJumpRightFuelNeeded() > jumpPack.getBatteryLevel())
        {
            returnString += "You don't have enough fuel to jump right. ";
        }
        return returnString;
    }
}

