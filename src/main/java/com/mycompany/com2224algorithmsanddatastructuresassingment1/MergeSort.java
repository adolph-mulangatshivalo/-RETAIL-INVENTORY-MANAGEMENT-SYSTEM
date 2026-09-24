package com.mycompany.com2224algorithmsanddatastructuresassingment1;

public class MergeSort {

    // Sorts the doubly linked list by Product ID and updates the head and tail
    public static void sortById(DoublyLinkedList list) {
        if (list.head == null || list.head.next == null) {
            return;
        }
        list.head = mergeSort(list.head);
        
        // Update the tail reference after sorting
        Node current = list.head;
        while (current != null && current.next != null) {
            current = current.next;
        }
        list.tail = current;
    }

    // Recursive merge sort function
    // Best case: O(n log n), Average: O(n log n), Worst case: O(n log n)
    private static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the list
        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;

        // Split the list into two halves
        middle.next = null;
        if (nextToMiddle != null) {
            nextToMiddle.prev = null;
        }

        // Recursively sort both halves
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);

        // Merge the sorted halves
        return sortedMerge(left, right);
    }

    // Helper function to merge two sorted lists
    private static Node sortedMerge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node result;
        // Sort in ascending order by Product ID
        if (left.data.getProductId().compareToIgnoreCase(right.data.getProductId()) <= 0) {
            result = left;
            result.next = sortedMerge(left.next, right);
            if (result.next != null) {
                result.next.prev = result;
            }
            result.prev = null;
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
            if (result.next != null) {
                result.next.prev = result;
            }
            result.prev = null;
        }
        return result;
    }

    // Helper function to find the middle node of a doubly linked list
    private static Node getMiddle(Node head) {
        if (head == null) return head;
        Node slow = head;
        Node fast = head;

        // Fast pointer moves two nodes, slow pointer moves one node
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
