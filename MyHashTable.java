/**
 *  Stores a list of words in an array.
 *  Reads the words from a file;
 *  stores them in an array of Strings;
 *  can retrieve them.
 */

import java.util.Scanner;
import java.io.*;
import java.util.LinkedList;

public class MyHashTable
{
    private final int TABLE_SIZE = 100000;
    private LinkedList [] table;

    /** The constructor sets up the hash table
     */
    public MyHashTable()
    {
        // Creates a new array of linked lists
        table = new LinkedList [TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
        {
            // each cell is a new empty linked list
            table[i] = new LinkedList<String>();
        }
    }

    /** Gets the key for a String
     *  @param  str  The string to get a key for
     *  @return The key for that String
     *  POSTCONDITION:  0 <= key < TABLE_SIZE
     */
    public int getKey (String str)
    {
        // Replace this with a more useful function!
        return 3;
    }

    /**
     *  Adds the given word to the hash table
     *  @param  str the word to add to the table
     */
    public void add (String str)
    {
        // Your code here!
        
    }

    /** 
     *  Determines whether the given string is in the hash table
     *  @param   str  the word to search for
     *  @return  whether the string is in the hash table
     */
    public boolean contains (String str)
    {
        // This does NOT work properly. Replace it!
        return false;
    }

    /**
     *  Prints out info about the hash table.
     */
    public void report()
    {
        int empty = 0, sizeOne = 0, larger = 0;
        int longest = 0, longLoc = 0;
        int totalEntries = 0;

        for (int i = 0; i < TABLE_SIZE; i++)
        {
            int listSize = table[i].size();
            totalEntries += listSize;
            if (listSize == 0)
            {
                empty++;
            }
            else if (listSize == 1)
            {
                sizeOne++;
            }
            else
            {
                larger++;
            }

            if (listSize > longest)
            {
                longest = listSize;
                longLoc = i;
            }

        }

        System.out.println(TABLE_SIZE + " total cells.");
        System.out.println(empty + " empty cells (" + (empty * 100.0/TABLE_SIZE) + "%).");
        System.out.println(sizeOne + " cells with one word (" + (sizeOne * 100.0/TABLE_SIZE) + "%).");
        System.out.println(larger + " larger lists (" + (larger * 100.0/TABLE_SIZE) + "%).");
        System.out.println("Average length of non-empty lists: " + ((double) totalEntries / (TABLE_SIZE - empty)));

        System.out.println("The longest linked list is in cell " + longLoc + "\n    " + table[longLoc]);

    }

}
