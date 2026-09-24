Retail Inventory Management System

COM 2224: Algorithms & Data Structures (Assignment 1) 
Group Topic: 5 (Retail Industry)

Project Overview
A Java-based console application built entirely from scratch to manage retail store inventory. This project demonstrates fundamental computer science concepts by utilizing custom-built data structures and algorithms without relying on Java's built-in Collections framework (like `ArrayList`) or external databases.

Key Features & Algorithms
* Doubly Linked List (`DoublyLinkedList.java`):** Used as the core memory structure to allow dynamic, $O(1)$ insertions and highly efficient item removals without array-shifting penalties.
* Linear Search:** Used to quickly find products by their unique Product ID in an unsorted linked structure.
* Merge Sort (`MergeSort.java`):** An optimal $O(n \log n)$ sorting algorithm uniquely suited for Linked Lists, manipulating node pointers rather than duplicating large data arrays.
* Data Persistence:** Uses File I/O (`inventory_data.txt`) to automatically save and load stock levels across sessions.
* Dynamic UI Formatting:** Tables dynamically adjust column widths to ensure no text is ever truncated or misaligned, regardless of input length.

Testing
The project includes a custom JUnit test suite (`MainTest.java`) that verifies data integrity, searching capabilities, pointer rewiring upon deletion, and correct alphabetical ordering during Merge Sort.

How to Run
This project was packaged using Maven and NetBeans.
1. Open the project in your preferred IDE (NetBeans, IntelliJ, Eclipse, VS Code).
2. Run the `Main.java` class to start the interactive terminal application.
3. To run the automated tests, execute `MainTest.java` via your IDE's Test Runner.
