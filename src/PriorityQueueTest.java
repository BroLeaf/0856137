import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PriorityQueueTest {
    List<Integer> expected;
    List<Integer> randomArr;
    List<Integer> AnserArr;
    private int third;

    public PriorityQueueTest(Integer[] inputArr, Integer[] AnsArr) {
        this.randomArr = Arrays.asList(inputArr) ;
        this.expected = Arrays.asList(AnsArr);
    }

    @Parameterized.Parameters
    public static Collection addedNumbers() {
        return Arrays.asList(new Integer[][][]{ {{3, 1, 2}, {1, 2, 3}}, {{5, 2, 3}, {2, 3, 5}}, {{7, 3, 4}, {3, 4, 7}},
                {{9, 4, 5}, {4, 5, 9}}, {{10, 99, 55}, {10, 55, 99}}, {{1, 9, 5}, {1, 5, 9}}});
    }

    @Test
    public void check_order() {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(randomArr);
        for (int i = 0; i < queue.size(); i++) {
            assertEquals(queue.poll(), expected.get(i));
        }
    }

    @Test(expected = NullPointerException.class)
    public void testNullArray() {
        PriorityQueue<Integer> queue = null;
        queue.offer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument() {
        PriorityQueue queue_illegal = new PriorityQueue(randomArr);
        queue_illegal.addAll(queue_illegal);
    }

    @Test(expected = ClassCastException.class)
    public void testClassCast() {
        // integer list cannot compare with string
        PriorityQueue queue = new PriorityQueue(randomArr);
        queue.add("HaHa");
    }
}