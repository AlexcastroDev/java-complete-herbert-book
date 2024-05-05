public class PrimitiveOptimization {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        double sum = 0.0;
        for (int i = 0; i < 1000000; i++) {
            sum += Math.sqrt(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Sum: " + sum);
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
    }
}
