// Class for the Buildings collection and methods for its use in the game 
// Author: David Sharp
// Version: 1.0

public class Buildings
{
    private Building[] buildings;

    // default constructor - set size to 16, 1x null, 15x buildings 
    public Buildings()
    {
        buildings = new Building[16];
    }

    // non-default constructor, directly pass in Building[]
    public Buildings(Building[] buildings)
    {
        this.buildings = buildings;
    }

    public void createBuildingArray()
    {
        // create building 0
        buildings[0] = new Building();
        // System.out.println(buildings[0].display());
        String buildingFileContents = FileIO.readFile("buildings.txt");
        // System.out.println(buildingFileContents);
        String[] parsedFileContents = buildingFileContents.split("\n");
        for (int i = 1; i <= 15; i++)
        {
            buildings[i] = new Building();
            buildings[i].setNumber(i);
            buildings[i].setHeight(Integer.parseInt(parsedFileContents[i - 1].split(",")[0]));
            buildings[i].setHasExitPortal(Boolean.parseBoolean(parsedFileContents[i - 1].split(",")[1]));
            buildings[i].setHasFuelCell(Boolean.parseBoolean(parsedFileContents[i - 1].split(",")[2]));
            buildings[i].setHasPoliceWeb(Boolean.parseBoolean(parsedFileContents[i - 1].split(",")[3]));
            buildings[i].setHasFrozen(Boolean.parseBoolean(parsedFileContents[i - 1].split(",")[4]));
            // System.out.println(buildings[i].display());
        }
    }

    // method to display "usable" buildings 1-15, not building 0
    public String displayBuildings()
    {
        String returnString = "";
        for (int i = 1; i < this.buildings.length; i++)
        {
            returnString += this.buildings[i].display() + "\n";
        }
        return returnString;
    }

    // method to display contents of entire building array, incl Building 0  this.buildings.length
    public String displayFullBuildingArray()
    {
        String returnString = "";
        for (int i = 0; i < this.buildings.length; i++)
        {
            returnString += this.buildings[i].display() + "\n";
        }
        return returnString;
    }

    // method to display a single building 
    public String displayOneBuilding(int index)
    {
        return (this.buildings[index].display());
    }

    // method to retrieve Building[]
    public Building[] getAllBuildings()
    {
        return buildings;
    }

    // method to access a single building in the array 
    public Building getBuilding(int index)
    {
        return buildings[index];
    }

    // method to set Building[]
    public void setAllBuildings(Building[] buildings)
    {
        this.buildings = buildings;
    }

    // method to set a single building
    public void setBuilding(Building building, int index)
    {
        this.buildings[index] = building;
    }
}