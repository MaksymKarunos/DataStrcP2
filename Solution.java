
/*************************************************************************
 *
 *  Pace University
 *  Spring 2020
 *  Algorithms and Computing Theory
 *
 *  Course: CS 242
 *  Team members: PUT THE NAMES HERE
 *  Collaborators: PUT THE NAME OF ANY COLLABORATORS OUTSIDE YOUR TEAM HERE, IF NONE, PUT NONE
 *  References: PUT THE LINKS TO YOUR SOURCES HERE
 *
 *  Assignment: PUT THE ASSIGNMENT NUMBER HERE
 *  Problem: PUT THE MAIN PROBLEM NAME HERE
 *  Description: PUT A BRIEF DESCRIPTION HERE
 *
 *  Input: 
 *  Output: 
 *
 *  Visible data fields:
 *  COPY DECLARATION OF VISIBLE DATA FIELDS HERE
 *
 *  Visible methods:
 *  COPY SIGNATURE OF VISIBLE METHODS HERE
 *
 *
 *   Remarks
 *   -------
 * QUICK SORT
 *                 10000000     1000000     100000      10000       1000       100
 *                  n1          n2          n3          n4          n5          n6
 *          1   r1  1031221600  94417300    19177900    1909200     2444800     1340900  
 *        100  r2  902358800    483402300   40652000    18197100    1726300     r>n
 *      1000    r3  N/A         633978100   259369400   11627300    r>n         r>n
 *      5000    r4  N/A         2152187900  201386700   25278200    r>n         r>n
 *      7500    r5  N/A         N/A         240831300   18800400    r>n         r>n
 *      10000   r6  N/A         N/A          N/A        23102300    r>n         r>n
 * 
 *  BUCKET SORT
 *                  10000000     1000000     100000      10000       1000       100
 *                      n1          n2          n3          n4          n5          n6
 *        1     r1  63947310100   1789948100  72245400    18016300    21312000    3326900 
 *       100    r2  69812788100   1766107500  69182200    6659900     2183300       r>n
 *      1000    r3  71587420200   1991198700  88502700    6139900       r>n         r>n
 *      5000    r4  N/A           2424423000  26917800    6896900       r>n         r>n
 *      7500    r5  N/A           106673000   23643800    6182600       r>n         r>n
 *      10000   r6  N/A           1891116000  17100300    1314300      r>n         r>n
 *  
 * 
 * Quicksort is the fastest sort given that numbers are completely random, however, it has O(n^2) time complexity if the array is already sorted or has a lot of repetions in which case it's likey to get a bad pivot. Bucket sort
 * is not always good either. Bucket Sort heavily realies on uniform distribution of numbers. Also, Quick Sort is more likey to run out memory when is n large enough with lots of repetions.
 * For example, on the large input of 10000000 with no repetions. QuickSort is 6 times faster than BucketSort since elements are clustered which hurts time complexity of BucketSort. Conversely looking at n = 10000, r =10000, for smaller input size with lots of repetions BucketSort is better
 * Since sort in the bucket is insertion sort O(n) for sorted ( in our case the same elements).
 *
 *************************************************************************/
import java.util.Random;
import java.util.Scanner;



public class Solution{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter size n");
        int n = myScanner.nextInt();
        System.out.println("Please enter size r");
        int r = myScanner.nextInt();
        assert r >= 1 : "r has to be a positive inter";
        double[] A1 = new double[n];
        double[] A2 = new double[n];
        // filling arrays with random numbers
        intializeArrays(A1, A2, n, r);
        long start = System.nanoTime();
        //QuickSort.rightQuickSort(A1,0,n-1);
        long end = System.nanoTime();
        System.out.println("Time taken to QuickSort   to sort: " + (end-start) + " milliseconds");
        start = System.nanoTime();
        BucketSort.bucketsort(A2);
        end = System.nanoTime();
        System.out.println("Time taken to Bucket Sort to sort: " + (end-start) + " milliseconds");;
        myScanner.close();
    }
    // filling out arrays with numbers
    private static void intializeArrays(double[] A1, double[] A2, int n, int r){
        Random myRandom = new Random();
        for  ( int i = 0; i < n; ){
        double value = myRandom.nextDouble();
        // upper bound depends on whatever value is smaller or bigger than 2r, in case is 
        double numberR = 2*r < n ? myRandom.nextInt(2*r) : myRandom.nextInt(n); 

            for ( int j = 0; j < numberR && i < n; j++){
                A1[i] = value;
                A2[i] = value;
                i++;
                }
            }
        }

    /// UNIT TESTS 
    private static void testing(double[] A2){
        System.out.println(" NEW ARRAY HAS BEEN TESTED \n\n");
        for ( double i : A2 ){
            System.out.println(i);
        }
    }
}