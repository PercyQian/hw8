import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

/**
 * Test class for Scheduler.
 */
public class SchedulerTest {

    /**
     * Cross-reference: scheduleExecution test design doc
     * Conditions: (CC1, B1, c1) - Good Data (legacy)
     * Test: normal queries within bounds
     */
    @Test
    public void testScheduleExecutionNormal() {
        Scheduler scheduler = new Scheduler();
        int[] permutation = {4, 2, 5, 1, 3};
        int[] indices = {3, 3, 5};
        List<Integer> result = scheduler.scheduleExecution(permutation, indices);
        // Expect [2, 4, 1]
        assertEquals(Arrays.asList(2, 4, 1), result);
    }

    /**
     * Cross-reference: scheduleExecution test design doc
     * Conditions: (CC2) - pop fails -> IllegalArgumentException
     * Test: not enough elements available
     */
    @Test(expected = IllegalArgumentException.class)
    public void testScheduleExecutionHeapEmpty() {
        Scheduler scheduler = new Scheduler();
        int[] permutation = {1, 2};
        int[] indices = {2, 2, 2}; // third pop from empty heap
        scheduler.scheduleExecution(permutation, indices);
    }

    /**
     * Cross-reference: scheduleExecution test design doc
     * Conditions: (B2) repeated indices
     */
    @Test
    public void testScheduleExecutionRepeatedIndices() {
        Scheduler scheduler = new Scheduler();
        int[] permutation = {3, 1, 4};
        int[] indices = {2, 2};
        List<Integer> result = scheduler.scheduleExecution(permutation, indices);
        // Behavior may vary: if second pop triggers exception or returns next smallest
        // Suppose we expect the first pop to return 1, the second to return 3
        // (adjust based on your design)
        assertEquals(Arrays.asList(1, 3), result);
    }

    /**
     * Cross-reference: scheduleExecution test design doc
     * Conditions: (b1) - out of bounds
     * Test: index beyond permutation length
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testScheduleExecutionIndexOutOfBound() {
        Scheduler scheduler = new Scheduler();
        int[] permutation = {1, 2, 3};
        int[] indices = {4}; // out-of-range index
        scheduler.scheduleExecution(permutation, indices);
    }

    /**
     * Nested test hook example:
     * If Scheduler had a private method you'd expose it in a static nested class.
     */
    public static class TestHookScheduler extends Scheduler {
        // Suppose there's a protected method "validateIndex(int i)"
        // public void testValidateIndex(int i) {
        //     validateIndex(i);
        // }
    }
}
