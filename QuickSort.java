/*************************************************************************
*
*  Pace University
*  Fall 2019
*  Data Structures and Algorithms
*
*  Input: NONE
*  Output: NONE
*
*  Visible data fields:
*  COPY DECLARATION OF VISIBLE DATA FIELDS HERE
*
*  Visible methods:
*  public static void leftQuickSort(int arr[], int low, int high)
*  public static void medianQuickSort(int arr[], int low, int high)
*************************************************************************/
 
public class QuickSort{
   // Quicksort using pivot as the median | excellent pivot

   // Using first (leftmost) element as the pivot | worst pivot
   public static void rightQuickSort(double arr[], int low, int high) {
 
       if (low < high ) {
           int pi = rightPartition(arr, low, high);
 
           // Recursively sort elements before
           // partition and after partition
           rightQuickSort(arr, low, pi - 1);
           rightQuickSort(arr, pi + 1, high);
       }
   }
  
   // Assistant method that uses first (leftmost) element as the pivot
  private static int rightPartition(double A[], int p, int r){
   double x = A[r];
   int i = p-1;
   double temp;
 
   for(int j = p ; j < r; j++){
       if(A[j] < x){
            i++;
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;
         }
   }
   temp = A[i+1];
   A[i+1] = A[r];
   A[r] = temp;
  
   return i + 1;
  }
}
 

