package project;

import java.awt.*;
import java.awt.event.*;

class Sorting extends SortingAlgorithm {
    void displayarray(int[] arr, TextArea output) {
        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            sb.append(val).append(" ");
        }
        output.append(sb.toString().trim() + "\n");
    }
}

public class SortingUI extends Frame {
    private TextField inputField;
    private TextArea outputArea;
    private Button bubbleButton, mergeButton, quickButton, selectionButton, insertionButton, clearButton;
    private Sorting sorter;

    public SortingUI() {
        sorter = new Sorting();

        setTitle("Sorting Algorithms");
        setSize(550, 350); 
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.LIGHT_GRAY);

        Panel inputPanel = new Panel(new BorderLayout());
        Label inputLabel = new Label("Enter numbers (comma-separated):");
        inputField = new TextField("", 40); 
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputField, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);

        outputArea = new TextArea(8, 50);
        outputArea.setEditable(false);
        add(outputArea, BorderLayout.CENTER);

        
        Panel buttonPanel = new Panel(new GridLayout(6, 1, 5, 5)); 
        bubbleButton = new Button("Bubble Sort");
        mergeButton = new Button("Merge Sort");
        quickButton = new Button("Quick Sort");
        selectionButton = new Button("Selection Sort");
        insertionButton = new Button("Insertion Sort");
        clearButton = new Button("Clear");

        bubbleButton.addActionListener(e -> sortAndDisplay("Bubble Sort"));
        mergeButton.addActionListener(e -> sortAndDisplay("Merge Sort"));
        quickButton.addActionListener(e -> sortAndDisplay("Quick Sort"));
        selectionButton.addActionListener(e -> sortAndDisplay("Selection Sort"));
        insertionButton.addActionListener(e -> sortAndDisplay("Insertion Sort"));
        clearButton.addActionListener(e -> {
            inputField.setText("");
            outputArea.setText("");
        });

        buttonPanel.add(bubbleButton);
        buttonPanel.add(mergeButton);
        buttonPanel.add(quickButton);
        buttonPanel.add(selectionButton);
        buttonPanel.add(insertionButton);
        buttonPanel.add(clearButton);
        add(buttonPanel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });

        setResizable(false); 
        setVisible(true);
    }

    private void sortAndDisplay(String algorithm) {
        try {
            String input = inputField.getText().trim();
            if (input.isEmpty()) {
                outputArea.setText("Error: Please enter numbers.\n");
                return;
            }

            String[] numbers = input.split(",");
            int[] arr = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                arr[i] = Integer.parseInt(numbers[i].trim());
            }

            int[] arrCopy = arr.clone();

            switch (algorithm) {
                case "Bubble Sort":
                    sorter.BubbleSort(arrCopy);
                    break;
                case "Merge Sort":
                    sorter.MergeSort(arrCopy, 0, arrCopy.length - 1);
                    break;
                case "Quick Sort":
                    sorter.PartitionSort(arrCopy, 0, arrCopy.length - 1);
                    break;
                case "Selection Sort":
                    sorter.SelectionSort(arrCopy);
                    break;
                case "Insertion Sort":
                    sorter.InsertionSort(arrCopy);
                    break;
            }

            outputArea.append("Sorted Array (" + algorithm + "):\n");
            sorter.displayarray(arrCopy, outputArea);

        } catch (NumberFormatException ex) {
            outputArea.setText("Error: Please enter valid numbers.\n");
        } catch (Exception ex) {
            outputArea.setText("Error: An unexpected error occurred.\n");
        }
    }

    public static void main(String[] args) {
        new SortingUI();
    }
}
