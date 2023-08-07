public class RenderDisplay 
{
    private Jumper jumper;
    private String welcomeScreen;
    private String instructionScreen;
    private String endScreen;
    private final String[] PLAYER_CHARS = new String[]{"~o/","/| ","/ \\"};
    private final String[] BUILDING_CHARS = new String[]{"---","==="};

    public RenderDisplay(Jumper jumper)
    {
        this.jumper = jumper;
        welcomeScreen = "";
        instructionScreen = "";
        endScreen = "";
    }

    public void renderTextDisplay()
    {
        System.out.println("=====================");
        System.out.println("Turn #:");

    }

    public void test()
    {
        jumper.getBuildings().displayBuildings();
    }

    public void printWelcomeScreen()
    {
        System.out.println("WELCOME TO JAVA JUMPER");
    }
}
