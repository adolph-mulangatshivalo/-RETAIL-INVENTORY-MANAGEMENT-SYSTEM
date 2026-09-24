package com.mycompany.com2224algorithmsanddatastructuresassingment1;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final String FILE_NAME = "inventory_data.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList inventory = new DoublyLinkedList();
        boolean running = true;

        // Load data from file at startup
        loadFromFile(inventory);

        while (running) {
            System.out.println("\n========================================");
            System.out.println(" RETAIL INVENTORY MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Search Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Sort Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Product ID: ");
                    String id = scanner.nextLine();
                    
                    // Check if ID already exists
                    if (inventory.search(id) != null) {
                        System.out.println("\nError: A product with ID '" + id + "' already exists! Please use a unique ID.");
                        break;
                    }

                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    
                    double price = 0;
                    int stock = 0;
                    try {
                        System.out.print("Enter Price (e.g., 29.99 or 30): ");
                        price = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter Stock Quantity (e.g., 50): ");
                        stock = Integer.parseInt(scanner.nextLine());
                        
                        Product newProduct = new Product(id, name, category, price, stock);
                        inventory.add(newProduct);
                        saveToFile(inventory); // Save changes automatically
                        System.out.println("\nProduct added successfully.");
                    } catch (NumberFormatException e) {
                        System.out.println("\nInvalid number format. Product not added.");
                    }
                    break;

                case "2":
                    System.out.print("Enter Product ID to remove: ");
                    String removeId = scanner.nextLine();
                    boolean removed = inventory.remove(removeId);
                    if (removed) {
                        saveToFile(inventory); // Save changes automatically
                        System.out.println("\nProduct removed successfully.");
                    } else {
                        System.out.println("\nProduct not found.");
                    }
                    break;

                case "3":
                    System.out.print("Enter Product ID to search: ");
                    String searchId = scanner.nextLine();
                    Product found = inventory.search(searchId);
                    if (found != null) {
                        System.out.println("\nProduct Found:");
                        
                        int idLen = Math.max(10, found.getProductId().length());
                        int nameLen = Math.max(20, found.getName().length());
                        int catLen = Math.max(15, found.getCategory().length());
                        
                        String formatHeader = "%-" + idLen + "s | %-" + nameLen + "s | %-" + catLen + "s | %-11s | %-5s";
                        String formatData = "%-" + idLen + "s | %-" + nameLen + "s | %-" + catLen + "s | R%-10.2f | %-5d";
                        
                        System.out.println(String.format(formatHeader, "ID", "Name", "Category", "Price", "Stock"));
                        
                        int totalWidth = idLen + nameLen + catLen + 11 + 5 + 12;
                        StringBuilder dashes = new StringBuilder();
                        for(int i=0; i<totalWidth; i++) dashes.append("-");
                        System.out.println(dashes.toString());
                        
                        System.out.println(String.format(formatData, found.getProductId(), found.getName(), found.getCategory(), found.getPrice(), found.getStockQuantity()));
                    } else {
                        System.out.println("\nProduct not found.");
                    }
                    break;

                case "4":
                    System.out.println();
                    inventory.display();
                    break;

                case "5":
                    System.out.println("\nSorting inventory by Product ID...");
                    MergeSort.sortById(inventory);
                    saveToFile(inventory); // Save the sorted order
                    System.out.println("Inventory sorted successfully.");
                    inventory.display();
                    break;

                case "6":
                    running = false;
                    saveToFile(inventory); // Final save before closing
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // Custom method to save the linked list to a text file
    private static void saveToFile(DoublyLinkedList inventory) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            Node current = inventory.head;
            while (current != null) {
                Product p = current.data;
                // Format data as Comma Separated Values (CSV)
                bw.write(p.getProductId() + "," + p.getName() + "," + p.getCategory() + "," + p.getPrice() + "," + p.getStockQuantity());
                bw.newLine();
                current = current.next;
            }
        } catch (IOException e) {
            System.out.println("Error saving inventory to file: " + e.getMessage());
        }
    }

    // Custom method to load data from the text file into the linked list
    private static void loadFromFile(DoublyLinkedList inventory) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String id = parts[0];
                    String name = parts[1];
                    String category = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    int stock = Integer.parseInt(parts[4]);
                    
                    // Add directly to the linked list
                    inventory.add(new Product(id, name, category, price, stock));
                }
            }
        } catch (IOException e) {
            // If the file doesn't exist yet (first time running), just ignore it and start fresh.
        }
    }
}
