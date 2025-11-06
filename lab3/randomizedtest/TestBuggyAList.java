package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> noResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();

        noResizing.addLast(5);
        noResizing.addLast(10);
        noResizing.addLast(15);

        buggyAList.addLast(5);
        buggyAList.addLast(10);
        buggyAList.addLast(15);

        assertEquals(buggyAList.size(), noResizing.size());
        assertEquals(buggyAList.removeLast(), noResizing.removeLast());
        assertEquals(buggyAList.removeLast(), noResizing.removeLast());
        assertEquals(buggyAList.removeLast(), noResizing.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 1000);
                L.addLast(randVal);
                B.addLast(randVal);
                assertEquals(L.removeLast(), B.removeLast());
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                assertEquals(L.size(), B.size());
                System.out.println("size: " + size);
            }
        }
    }
}
