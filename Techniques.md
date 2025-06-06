Backtracking

Backtracking is a systematic way to try out different sequences or combinations by building the solution incrementally and undoing ("backtracking") the previous step when needed. It’s often used in combinatorial problems (e.g., permutations, combinations, subsets, path finding).



🧠 Core Thinking Pattern:

Choose: Pick a candidate to be part of the solution.
Explore: Recursively explore further with the current choice.
Unchoose (Backtrack): Remove the choice and try the next option.

This gives us a decision tree — where we explore all paths and backtrack when a path is invalid or complete.
