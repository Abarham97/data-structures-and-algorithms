#  Tree-Intersection
find the intersection of two binary trees and return the set of values that are common in both trees. The binary trees are represented by TreeNode objects, and the goal is to implement a function that follows the Single Responsibility Principle, providing clean, reusable, and abstract components to solve the challenge.



## Whiteboard Process
![treeintersection.drawio.png](treeintersection.drawio.png)
## Approach & Efficiency

# Approach
Create a HashSet from One Tree:

Implement a method called buildHashSet that takes a TreeNode as input.
Perform a pre-order traversal of the tree (or any other suitable traversal).
While traversing the tree, store the encountered values in a HashSet.
Return the HashSet containing values from the tree.
Find Common Values:

Implement a method called findCommonValues that takes a TreeNode and a HashSet as input.
Perform a pre-order traversal of the tree (matching the traversal used in buildHashSet).
During traversal, check if the encountered values are present in the HashSet.
If a value is found in the HashSet, add it to another HashSet to store common values.
Return the HashSet containing common values.
Main Intersection Operation:

Create the main treeIntersection method.
Call the buildHashSet method for one of the binary trees to create a HashSet containing its values.
Call the findCommonValues method for the other binary tree, passing the HashSet from step 2 as a parameter.
Return the HashSet containing common values as the result of the intersection.

# Efficiency
time --> o(1)
space --> o (n)
## Solution
![Capture.PNG](Capture.PNG)