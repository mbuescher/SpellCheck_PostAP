
/**
 * Opens a .txt file for input and returns individual words.
 *
 * @author Michael Buescher and Post-AP CS@HB
 * @version 2022-03-28
 */

import java.util.Scanner;
import java.io.*;

public class TextFile
{
    Scanner wordFile;
    /**
     * The constructor simply opens the file for input.
     */
    public TextFile (String fileName)
    {
        // Try to open the file for input.       
        File file = new File(fileName);
        wordFile = null;
        try
        {
            wordFile = new Scanner(file);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("*** Cannot open " + fileName + " ***");
            System.exit(1);        // quit the program
        } 

    }
    
    public String getNextWord()
    {
        if (wordFile.hasNext())
        {
            return wordFile.next();
        }
        else
        {
            return null;
        }
    }
    
    /** Closes the file  */
    public void close()
    {
        wordFile.close();
    }
}
