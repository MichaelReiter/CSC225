/* HeapSort.java
   CSC 225 - Fall 2015
   Assignment 3 - Template for Heap Sort
   
   This template includes some testing code to help verify the implementation.
   To interactively provide test inputs, run the program with
  java HeapSort

   To conveniently test the algorithm with a large input, create a 
   text file containing space-separated integer values and run the program with
  java HeapSort file.txt
   where file.txt is replaced by the name of the text file.

   M. Simpson & B. Bird - 11/16/2015
*/

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

//Do not change the name of the HeapSort class
public class HeapSort{
  /* HeapSort(A)
    Sort the array A using heap sort.
    You may add additional functions (or classes) if needed, but the entire program must be
    contained in this file. 

    Do not change the function signature (name/parameters).
  */
  public static void HeapSort(int[] A) {
    int n = A.length;
    makeHeap(A, n);

    int last = n-1;
    while (last > 0) {
      int temp = A[last];
      A[last] = A[0];
      A[0] = temp;
      siftHeap(A, 0, last-1);
      last -= 1;
    }
  }

  public static void makeHeap(int[] input, int n) {
    int first = (n-2) / 2;
   
    while (first >= 0) {
      siftHeap(input, first, n-1);
      first -= 1;
    }
  }
   
  public static void siftHeap(int[] input, int first, int last) {
    int rootNode = first;
   
    while ((rootNode*2 + 1) <= last) {
      int childNode = rootNode*2 + 1;
      if (childNode+1 <= last && input[childNode] < input[childNode+1]) {
        childNode += 1;
      }
      if (input[rootNode] < input[childNode]) {
        int temp = input[rootNode];
        input[rootNode] = input[childNode];
        input[childNode] = temp;
        rootNode = childNode;
      } else {
        break;
      }
    }
  }

  /* main()
     Contains code to test the HeapSort function. Nothing in this function 
     will be marked. You are free to change the provided code to test your 
     implementation, but only the contents of the HeapSort() function above 
     will be considered during marking.
  */
  public static void main(String[] args){
    Scanner s;
    if (args.length > 0){
      try{
        s = new Scanner(new File(args[0]));
      } catch(java.io.FileNotFoundException e){
        System.out.printf("Unable to open %s\n",args[0]);
        return;
      }
      System.out.printf("Reading input values from %s.\n",args[0]);
    }else{
      s = new Scanner(System.in);
      System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
    }
    Vector<Integer> inputVector = new Vector<Integer>();

    int v;
    while(s.hasNextInt() && (v = s.nextInt()) >= 0)
      inputVector.add(v);

    int[] array = new int[inputVector.size()];

    for (int i = 0; i < array.length; i++)
      array[i] = inputVector.get(i);

    System.out.printf("Read %d values.\n",array.length);


    long startTime = System.currentTimeMillis();

    HeapSort(array);

    long endTime = System.currentTimeMillis();

    double totalTimeSeconds = (endTime-startTime)/1000.0;

    //Don't print out the values if there are more than 100 of them
    if (array.length <= 100){
      System.out.println("Sorted values:");
      for (int i = 0; i < array.length; i++)
        System.out.printf("%d ",array[i]);
      System.out.println();
    }

    //Check whether the sort was successful
    boolean isSorted = true;
    for (int i = 0; i < array.length-1; i++)
      if (array[i] > array[i+1])
        isSorted = false;

    System.out.printf("Array %s sorted.\n",isSorted? "is":"is not");
    System.out.printf("Total Time (seconds): %.2f\n",totalTimeSeconds);
  }
}