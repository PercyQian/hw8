import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Scheduler {
    private MinHeap minHeap;    // To store available numbers
    private int curr;           // Pointer for processed permutation elements

    public Scheduler() {
        minHeap = new MinHeap();
        curr = 0;
    }

    public List<Integer> scheduleExecution(int[] permutation, int[] indices) {
        List<Integer> result = new ArrayList<>();    // To store output for each query
        curr = 0;

        // Process queries in sorted order
        for (int queryIndex : indices) {
            try {
                // Extend the available set to include elements up to the current query index
                while (curr < queryIndex) {
                    minHeap.push(permutation[curr]);
                    curr++;
                }
                
                // Retrieve and remove the smallest available number
                int chosen = minHeap.pop();
                result.add(chosen);
            } catch (NoSuchElementException e) {
                throw new IllegalArgumentException("Not enough elements available for index " + queryIndex);
            }
        }

        return result;
    }
}
