# algorithms
A scala project with some basic algorithms

### Common Asymptotic Notations

Asymptotic analysis of an algorithm refers to defining the mathematical boundation/framing of its run-time performance. Using asymptotic analysis, we can very well conclude the best case, average case, and worst case scenario of an algorithm.

Asymptotic analysis is input bound i.e., if there's no input to the algorithm, it is concluded to work in a constant time. Other than the "input" all other factors are considered constant.

Asymptotic analysis refers to computing the running time of any operation in mathematical units of computation. For example, the running time of one operation is computed as f(n) and may be for another operation it is computed as g(n2). This means the first operation running time will increase linearly with the increase in n and the running time of the second operation will increase exponentially when n increases. Similarly, the running time of both operations will be nearly the same if n is significantly small.

Usually, the time required by an algorithm falls under three types −

Best Case − Minimum time required for program execution.

Average Case − Average time required for program execution.

Worst Case − Maximum time required for program execution.

| Time complexity | Notation | Description |
|-----------------|:---------:|:----------:|
| constant        |  Ο(1)   | The algorithm is executed with a constant rate of complexity |
| linear          |  Ο(n)   | The algorithm grows in direct proportion to the size of the input |
| quadratic       |  Ο(n2)  | The algorithm is squared by the size of the input (common in nested loops) |
| cubic           |  Ο(n3)  | The algorithm is cubed by the size of the input (common in nested loops) |
| logarithmic     |  Ο(log n) | The algorithms growth rate is high in early iterations but is drastically reduced on each iteration (common in binary search) |
| n log n         |  Ο(n log n) | The algorithm is random and often peaks early and flattens out (divide and conquer algorithms such as merge sort) |
| polynomial      |  nΟ(1)   | Computing square roots, addition... etc Poloynormial algorithms are fast |
| exponential     |  2Ο(n)   | The algorithms growth rate grows at every iteration. |
