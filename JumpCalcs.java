import java.lang.Math;

public class JumpCalcs {
    private boolean canJumpLeft;
    private boolean canJumpRight;
    private boolean canJumpAtAll;
    private int jumpDistance;
    private int jumpLeftFuelNeeded;
    private int jumpRightFuelNeeded;
    private int jumpLeftTargetBuildingNumber;
    private int jumpRightTargetBuildingNumber;


    public JumpCalcs()
    {
        this.canJumpLeft = false;
        this.canJumpRight = false;
        this.canJumpAtAll = false;
        this.jumpDistance = 0;
        this.jumpLeftFuelNeeded = 0;
        this.jumpRightFuelNeeded = 0;
    }

    // non-default constructor - player always starts at left so some assumptions can be made 
    public JumpCalcs(int jumpDistance, int jumpRightFuelNeeded)
    {
        this.canJumpLeft = false; // default ok 
        this.canJumpRight = false; // default ok 
        this.canJumpAtAll = false; // default ok 
        this.jumpDistance = jumpDistance; // needed 
        this.jumpLeftFuelNeeded = 0; // default ok 
        this.jumpRightFuelNeeded = jumpRightFuelNeeded; // needed 
    }

    public JumpCalcs(boolean canJumpLeft, boolean canJumpRight, boolean canJumpAtAll, int jumpDistance, int jumpLeftFuelNeeded, int jumpRightFuelNeeded)
    {
        this.canJumpLeft = canJumpLeft;
        this.canJumpRight = canJumpRight;
        this.canJumpAtAll = canJumpAtAll;
        this.jumpDistance = jumpDistance;
        this.jumpLeftFuelNeeded = jumpLeftFuelNeeded;
        this.jumpRightFuelNeeded = jumpRightFuelNeeded;
    }

    public String display()
    {
        String returnString = "canJumpLeft:" + this.canJumpLeft + ";  canJumpRight:" + this.canJumpRight
         + ";  canJumpAtAll:" + this.canJumpAtAll + ";  jumpDistance:" + this.jumpDistance
         + ";  jumpLeftFuelNeeded:" + this.jumpLeftFuelNeeded + ";  jumpRightFuelNeeded:" + this.jumpRightFuelNeeded;

        return returnString;
    }



    public boolean getCanJumpLeft()
    {
        return this.canJumpLeft;
    }

    public boolean getCanJumpRight()
    {
        return this.canJumpRight;
    }

    public boolean getCanJumpAtAll()
    {
        return this.canJumpAtAll;
    }

    public int getJumpDistance()
    {
        return this.jumpDistance;
    }

    public int getJumpLeftFuelNeeded()
    {
        return this.jumpLeftFuelNeeded;
    }

    public int getJumpRightFuelNeeded()
    {
        return this.jumpRightFuelNeeded;
    }

    public void setCanJumpLeft(boolean canJumpLeft)
    {
        this.canJumpLeft = canJumpLeft;
    }

    public void setCanJumpRight(boolean canJumpRight)
    {
        this.canJumpRight = canJumpRight;
    }

    public void setCanJumpAtAll(boolean canJumpAtAll)
    {
        this.canJumpAtAll = canJumpAtAll;
    }

    public void setJumpDistance(int jumpDistance)
    {
        this.jumpDistance = jumpDistance;
    }

    public void setJumpLeftFuelNeeded(int jumpLeftFuelNeeded)
    {
        this.jumpLeftFuelNeeded = jumpLeftFuelNeeded;
    }

    public void setJumpRightFuelNeeded(int jumpRightFuelNeeded)
    {
        this.jumpRightFuelNeeded = jumpRightFuelNeeded;
    }




}
