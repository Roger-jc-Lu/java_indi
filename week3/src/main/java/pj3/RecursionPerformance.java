package pj3;
import java.util.Scanner;

public final class RecursionPerformance {

    public int fibonacci(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public static void main(String[] args) {

        Runtime run = Runtime.getRuntime();
        run.gc();

        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        RecursionPerformance Fibonacci = new RecursionPerformance();

        long initTime = System.currentTimeMillis();
        long initMem = run.totalMemory() - run.freeMemory();
        System.out.println("start time: " + initTime);
        System.out.println("start total memory: " + run.totalMemory() + "| start free memory: " + run.freeMemory() + "| memory used: " + initMem);

        System.out.println(Fibonacci.fibonacci(n));

        long endTime = System.currentTimeMillis();
        long endMem = run.totalMemory() - run.freeMemory();
        System.out.println("end time: " + endTime);
        System.out.println("end total momory: " + run.totalMemory() + "| end free memory:" + run.freeMemory() + "| memory used:" + endMem);
        System.out.println("total time used = " + (endTime - initTime) + "ms");
        System.out.println("total memory used = " + (endMem - initMem) + "B");
    }
}
