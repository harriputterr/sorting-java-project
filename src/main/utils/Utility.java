package main.utils;

import main.shapes.AbstractShape;
import java.util.Comparator;

public class Utility {

    // Bubble Sort
    public static void bubbleSort(AbstractShape[] arr, Comparator<AbstractShape> comparator) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(arr[j], arr[j+1]) > 0) {
                    AbstractShape temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) break;  // If no swapping was done, the array is already sorted
        }
    }

    // Selection Sort
    public static void selectionSort(AbstractShape[] arr, Comparator<AbstractShape> comparator) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(arr[j], arr[min_idx]) < 0) {
                    min_idx = j;
                }
            }

            AbstractShape temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    public static void insertionSort(AbstractShape[] arr, Comparator<AbstractShape> comparator) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            AbstractShape key = arr[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Merge Sort
    public static void mergeSort(AbstractShape[] arr, Comparator<AbstractShape> comparator) {
        int n = arr.length;
        if (n < 2) return;

        int mid = n / 2;

        AbstractShape[] left = new AbstractShape[mid];
        AbstractShape[] right = new AbstractShape[n - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, n - mid);

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(arr, left, right, comparator);
    }

    private static void merge(AbstractShape[] arr, AbstractShape[] left, AbstractShape[] right, Comparator<AbstractShape> comparator) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Quick Sort
    public static void quickSort(AbstractShape[] arr, Comparator<AbstractShape> comparator) {
        quickSortHelper(arr, 0, arr.length - 1, comparator);
    }

    private static void quickSortHelper(AbstractShape[] arr, int low, int high, Comparator<AbstractShape> comparator) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, comparator);
            quickSortHelper(arr, low, pivotIndex - 1, comparator);
            quickSortHelper(arr, pivotIndex + 1, high, comparator);
        }
    }

    private static int partition(AbstractShape[] arr, int low, int high, Comparator<AbstractShape> comparator) {
        AbstractShape pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (comparator.compare(arr[j], pivot) <= 0) {
                i++;
                AbstractShape temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        AbstractShape temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}

