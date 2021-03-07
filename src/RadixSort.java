/************************************************************** 
Purpose/Description: <  Implement (in Java) the radixSort algorithm to sort in 
* increasing order an array of integer positive keys. 
* public void radixSort(int arr[])
In your implementation you must consider that each key contains only even digits 
* (0, 2, 4, 6, and 8). Your program must detect the case of odd digits in the 
* keys, and, in this case, abort. >
Author’s Panther ID: <XXXXXXXX>
Certification: I hereby certify that this work is my own and none of it is 
the work of any other person.
**************************************************************/


import java.util.*;

public class RadixSort {

    // main method to test the following  function
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter the size of array");
        int numOfElements = sc.nextInt();
        System.out.println("Enter "+numOfElements+" elements with space separated");
        for(int i=0;i<numOfElements;i++){
            arr.add(sc.nextInt());
        }
        for(Integer i: arr){
            if(!FindOddNum(i)){
                System.out.println("Aborting. Found a key having odd digit/s.");
                System.exit(0);
            }
        }
        radixSort(arr);


    }

    //this function will determine if a number is odd or even
    // return true if even fasle if odd
    private static boolean FindOddNum(Integer key){
      int k = key.intValue();
      if(k==0)
          return true;
        while(k>0){
            if(k%2==1)
                return false;
            k=k/10;
        }
        return true;
    }

    //retunr the maximum value in an array
    private static Integer MaxNum(ArrayList<Integer> arr){
        Integer max = new Integer(0);
      for(Integer i: arr){
          if(i.intValue() > max.intValue())
              max = i;
      }
      return max;
    }
    
    // create and manage the list of integers 
    private static void SetList(ArrayList<Integer> arr, int pow){
    int len = arr.size();
    ArrayList<Integer> newArr = new ArrayList<>(len);
    ArrayList<Integer> bucket = new ArrayList<>();
    for (int i=0;i<10;i++){
        bucket.add(0);
    }
     for(int i=0;i<len;i++){
        newArr.add(0);
        int newEle = (arr.get(i).intValue()/pow)%10;
        bucket.set(newEle,bucket.get(newEle).intValue()+1);
    }

    for(int i=1;i<10;i++){
         bucket.set(i,bucket.get(i-1).intValue() + bucket.get(i).intValue());
     }

     for (int i=len-1;i>=0;i--){
         int curr =   (arr.get(i).intValue()/pow)%10;
        newArr.set(bucket.get(curr)-1,arr.get(i));
          bucket.set(curr,bucket.get(curr)-1);
        }

     for(int i=0;i<len;i++){
        arr.set(i,newArr.get(i));
      }
    }

    
    //will sort the list of integers
    public static void radixSort(ArrayList<Integer> arr){
        int mx = MaxNum(arr).intValue();
       for(int i = 1;mx/i>0;i=i*10)
           SetList(arr,i);
     for(int i=0;i<arr.size();i++){
         System.out.print(arr.get(i).intValue()+" ");
     }
    }
}

