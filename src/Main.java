public class Main {
    public static void main(String[] args) {
        // Declare a variable called num
        int num;

        // Assign a value to num
        num = 100;
        System.out.println("This is num: " + num);

        // I can reassign the value of num
        num = num * 2;

        // Print the value of num
        // Here the num variable is being concatenated with the string
        // but only the value of num will be printed
        System.out.print("The value of num * 2 is " + num);
    }
}