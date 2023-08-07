// Class to generate log files for testing, exception reporting and debugging 
// inspiration for BufferedWriter: https://beginnersbook.com/2014/01/how-to-append-to-a-file-in-java/
// Author: David Sharp
// Version: 1.0

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
public class Log 
{
    static File errorLogFile = new File("ErrorLog.txt");
    static File fullLogFile = new File("VerboseLog.txt");
    
    public static void addToErrorLog(String errorMsg)
    {
        FileWriter filewriter = null;
        PrintWriter printwriter = null;
        BufferedWriter bufferedwriter = null;
        try 
        {
            filewriter = new FileWriter(errorLogFile,true);
            bufferedwriter = new BufferedWriter(filewriter);
            printwriter = new PrintWriter(bufferedwriter);
            printwriter.println(errorMsg);
        } 
        catch (Exception e) 
        {
            System.out.println("Error Adding to Error Log: " + e.getMessage());
        }
        finally
        {
            try
            {
                printwriter.close();
                bufferedwriter.close();
                filewriter.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }

    public static void addToFullLog(String msg)
    {
        FileWriter filewriter = null;
        PrintWriter printwriter = null;
        BufferedWriter bufferedwriter = null;
        try 
        {
            filewriter = new FileWriter(fullLogFile,true);
            bufferedwriter = new BufferedWriter(filewriter);
            printwriter = new PrintWriter(bufferedwriter);
            printwriter.println(msg);
        } 
        catch (Exception e) 
        {
            // System.out.println("Error Adding to Full Log: " + e.getMessage());
            Log.addToErrorLog("Error adding msg " + msg + " to full log: " + e.getMessage());
        }
        finally
        {
            try
            {
                printwriter.close();
                bufferedwriter.close();
                filewriter.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }

    public static void initErrorLog()
    {
        if (errorLogFile.exists())
        {
            errorLogFile.delete();
        }
    }

    public static void initFullLog()
    {
        if (fullLogFile.exists())
        {
            fullLogFile.delete();
        }
    }
}
