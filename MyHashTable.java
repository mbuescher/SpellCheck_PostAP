/**
 *  Stores a list of words in an array.
 *  Reads the words from a file;
 *  stores them in an array of Strings;
 *  can retrieve them.
 */

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class MyHashTable

{
    private final int TABLE_SIZE = 40000;

    /** The constructor sets up the hash table
     */
    public MyHashTable()
    {
 
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
        return (Math.random() < 0.5);
    }
}