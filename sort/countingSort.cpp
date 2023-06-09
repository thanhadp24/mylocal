#include <stdio.h>

// Function to perform Counting Sort
void countingSort(int arr[], int n) {
    // Find the maximum element in the array
    int max = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    // Create a count array to store the count of each element
    int count[max + 1];
    for (int i = 0; i <= max; i++) {
        count[i] = 0;
    }

    // Count the occurrences of each element
    for (int i = 0; i < n; i++) {
        count[arr[i]]++;
    }

    // Modify the count array to store the actual position of each element in the sorted array
    for (int i = 1; i <= max; i++) {
        count[i] += count[i - 1];
    }

    // Create a temporary array to store the sorted output
    int output[n];

    // Build the sorted array
    for (int i = n - 1; i >= 0; i--) {
        output[count[arr[i]] - 1] = arr[i];
        count[arr[i]]--;
    }

    // Copy the sorted elements back to the original array
    for (int i = 0; i < n; i++) {
        arr[i] = output[i];
    }
}

// Function to print an array
void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

// Driver code
int main() {
    int arr[] = {4,0, 2, 2, 8, 3, 3, 1};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Original array: ");
    printArray(arr, n);

    countingSort(arr, n);

    printf("Sorted array: ");
    printArray(arr, n);

    return 0;
}
