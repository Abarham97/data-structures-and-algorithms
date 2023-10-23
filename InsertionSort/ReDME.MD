## Explaining 
In this article, we will dive into the Insertion Sort algorithm, explore its pseudocode, and provide a visual step-by-step explanation of how it works with various sample arrays. We will also implement this algorithm in Java and create a set of tests to ensure its correctness.


## Insertion Sort Overview
Insertion Sort is a simple comparison-based sorting algorithm that builds the final sorted array one element at a time. It works by taking each element from an unsorted part of the array and inserting it into its correct position in the sorted part. This process continues until the entire array is sorted.

## Pseudocode review 

Insert(int[] sorted, int value)
initialize i to 0
WHILE value > sorted[i]
set i to i + 1
WHILE i < sorted.length
set temp to sorted[i]
set sorted[i] to value
set value to temp
set i to i + 1
append value to sorted

InsertionSort(int[] input)
LET sorted = New Empty Array
sorted[0] = input[0]
FOR i from 1 up to input.length
Insert(sorted, input[i])
return sorted


## Visual Step-Through: [8, 4, 23, 42, 16, 15]

Let's use the sample array [8, 4, 23, 42, 16, 15] to visually demonstrate how Insertion Sort works:

Initial State:
sorted is an empty array.
input is [8, 4, 23, 42, 16, 15].
Iteration 1:
Insert(sorted, 8)
sorted remains [8].
Iteration 2:
Insert(sorted, 4)
sorted becomes [4, 8].
Iteration 3:
Insert(sorted, 23)
sorted becomes [4, 8, 23].
Iteration 4:
Insert(sorted, 42)
sorted becomes [4, 8, 23, 42].
Iteration 5:
Insert(sorted, 16)
sorted becomes [4, 8, 16, 23, 42].
Iteration 6:
Insert(sorted, 15)
sorted becomes [4, 8, 15, 16, 23, 42].
This is the final sorted array.


## Big O Complexity

The time complexity of the Insertion Sort algorithm is O(n^2) in the worst case, where n is the number of elements in the array. This makes it less efficient than some other sorting algorithms for larger datasets. However, it is efficient for small datasets and has the advantage of being an in-place sorting algorithm.

The space complexity of the Insertion Sort algorithm is O(1), which means it uses a constant amount of extra memory space regardless of the size of the input array. This is because it primarily operates on the input array in-place and doesn't require additional data structures or memory allocation that scales with the input size.

In conclusion, Insertion Sort is a straightforward sorting algorithm with a time complexity of O(n^2). It is suitable for small datasets and has the advantage of being in-place. We have visualized its step-by-step execution and provided a working Java implementation with tests to ensure its correctness.





