import java.lang.Math;

public class JumpCalcs {
    private boolean canJumpLeft;
    private boolean canJumpRight;
    private boolean canJumpAtAll;
    private int jumpDistance;
    private int jumpLeftFuelNeeded;
    private int jumpRightFuelNeeded;


    public JumpCalcs()
    {
        this.canJumpLeft = false;
        this.canJumpRight = false;
        this.canJumpAtAll = false;
        this.jumpDistance = 0;
        this.jumpLeftFuelNeeded = 0;
        this.jumpRightFuelNeeded = 0;
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

    public void doJumpCalculations(boolean onFrozenBuilding, boolean onPoliceWeb, int currentHeight, int currentBuilding, Buildings buildings)
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

        // jump distance is building height
        this.jumpDistance = currentHeight;
        
        // calculate fuel burn - absolute value of (bldA height - bldB height)
        int bldToLeftHeight = 0;
        int bldToRightHeight = 0;
        if (onPoliceWeb == true)
        {
            jumpLeftFuelNeeded = 5;
            jumpRightFuelNeeded = 5;
        }

        try 
        {
            bldToLeftHeight = buildings.getAllBuildings()[currentBuilding - currentHeight].getHeight();
        } 
        catch (Exception e) 
        {
            Log.addToErrorLog("JumpCalcs - Array Probably Out of Bounds: " + e.getMessage());
            // canJumpLeft = false;
        }
        finally
        {
            jumpLeftFuelNeeded += bldToLeftHeight;
        }

        try 
        {
            bldToRightHeight = buildings.getAllBuildings()[currentBuilding + currentHeight].getHeight();
        } 
        catch (Exception e) 
        {
            Log.addToErrorLog("doJumpCalculations - Array Probably Out of Bounds: " + e.getMessage());
        }
        finally
        {
            jumpRightFuelNeeded += bldToRightHeight;
        }
        
        // player can't move if on frozen building
        if (onFrozenBuilding == true)
        {
            this.canJumpAtAll = false;
        }
        else if (onFrozenBuilding == false)
        {
            this.canJumpAtAll = true;
        }

        // log at end 
        Log.addToFullLog("JumpCalculations: " + this.display());
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
