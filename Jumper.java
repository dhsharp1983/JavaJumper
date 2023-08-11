// Main Program and attributes for Jumper 
// Author: David Sharp
// Version: 1.1 

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
        // initialise - create objects 
        Log.initErrorLog();
        Log.initFullLog();
        Jumper jumper = new Jumper();
        RenderDisplay renderDisplay = new RenderDisplay(jumper);
        jumper.gameEngine.createBuildingArray();
        GameEngine gameEngine = jumper.getGameEngine();
        Player player = gameEngine.getPlayer();
        JumpCalcs jumpCalcs = gameEngine.getJumpCalcs();
        String userMove = "";


        
        // start the game 
        renderDisplay.printWelcomeScreen();
        player.inputPlayerName();
        jumper.startGame();

        // set initial variables
        gameEngine.setPlayerOnBuilding(1);
        gameEngine.setGameTurn(1);

        for (int i = 0; i < 10; i++)
        {
            // log start
            Log.addToFullLog(Log.breakLine);
            Log.addToFullLog("COMMENCE TURN " + gameEngine.getGameTurn());
            
            // perform jump calculations 
            gameEngine.doJumpCalculations();
            Log.addToFullLog(gameEngine.displayGameStats());
            Log.addToFullLog(gameEngine.displayBuildings());
            Log.addToFullLog(gameEngine.getJumpCalcs().display());

            // display Frame
            

            // get user input
            boolean canJumpAtAll = jumpCalcs.getCanJumpAtAll();
            boolean canJumpLeft = jumpCalcs.getCanJumpLeft();
            boolean canJumpRight = jumpCalcs.getCanJumpRight();
            if ((canJumpAtAll == true) && (canJumpLeft == true) && (canJumpRight == true))
                userMove = Input.acceptLSRTurnInput();
            if ((canJumpAtAll == true) && (canJumpLeft == true) && (canJumpRight == false))
                userMove = Input.acceptLSTurnInput();
            if ((canJumpAtAll == true) && (canJumpLeft == false) && (canJumpRight == true))
                userMove = Input.acceptSRTurnInput();
            if ((canJumpAtAll == false) || ((canJumpLeft == false) && (canJumpRight == false)))
                userMove = Input.acceptSkipTurnInput();
            

            // execute jump 
            gameEngine.executeJump(userMove);

            // post jump changes 
            gameEngine.randomiseBuildingHeights();
            gameEngine.moveFrozenBuilding(RandomCalcs.selectRandomBuilding());
            gameEngine.moveWebTrap(RandomCalcs.selectRandomBuilding());
            gameEngine.respawnFuelCells();
            gameEngine.setGameTurn(gameEngine.getGameTurn() + 1);
            System.out.println(gameEngine.displayGameStats());
            if (gameEngine.getJumpPack().getBatteryLevel() < 1)
            {
                //loseGame()
                renderDisplay.displayInputText("You lose");
                System.exit(0);
            }
        }
        
    
    // end of Main     
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
