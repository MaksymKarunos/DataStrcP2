import java.util.*;

public class BucketSort{
public static void bucketsort(double [] A) {
    //get hash codes
    double[] hashCode = hash(A);
    //intialization
    ArrayList<Double>[] buckets = new ArrayList[(int)hashCode[1]];
    for (int i = 0; i < hashCode[1]; i++) {
      buckets[i] = new ArrayList<Double>();
    }
    // filling elemts to buckets 
    for ( double i : A) {
      buckets[hash(hashCode, i)].add(i);
    }
    // sorting using insertion sort ( implemented below 
    for ( int i = 0; i < buckets.length; i++){
        sort(buckets, i);
    }
    int index = 0;
    //merge the buckets
    for (int i = 0; i < buckets.length; i++) {
      for (double element : buckets[i]) {
        A[index++] = element;
      }
    }
  }
  // hashing 
  private static double[] hash(double[] A) {
    double m = A[0];
    for (int i = 1; i < A.length; i++) {
      if (m < A[i]) {
        m = A[i];
      }
    }
    return new double[]{m, (int) Math.sqrt(A.length)};
  }
 // hashing 
  private static int hash(double[] hashV, double index) {
    return (int) ((double) index / hashV[0] * (hashV[1] - 1));
  }
  
  private static void sort(ArrayList<Double>[] buckets, int index){
        int n = buckets[index].size(); 
        for (int i = 1; i < n; ++i) { 
            double key = buckets[index].get(i); 
            int j = i - 1; 
            while (j >= 0 && buckets[index].get(j) > key) { 
                buckets[index].set(j + 1,buckets[index].get(j)); 
                j = j - 1; 
            } 
            buckets[index].set(j + 1, key); 
        } 
    }
}