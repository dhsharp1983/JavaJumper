public class BuildingGraphic 
{
    private String[] buildingColumn;

    // default constructor 
    public BuildingGraphic()
    {
        this.buildingColumn = new String[]{"abc"};
    }
    
    // non-default constructor 
    public BuildingGraphic(int buildingNumber)
    {
        this.buildingColumn = new String[14]; // 14 lines of 3 chars each 
    }

    // get building column array 
    public String[] getBuildingColumn()
    {
        return this.buildingColumn;
    }

    // get a single diplay line for a single building column 
    public String getSingleBuildingColumnLine(int line)
    {
        return this.buildingColumn[line];
    }

    // set values for a building column 
    public void setBuildingColumn(String[] buildingColumn)
    {
        this.buildingColumn = buildingColumn;
    }

    // set a single display line for a single building column 
    public void setSingleBuildingColumnLine(String singleBuildingColumnLine, int index)
    {
        this.buildingColumn[index] = singleBuildingColumnLine;
    }




}
