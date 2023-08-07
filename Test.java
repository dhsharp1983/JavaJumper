
public class Test {
    public static void main(String[] args)
    {
        Player player = new Player();
        Log.initErrorLog();
        player.setFuelCellsFound(1);
        player.setPlayerName("Dave");
        System.out.println(player.display());
        Player player2 = new Player("DaVEE", 5, 55);
        System.out.println(player2.display());
        Building building1 = new Building();
        building1.setNumber(1);
        building1.setHeight(3);
        building1.setHasExitPortal(false);
        building1.setHasFrozen(true);  
        building1.setHasFuelCell(false);
        building1.setHasPoliceWeb(true);
        Building building2 = new Building(2, 4, true, true, false, false);
        System.out.println(building1.display());
        System.out.println(building2.display());
        Buildings buildings = new Buildings();
        System.out.println(buildings.getAllBuildings().length);
        buildings.setBuilding(building2, 0);
        // System.out.println(buildings.getBuilding(0).display());
        buildings.setBuilding(building1, 1);
        // for (int i = 0; i < 10; i++)
        // {
        //     buildings.setBuilding(building2, i);
        //     System.out.println("Building " + i + " set");
        // }
        System.out.println("START DUMP");
        // for (int i = 0; i < buildings.getAllBuildings().length; i++)
        // {
        //     System.out.println(buildings.getBuilding(i).display());
        // }
        // System.out.println("DUMPING DISPLAYFULLBUILDINGARRAY");
        // System.out.println(buildings.displayFullBuildingArray());
        // Building[] bld = buildings.getAllBuildings();
        // for (Building building : bld) {
        //     building.display();
        // }
        // buildings.createBuildingArray();
        // System.out.println(buildings.displayBuildings());
        try
        {
            Log.addToErrorLog("TestMessage");
            Log.addToErrorLog("blah");
        }
        catch (Exception e)
        {
            System.out.println("Could not add to error log");
        }
        Log.addToErrorLog("TestMessage no trycatch ");
    }
}
