public class BuildingGraphic {
    
    private String[] buildingColumn;
    private int buildingNumber;
    private final String[] PLAYER_CHARS = new String[]{"~o/","/| ","/ \\"};
    private final String[] BUILDING_CHARS = new String[]{"   ","---","==="};

    public BuildingGraphic()
    {
        this.buildingNumber = 0;
        this.buildingColumn = new String[]{"abc"};
    }
    
    public BuildingGraphic(int buildingNumber)
    {
        this.buildingNumber = buildingNumber;
        this.buildingColumn = new String[14]; // 14 lines of 3 chars each 
    }

    public String[] getBuildingColumn()
    {
        return this.buildingColumn;
    }

    public String getSingleBuildingColumnLine(int line)
    {
        return this.buildingColumn[line];
    }

    public void setBuildingColumn(String[] buildingColumn)
    {
        this.buildingColumn = buildingColumn;
    }

    public void setSingleBuildingColumnLine(String singleBuildingColumnLine, int index)
    {
        this.buildingColumn[index] = singleBuildingColumnLine;
    }




}
