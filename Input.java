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
            System.out.println("Error reading in Char, bad arg: " + badArg.getMessage());
            inputChar = ' ';
            return inputChar;
        }
        catch (Exception e)
        {
            System.out.println("Error in acceptCharInput: " + e.getMessage());
            inputChar = ' ';
        }
        return inputChar;
    }

    public Double acceptDoubleInput(String displayMessage)
        throws IllegalArgumentException, Exception
    {
        Scanner console = new Scanner(System.in);
        System.out.println(displayMessage);
        try
        {
            String input = console.nextLine();
            if (input == "")
                throw new Exception("Error in acceptDoubleInput: value empty");
            double inputDouble = Double.parseDouble(input);
            return inputDouble;
        }
        catch (IllegalArgumentException badArg)
        {
            System.out.println("Error reading in Double, bad arg: " + badArg.getMessage());
        }
        catch (Exception e)
        {
            try
            {
                Log.addToErrorLog("Error in acceptDoubleInput: " + e.getMessage());
            }
            catch (Exception ex)
            {;}
        }
    }

    public String acceptStringInput(String displayMessage)
        throws IllegalArgumentException, Exception
    {
        String temp;
        return temp;
    }
}