// Class to build graphics and print text
// Inspriation for clearScreen method: https://www.javatpoint.com/how-to-clear-screen-in-java
// Author: David Sharp
// Version: 1.1 

public class RenderDisplay 
{
    private Jumper jumper;
    private GameEngine gameEngine;
    private String welcomeScreen;
    private String instructionScreen;
    private String endScreen;
    private BuildingGraphic[] buildingGraphics;
    private String[] buildingLines;
    private String[] topDisplayLines;
    private final String[] PLAYER_CHARS = new String[]{"~o/","/| ","/ \\"};
    private final String[] EXITPORTAL_CHARS = new String[]{"@@@","@ @","@@@"};
    private final String[] BUILDING_CHARS = new String[]{"   ","---","===","***","#%#","~~~"};
    private final String[] FUEL_CHARS = new String[]{" % "};

    // primary client class has a limited default constructor only. 
    // Actively uses data in jumper object. Must be passed in.
    public RenderDisplay(Jumper jumper)
    {
        this.jumper = jumper;
        this.gameEngine = jumper.getGameEngine();
        welcomeScreen = "";
        instructionScreen = "";
        endScreen = "";
    }

    // clears the screen for frame display 
    public void clearScreen()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    // displays a rendered frame. 
    // Requires renderBuildingGraphs, renderBuldingLines and renderTopDiplsayLines to run first. 
    public void displayFrame()
    {
        for (String line : topDisplayLines) 
        {
            System.out.println(line);
        }
        for (int i = (buildingLines.length - 1); i > 0; i--)
        {
            System.out.println(buildingLines[i-1]);
        }
    }

    // renders the graphics for the buildings.
    // each element in the buildingGraphics array represents a single building (column).
    public void renderBuildingGraphics()
    {
        buildingGraphics = new BuildingGraphic[16];
        boolean isPlayerOnBuilding = false;

        // set null building 0 - building 0 not used in practice 
        buildingGraphics[0] = new BuildingGraphic();

        // loop through buildings and generate their sizes and contents 
        for (int i = 1; i < buildingGraphics.length; i++)
        {
            buildingGraphics[i] = new BuildingGraphic(i);
            int bldHeight = gameEngine.getBuilding(i).getHeight();
            if(gameEngine.getPlayerOnBuilding() == i) {isPlayerOnBuilding = true;}
            else {isPlayerOnBuilding = false;}
            int colHeight = (bldHeight* 2);
            int colStoreys = colHeight - 1;
            int colRoof = colHeight;
            for (int j = 0; j < 14; j++)
            {
                if (j == 0) {buildingGraphics[i].setSingleBuildingColumnLine(BUILDING_CHARS[5], j);} // sets ground ~~~
                else if ((j <= colStoreys) && (gameEngine.getBuilding(i).getHasFrozen() == true)) {buildingGraphics[i].setSingleBuildingColumnLine(BUILDING_CHARS[3], j);} // sets building frozen chars ***
                else if (j <= colStoreys) {buildingGraphics[i].setSingleBuildingColumnLine(BUILDING_CHARS[1], j);} // sets storey chars ---
                else if ((j == colRoof) && (gameEngine.getBuilding(i).getHasPoliceWeb() == true)) {buildingGraphics[i].setSingleBuildingColumnLine(BUILDING_CHARS[4], j);} // sets police web #%#
                else if (j == colRoof) {buildingGraphics[i].setSingleBuildingColumnLine(BUILDING_CHARS[2], j);} // sets roof char ===
                else if ((j == (colRoof + 1)) && (isPlayerOnBuilding == true)) {buildingGraphics[i].setSingleBuildingColumnLine(PLAYER_CHARS[2], j);} // add bottom row player char
                else if ((j == (colRoof + 2)) && (isPlayerOnBuilding == true)) {buildingGraphics[i].setSingleBuildingColumnLine(PLAYER_CHARS[1], j);} // add middle row player char 
                else if ((j == (colRoof + 3)) && (isPlayerOnBuilding == true)) {buildingGraphics[i].setSingleBuildingColumnLine(PLAYER_CHARS[0], j);} // add top row player char 
                else if ((j == (colRoof + 1)) && (gameEngine.getBuilding(i).getHasExitPortal() == true)) {buildingGraphics[i].setSingleBuildingColumnLine(EXITPORTAL_CHARS[0], j);} // add bottom exit portal char
                else if ((j == (colRoof + 2)) && (gameEngine.getBuilding(i).getHasExitPortal() == true)) {buildingGraphics[i].setSingleBuildingColumnLine(EXITPORTAL_CHARS[1], j);} // add middle exit portal char
                else if ((j == (colRoof + 3)) && (gameEngine.getBuilding(i).getHasExitPortal() == true)) {buildingGraphics[i].setSingleBuildingColumnLine(EXITPORTAL_CHARS[2], j);} // add top exit portal char
                else if ((j == (colRoof + 1)) && (gameEngine.getBuilding(i).getHasFuelCell() == true)) {buildingGraphics[i].setSingleBuildingColumnLine(" @ ", j);} // add fuel cell @
                else if (j > colRoof) {buildingGraphics[i].setSingleBuildingColumnLine(BUILDING_CHARS[0], j);} // sets space chars 
            }
        }
    }
    
    // Converts building columns into horizontal lines for display. 
    public void renderBuildingLines()
    {
        buildingLines = new String[15];
        // set ground layer 
        buildingLines[0] = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        // set remaining lines 
        for (int line = 1; line < 14; line++)
        {
            String content = "  ";
            for (int col = 1; col <= 15; col++)
            {
                content = content + buildingGraphics[col].getSingleBuildingColumnLine(line) + "  ";
            }
            buildingLines[line] = content;
        }
    }

    // creates the top section of the frame for printing messages and instructions 
    public void renderTopDisplayLines(String messageInput)
    {
        this.topDisplayLines = new String[6];
        topDisplayLines[0] = "                                 JAVA JUMPER!                                  ";
        topDisplayLines[1] = "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -";
        // topDisplayLines[2] = "                                                                               ";
        topDisplayLines[2] = "         Turn: " + jumper.getGameEngine().getGameTurn() + "                                                               ";
        topDisplayLines[3] = "    Fuel Left: " + jumper.getGameEngine().getJumpPack().getBatteryLevel() + "                                                                ";
        // topDisplayLines[5] = "                                                                               ";
        topDisplayLines[4] = " " + messageInput;
        // topDisplayLines[7] = "                                                                               ";
        topDisplayLines[5] = "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -";
    }

    // prints out input text to screen 
    public void displayInputText(String inputText)
    {
        System.out.println(inputText);
    }

    // prints welcome screen 
    public void printWelcomeScreen()
    {
        System.out.println("WELCOME TO JAVA JUMPER");
    }
}
