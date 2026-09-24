package com.mycompany.com2224algorithmsanddatastructuresassingment1;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add a product to the end of the list
    public void add(Product product) {
        Node newNode = new Node(product);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Remove a product by ID
    public boolean remove(String productId) {
        Node current = head;
        while (current != null) {
            if (current.data.getProductId().equalsIgnoreCase(productId)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next; // Removing head
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; // Removing tail
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false; // Not found
    }

    // LINEAR SEARCH implementation
    // Best case: O(1), Average: O(n), Worst case: O(n)
    public Product search(String productId) {
        Node current = head;
        while (current != null) {
            if (current.data.getProductId().equalsIgnoreCase(productId)) {
                return current.data; // Found
            }
            current = current.next;
        }
        return null; // Not found
    }

    // Display all products in the inventory
    public void display() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        // Calculate max widths for dynamic table sizing
        int maxId = 10;
        int maxName = 20;
        int maxCat = 15;
        
        Node current = head;
        while (current != null) {
            if (current.data.getProductId().length() > maxId) maxId = current.data.getProductId().length();
            if (current.data.getName().length() > maxName) maxName = current.data.getName().length();
            if (current.data.getCategory().length() > maxCat) maxCat = current.data.getCategory().length();
            current = current.next;
        }

        String formatHeader = "%-" + maxId + "s | %-" + maxName + "s | %-" + maxCat + "s | %-11s | %-5s";
        String formatData = "%-" + maxId + "s | %-" + maxName + "s | %-" + maxCat + "s | R%-10.2f | %-5d";

        System.out.println(String.format(formatHeader, "ID", "Name", "Category", "Price", "Stock"));
        
        // Create dashed line that matches exact width
        int totalWidth = maxId + maxName + maxCat + 11 + 5 + 12;
        StringBuilder dashes = new StringBuilder();
        for(int i=0; i<totalWidth; i++) dashes.append("-");
        System.out.println(dashes.toString());

        current = head;
        while (current != null) {
            Product p = current.data;
            System.out.println(String.format(formatData, p.getProductId(), p.getName(), p.getCategory(), p.getPrice(), p.getStockQuantity()));
            current = current.next;
        }
        System.out.println(dashes.toString());
        System.out.println("Total items: " + size);
    }
}
