public class JumpCalcs {
    private boolean canJumpLeft;
    private boolean canJumpRight;
    private boolean canJumpAtAll;
    private int jumpDistance;
    private int jumpFuelNeeded;
    private int currentBuilding;
    private int currentHeight;
    private boolean hasPoliceWeb;
    private boolean hasFrozen;

    public JumpCalcs(boolean hasPoliceWeb, boolean hasFrozen, int currentBuilding, int currentHeight)
    {
        this.hasPoliceWeb = hasPoliceWeb;
        this.hasFrozen = hasFrozen;
        this.currentBuilding = currentBuilding;
        this.currentHeight = currentHeight;
    }

    

}
