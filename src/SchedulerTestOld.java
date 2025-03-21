import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class SchedulerTestOld {
    @Test
    public void testBasicScheduler() {
        Scheduler scheduler = new Scheduler();
        int[] permutation = {4, 2, 5, 1, 3};
        int[] indices = {3, 3, 5};
        List<Integer> expected = Arrays.asList(2, 4, 1);
        Assert.assertEquals(expected, scheduler.scheduleExecution(permutation, indices));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyHeap() {
        Scheduler scheduler = new Scheduler();
        int[] permutation = {1, 2};
        int[] indices = {2, 2, 2}; // try to pop three times from the heap, but there are not enough elements
        scheduler.scheduleExecution(permutation, indices);
    }

    @Test
    public void testSingleElement() {
        Scheduler scheduler = new Scheduler();
        int[] permutation = {1};
        int[] indices = {1};
        List<Integer> expected = Arrays.asList(1);
        Assert.assertEquals(expected, scheduler.scheduleExecution(permutation, indices));
    }

    @Test
    public void testRepeatedIndices() {
        Scheduler scheduler = new Scheduler();
        int[] permutation = {3, 1, 4, 2};
        int[] indices = {2, 2}; // repeated indices, ensure the heap has enough elements
        List<Integer> expected = Arrays.asList(1, 3);
        Assert.assertEquals(expected, scheduler.scheduleExecution(permutation, indices));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testInsufficientElements() {
        Scheduler scheduler = new Scheduler();
        int[] permutation = {1, 2, 3};
        int[] indices = {4}; // request index 4, but the array length is only 3
        scheduler.scheduleExecution(permutation, indices);
    }

    @Test
    public void testEmptyHeapState() {
        Scheduler scheduler = new Scheduler();
        int[] permutation = {1};
        int[] indices = {1, 1};  // the heap should be empty after the second pop
        
        try {
            scheduler.scheduleExecution(permutation, indices);
            Assert.fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // 期望的异常
            Assert.assertTrue(e.getMessage().contains("Not enough elements"));
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testZeroElements() {
        Scheduler scheduler = new Scheduler();
        int[] permutation = new int[0];
        int[] indices = {1};  // change to 1, so it will directly trigger array out of bounds
        scheduler.scheduleExecution(permutation, indices);
    }

    @Test
    public void testMinHeapMethods() {
        MinHeap minHeap = new MinHeap();
        Assert.assertTrue(minHeap.isEmpty());  // test initial state
        
        minHeap.push(1);
        Assert.assertFalse(minHeap.isEmpty());  // test non-empty state
        
        minHeap.pop();
        Assert.assertTrue(minHeap.isEmpty());  // test pop after pop
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopEmptyHeap() {
        MinHeap minHeap = new MinHeap();
        minHeap.pop();  // should throw NoSuchElementException
    }
}
