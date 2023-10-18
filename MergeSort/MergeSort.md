## Understanding Merge Sort

Merge Sort is a popular divide and conquer algorithm used for sorting arrays. It works by recursively dividing the unsorted list into smaller sublists until each sublist contains a single element. Then, it merges these sublists back together in a sorted order. The key idea is that merging two sorted lists into one is a much simpler operation than sorting an unsorted list.

## walk through pseudo code visually

Let's walk through the provided pseudocode and visually demonstrate the process of using Merge Sort on the input array [8, 4, 23, 42, 16, 15].

Step 1: Splitting the Array
The first step is to divide the array into smaller subarrays until each subarray has a single element. This is done recursively.

Input Array: [8, 4, 23, 42, 16, 15]

Split into [8, 4, 23] and [42, 16, 15]
Step 2: Further Splitting
Now, we continue to split the subarrays into smaller parts.

Subarray 1: [8, 4, 23]

Split into [8] and [4, 23]
Subarray 2: [42, 16, 15]

Split into [42] and [16, 15]
Step 3: Merging
Now, we start merging the sorted subarrays back together.

Subarray 1: [8]
Subarray 2: [4, 23]

Merge them into [4, 8, 23]
Subarray 3: [42]
Subarray 4: [16, 15]

Merge them into [15, 16, 42]
Step 4: Final Merge
Finally, we merge the two larger subarrays into a sorted array.

Subarray 1: [4, 8, 23]
Subarray 2: [15, 16, 42]

Merge them into the final sorted array [4, 8, 15, 16, 23, 42]
This visual representation demonstrates how Merge Sort recursively divides and conquers the array to sort it efficiently.

