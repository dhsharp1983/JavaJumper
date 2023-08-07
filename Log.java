import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
public class Log 
{
    static File errorLogFile = new File("ErrorLog.txt");
    
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

    public static void initErrorLog()
    {
        if (errorLogFile.exists())
        {
            errorLogFile.delete();
        }
    }
}
