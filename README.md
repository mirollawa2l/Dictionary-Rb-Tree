# Dictionary-Rb-Tree

## Overview

This repository contains a Java-based dictionary application built around a red-black tree style node structure. It includes a simple Swing GUI for inserting and searching words, as well as tools for reading a dictionary file and computing tree metrics such as size, height, and black height.

## Project Structure

- `Dictionary.java` - Console entry point that creates a `Tree`, loads data via `TreeOperation`, and prints tree metrics.
- `Main.java` - Swing GUI application for inserting and searching words and displaying tree statistics.
- `Main.form` - Form file used by NetBeans for the GUI layout.
- `Tree.java` - Simple tree wrapper holding the root node and tree size.
- `TreeOperation.java` - Core tree operations, including search, insertion helpers, rotations, color swaps, and dictionary loading from `Dictionary.txt`.
- `Node.java` - Node representation for tree entries, with color, value, parent, left, and right pointers.

## Features

- Load initial words from `Dictionary.txt` on startup.
- Insert new dictionary words into the tree.
- Search for words case-insensitively.
- Display tree metadata:
  - Tree size
  - Tree height
  - Black height
- Swing-based GUI for easy interaction.

## Requirements

- Java SE Development Kit (JDK) 8 or newer
- A text file named `Dictionary.txt` in the project root containing one word per line

## Build and Run

From the project root folder:

```powershell
javac -d bin Dictionary.java Main.java Node.java Tree.java TreeOperation.java
java -cp bin c.dictionary.Main
```

If you want to run the console entry point instead:

```powershell
java -cp bin c.dictionary.Dictionary
```

## Notes

- The GUI application is the main user-facing entry point.
- `TreeOperation` currently loads words from `Dictionary.txt`, so that file should exist before running the app.
- The repository is structured for use with a Java IDE such as NetBeans, but it can also be compiled and run from the command line.
