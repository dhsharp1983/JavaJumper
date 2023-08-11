// Main Program and attributes for Jumper 
// Author: David Sharp
// Version: 1.2

// credits:
// for measuring time: 
// https://stackoverflow.com/questions/6317750/how-to-measure-the-a-time-span-in-seconds-using-system-currenttimemillis


import java.util.concurrent.TimeUnit;

public class Jumper 
{
    private GameEngine gameEngine;
    

    // default constructor only as this is a primary client class 
    public Jumper()
    {
        this.gameEngine = new GameEngine();
    }

    // no non-default constructor     

    public GameEngine getGameEngine()
    {
        return this.gameEngine;
    }

    public static void main(String[] args)
    {
        // set additional variables 
        boolean winCondition = false;
        boolean lossCondition = false;
        
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

        // loop gameplay 
        for (int i = 0; i < 9999; i++)
        {
            // log start
            Log.addToFullLog(Log.breakLine);
            Log.addToFullLog("COMMENCE TURN " + gameEngine.getGameTurn());
            
            // perform jump calculations
            gameEngine.doJumpCalculations();

            // log jump calculations 
            Log.addToFullLog(gameEngine.displayGameStats());
            Log.addToFullLog(gameEngine.displayBuildings());
            Log.addToFullLog(gameEngine.getJumpCalcs().display());

            // display Frame
            renderDisplay.renderBuildingGraphics();
            renderDisplay.renderBuildingLines();
            renderDisplay.renderTopDisplayLines("");
            renderDisplay.clearScreen();
            renderDisplay.displayFrame();

            // get user input - uses jumpCalcs parameters to validate move selection 
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
            gameEngine.setGameTurn(gameEngine.getGameTurn() + 1);
            gameEngine.randomiseBuildingHeights();
            gameEngine.moveFrozenBuilding(RandomCalcs.selectRandomBuilding());
            gameEngine.moveWebTrap(RandomCalcs.selectRandomBuilding());
            gameEngine.respawnFuelCells();
            System.out.println(gameEngine.displayGameStats());

            // evaluate if player is on building 15 for exit portal, set win condition 
            if (gameEngine.getPlayerOnBuilding() == 15)
            {
                winCondition = true;
                lossCondition = false;
                renderDisplay.displayInputText("You win!");
                System.exit(0);
            }

            // evaluate if player is out of fuel, set loss condition 
            if (gameEngine.getJumpPack().getBatteryLevel() < 1)
            {
                //loseGame()
                winCondition = false;
                lossCondition = true;
                renderDisplay.displayInputText("You lose");
                System.exit(0);
            }
        } // end gameplay loop 
    // end of Main     
    } 

    // method to start the game and print a countdown timer 
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
