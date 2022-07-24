public class Sorting {
    public static void bubbleSort(String[] wordBank) {
        for (int i = 0; i < wordBank.length; i++) {
            for (int j = 0; j < wordBank.length - 1 - i; j++) {
                if (wordBank[j+1].compareTo(wordBank[j]) < 0) {
                    String temp = wordBank[j];
                    wordBank[j] = wordBank[j+1];
                    wordBank[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(String[] wordBank) {
        for (int i = 0; i < wordBank.length - 1; i++) {
            int indexSmallest = i;

            for (int j = i + 1; j < wordBank.length; j++) {
                if (wordBank[j].compareTo(wordBank[indexSmallest]) < 0) {
                    indexSmallest = j;
                }
            }
            String temp = wordBank[i];
            wordBank[i] = wordBank[indexSmallest];
            wordBank[indexSmallest] = temp;
        }
    }

    public static void insertionSort(String[] wordBank) {
        for (int i = 1; i < wordBank.length; i++) {
            int j = i;

            while (j > 0 && (wordBank[j].compareTo(wordBank[j-1]) < 0)) {
                String temp = wordBank[j];
                wordBank[j] = wordBank[j-1];
                wordBank[j-1] = temp;
                j--;
            }
        }
    }

    public static void mergeSort(String[] wordBank) {
        mergeSort(wordBank, 0, wordBank.length-1);
    }

    private static void mergeSort(String[] wordBank, int i, int k) {
        int j = 0;

        if (i < k) {
            j = (i + k) / 2;

            mergeSort(wordBank, i, j);
            mergeSort(wordBank, j+1, k);

            merge(wordBank, i, j, k);
        }
    }

    private static void merge(String[] wordBank, int i, int j, int k) {
        int mergeSize = k - i + 1;

        String[] mergeArray = new String[mergeSize];

        int mergePos;

        int leftPos;
        int rightPos;

        mergePos = 0;
        leftPos = i;
        rightPos = j + 1;

        while (leftPos <= j && rightPos <= k) {
            if (wordBank[leftPos].compareTo(wordBank[rightPos]) < 0) {
                mergeArray[mergePos] = wordBank[leftPos];
                leftPos++;
            }
            else {
                mergeArray[mergePos] = wordBank[rightPos];
                rightPos++;
            }
            mergePos++;
        }

        while (leftPos <= j) {
            mergeArray[mergePos] = wordBank[leftPos];
            ++leftPos;
            ++mergePos;
        }

        while (rightPos <= k) {
            mergeArray[mergePos] = wordBank[rightPos];
            ++rightPos;
            ++mergePos;
        }

        for (mergePos = 0; mergePos < mergeSize; ++mergePos) {
            wordBank[i + mergePos] = mergeArray[mergePos];
        }
    }

    public static void quickSort(String[] wordBank) {
        quickSort(wordBank, 0, wordBank.length - 1);
    }

    private static void quickSort(String[] wordBank, int first, int last) {
        if (first >= last) {
            return;
        }

        int p = partition(wordBank, first, last);

        quickSort(wordBank, first, p - 1);

        quickSort(wordBank, p + 1, last);
    }

    private static int partition(String[] wordBank, int first, int last) {
        String pivot = wordBank[last];
        int i = first - 1;

        for (int j = first; j < last; j++) {
            if ((wordBank[j].compareTo(pivot) < 0) || (wordBank[j].compareTo(pivot) == 0)) {
                i++;
                String temp = wordBank[i];
                wordBank[i] = wordBank[j];
                wordBank[j] = temp;
            }
        }

        String temp = wordBank[i+1];
        wordBank[i+1] = wordBank[last];
        wordBank[last] = temp;
        return i + 1;
    }

    public static void shellSort(String[] wordBank) {
        int increment = wordBank.length / 2;

        while (increment > 0) {
            for (int i = increment; i < wordBank.length; i++) {
                int j = i;
                String temp = wordBank[i];

                while (j >= increment && (wordBank[j - increment].compareTo(temp) > 0)) {
                    wordBank[j] = wordBank[j-increment];
                    j = j - increment;
                }
                wordBank[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            }
            else {
                increment *= (5.0/11);
            }
        }
    }

}
