/*
 *
 * Philip Tenteromano
 * 2/20/2018
 * Random number Array and sort
 * Java Programming
 *y
 *
 */

// need this, despite red line
package RandomNumArr;

import java.util.Random;    //importing packages
import java.util.Scanner;

// Primary class
public class RandomNum {
    static Random rand = new Random();      // Static member variables
    private static int n;                   // n for indexing        
    private static int newSize;
    private static int arr[];
    
    // initalize function
    public static void makeArr() 
    {
        int MAXSIZE = 6;                    // initial size = 6
        
        if (newSize > 0 && newSize <= 20)
            MAXSIZE = newSize;
        
        int count = 0;                      // initalize index and array
        arr = new int[MAXSIZE];
                
        do {                                // loop through and randomize nums
            n = rand.nextInt(1000) + 1;
            arr[count] = n;
            count++;
        }while(count < MAXSIZE);  
    }
    
    // print function
    public static void printArray(int[] anArray) 
    {
      for (int i = 0; i < anArray.length; i++) {
         if (i > 0) {                           // separating with commas
            System.out.print(", ");
         }                                      // print each index
         System.out.print(anArray[i]);   
      }
      System.out.print('\n');                   // carriage return
    }
    
    // sorting array - Bubble sort
    public static void sortArray(int[] anArray)
    {
        //Using Bubble Sort Algorithm
        int len = anArray.length;       // get length
        int temp = anArray[0];          // initalize some temp value
        for(int i = 0; i< len-1; i++ )  // loop through length - 1, bubble
            for(int k=0; k<len-i-1; k++) 
                if(arr[k] > arr[k+1]) { // swap if k > k+1
                    temp = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1] = temp;
                }           
    }
    
    // Main Program:
    public static void main(String[] args) 
    {               
        char response = 'n';
        int count = 0;          // loop variables
        
        System.out.println("Let's start");
        
        do {    // call functions, print out original, sort, print sorted
            makeArr();
            System.out.println("\nOriginal Array:");
            printArray(arr);            // printing original
            
            System.out.println("\nSorted Array:");
            sortArray(arr);             // sorting and printing sorted
            printArray(arr);
            count++;

            // print 3 arrays, then ask to go again
            if(count >= 3) {
                System.out.println("\nGo again? (Y/N)");
                Scanner sc = new Scanner(System.in);
                response = sc.next().charAt(0);
           
                if (response == 'Y') {
                    System.out.println("Adjust size of the array? 1-20");
                    newSize = sc.nextInt();
                }
            }
        }while(response == 'Y' || count < 3);
        
    }   // end main
    
}
