import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGUI extends JFrame {
    private static final int SIZE = 9;
    private JTextField[][] cells = new JTextField[SIZE][SIZE];
    private SudokuGenerator generator = new SudokuGenerator();

    public SudokuGUI() {
        setTitle("Sudoku Game");
        setSize(600, 700);  // Adjusted to make it more spacious
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main panel to hold the grid and buttons
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10)); // Add space between the components
        mainPanel.setBackground(new Color(240, 240, 240)); // Background color for the main panel
        add(mainPanel, BorderLayout.CENTER);

        // Sudoku Grid Panel
        JPanel gridPanel = new JPanel(new GridLayout(SIZE, SIZE));
        gridPanel.setBackground(Color.WHITE);

        Font font = new Font("Arial", Font.BOLD, 20);
        
        // Create grid cells with individual borders for visual separation
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // First create the JTextField
                cells[row][col] = new JTextField();
                
                // Then set all its properties
                cells[row][col].setHorizontalAlignment(JTextField.CENTER);
                cells[row][col].setFont(font);
                cells[row][col].setPreferredSize(new Dimension(60, 60));
                cells[row][col].setMargin(new Insets(0, 0, 0, 0));

                // Create borders based on position
                int top = (row % 3 == 0) ? 3 : 1;
                int left = (col % 3 == 0) ? 3 : 1;
                int bottom = (row == SIZE-1 || row % 3 == 2) ? 3 : 1;
                int right = (col == SIZE-1 || col % 3 == 2) ? 3 : 1;
                
                cells[row][col].setBorder(BorderFactory.createMatteBorder(
                    top,    // top
                    left,   // left
                    bottom, // bottom
                    right,  // right
                    Color.BLACK
                ));

                // Set the pre-filled numbers (based on generator)
                if (generator.getBoard()[row][col] != 0) {
                    cells[row][col].setText(String.valueOf(generator.getBoard()[row][col]));
                    cells[row][col].setEditable(false);
                    cells[row][col].setBackground(new Color(240, 240, 240)); // Light gray for fixed cells
                }

                gridPanel.add(cells[row][col]);
            }
        }

        mainPanel.add(gridPanel, BorderLayout.CENTER);

        // Button Panel (Improved layout and spacing)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Center buttons and add spacing
        buttonPanel.setBackground(new Color(240, 240, 240)); // Match the main panel background color

        JButton checkButton = new JButton("Check Solution");
        JButton solveButton = new JButton("Solve Puzzle");
        JButton resetButton = new JButton("Reset");

        // Style buttons with padding, borders, and hover effect
        styleButton(checkButton);
        styleButton(solveButton);
        styleButton(resetButton);

        // Check Button Action
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSudokuSolvedCorrectly()) {
                    JOptionPane.showMessageDialog(null, "Congratulations! Solution is correct!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Oops! The solution is incorrect.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Solve Button Action (Solves the puzzle immediately)
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solvePuzzle();
            }
        });

        // Reset Button Action
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SudokuGUI();
            }
        });

        // Add buttons to the panel
        buttonPanel.add(checkButton);
        buttonPanel.add(solveButton);
        buttonPanel.add(resetButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    // Function to check if the Sudoku is solved correctly
    private boolean isSudokuSolvedCorrectly() {
        int[][] correctBoard = generator.getSolution(); // Get the solved board

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                try {
                    int value = Integer.parseInt(cells[row][col].getText());
                    if (value != correctBoard[row][col]) {
                        return false; // Incorrect solution
                    }
                } catch (NumberFormatException e) {
                    return false; // Non-numeric input
                }
            }
        }
        return true;
    }

    // Function to solve the puzzle instantly
    private void solvePuzzle() {
        int[][] solution = generator.getSolution();
        
        // Fill the grid with the solution values
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col].setText(String.valueOf(solution[row][col]));
                cells[row][col].setEditable(false);  // Make the cells non-editable after solving
                cells[row][col].setBackground(new Color(200, 200, 200)); // Gray for fixed cells
            }
        }
    }

    // Button style method for consistent appearance
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(255, 165, 0)); // Orange color for buttons
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(150, 40)); // Consistent button size
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Border for buttons
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Add hover effect for the buttons
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(255, 140, 0)); // Darker shade on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(255, 165, 0)); // Original color
            }
        });
    }

    public static void main(String[] args) {
        new SudokuGUI();
    }
}
