
/**
 * A class for testing a Hash Table & Spelling Checker
 *
 * @author Michael Buescher and Post-AP CS at Hathaway Brown
 * @version 2022-03
 */

import java.util.Scanner;
import java.io.*;

public class MakeHashTester
{
    MyHashTable hashTable;
    long startMS, endMS;
    
    public void report ()
    {
        long elapsedMS = endMS - startMS;
        System.out.println((0.001 * elapsedMS) + " seconds to create the hash table.");
    }
    
    public MakeHashTester (String fileName)
    {
        int count = 0;
        hashTable = new MyHashTable();
        startMS = System.currentTimeMillis();
        
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
        endMS = System.currentTimeMillis();
    }

    
    public static void main (String[] args)
    {
        MakeHashTester tester = new MakeHashTester("popular.txt");
        TextFile text = new TextFile("26WestReview.txt");
        String word = text.getNextWord();
        while (word != null)
        {
            System.out.println(word);
            word = text.getNextWord();
        }
        tester.report();
    }
}
