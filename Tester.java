import java.util.*;
import java.io.*;

public class Tester {
    public static void main(String[] args) throws FileNotFoundException {
        String[] originalWordBank = populateWordBank("dictionary.txt");

        System.out.println("BSI RUNS");
        runBSI(originalWordBank, 1);

        System.out.println("\nMQS RUNS");
        runMQS(originalWordBank, 1);

        String[] sortedWordBank = cloneArray(originalWordBank);
        Sorting.quickSort(sortedWordBank);


        timeSequentialSearch(sortedWordBank, "yellow-earth");
        timeBinarySearch(sortedWordBank, "yellow-earth");

        timeSequentialSearch(sortedWordBank, "AMARyYO");
        timeBinarySearch(sortedWordBank, "AMARyYO");

        timeSequentialSearch(sortedWordBank, "amarillo");
        timeBinarySearch(sortedWordBank, "amarillo");

        timeSequentialSearch(sortedWordBank, "yellow");
        timeBinarySearch(sortedWordBank, "yellow");





    }

    public static void timeSequentialSearch(String[] wordBank, String target) {
        double startTime = System.nanoTime();
        boolean searchResults = sequentialSearchIterative(wordBank, target);
        double endTime = System.nanoTime();

        System.out.println("Sequential Search For: " + target);
        System.out.println("Target Found: " + searchResults);
        System.out.println("Run Time: " + (endTime-startTime) + "\n");


    }

    public static void timeBinarySearch(String[] wordBank, String target) {
        double startTime = System.nanoTime();
        boolean searchResults = binarySearchRecursive(wordBank, target, 0, wordBank.length-1);
        double endTime = System.nanoTime();

        System.out.println("Binary Search For: " + target);
        System.out.println("Target Found: " + searchResults);
        System.out.println("Run Time: " + (endTime-startTime) + "\n");


    }

    public static boolean sequentialSearchIterative(String[] wordBank, String target) {
        for (int i = 0; i < wordBank.length; i++) {
            if (wordBank[i].equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchRecursive(String[] wordBank, String target, int small, int large) {
        if (small <= large) {
            int mid = small + (large - small) / 2;

            if (wordBank[mid].equals(target)) {
                return true;
            }
            else if (wordBank[mid].compareTo(target) > 0) {
                return binarySearchRecursive(wordBank, target, small, mid - 1);
            }
            else {
                return binarySearchRecursive(wordBank, target, mid + 1, large);
            }
        }
        return false;
    }



    public static void runBSI(String[] originalWordBank, int run) {
        if (run >= 3) return;

        String[] bubbleWordBank = cloneArray(originalWordBank);
        String[] selectionWordBank = cloneArray(originalWordBank);
        String[] insertionWordBank = cloneArray(originalWordBank);

        System.out.println("\nRun " + run);

        System.out.println("Bubble Sort Time: " + timeBubbleSort(bubbleWordBank));
        System.out.println("Selection Sort Time: " + timeSelectionSort(selectionWordBank));
        System.out.println("Insertion Sort Time: " + timeInsertionSort(insertionWordBank));

        runBSI(originalWordBank, run + 1);
    }

    public static void runMQS(String[] originalWordBank, int run) {
        if (run >= 51) return;

        String[] mergeWordBank = cloneArray(originalWordBank);
        String[] quickWordBank = cloneArray(originalWordBank);
        String[] shellWordBank = cloneArray(originalWordBank);

        System.out.println("\nRun " + run);

        System.out.println("Merge Sort Time: " + timeMergeSort(mergeWordBank));
        System.out.println("Quick Sort Time: " + timeQuickSort(quickWordBank));
        System.out.println("Shell Sort Time: " + timeShellSort(shellWordBank));

        runMQS(originalWordBank, run + 1);

    }

    public static double timeBubbleSort(String[] wordBank) {
        double startTime = System.nanoTime();
        Sorting.bubbleSort(wordBank);
        double endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static double timeSelectionSort(String[] wordBank) {
        double startTime = System.nanoTime();
        Sorting.selectionSort(wordBank);
        double endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static double timeInsertionSort(String[] wordBank) {
        double startTime = System.nanoTime();
        Sorting.insertionSort(wordBank);
        double endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static double timeMergeSort(String[] wordBank) {
        double startTime = System.nanoTime();
        Sorting.mergeSort(wordBank);
        double endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static double timeQuickSort(String[] wordBank) {
        double startTime = System.nanoTime();
        Sorting.quickSort(wordBank);
        double endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static double timeShellSort(String[] wordBank) {
        double startTime = System.nanoTime();
        Sorting.shellSort(wordBank);
        double endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static int countLines(String fileName) throws FileNotFoundException {
        File dictionary = new File(fileName);
        Scanner fSc = new Scanner(dictionary);
        int numOfLines = 0;

        while (fSc.hasNextLine()) {
            numOfLines++;
            fSc.nextLine();
        }
        return numOfLines;
    }

    public static String[] populateWordBank(String fileName) throws FileNotFoundException {
        File dictionary = new File(fileName);
        Scanner fSc = new Scanner(dictionary);

        String[] wordBank = new String[countLines(fileName)];
//        String[] wordBank = new String[10000];

        for (int i = 0; i < wordBank.length; i++) {
            wordBank[i] = fSc.nextLine();
        }
        return wordBank;
    }

    public static void printArray(String[] wordBank) {
        for (String currentWord : wordBank) {
            System.out.println(currentWord);
        }
    }

    public static String[] cloneArray(String[] arrayIn) {
        String[] arrayOut = new String[arrayIn.length];

        for (int i = 0; i < arrayIn.length; i++) {
            arrayOut[i] = arrayIn[i];
        }
        return arrayOut;
    }
}
