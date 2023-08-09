// Main Program and attributes for Jumper 
// Author: David Sharp
// Version: 1.0 

// credits:
// for measuring time: 
// https://stackoverflow.com/questions/6317750/how-to-measure-the-a-time-span-in-seconds-using-system-currenttimemillis

import java.util.concurrent.TimeUnit;

public class Jumper 
{
    // private int turn;
    // private int onBuilding;
    // private Player player;
    // private Buildings buildings;
    // private JumpPack jumpPack;
    private GameEngine gameEngine;

    public Jumper()
    {
        // this.turn = 1;
        // this.onBuilding = 1;
        // this.player = new Player();
        // this.buildings = new Buildings();
        // this.jumpPack = new JumpPack();
        this.gameEngine = new GameEngine();
    }

    // public Buildings getBuildings()
    // {
    //     return this.buildings;
    // }

    public GameEngine getGameEngine()
    {
        return this.gameEngine;
    }

    public static void main(String[] args)
    {
        // initialise - create objects and call startGame()
        Jumper jumper = new Jumper();
        RenderDisplay renderDisplay = new RenderDisplay(jumper);
        jumper.gameEngine.createBuildingArray();
        GameEngine gameEngine = jumper.getGameEngine();
        Player player = gameEngine.getPlayer();
        renderDisplay.printWelcomeScreen();
        player.inputPlayerName();
        jumper.startGame();
        
    // end of Main     
    } 

    public static void startGame()
    {
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
