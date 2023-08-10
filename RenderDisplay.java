// Class to build graphics and print text
// Inspriation for clearScreen method: https://www.javatpoint.com/how-to-clear-screen-in-java
public class RenderDisplay 
{
    private Jumper jumper;
    private GameEngine gameEngine;
    private String welcomeScreen;
    private String instructionScreen;
    private String endScreen;
    private BuildingGraphic[] buildingGraphics;
    private String[] displayLines;
    private final String[] PLAYER_CHARS = new String[]{"~o/","/| ","/ \\"};
    private final String[] BUILDING_CHARS = new String[]{"   ","---","===","fff","www","~~~"};
    private final String[] FUEL_CHARS = new String[]{" @ "};

    public RenderDisplay(Jumper jumper)
    {
        this.jumper = jumper;
        this.gameEngine = jumper.getGameEngine();
        welcomeScreen = "";
        instructionScreen = "";
        endScreen = "";
    }

    public void clearScreen()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public void renderBuildingGraphics()
    {
        buildingGraphics = new BuildingGraphic[16];

        // set null building 0
        buildingGraphics[0] = new BuildingGraphic();

        for (int i = 1; i < buildingGraphics.length; i++)
        {
            buildingGraphics[i] = new BuildingGraphic(i);
            int bldHeight = jumper.getGameEngine().getBuilding(i).getHeight();
            int colHeight = (bldHeight* 2);
            int colStoreys = colHeight - 1;
            int colRoof = colHeight;
            for (int j = 0; j < 14; j++)
            {
                if (j == 0) {buildingGraphics[i].setSingleBuildingColumnLine(BUILDING_CHARS[5], j);}
                else if (j <= colStoreys) {buildingGraphics[i].setSingleBuildingColumnLine(BUILDING_CHARS[1], j);}
                else if (j == colRoof) {buildingGraphics[i].setSingleBuildingColumnLine(BUILDING_CHARS[2], j);}
                else if (j > colRoof) {buildingGraphics[i].setSingleBuildingColumnLine(BUILDING_CHARS[0], j);}
            }
        }
    }

    public void renderDisplayLines()
    {
        displayLines = new String[15];
        for (int line = 0; line < 15; line++)
        {
            String content = "  ";
            for (int col = 1; col <= 15; col++)
            {
                content = content + buildingGraphics[col].getSingleBuildingColumnLine(line) + "  ";
            }
            displayLines[line] = content;
            // displayLines[i] = buildingGraphics[1].getSingleBuildingColumnLine(i) + buildingGraphics[2].getSingleBuildingColumnLine(i) + buildingGraphics[3].getSingleBuildingColumnLine(i) + buildingGraphics[4].getSingleBuildingColumnLine(i);
            System.out.println(displayLines[line]);
        }
    }

    public void displayInputText(String inputText)
    {
        System.out.println(inputText);
    }

    public void test()
    {
        // jumper.getBuildings().displayBuildings();
        
    }

    public void printWelcomeScreen()
    {
        System.out.println("WELCOME TO JAVA JUMPER");
    }
}
