import java.lang.Math;

public class JumpCalcs {
    private boolean canJumpLeft;
    private boolean canJumpRight;
    private boolean canJumpAtAll;
    private int jumpDistance;
    private int jumpFuelNeeded;


    public JumpCalcs()
    {
        this.canJumpLeft = false;
        this.canJumpRight = false;
        this.canJumpAtAll = false;
        this.jumpDistance = 0;
        this.jumpFuelNeeded = 0;
    }

    public JumpCalcs(boolean canJumpLeft, boolean canJumpRight, boolean canJumpAtAll, int jumpDistance, int jumpFuelNeeded)
    {
        this.canJumpLeft = canJumpLeft;
        this.canJumpRight = canJumpRight;
        this.canJumpAtAll = canJumpAtAll;
        this.jumpDistance = jumpDistance;
        this.jumpFuelNeeded = jumpFuelNeeded;
    }

    public void doJumpCalculations(boolean onFrozenBuilding, boolean onPoliceWeb, int currentHeight, int currentBuilding)
    {
        // can only jump left to building 1 and not past it 
        if ((currentBuilding - currentHeight) < 1)
            this.canJumpLeft = false;
        else if ((currentBuilding - currentHeight) >= 1)
            this.canJumpLeft = true;

        // can only jump right to building 15 and not past it
        if ((currentBuilding + currentHeight) > 15)
            this.canJumpRight = false;
        else if ((currentBuilding + currentHeight) <= 15)
            this.canJumpRight = true;
        
        // calculate fuel burn - absolute value of (bldA height - bldB height)
        if (onPoliceWeb = true)
        {
            jumpFuelNeeded = 5;
        }
        
        
        // 
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

    public int getJumpFuelNeeded()
    {
        return this.jumpFuelNeeded;
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

    public void setJumpFuelNeeded(int jumpFuelNeeded)
    {
        this.jumpFuelNeeded = jumpFuelNeeded;
    }




}
