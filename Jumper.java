// Main Program and attributes for Jumper 
// Author: David Sharp
// Version: 1.0 

// credits:
// for measuring time: 
// https://stackoverflow.com/questions/6317750/how-to-measure-the-a-time-span-in-seconds-using-system-currenttimemillis

import java.util.concurrent.TimeUnit;

public class Jumper 
{
    private int turn;
    private int onBuilding;
    private Player player;
    private Buildings buildings;
    private JumpPack jumpPack;

    public Jumper()
    {
        this.turn = 1;
        this.onBuilding = 1;
        this.player = new Player();
        this.buildings = new Buildings();
        this.jumpPack = new JumpPack();
    }

    public Buildings getBuildings()
    {
        return this.buildings;
    }

    

    public String inputPlayerName()
    {
        String playerName = "";
        try 
        {
            playerName = Input.acceptStringInput("Enter Player Name:");
        } 
        catch (Exception e) 
        {
            Log.addToErrorLog(getClass() + ": Error getting player name: " + e.getMessage());
        }
        return playerName;
        
    }

    public static void main(String[] args)
    {
        // initialise - create objects and call startGame()
        Jumper jumper = new Jumper();
        RenderDisplay renderDisplay = new RenderDisplay(jumper);
        jumper.buildings.createBuildingArray();
        startGame(jumper);
        
    } // end of Main 

    public static void startGame(Jumper jumper)
    {
        String playerName  = jumper.inputPlayerName();
        RenderDisplay startGameRenderDisplay = new RenderDisplay(jumper);
        if (Validation.isNameLengthOK(playerName, 3, 12) == true)
        {
            jumper.player.setPlayerName(playerName);
        }
        else
        {
            do
            {
                startGameRenderDisplay.printWelcomeScreen();
                System.out.println("\nPlease enter a name of 3 to 12 characters!\n");
                playerName  = jumper.inputPlayerName();
                if (Validation.isNameLengthOK(playerName, 3, 12) == true)
                    jumper.player.setPlayerName(playerName);
            } while (playerName == "");
        }
        System.out.println("Welcome " + playerName + "!");
        System.out.print("Game starting in:  ");
        for (int i = 1; i >= 0; i--) // change i to 3 for prod 
        {
            try 
            {
                TimeUnit.SECONDS.sleep(1);
            } 
            catch (Exception ignore) {};
            if (i > 0)
                System.out.print(i + "...  ");
            else
                System.out.println();
        }
    }
}
