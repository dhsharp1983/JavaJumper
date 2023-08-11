// Decommissioned - replaced by GameEngine Class 

// // Class for the Buildings collection and methods for its use in the game 
// // Author: David Sharp
// // Version: 1.0

// public class Buildings
// {
//     private Building[] buildings;

//     // default constructor - set size to 16, 1x null, 15x buildings 
//     public Buildings()
//     {
//         buildings = new Building[16];
//     }

//     // non-default constructor, directly pass in Building[]
//     public Buildings(Building[] buildings)
//     {
//         this.buildings = buildings;
//     }

//     public void createBuildingArray()
//     {
//         // create building 0
//         buildings[0] = new Building();
//         String buildingFileContents = "";
//         try 
//         {
//             buildingFileContents = FileIO.readFile("buildings.txt");
//         } 
//         catch (Exception e) 
//         {
//             Log.addToErrorLog(getClass() + ": Error reading buildings.txt");
//         }
        
//         String[] parsedFileContents = buildingFileContents.split("\n");
//         for (int i = 1; i <= 15; i++)
//         {
//             buildings[i] = new Building();
//             buildings[i].setNumber(i);
//             buildings[i].setHeight(Integer.parseInt(parsedFileContents[i - 1].split(",")[0]));
//             buildings[i].setHasExitPortal(Boolean.parseBoolean(parsedFileContents[i - 1].split(",")[1]));
//             buildings[i].setHasFuelCell(Boolean.parseBoolean(parsedFileContents[i - 1].split(",")[2]));
//             buildings[i].setHasPoliceWeb(Boolean.parseBoolean(parsedFileContents[i - 1].split(",")[3]));
//             buildings[i].setHasFrozen(Boolean.parseBoolean(parsedFileContents[i - 1].split(",")[4]));
//             // System.out.println(buildings[i].display());
//         }
//     }

//     // method to display "usable" buildings 1-15, not building 0
//     public String displayBuildings()
//     {
//         String returnString = "";
//         for (int i = 1; i < this.buildings.length; i++)
//         {
//             returnString += this.buildings[i].display() + "\n";
//             // System.out.println(this.buildings[i].display());
//         }
//         return returnString;
//     }

//     // method to display contents of entire building array, incl Building 0  
//     public String displayEntireBuildingArray()
//     {
//         String returnString = "";
//         for (int i = 0; i < this.buildings.length; i++)
//         {
//             returnString += this.buildings[i].display() + "\n";
//         }
//         return returnString;
//     }

//     // method to display a single building 
//     public String displayOneBuilding(int index)
//     {
//         return (this.buildings[index].display());
//     }

//     // method to retrieve Building[]
//     public Building[] getAllBuildings()
//     {
//         return buildings;
//     }

//     // method to access a single building in the array 
//     public Building getBuilding(int index)
//     {
//         return buildings[index];
//     }

//     // method to move the Frozen condition to a random building, get input paramater from RandomCalcs.selectRandomBuilding
//     public void moveFrozenBuilding(int targetBuilding)
//     {
//         for (int i = 1; i < this.buildings.length; i++)
//         {
//             this.buildings[i].setHasFrozen(false);
//         }
//         this.buildings[targetBuilding].setHasFrozen(true);
//         Log.addToFullLog(getClass() + ": Frozen Building moved to " + this.buildings[targetBuilding]);
//     }

//     // method to move the web trap to a random building, get input paramater from RandomCalcs.selectRandomBuilding
//     public void moveWebTrap(int targetBuilding)
//     {
//         boolean continueLoop = true;
//         for (int i = 1; i < this.buildings.length; i++)
//         {
//             this.buildings[i].setHasPoliceWeb(false);
//         }
//         this.buildings[targetBuilding].setHasPoliceWeb(true);
//         // do
//         // {
//         //     if (this.buildings[targetBuilding].getHasFrozen() == false)
//         //     {
//         //         this.buildings[targetBuilding].setHasPoliceWeb(true);
//         //         continueLoop = false;
//         //     }

//         // } while (continueLoop = true);
//         Log.addToFullLog(getClass() + ": Police web moved to " + this.buildings[targetBuilding]);
//     }

//     // method to respawn fuel cells on every third turn. 
//     // loops through array to reset FuelCell flag to false
//     // then, picks 3x random unique buildings, sets the flag on those buildings to true.
//     public void respawnFuelCells(int turn)
//     {
//         if (turn % 3 == 0)
//         {
//             int targetBuilding2 = 0;
//             int targetBuilding3 = 0;
//             int targetBuilding1 = RandomCalcs.selectRandomBuilding();
//             do
//             {
//                 targetBuilding2 = RandomCalcs.selectRandomBuilding();
//                 targetBuilding3 = RandomCalcs.selectRandomBuilding();
//                 System.out.println(targetBuilding1 + " " + targetBuilding2 + " " + targetBuilding3);
//             } while ((targetBuilding1 == targetBuilding2) || (targetBuilding1 == targetBuilding3) || (targetBuilding2 == targetBuilding3));
//             for (int i = 1; i < this.buildings.length; i++)
//             {
//                 this.buildings[i].setHasFuelCell(false);
//             }
//             this.buildings[targetBuilding1].setHasFuelCell(true);
//             this.buildings[targetBuilding2].setHasFuelCell(true);
//             this.buildings[targetBuilding3].setHasFuelCell(true);
//             Log.addToFullLog(getClass() + ": Fuel Cells added to buildings " + targetBuilding1 + " " + targetBuilding2 + " " + targetBuilding3);
//         }
//     }

//     // method to change the building heights following a turn 
//     public void randomiseBuildingHeights()
//     {
//         for (int i = 1; i < this.buildings.length; i++)
//         {
//             this.buildings[i].setHeight(RandomCalcs.getRandomBuildingHeight());
//         }
//     }

//     // method to set Building[]
//     public void setAllBuildings(Building[] buildings)
//     {
//         this.buildings = buildings;
//     }

//     // method to set a single building
//     public void setBuilding(Building building, int index)
//     {
//         this.buildings[index] = building;
//     }
// }