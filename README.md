# 🎮 Java Sudoku Game

<div align="center">

![Sudoku Game](https://img.shields.io/badge/Game-Sudoku-blue)
![Language](https://img.shields.io/badge/Language-Java-orange)
![GUI](https://img.shields.io/badge/GUI-Swing-green)
![License](https://img.shields.io/badge/License-MIT-yellow)

A classic Sudoku puzzle game with a modern interface, built using Java Swing.
</div>

---

## 🌟 Features

- 📋 Interactive 9x9 Sudoku grid
- 🎨 Clean and intuitive user interface
- ✨ Real-time validation of moves
- 🔄 Auto-solve functionality
- 🎯 Multiple difficulty levels
- 🎨 Visual cell highlighting
- 🔍 Error checking system

## 🎯 Game Rules

1. Fill the 9×9 grid with numbers from 1-9
2. Each row must contain numbers 1-9 without repetition
3. Each column must contain numbers 1-9 without repetition
4. Each 3×3 box must contain numbers 1-9 without repetition

## 🚀 Getting Started

### Prerequisites

- Java Runtime Environment (JRE) 8 or higher
- Java Development Kit (JDK) for compilation
- Minimum screen resolution: 600x700 pixels

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/sudoku-game.git
```

2. Navigate to the project directory:
```bash
cd sudoku-game
```

3. Compile the source files:
```bash
javac SudokuGUI.java SudokuGenerator.java SudokuSolver.java
```

4. Run the game:
```bash
java SudokuGUI
```

## 🎮 How to Play

1. Launch the game
2. Enter numbers (1-9) in empty cells
3. Use the control buttons:
   - ✅ **Check Solution**: Validates your current progress
   - 🔄 **Solve**: Reveals the complete solution
   - 🆕 **Reset**: Starts a new game

## 🏗️ Project Structure

```
sudoku-game/
│
├── src/
│   ├── SudokuGUI.java        # Main GUI implementation
│   ├── SudokuGenerator.java  # Puzzle generation logic
│   └── SudokuSolver.java     # Solution verification
│
└── README.md
```

## 🛠️ Technical Details

- **Language**: Java
- **GUI Framework**: Swing
- **Grid Size**: 9x9
- **Input Validation**: Real-time number checking
- **Visual Features**:
  - Distinct 3x3 box borders
  - Highlighted fixed cells
  - Error indication
  - Clean modern interface

## 🎯 Future Enhancements

- [ ] Multiple difficulty levels
- [ ] Save/Load game functionality
- [ ] Timer feature
- [ ] Hint system
- [ ] Score tracking
- [ ] Custom themes
- [ ] Undo/Redo functionality

## 👥 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

