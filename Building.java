// Class to define a single building. NOT the collective array.
// Author: David Sharp
// Version: 1

public class Building
{
    private int number;
    private int height;
    private boolean hasExitPortal;
    private boolean hasFuelCell;
    private boolean hasPoliceWeb;
    private boolean hasFrozen;
    public final int MIN_HEIGHT = 1;
    public final int MAX_HEIGHT = 5;

    // default constructor, can be used for building 0
    public Building()
    {
        this.number = -1;
        this.height = -1;
        this.hasExitPortal = false;
        this.hasFuelCell = false;
        this.hasPoliceWeb = false;
        this.hasFrozen = false;
    }

    // non-default constructor, for buildings 1-15
    public Building(int number, int height, boolean hasExitPortal, boolean hasFuelCell, boolean hasPoliceWeb, boolean hasFrozen)
    {
        this.number = number;
        this.height = height;
        this.hasExitPortal = hasExitPortal;
        this.hasFuelCell = hasFuelCell;
        this.hasPoliceWeb = hasPoliceWeb;
        this.hasFrozen = hasFrozen;
    }

    // display method 
    public String display()
    {
        return ("Building #: " + this.number + ";  Height: " + this.height + ";  HasExitPortal:" + this.hasExitPortal + ";  HasFuelCell:" + this.hasFuelCell + ";  HasPoliceWeb:" + this.hasPoliceWeb + ";  HasFrozen:" + this.hasFrozen);
    }

    // Accessor for Building number
    public int getNumber()
    {
        return this.number;
    }

    // Accessor for Building Height 
    public int getHeight()
    {
        return this.height;
    }

    // Accessor for Does Building Have Exit Portal 
    public boolean getHasExitPortal()
    {
        return this.hasExitPortal;
    }

    // Accessor for Does Building Have Fuel Cell 
    public boolean getHasFuelCell()
    {
        return this.hasFuelCell;
    }

    // Accessor for Does Building Have a Police Web 
    public boolean getHasPoliceWeb()
    {
        return this.hasPoliceWeb;
    }

    // Accessor for Is Building Frozen 
    public boolean getHasFrozen()
    {
        return this.hasFrozen;
    }

    // Mutator for Building Number 
    public void setNumber(int number)
    {
        this.number = number;
    }

    // Mutator for Building Height 
    public void setHeight(int height)
    {
        this.height = height;
    }

    // Mutator for Does Building have Exit Portal 
    public void setHasExitPortal(boolean hasExitPortal)
    {
        this.hasExitPortal = hasExitPortal;
    }

    // Mutator for Does Building have a Fuel Cell on it 
    public void setHasFuelCell(boolean hasFuelCell)
    {
        this.hasFuelCell = hasFuelCell;
    }

    // Mutator for Does Building have a Police Web 
    public void setHasPoliceWeb(boolean hasPoliceWeb)
    {
        this.hasPoliceWeb = hasPoliceWeb;
    }

    // Mutator for Has Building been Frozen 
    public void setHasFrozen(boolean hasFrozen)
    {
        this.hasFrozen = hasFrozen;
    }
}