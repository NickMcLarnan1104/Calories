     /*
        Nick McLarnan
        Assignment 6
        This assignment uses everything we've learned so far and creates a real world application
        10/13/2022
     */
    // this program takes input from the user and returns how many calories needed to either lose weight or gain muscle

public class Calories {

    // instance variables
    private int age, gender, activity;
    private String name;
    private double bmr, calories, weight, height;

    // constructor
    public Calories(int age, double weight, double height, String name, int gender, int activity) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.name = name;
        this.gender = gender;
        this.activity = activity;
    }

    // getters and setters
    void setAge(int age) {
        this.age = age;
    }
    int getAge() {
        return age;
    }

    void setWeight(double weight) {
        this.weight = weight;
    }
    double getWeight() {
        return weight;
    }

    void setHeight(double height) {
        this.height = height;
    }
    double getHeight() {
        return height;
    }
    
    void setName(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }

    void setGender(int gender) {
        this.gender = gender;
    }
    int getGender() {
        return gender;
    }

    void setActivity(int activity) {
        this.activity = activity;
    }
    int getActivity() {
        return activity;
    }

    // calculation methods
    // this method determines your BMR, which is the natural amount of calories your body burns without determining your activity levels
    double getBMR(int gender, double weight, double height, int age) {
        // loop
        while(true) {
            // conditionals
            if(gender == 1) {
                // for men
                bmr = 66.5 + (13.75 * weight) + (5.003 * height) - (6.75 * age);
                break;
            } else if(gender == 2) {
                bmr = 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age);
                break;
            } else {
                System.out.println("Please enter a correct gender.");
                continue;
            }
        }
        // return value
        return bmr;
    }

    // calculates how many calories per day you should be consuming taking into account activity levels
    // uses if statements to determine
    double getCaloriesPerDay(double bmr, int activity) {
        while(true) {
            if(activity == 1) {
                // sedentary
                calories = bmr * 1.2;
                break;
            } else if(activity == 2) {
                // lightly active
                calories = bmr * 1.375;
                break;
            } else if(activity == 3) {
                // moderately active
                calories = bmr * 1.55;
                break;
            } else if(activity == 4) {
                // very active
                calories = bmr * 1.725;
                break;
            } else if(activity == 5) {
                // extremely active
                calories = bmr * 1.9;
                break;
            } else {
                // incorrect choice
                System.out.println("Please enter a valid choice.");
                continue;
            }
        }
        // return value
        return calories;
    } // end main method

    // these two methods take how many calories you need in the day and subtracts/adds a specific amount to determine how many
    // calories needed to gain muscle and lose weight.
    static double caloriesToLoseWeight(double calories) {
        // return value
        return calories - 650;
    }
    static double caloriesToGainMuslce(double calories) {
        // return value
        return calories + 500;
    }
    // method with no parameters
    static void displayCalorieInformation() {
        System.out.println("\n\t-- Welcome to Nick's Calorie Calculator --\n");
        System.out.println("\t- Your basal metabolic rate(BMR) is the amount of energy needed for your body to function.");
        System.out.println("\t- Your BMR multiplied by your activity levels determines how many calories you need daily.");
        System.out.println("\t- Your calories subtracted by 650 is how many calories you need to burn weight in a healthy way.");
        System.out.println("\t- Your calories added by 500 is how many calories you need to gain muscle.");
        System.out.println("\nEnter some basic information.\n");
    }

} // end class

// END PROGRAM