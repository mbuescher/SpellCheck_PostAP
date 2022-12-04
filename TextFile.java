
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
    String nextLine = "";
    
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
    
    /**  Reads and returns the next word from the TextFile.
     *   Cleans the word by removing punctuation (anything not a letter) from beginning and end.
     *   @return  the next word from the text file, or null if there are no more words in the file.
     */
    public String getNextWord()
    {
        if (wordFile.hasNext())
        {
            return clean(wordFile.next());
        }
        else
        {
            return null;
        }
    }
    
    /** "Cleans" the string by removing any non-alphabetic characters from the front and back of the word
     *   @param   The String to clean
     *   @return  The cleaned String
     */
    public String clean (String str)
    {
        // Find first alphabetic character
        int start = 0;
        while (str.length() > start && !Character.isAlphabetic(str.charAt(start)))
        {
            start++;
        }
        
        // Find last alphabetic character
        int end = str.length() - 1;
        while (end >= 0 && !Character.isAlphabetic(str.charAt(end)))
        {
            end--;
        }
        
        // If something is not right, returns an empty string.
        if (start > end)
        {
            return "";
        }
        
        // return the lowercase version of the substring
        return str.substring(start, end + 1).toLowerCase();
    }
    
    /** Closes the file  */
    public void close()
    {
        wordFile.close();
    }
}
