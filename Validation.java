// Static class to perform input validations
//  
// Author: David Sharp
// Version: 1.1
public class Validation 
{
    // check if String is blank 
    public static boolean isStringBlank(String stringToValidate)
    {
        // boolean validation should return True for a bad input 
        boolean validation = true;
        if (((stringToValidate.length()) == 0) || (stringToValidate == ""))
        {
            return (validation = true); // failed validation 
        }
        else 
        {
            return (validation = false); // validation passed 
        }
    }

    // check if Character is blank space 
    public static boolean isCharBlank(char charToValidate)
        {
        // boolean validation should return True for a bad input 
        boolean validation = true;
        if ((charToValidate == ' ') || (charToValidate == '\0'))
        {
            return (validation = true); // failed validation 
        }
        else 
        {
            return (validation = false); // validation passed 
        }
    }

    // check if player name length is between two values 
    public static boolean isNameLengthOK(String inputString, int minLength, int maxLength)
    {
        // lengthWithinRange should return false for a bad input 
        boolean validation = false;
        if ((inputString.length() >= minLength) && (inputString.length() <= maxLength))
            return (validation = true); // good input 
        else
            return (validation = false); // bad input 
    }

    // check if number is not 0 
    public static boolean isIntNotZero (int integerToValidate)
    {
        boolean validation = false;
        if (integerToValidate != 0)
            return (validation = true); // good input 
        else
            return (validation = false); // bad input 
    }

    // check if number is not 0 
    public static boolean isDoubleNotZero (double doubleToValidate)
    {
        boolean validation = false;
        if (doubleToValidate != 0)
            return (validation = true); // good input 
        else
            return (validation = false); // bad input 
    }
}
