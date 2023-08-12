// Static class to read files and write files 
// Author: David Sharp
// Version: 1.0

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIO
{
    // Static method to read a file and return contents as String
    public static String readFile(String filename) throws IOException, Exception
    {
        String fileContents = "";
        try
        {
            FileReader reader = new FileReader(filename);
            try
            {
                Scanner fileInput = new Scanner(reader);
                while (fileInput.hasNextLine())
                {
                    fileContents += fileInput.nextLine() + "\n";
                }
                reader.close();
            }
            catch(Exception e) // catch error reading file contents 
            {
                System.out.println("Error reading file contents");
                System.out.println(e.getMessage());
            }
        }
        catch(Exception e) // catch error on FileReader reader = new FileReader 
        {
            System.out.println("Error opening file");
            System.out.println(e.getMessage());
        }
        return fileContents;
    }

    // static method to write a file, returns nothing 
    public static void writeFile(String inputString, String writeFileName)
        throws IOException, Exception
    {
        try
        {
            PrintWriter printWriter = new PrintWriter(writeFileName);
            try
            {
                printWriter.println(inputString);
                printWriter.close();
            }
            catch (Exception e)
            {
                Log.addToErrorLog("FileIO writeFile(): could not write data: " + e.getMessage());
            }
        }
        catch (Exception e)
        {
            Log.addToErrorLog("FileIO writeFile(): could not open file to write to:" + e.getMessage());
        }
    }
}