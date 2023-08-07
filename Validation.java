// Static class to perform input validations
//  
// Author: David Sharp
// Version: 1.0
public class Validation 
{
    public boolean isStringBlank(String stringToValidate)
    {
        // boolean validation should return True for a bad input 
        boolean validation = true;
        if (((stringToValidate.length()) == 0) || (stringToValidate == ""))
        {
            return (validation = true); // failed validation 
        }
        else 
        {
            return (validation = false);
        }
    }

    public boolean isCharBlank(char charToValidate)
        {
        // boolean validation should return True for a bad input 
        boolean validation = true;
        if ((charToValidate == ' ') || (charToValidate == '\0'))
        {
            return (validation = true); // failed validation 
        }
        else 
        {
            return (validation = false);
        }
    }

    public boolean isNameLengthOK(String inputString, int minLength, int maxLength)
    {
        // lengthWithinRange should return false for a bad input 
        boolean validation = false;
        if ((inputString.length() >= minLength) && (inputString.length() <= maxLength))
            return (validation = true);
        else
            return (validation = false);
    }

    public boolean isIntGreaterThanZero (int integerToValidate)
    {
        boolean validation = false;
        if (integerToValidate > 0)
            return (validation = true);
        else
            return (validation = false);
    }

    public boolean isDoubleGreaterThanZero (double doubleToValidate)
    {
        boolean validation = false;
        if (doubleToValidate > 0)
            return (validation = true);
        else
            return (validation = false);
    }

}
