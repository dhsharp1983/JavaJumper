import java.util.Scanner;

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
            Log.addToErrorLog("Error reading in Char, bad arg: " + badArg.getMessage());
            inputChar = ' ';
        }
        catch (Exception e)
        {
            Log.addToErrorLog("Error in acceptCharInput: " + e.getMessage());
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
            Log.addToErrorLog("Error reading in Double, bad arg: " + badArg.getMessage());
            inputDouble = 0;
        }
        catch (Exception e)
        {
            Log.addToErrorLog("Error accepting inputDouble in Input: " + e.getMessage());
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
            Log.addToErrorLog("Error reading in Integer, bad arg: " + badArg.getMessage());
            inputInt = 0;
        }
        catch (Exception e)
        {
            Log.addToErrorLog("Error accepting inputInt in Input: " + e.getMessage());
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
            Log.addToErrorLog("Error accepting String input: " + e.getMessage());
            inputString = "";
        }
        return inputString;
    }
}