import static org.junit.Assert.*;
import org.junit.Test;
import java.util.NoSuchElementException;

/**
 * Test class for MinHeap.
 */
public class MinHeapTest {

    /**
     * Cross-reference: push method test design doc
     * Conditions: (CC1, MP2) - Good Data (legacy)
     * Test: push single element -> pop -> isEmpty
     */
    @Test
    public void testPushSingleElement() {
        MinHeap heap = new MinHeap();
        heap.push(5);
        assertFalse("Heap should not be empty after push", heap.isEmpty());
        assertEquals("Pop should return 5", 5, heap.pop());
        assertTrue("Heap should be empty after popping the only element", heap.isEmpty());
    }

    /**
     * Cross-reference: push method test design doc
     * Conditions: (CC1, c1)
     * Test: push multiple elements -> pop returns the smallest
     */
    @Test
    public void testPushMultipleElements() {
        MinHeap heap = new MinHeap();
        heap.push(8);
        heap.push(3);
        heap.push(7);
        assertEquals("Pop should return smallest element (3)", 3, heap.pop());
        // Next pop should return 7, then 8
        assertEquals("Pop should return next smallest element (7)", 7, heap.pop());
        assertEquals("Pop should return next element (8)", 8, heap.pop());
        assertTrue("Heap should be empty now", heap.isEmpty());
    }

    /**
     * Cross-reference: pop method test design doc
     * Conditions: (CC2) - Bad Data
     * Test: pop from empty heap -> expect exception
     */
    @Test(expected = NoSuchElementException.class)
    public void testPopEmptyHeap() {
        MinHeap heap = new MinHeap();
        heap.pop(); // should throw NoSuchElementException
    }

    /**
     * Cross-reference: isEmpty method test design doc
     * Conditions: (CC1) - brand new heap
     * Test: a new heap should be empty
     */
    @Test
    public void testIsEmptyOnNewHeap() {
        MinHeap heap = new MinHeap();
        assertTrue("New heap should be empty", heap.isEmpty());
    }

    /**
     * Cross-reference: isEmpty method test design doc
     * Conditions: (CC2, b1) - good data (legacy)
     * Test: after push/pop, check isEmpty transitions
     */
    @Test
    public void testIsEmptyAfterPushPop() {
        MinHeap heap = new MinHeap();
        heap.push(10);
        assertFalse("Heap not empty after push", heap.isEmpty());
        heap.pop();
        assertTrue("Heap empty after popping last element", heap.isEmpty());
    }

    /**
     * Example of a nested test hook for a private or protected method.
     * (If your MinHeap had a private method, you'd expose it like this.)
     */
    public static class TestHookMinHeap extends MinHeap {
        // Suppose we have a protected method called 'checkInvariant()'
        // public boolean testCheckInvariant() {
        //     return checkInvariant(); 
        // }
    }

    // You'd then have a @Test method using TestHookMinHeap if needed.
    // @Test
    // public void testPrivateCheckInvariant() {
    //     TestHookMinHeap hook = new TestHookMinHeap();
    //     // Cross-reference: design doc for checkInvariant
    //     assertTrue(hook.testCheckInvariant());
    // }
}
