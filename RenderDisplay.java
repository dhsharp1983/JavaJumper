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
    private final String[] BUILDING_CHARS = new String[]{"   ","---","===","fff","www"};
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

    public void renderTextDisplay()
    {
        System.out.println("=====================");
        System.out.println("Turn #:");

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
