/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.com2224algorithmsanddatastructuresassingment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testInsertion() {
        System.out.println("Running Test 1: Insertion (Adding Products to Doubly Linked List)...");
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(new Product("P001", "Apple", "Food", 10.0, 50));
        list.add(new Product("P002", "Banana", "Food", 5.0, 100));
        
        assertEquals(2, list.size, "Size should be 2 after adding two products");
        assertEquals("P001", list.head.data.getProductId(), "Head should be P001");
        assertEquals("P002", list.tail.data.getProductId(), "Tail should be P002");
        System.out.println("✅ Test 1 Passed: Successfully inserted 2 products and updated head/tail pointers.");
        System.out.println("--------------------------------------------------");
    }

    @Test
    public void testLinearSearchFound() {
        System.out.println("Running Test 2: Linear Search (Finding an existing product)...");
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(new Product("P002", "Banana", "Food", 5.0, 100));
        
        Product found = list.search("P002");
        assertNotNull(found, "Product should be found");
        assertEquals("Banana", found.getName(), "Found product name should match");
        System.out.println("✅ Test 2 Passed: Linear Search correctly traversed the list and found the product.");
        System.out.println("--------------------------------------------------");
    }

    @Test
    public void testLinearSearchNotFound() {
        System.out.println("Running Test 3: Linear Search (Searching for non-existent product)...");
        DoublyLinkedList list = new DoublyLinkedList();
        Product notFound = list.search("P999");
        assertNull(notFound, "Searching for non-existent product should return null");
        System.out.println("✅ Test 3 Passed: Linear Search safely handled a missing product (Returned null).");
        System.out.println("--------------------------------------------------");
    }

    @Test
    public void testRemoval() {
        System.out.println("Running Test 4: Removal (Deleting a product & updating pointers)...");
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(new Product("P001", "Apple", "Food", 10.0, 50));
        list.add(new Product("P002", "Banana", "Food", 5.0, 100));
        
        boolean removed = list.remove("P001");
        assertTrue(removed, "Removal should return true");
        assertEquals(1, list.size, "Size should drop to 1");
        assertEquals("P002", list.head.data.getProductId(), "Head should update to P002");
        System.out.println("✅ Test 4 Passed: Removal deleted the product and correctly rewired the pointers.");
        System.out.println("--------------------------------------------------");
    }

    @Test
    public void testMergeSort() {
        System.out.println("Running Test 5: Merge Sort (Sorting by Product ID)...");
        DoublyLinkedList sortList = new DoublyLinkedList();
        sortList.add(new Product("Z100", "Zebra", "Toys", 1.0, 1));
        sortList.add(new Product("A001", "Apple", "Food", 1.0, 1));
        sortList.add(new Product("M050", "Mango", "Food", 1.0, 1));
        
        MergeSort.sortById(sortList);
        
        assertEquals("A001", sortList.head.data.getProductId(), "First element should be A001");
        assertEquals("M050", sortList.head.next.data.getProductId(), "Second element should be M050");
        assertEquals("Z100", sortList.tail.data.getProductId(), "Last element should be Z100");
        System.out.println("✅ Test 5 Passed: Merge Sort correctly arranged the random inputs into alphabetical order.");
        System.out.println("==================================================\n");
    }
}
