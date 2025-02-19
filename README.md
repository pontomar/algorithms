# Algorithms Practice

This repo contains code for the following algorithms: 

### Branch & Bound
💡 Used for combinatorial optimization problems.  
➡️ Bin Packing Problem, Job Scheduling Problem, Traveling Salesman Problem  
ℹ️ It divides the solution space into smaller subproblems and systematically explores it. Before going through all possible options of particular branch, the branch is estimated against the upper / lower estimated bounds on the optimal solution. If it's clear that it can't produce a better solution, the branch is discarded.   
🛄 My implementation solves the problem of optimally packing suitcases so that the number of suitcases is minimized while staying within the airline's weight limit.
