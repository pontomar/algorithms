# Algorithms Practice

This repo contains code for the following algorithms & problems: 

### Branch & Bound
💡 Used for combinatorial optimization problems.  
➡️ Bin Packing Problem, Job Scheduling Problem, Traveling Salesman Problem  
ℹ️ It divides the solution space into smaller subproblems and systematically explores it. Before going through all possible options of particular branch, the branch is estimated against the upper / lower estimated bounds on the optimal solution. If it's clear that it can't produce a better solution, the branch is discarded.   

### Fibonacci
🔢 Fibonacci Series: 0, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...  
💡 A Fibonacci x can be calculated with the following formula: Fx = Fx-1 + Fx-2  
💡 In other words: in the Fibonacci Series, the addition of the current and previous number equals the next number.   
💡 Every 3rd number is divisible by two, every 4th number is divisible by 4, etc.

This classic number series is often used to introduce recursion in programming.

### Kruskal
💡 An exact greedy algorithm to find a Minimum Spanning Tree (MST)  
ℹ️ How it works: 
1. Sort all edges by their weights
2. Start iterating by adding the next lowest-weight edge to the solution tree
=> constraint: so that it doesn't form a cycle
🪄 The trick is to assign a root node to each node. Initially each node is its own root. As the first edge is added  
to the solution tree, one of the two nodes becomes the root for the whole solution space and the other node gets assigned that root node. If the nodes of an edge to add
both have the same root node, it is not added to the solution tree as it would form a cycle. If they have different root nodes, we perform a union by setting the root node of one of the nodes to the other and then add the edge to the solution, effectively merging the two sets.
