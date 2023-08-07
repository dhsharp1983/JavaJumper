// Class to create the Jump Pack object and hold its properties 
// Author: David Sharp
// Version: 1.0

public class JumpPack
{
    private int batteryLevel;
    public final int MAX_BATTERY_LEVEL = 20;

    // default constructor, is OK to use in production 
    public JumpPack()
    {
        batteryLevel = 10;
    }

    // non-default constructor, unlikely to be needed 
    public JumpPack(int batteryLevel)
    {
        this.batteryLevel = batteryLevel;
    }

    // charge battery if fuel cell found. If fuel cell found, battery cannot exceed max.
    public void chargeBattery(int batteryPoints)
    {
        int oldBatteryLevel = this.batteryLevel;
        this.batteryLevel += batteryPoints;
        if (this.batteryLevel > 20)
        {
            this.batteryLevel = MAX_BATTERY_LEVEL;
        }
        Log.addToFullLog("Battery Charged from " + oldBatteryLevel + " to " + this.batteryLevel);
    }

    // deplete battery during play. If battery runs out, cannot go under 0.
    public void depleteBattery(int batteryPoints)
    {
        int oldBatteryLevel = this.batteryLevel;
        this.batteryLevel -= batteryPoints;
        if (this.batteryLevel < 0)
        {
            this.batteryLevel = 0;
        }
        Log.addToFullLog(getClass() + ": Battery depleted from " + oldBatteryLevel + " to " + this.batteryLevel);
    }

    // display method 
    public String display()
    {
        return ("Jump Pack Battery Level: " + this.batteryLevel);
    }

    // Accessor method for Battery Level 
    public int getBatteryLevel()
    {
        return this.batteryLevel;
    }

    // Accessor method for Max Battery, adding for consistency 
    public int getMaxBatteryLevel()
    {
        return this.MAX_BATTERY_LEVEL;
    }

    // Mutator method for Battery Level 
    public void setBatteryLevel(int batteryLevel)
    {
        this.batteryLevel = batteryLevel;
    }
}