
package breadthfirstsearch;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        
        // generate map object
        Map newMap = generateMap();
        
        // create queue of people to look up
        Queue<String> q = new LinkedList<>();
        
        // add "You" to the Queue
        q.add("You");

        // while there are people in the queue, check if they sell mangoes
        while (q.size() > 0){
            String person = q.remove();
            
            // determine if person sells mangoes
            boolean found = checkMango(person);
            
            // if they do sell mangoes, print message and end the loop
            if (found){
               System.out.println(person + " sells mangoes!");
               break; 
            }
            
            // add current person's connections to the back of the queue
            ArrayList<String> connections = (ArrayList<String>) newMap.get(person);;
            q.addAll(connections);
            
            // Show what the queue is now
            System.out.println("Queue is: " + q);       
        }
    }

    public static Map generateMap(){
        HashMap<String,ArrayList<String>> newMap = new HashMap<>();
        
        newMap.put("You", new ArrayList<>(Arrays.asList("Alice", "Bob", "Claire")));
        newMap.put("Alice", new ArrayList<>(Arrays.asList("Peggy")));
        newMap.put("Bob", new ArrayList<>(Arrays.asList("Peggy", "Anuj")));
        newMap.put("Claire", new ArrayList<>(Arrays.asList("Tom", "Johnny")));
        newMap.put("Anuj", new ArrayList<>(Arrays.asList("Bill")));
        newMap.put("Tom", new ArrayList<>(Arrays.asList()));
        newMap.put("Johnny", new ArrayList<>(Arrays.asList()));
        newMap.put("Peggy", new ArrayList<>(Arrays.asList()));
        newMap.put("Bill", new ArrayList<>(Arrays.asList()));
        
        return newMap;

    }
    
    public static boolean checkMango(String person){
        return person.length() == 4;
    }
   
}
