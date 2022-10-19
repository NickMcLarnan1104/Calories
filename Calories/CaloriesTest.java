    /*
        Nick McLarnan
        Assignment 6
        This assignment uses everything we've learned so far and creates a real world application
        10/13/2022
        .
     */

// import scanner
import java.util.Scanner;

// create class
public class CaloriesTest {
    // create main method
    public static void main(String[] args) {

        // create a scanner object
        Scanner in = new Scanner(System.in);

        // method with no arguments that displays information on brm
        Calories.displayCalorieInformation();

        // loop - ask user information
        while(true) {
            System.out.print("\nName: ");
            String name = in.nextLine();

            System.out.print("Weight(kilograms): ");
            double weight = in.nextDouble();

            System.out.print("Height(centimeters): ");
            double height = in.nextDouble();

            System.out.print("Age: ");
            int age = in.nextInt();
            in.nextLine(); // needed to prevent error in input
            
            System.out.print("Gender(1 for male, 2 for female): ");
            int gender = in.nextInt();
            in.nextLine(); // needed to prevent error in input

            System.out.print("Activity Level: \n\t1 for Sedentary\n\t" +
                                                "2 for Lightly active\n\t" +
                                                "3 for Moderately active\n\t" +
                                                "4 for Very active\n\t" +
                                                "5 for Extra active\n"
                                                );
            int activity = in.nextInt();
            in.nextLine(); // needed to prevent error in input

            // input data into constructor
            Calories user = new Calories(age, weight, height, name, gender, activity);

            // nonstatic methods using object to call
            double dailyBrm = user.getBMR(gender, weight, height, age);
            double dailyCalories = user.getCaloriesPerDay(dailyBrm, activity);
            System.out.printf("\n-- Hello, %s! --%n", user.getName());
            System.out.printf("\n- Your basal metabolic rate is: %,.2f calories per day.%n", dailyBrm);
            System.out.printf("- You need to consume %,.2f calories per day to maintain weight.%n", dailyCalories);
            
            // loop
            while(true) {
                System.out.print("\nEnter 1 to check weight loss, 2 for muslce gain, 0 to input another person: ");
                int healthPicker = in.nextInt();
                in.nextLine(); // needed to prevent error in input

                // methods below are static, uses class to call
                // conditional
                if(healthPicker == 1) {
                    System.out.printf("\n\tYou need to consume %,.2f calories a day to lose weight in a healthy way.%n", Calories.caloriesToLoseWeight(dailyCalories));
                } else if(healthPicker == 2) {
                    System.out.printf("\n\tYou need to consume %,.2f calories a day to gain weight in muscle.%n", Calories.caloriesToGainMuslce(dailyCalories));
                } else if(healthPicker == 0) {
                    break;
                }
            }

            // ask to do outer loop again
            System.out.print("\nPress 1 to enter another person or any other number to quit: ");
            int again = in.nextInt();
            in.nextLine(); // needed to prevent error in input
            // conditional
            if(again == 1) {
                continue;
            } else {
                break;
            }
        }
        // final message
        System.out.println("\nThank you for using my program!");
        in.close(); // close input
    } // end main method
} // end class

// END PROGRAM