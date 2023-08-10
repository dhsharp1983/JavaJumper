// Static class to get input and perform exception reporting 
// If input (try/catch) fails, a default value is passed. 
// Validation should be performed by the methods in Validation. 
// Author: David Sharp
// Version: 1.0

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Input
{
    
    public static char acceptCharInput(String displayMessage, int charAt)
        throws IllegalArgumentException, Exception
    {
        char inputChar;
        Scanner console = new Scanner(System.in);
        console.useDelimiter("\\z");
        System.out.println(displayMessage);
        try
        {
            inputChar = console.next().charAt(charAt);
        }
        catch (IllegalArgumentException badArg)
        {
            Log.addToErrorLog("acceptCharInput():Error reading in Char, bad arg: " + badArg.getMessage());
            inputChar = ' ';
        }
        catch (Exception e)
        {
            Log.addToErrorLog("acceptCharInput():Error in acceptCharInput: " + e.getMessage());
            inputChar = ' ';
        }
        return inputChar;
    }

    public static Double acceptDoubleInput(String displayMessage)
        throws IllegalArgumentException, Exception
    {
        double inputDouble;
        Scanner console = new Scanner(System.in);
        System.out.println(displayMessage);
        try
        {
            String input = console.nextLine();
            if (input == "")
                throw new Exception("Error in acceptDoubleInput: value empty");
            inputDouble = Double.parseDouble(input);
            return inputDouble;
        }
        catch (IllegalArgumentException badArg)
        {
            Log.addToErrorLog("acceptDoubleInput():Error reading in Double, bad arg: " + badArg.getMessage());
            inputDouble = 0;
        }
        catch (Exception e)
        {
            Log.addToErrorLog("acceptDoubleInput():Error accepting inputDouble in Input: " + e.getMessage());
            inputDouble = 0;
        }
        return inputDouble;
    }

    public static int acceptIntegerInput(String displayMessage)
        throws IllegalArgumentException, Exception
    {
        int inputInt;
        Scanner console = new Scanner(System.in);
        System.out.println(displayMessage);
        try
        {
            inputInt = Integer.parseInt(console.nextLine());
            return inputInt;
        }
        catch (IllegalArgumentException badArg)
        {
            Log.addToErrorLog("acceptIntegerInput(): Error reading in Integer, bad arg: " + badArg.getMessage());
            inputInt = 0;
        }
        catch (Exception e)
        {
            Log.addToErrorLog("acceptIntegerInput(): Error accepting inputInt in Input: " + e.getMessage());
            inputInt = 0;
        }
        return inputInt;
    }

    public static String acceptStringInput(String displayMessage)
        throws Exception
    {
        String inputString = "";
        Scanner console = new Scanner(System.in);
        System.out.println(displayMessage);
        try
        {
            inputString = console.nextLine();
            return inputString;
        }
        catch (Exception e)
        {
            Log.addToErrorLog("acceptStringInput(): Error accepting String input: " + e.getMessage());
            inputString = "";
        }
        return inputString;
    }

    public static String acceptLSRTurnInput()
    {
        String userMove = "";
        do
        {
            try
            {
                userMove = Input.acceptStringInput("Select a move: \nType LEFT or A to move LEFT; Type RIGHT or D to move RIGHT; Type SKIP or S to Skip Turn");
                if (Validation.isStringBlank(userMove) == true) {userMove = "";}
                userMove = userMove.toLowerCase();
            }
            catch (Exception e)
            {
                Log.addToErrorLog("acceptUserTurnInput() Input Error when accepting user move:" + e.getMessage());
                userMove = "";
            }
            finally
            {
                
                String[] acceptableInput = new String[]{"a","s","d","left","right","skip"};
                List acceptableInputList = Arrays.asList(acceptableInput);
                // if ((userMove.equals("a"))) //|| (userMove != "s") || (userMove != "d") || (userMove != "left") || (userMove != "skip") || (userMove != "right"))
                if (!(acceptableInputList.contains(userMove)))
                {
                    Log.addToErrorLog("acceptUserTurnInput(): userMove value not in acceptable input list: " + userMove);
                    userMove = "";
                }
                if (userMove == "a") {userMove = "left";}
                if (userMove == "s") {userMove = "skip";}
                if (userMove == "d") {userMove = "right";}
            }
        } while (userMove == "");
        // System.out.println("user selected " + userMove);
        Log.addToFullLog("acceptUserTurnInput(): user selected " + userMove);
        return userMove;
    }

    public static String acceptSRTurnInput()
    {
        String userMove = "";
        do
        {
            try
            {
                userMove = Input.acceptStringInput("Select a move: \nType Type RIGHT or D to move RIGHT; Type SKIP or S to Skip Turn");
                if (Validation.isStringBlank(userMove) == true) {userMove = "";}
                userMove = userMove.toLowerCase();
            }
            catch (Exception e)
            {
                Log.addToErrorLog("acceptUserTurnInput() Input Error when accepting user move:" + e.getMessage());
                userMove = "";
            }
            finally
            {
                
                String[] acceptableInput = new String[]{"s","d","right","skip"};
                List acceptableInputList = Arrays.asList(acceptableInput);
                // if ((userMove.equals("a"))) //|| (userMove != "s") || (userMove != "d") || (userMove != "left") || (userMove != "skip") || (userMove != "right"))
                if (!(acceptableInputList.contains(userMove)))
                {
                    Log.addToErrorLog("acceptUserTurnInput(): userMove value not in acceptable input list: " + userMove);
                    userMove = "";
                }
                if (userMove == "s") {userMove = "skip";}
                if (userMove == "d") {userMove = "right";}
            }
        } while (userMove == "");
        // System.out.println("user selected " + userMove);
        Log.addToFullLog("acceptUserTurnInput(): user selected " + userMove);
        return userMove;
    }

    public static String acceptLSTurnInput()
    {
        String userMove = "";
        do
        {
            try
            {
                userMove = Input.acceptStringInput("Select a move: \nType LEFT or A to move LEFT; Type SKIP or S to Skip Turn");
                if (Validation.isStringBlank(userMove) == true) {userMove = "";}
                userMove = userMove.toLowerCase();
            }
            catch (Exception e)
            {
                Log.addToErrorLog("acceptUserTurnInput() Input Error when accepting user move:" + e.getMessage());
                userMove = "";
            }
            finally
            {
                
                String[] acceptableInput = new String[]{"a","s","left","skip"};
                List acceptableInputList = Arrays.asList(acceptableInput);
                // if ((userMove.equals("a"))) //|| (userMove != "s") || (userMove != "d") || (userMove != "left") || (userMove != "skip") || (userMove != "right"))
                if (!(acceptableInputList.contains(userMove)))
                {
                    Log.addToErrorLog("acceptUserTurnInput(): userMove value not in acceptable input list: " + userMove);
                    userMove = "";
                }
                if (userMove == "a") {userMove = "left";}
                if (userMove == "s") {userMove = "skip";}
            }
        } while (userMove == "");
        // System.out.println("user selected " + userMove);
        Log.addToFullLog("acceptUserTurnInput(): user selected " + userMove);
        return userMove;
    }

    public static String acceptSkipTurnInput()
    {
        String userMove = "";
        do
        {
            try
            {
                userMove = Input.acceptStringInput("You can't move! Type SKIP or S to Skip Turn");
                if (Validation.isStringBlank(userMove) == true) {userMove = "";}
                userMove = userMove.toLowerCase();
            }
            catch (Exception e)
            {
                Log.addToErrorLog("acceptUserTurnInput() Input Error when accepting user move:" + e.getMessage());
                userMove = "";
            }
            finally
            {
                
                String[] acceptableInput = new String[]{"s","skip"};
                List acceptableInputList = Arrays.asList(acceptableInput);
                // if ((userMove.equals("a"))) //|| (userMove != "s") || (userMove != "d") || (userMove != "left") || (userMove != "skip") || (userMove != "right"))
                if (!(acceptableInputList.contains(userMove)))
                {
                    Log.addToErrorLog("acceptUserTurnInput(): userMove value not in acceptable input list: " + userMove);
                    userMove = "";
                }
                if (userMove == "s") {userMove = "skip";}
            }
        } while (userMove == "");
        // System.out.println("user selected " + userMove);
        Log.addToFullLog("acceptUserTurnInput(): user selected " + userMove);
        return userMove;
    }

}