// Main Program and attributes for Jumper 
// Author: David Sharp
// Version: 1.1 

// credits:
// for measuring time: 
// https://stackoverflow.com/questions/6317750/how-to-measure-the-a-time-span-in-seconds-using-system-currenttimemillis


import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


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
        // initialise - create objects 
        Log.initErrorLog();
        Log.initFullLog();
        Jumper jumper = new Jumper();
        RenderDisplay renderDisplay = new RenderDisplay(jumper);
        jumper.gameEngine.createBuildingArray();
        GameEngine gameEngine = jumper.getGameEngine();
        Player player = gameEngine.getPlayer();

        
        // start the game 
        renderDisplay.printWelcomeScreen();
        player.inputPlayerName();
        jumper.startGame();

        // set initial variables
        gameEngine.setPlayerOnBuilding(3);
        gameEngine.setGameTurn(1);

        // perform jump calculations 
        gameEngine.doJumpCalculations();
        //debug
        System.out.println(gameEngine.getJumpCalcs().display());

        System.out.println("Select a move: press left arrow for left; right arrow for right; enter to skip");
        
        
        
        




        
    // end of Main     
    } 

    public void keyPressed(KeyEvent e)
    {
        System.out.println("keypress: " + e.getKeyCode() + " " + e.getKeyChar());
    }

    public void startGame()
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
