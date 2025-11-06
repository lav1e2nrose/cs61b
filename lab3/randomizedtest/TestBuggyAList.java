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

        int N = 5000; // 测试次数
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 4); // 0~3 四种操作

            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 1000);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                assertEquals(L.size(), B.size());
                System.out.println("size: " + L.size());
            } else if (operationNumber == 2 && L.size() > 0) {
                // getLast
                int lastL = L.getLast();
                int lastB = B.getLast();
                assertEquals(lastL, lastB);
                System.out.println("getLast -> " + lastL);
            } else if (operationNumber == 3 && L.size() > 0) {
                // removeLast
                int valL = L.removeLast();
                int valB = B.removeLast();
                assertEquals(valL, valB);
                System.out.println("removeLast -> " + valL);
            }
        }
    }
}