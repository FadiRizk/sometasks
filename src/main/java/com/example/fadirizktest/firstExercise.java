package com.example.fadirizktest;

public class firstExercise {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("Visual Nuts");
            } else if (i % 3 == 0) {
                System.out.println("Visual");
            } else if (i % 5 == 0) {
                System.out.println("Nuts");
            } else {
                System.out.println(i);
            }
        }
    }
}
//    I will Try to provide a description and analysis of the structure and algorithm of the code:
//    The complexity of the algorithm is O(n), where n is the number of iterations of the for loop (in this case, 100).
//    This means that the time taken by the algorithm is directly proportional to the number of iterations of the loop.
//    The reason for this complexity is that the algorithm has a single for loop that iterates from 1 to 100, and for
//    each iteration, it performs a constant number of operations
//    (three if statements and a call to System.out.println()). Since the number of iterations is fixed (100),
//    the time taken by the algorithm will not increase significantly as the input size increases.
//    In general, an algorithm with complexity O(n) is considered to have good time efficiency, as the time taken by the
//    algorithm grows linearly with the input size. This means that the algorithm will not become significantly slower
//    even if the input size is increased significantly.
//    However, it is worth noting that the actual time taken by the algorithm will depend on various factors, such as
//    the speed of the hardware it is running on, the efficiency of the Java runtime, and the specific operations being
//    performed within the loop.
