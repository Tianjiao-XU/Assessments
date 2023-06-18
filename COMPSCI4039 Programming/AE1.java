package test;


/*
Non task-specific marks:
 - Add a comment with your name and GUID here - [1 mark]
 - Clear code commenting [1 mark]
 - Use of correct Java variable and method naming conventions [1 mark]
*/

import java.util.Scanner;

public class AE1 {

    public static void main(String[] args) {

        helloWorld();

        /*
         * PLACE YOUR METHOD CALLS HERE
         */

        task1();

        task2(99, 39);
        task2(99, 63);
        task2(99, 98);

        task3(10);

        task4(369);

        task5();

    }

    private static void helloWorld() {
        System.out.println("hello world!");
    }

    public static void printingMethod(String toPrint) {
        System.out.println(toPrint);
    }

    /*
     * PLACE YOUR METHODS HERE
     */

    //TASK1
    public static void task1() {
        System.out.println("TASK1");
        System.out.println("Please enter the length and width: ");

        //Use a scanner to capture input
        Scanner s1 = new Scanner(System.in);
        //Get the length and width of the rectangle
        double length = s1.nextDouble();
        double width = s1.nextDouble();

        //Calculate the area of this rectangle
        double area = length * width;
        System.out.println("the area of this rectangle is " + String.format("%.2f", area) + "(specified to 2 decimal places)" + '\n');
    }


    //TASK2
    public static void task2(int max, int number) {
        System.out.println("TASK2");
        //Initialization
        int count = 0;
        //The value must be odd
        for (int i = 1; i <= max; i += 2) {
            //And the value must be a factor of number.
            if (number % i == 0) {
                //Count the numbers that meet the conditions.
                count++;
            }
        }

        //Output
        System.out.println("the number of odd factors for task2(" + max + "," + number + ") is " + count);
        System.out.print('\n');
    }


    //TASK3
    public static void task3(int challenge) {
        System.out.println("TASK3");
        //Initialization
        int playerPoint = 3;
        int monsterPoint = 3;
        int round = 0;
        int defense = 1;

        //A while loop until either the player or the monster lose all their points
        while (playerPoint > 0 && monsterPoint > 0) {
            //Count the round.
            round++;
            System.out.println("This is round " + round + ", playerPoint is:" + playerPoint + ", monsterPoint is:" + monsterPoint);
            System.out.println("Please enter your number from the dice");

            //Get the number from the dice.
            Scanner s3 = new Scanner(System.in);
            int diceNum = s3.nextInt();

            //If higher than the challenge, then successful in attacking
            if (diceNum > challenge) {
                monsterPoint--;
            }
            //If roll less than or the value of challenge, the monster will attack.
            else if (defense == 0) {
                playerPoint--;
            } else {
                //When fail for the first time the monster will miss.
                defense--;
                System.out.println("You fail for the first time and will not lose a point");
            }
        }

        //Game over
        if (playerPoint == 0) {
            System.out.println("You lose!" + '\n');
        } else {
            System.out.println("You win!" + '\n');
        }
    }


    //TASK4
    public static void task4(int secretNum) {
        System.out.println("TASK4");
        int differ = 1;

        //Game will not over until you guess correctly
        while (differ > 0) {
            System.out.println("Please enter two numbers separated by spaces");

            //Initialization
            int validity = 0;
            int num1 = 0;
            int num2 = 0;

            //Use a scanner to capture input
            while (validity == 0) {
                Scanner s = new Scanner(System.in);
                String readString = s.nextLine();
                Scanner s4 = new Scanner(System.in);
                s4 = new Scanner(readString);

                //Two numbers separated by spaces
                if (!s4.hasNextInt()) {
                    System.out.println("ERROR!You have entered 0 number!Please re-enter!");
                } else {
                    num1 = s4.nextInt();
                    if (!s4.hasNextInt()) {
                        System.out.println("ERROR!You have entered 1 number!Please re-enter!");
                    } else {
                        num2 = s4.nextInt();
                        if (!s4.hasNextInt()) {
                            //Correct input
                            validity = 1;
                        } else {
                            System.out.println("ERROR!More than 2 numbers!Please re-enter!");
                        }
                    }
                }
            }

            //Calculate difference
            int differ1 = num1 - secretNum;
            //Difference is positive
            if (differ1 < 0) {
                differ1 = -differ1;
            }
            int differ2 = num2 - secretNum;
            if (differ2 < 0) {
                differ2 = -differ2;
            }

            //Get the smaller difference
            differ = differ1;
            if (differ2 < differ) {
                differ = differ2;
            }

            //Output the result
            if (differ == 0) {
                System.out.println("You are right, the secret number is " + secretNum + '\n');
            } else {
                System.out.println("You are " + String.format("%03d", differ) + " away from the secret number!");
            }
        }
    }


    //TASK5
    public static void task5() {
        System.out.println("TASK5");

        //Initialization
        int validity = 0;
        int rows = 5;
        int columns = 5;

        //The method should accept values between 5 and 10 for the rows and columns
        while (validity == 0) {
            System.out.println("Please enter the rows and columns: ");
            Scanner s5 = new Scanner(System.in);
            rows = s5.nextInt();
            columns = s5.nextInt();
            if (rows >= 5 && rows <= 10 && columns >= 5 && columns <= 10) {
                System.out.println("OK!Rows and columns are between 5 and 10!");
                validity = 1;
            } else {
                System.out.println("Values should be between 5 and 10,please re-enter!");
            }
        }

        //3 mines were specified at 1,2 and 4,1 and 5,5
        int x1 = 1, y1 = 2;
        int x2 = 4, y2 = 1;
        int x3 = 5, y3 = 5;
        System.out.println("The mines are in (" + x1 + "," + y1 + "),(" + x2 + "," + y2 + "),(" + x3 + "," + y3 + ")");
        System.out.println("Here is the table:");

        //The 1st row of the tabel
        System.out.print("|");
        for (int i = 1; i <= columns; i++) {
            System.out.print(String.format("%3d", i));
        }
        System.out.print('\n');

        //The 2nd row of the tabel
        System.out.print("|");
        for (int i = 1; i <= columns; i++) {
            System.out.print(String.format("%3s", "-"));
        }
        System.out.print('\n');

        //The main part of the tabel
        for (int j = 1; j <= rows; j++) {
            System.out.print(j + " |");
            for (int i = 1; i <= columns; i++) {
                if ((j == x1 && i == y1) || (j == x2 && i == y2) || (j == x3 && i == y3)) {
                    //use String.format() in this task
                    System.out.print(String.format("%3s", "x"));
                } else {
                    System.out.print(String.format("%3s", "o"));
                }
            }
            System.out.print('\n');
            System.out.print('\n');
        }
    }

}
