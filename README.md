# Java Sudoku Game

A desktop Sudoku game implementation with a graphical user interface built using Java Swing.

## Features

- Interactive Sudoku puzzle generator
- User-friendly graphical interface
- Real-time solution validation
- Auto-solve functionality
- Reset option for new puzzles
- Visual distinction between fixed and editable cells
- 3x3 grid highlighting for better visibility

## Components

The project consists of three main classes:

1. `SudokuGUI.java`: Handles the graphical user interface
   - Grid display with 9x9 cells
   - Interactive input cells
   - Control buttons (Check Solution, Solve Puzzle, Reset)
   - Visual styling and user feedback

2. `SudokuGenerator.java`: Manages puzzle generation
   - Creates valid Sudoku puzzles
   - Maintains both the puzzle and its solution
   - Implements puzzle generation algorithms
   - Controls difficulty by removing numbers

3. `SudokuSolver.java`: Implements solving algorithm
   - Uses backtracking algorithm
   - Validates puzzle solutions
   - Provides solution checking functionality

## How to Play

1. Run the application by executing the `SudokuGUI` class
2. Fill in the empty cells with numbers 1-9
3. Use the buttons at the bottom to:
   - Check your solution
   - Automatically solve the puzzle
   - Reset to start a new game

## Controls

- **Check Solution**: Validates your current solution
- **Solve Puzzle**: Automatically fills in the correct solution
- **Reset**: Starts a new game with a fresh puzzle

## Technical Requirements

- Java Runtime Environment (JRE) 8 or higher
- Java Development Kit (JDK) for compilation
- Minimum screen resolution: 600x700 pixels

## Building and Running

1. Compile all Java files:
```bash
javac SudokuGUI.java SudokuGenerator.java SudokuSolver.java
```

2. Run the application:
```bash
java SudokuGUI
```

## Implementation Details

- Grid Size: 9x9
- Default difficulty: 40 cells removed
- GUI built with Java Swing
- Custom styling with distinct borders for 3x3 boxes
- Input validation for numeric entries
- Color coding for fixed and user-input cells

## Future Improvements

- Multiple difficulty levels
- Save/Load game functionality
- Timer feature
- Hint system
- Score tracking
- Custom themes

## License

This project is open source and available under the MIT License.#   S u d o k u G a m e  
 