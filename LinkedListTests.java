import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LinkedListTests {
    public ListNode addMany(ListNode ll, List<Integer> values) {
        ListNode current = ll;
        while (current.next != null) {
            current = current.next;
        }

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return ll;
    }

    public List<Integer> getNodesInArray(ListNode ll) {
        List<Integer> nodes = new ArrayList<Integer>();
        ListNode current = ll;
        while (current != null) {
            nodes.add(current.value);
            current = current.next;
        }
        return nodes;
    }

    @Test
    public void testMergeTwoSortedLists() {
        ListNode exampleOne = new ListNode(2);
        addMany(exampleOne, new ArrayList<Integer>(Arrays.asList(6, 7, 8)));
        ListNode exampleTwo = new ListNode(1);
        addMany(exampleTwo, new ArrayList<Integer>(Arrays.asList(3, 4, 5, 9, 10)));
        ListNode output = merge_two_sorted_lists.mergeTwoLists(exampleOne, exampleTwo);
        List<Integer> expectedNodes = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode exampleThree = null;
        ListNode exampleFour = null;
        output = merge_two_sorted_lists.mergeTwoLists(exampleThree, exampleFour);
        expectedNodes = new ArrayList<Integer>(Arrays.asList());
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode exampleSix = null;
        ListNode exampleSeven = new ListNode(0);
        output = merge_two_sorted_lists.mergeTwoLists(exampleSix, exampleSeven);
        expectedNodes = new ArrayList<Integer>(Arrays.asList(0));
        assertTrue(getNodesInArray(output).equals(expectedNodes));
    }

    @Test
    public void testOddEvenLinkedList() {
        ListNode exampleOne = new ListNode(1);
        addMany(exampleOne, new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5)));
        ListNode output = odd_even_linked_list.oddEvenList(exampleOne);
        List<Integer> expectedNodes = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 2, 4));
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode exampleTwo = new ListNode(2);
        addMany(exampleTwo, new ArrayList<Integer>(Arrays.asList(1, 3, 5, 6, 4, 7)));
        output = odd_even_linked_list.oddEvenList(exampleTwo);
        expectedNodes = new ArrayList<Integer>(Arrays.asList(2, 3, 6, 7, 1, 5, 4));
        assertTrue(getNodesInArray(output).equals(expectedNodes));
    }

    @Test
    public void testPalindromeLinkedList() {
        ListNode exampleOne = new ListNode(1);
        addMany(exampleOne, new ArrayList<>(Arrays.asList(2, 2, 1)));
        boolean output = palindrome_linked_list.isPalindrome(exampleOne);
        assertTrue(output == true);

        ListNode exampleTwo = new ListNode(1);
        addMany(exampleTwo, new ArrayList<>(Arrays.asList(2)));
        output = palindrome_linked_list.isPalindrome(exampleTwo);
        assertTrue(output == false);
    }

    @Test
    public void testReverseLinkedList() {
        ListNode exampleOne = new ListNode(1);
        addMany(exampleOne, new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
        ListNode output = reverse_linked_list.reverseListRecursive(exampleOne);
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode exampleTwo = new ListNode(1);
        addMany(exampleTwo, new ArrayList<>(Arrays.asList(2)));
        output = reverse_linked_list.reverseList(exampleTwo);
        expectedNodes = new ArrayList<>(Arrays.asList(2, 1));
        assertTrue(getNodesInArray(output).equals(expectedNodes));

        ListNode exampleThree = null;
        output = reverse_linked_list.reverseList(exampleThree);
        expectedNodes = new ArrayList<Integer>(Arrays.asList());
        assertTrue(getNodesInArray(output).equals(expectedNodes));
    }
}