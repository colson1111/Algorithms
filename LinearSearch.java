package linearsearch;
import java.util.*;

public class LinearSearch {

    public static void main(String[] args) {
        int n, search;
        List<Integer> array;
        
        // Enter the number of elements in the list
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        n = in.nextInt();
        
        // Create an array List of integers
        array = generateRandomArray(n);
        
        // Sort the list
        Collections.sort(array);
        
        // Print the array
        System.out.println("Array: " + array);
        
        // Get the value to look for
        System.out.println("Enter the value to find: ");
        search = in.nextInt();
        
        String result = search + " not found in list.";
        
        for (int i = 0; i <= n; i++){
            if (array.get(i) == search){
                result = search + " found at location " + i + ".";
                break;
            }
        }
        
        System.out.println(result);
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
