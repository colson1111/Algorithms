package quicksort;
import java.util.*;

public class QuickSort {

    public static void main(String[] args) {
        // Initialize variables
        int n;
        List<Integer> array;
        
        // Get the length of the list from the user
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of items in the list: ");
        n = in.nextInt();
        
        // Get the random list
        array = generateList(n);
        
        // Show the list
        System.out.println(array);
        
        // Sort the list
        array = quicksort(array);
        
        // Print the sorted list
        System.out.println("Sorted List: " + array);
    }

    // function to generate unsorted list of random numbers
    public static List<Integer> generateList(int n){
        ArrayList<Integer> list = new ArrayList<>(n);
        Random random = new Random();
        
        for (int i = 0; i < n; i++){
            list.add(random.nextInt(1000));
        }
        return list;
    }
    
    // quicksort function
    public static List<Integer> quicksort(List<Integer> array){
        int length = array.size();
        if (length < 2){
            return array;
        }
        int pivot_value = array.get(0);
        List<Integer> less = new ArrayList<>();
        List<Integer> more = new ArrayList<>();

        for (int i = 1; i < length; i++) {
            if (array.get(i) <= pivot_value){   // if the element is less than the pivot
                less.add(array.get(i));         // add element to the end of 'less'
            } else {                            // otherwise:
                more.add(array.get(i));         // add the element to the end of 'more'
            }   
        }
        List<Integer> combined = new ArrayList<>(quicksort(less));
        combined.add(pivot_value);
        combined.addAll(quicksort(more));
        return combined;
    }
}
