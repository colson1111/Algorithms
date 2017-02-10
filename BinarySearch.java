
package binarysearch; 
import java.util.*;

public class BinarySearch { 
    
    public static void main(String[] args) { 
        int first, last, middle, n, search;
        List<Integer> array;
        
        // Enter the number of elements in the list
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        n = in.nextInt();
        
        // Create an array list of integers
        array = generateRandomArray(n);
        
        // sort the arrayList
	Collections.sort(array);
        
        System.out.println("Array: " + array);
        
        // Get the value to search for
        System.out.println("Enter value to find: ");
        search = in.nextInt();
        
        // Define first, middle, and last variables
        first = 0;
        last = n - 1;
        middle = (first + last) / 2;
        
        while(first <= last){
            if (array.get(middle) < search){
                first = middle + 1;
            } else if (array.get(middle) == search){
                System.out.println(search + " found at location " + (middle + 1) + ".");
                break;
            } else {
                last = middle - 1;
            }
            
            middle = (first + last) / 2;
        }
        if (first > last){
            System.out.println(search + " is not present in the list.\n");
        }
    } 

    public static List<Integer> generateRandomArray(int n){
        ArrayList<Integer> list = new ArrayList<>(n);
        Random random = new Random();
        
        for (int i = 0; i < n; i++){
            list.add(random.nextInt(1000));
        }
        return list;
    }
}
