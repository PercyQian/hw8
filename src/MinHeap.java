import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class MinHeap {
    // Internal representation (e.g., array)
    private PriorityQueue<Integer> heap;

    public MinHeap() {
        // heap <- empty list
        heap = new PriorityQueue<>();
    }

    // Insert value into heap and reheapify
    public void push(int value) {
        heap.offer(value);  // PriorityQueue automatically maintains heap property
    }

    // Remove and return the smallest element
    public int pop() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.poll();  // Returns and removes the root (smallest element)
    }

    // Return true if heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
