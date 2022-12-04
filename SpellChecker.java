
/**
 * A class for testing a Hash Table & Spelling Checker
 *
 * @author Michael Buescher and Post-AP CS at Hathaway Brown
 * @version 2022-12
 */

import java.util.Scanner;
import java.io.*;

public class SpellChecker
{
    MyHashTable hashTable;
    long startLoadMS, endLoadMS;
    long startCheckMS, endCheckMS;
    
    /** Creates a hash table and opens a dictionary to load into it.
     *  @param  fileName  The name of the file where the dictionary is stored.
     */
    public SpellChecker (String fileName)
    {
        int count = 0;
        hashTable = new MyHashTable();
        startLoadMS = System.currentTimeMillis();
        
        // Try to open the file for input.       
        File file = new File(fileName);
        Scanner wordFile = null;
        try
        {
            wordFile = new Scanner(file);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("*** Cannot open " + fileName + " ***");
            System.exit(1);        // quit the program
        } 

        while (wordFile.hasNext())
        {
            String nextWord = wordFile.next();
            hashTable.add(nextWord);
            count++;
        }
        wordFile.close();
        System.out.println ("Read " + count + " words from the file.");
        endLoadMS = System.currentTimeMillis();
    }

    /** Reports on the status of the spell check:
     *    -- The time it takes to load the dictionary into the hash table
     *    -- The time it takes to spell-check the file
     *    -- Statistics for the hash table (empty cells, average length, etc)
     */
    public void report ()
    {
        // Time it takes to read the dictionary into the hash table
        long elapsedLoadMS = endLoadMS - startLoadMS;
        System.out.println((0.001 * elapsedLoadMS) + " seconds to create the hash table.");
        
        // Time it takes to spell-check a file
        long elapsedCheckMS = endCheckMS - startCheckMS;
        System.out.println((0.001 * elapsedCheckMS) + " seconds to spell-check the file.");
        
        // Statistics about the hash table
        hashTable.report();
    }
    
    /** Prints information about a string: hash code, hash table key, and whether it is in the dictionary
     *  @param   str  The String about which to print information
     */
    public void printWordInfo(String str)
    {
        System.out.println(str + "\t" + str.hashCode() + "\t" 
               + hashTable.getKey(str) + "\t" + hashTable.contains(str));
    }
    
    /**
     *   A tester method to check individual words against the hash table.
     */
    public void testWords()
    {
        System.out.println("Enter a bunch of words, one per line, blank line to end.");
        Scanner kbd = new Scanner(System.in);
        String str = kbd.nextLine();
        while (str.length() > 0)
        {
            printWordInfo(str);
            str = kbd.nextLine();
        }
        kbd.close();
    }
    
    /** A method to spell-check a text file
     *  Opens a new TextFile (see that separate class)
     *  Prints out every word in the text file that is not in the dictionary
     */
    public void spellCheck(String fileName)
    {
        startCheckMS = System.currentTimeMillis();
        TextFile text = new TextFile(fileName);
        String word = text.getNextWord();
    
        System.out.println("Not found in dictionary: ");
        while (word != null)
        {
            if (!hashTable.contains(word))
            {
                printWordInfo(word);
            }
            word = text.getNextWord();
        }
        
        text.close();
        endCheckMS = System.currentTimeMillis();
    }
    
    public static void main (String[] args)
    {
        SpellChecker tester = new SpellChecker("popular.txt");
        //tester.testWords();
        
        //tester.spellCheck("alice_in_wonderland.txt");
        tester.report();
    }
}
