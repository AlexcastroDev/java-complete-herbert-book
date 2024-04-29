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

class Light {
    public static void main(String[] args) {
        int lightspeed;
        long days;
        long seconds;
        long distance;

        // approximate speed of light in miles per second
        lightspeed = 186000;
        days = 1000; // specify number of days here
        seconds = days * 24 * 60 * 60; // convert to seconds
        distance = lightspeed * seconds; // compute distance

        System.out.print("In " + days);
        System.out.print(" days light will travel about ");
        System.out.println(distance + " miles.");
    }
}