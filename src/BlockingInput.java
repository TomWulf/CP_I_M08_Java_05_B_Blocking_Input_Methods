import java.util.Scanner;

public class BlockingInput {
    public static void main(String[] args) {

        /**
         * Design constraints for our SafeInput file of Static Methods
         *
         * All methods block and repeat until they get a valid input
         *
         * We pass in the Scanner - we will call that parameter pipe
         * We usually have a String prompt next
         * then we have a numeric low and high range values OR
         * a RegEx String pattern to test the input against
         *  public static TYPE METHOD_NAME( Param list TYPE:ParamName
         *
         *  public static String getNonZeroLengthString(Scanner pipe, String prompt)
         *
         *  public static int getInt(Scanner pipe, String prompt)
         *  public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
         */


        // Here (in main) is where we test our methods
        Scanner in = new Scanner(System.in);

        String userName = getNonZeroLengthString(in, "Enter you user name");
        System.out.println("\nYou said your name is: " + userName);

        int ageAny = getint(in, "enter your age");
        System.out.println("\nYou said your age is: " + ageAny);

        int favNum = getRangedInt(in, "Enter your favorite number", 1,10);
        System.out.println("\nYou said your favorite number is: " + favNum);
    }

    /**
     * Gets a String from the user that has to be at least one character or more
     *
     * @param pipe Scanner to use for input set to the console with System.in
     * @param prompt the prompt for the user the methods adds the ": " and uses System.print
     *               ranged methods get a "..[low - high]: "
     * @return  After looping until the user enters something a non zero String...
     */
    public static String getNonZeroLengthString(Scanner pipe, String prompt)
    {
        String nonZeroLength = "";

        do{
            System.out.print("\n" + prompt + ": ");
            nonZeroLength = pipe.nextLine();

        }while (nonZeroLength.length() == 0 );

        return nonZeroLength;
    }

    /**
     * Get an integer value from the user with no constraints
     *
     *
     * @param pipe Scanner to use for input
     * @param prompt User prompt
     * @return an int value provided by the user
     */
    public static int getint(Scanner pipe, String prompt)
    {
        int retValue = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                pipe.nextLine(); // clear key buffer
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid number not: " + trash);
            }
        }while (!done);

        return retValue;
    }

    /**
     * Get an integer value from the user within a speciied inclusive low - high range
     *
     *
     * @param pipe Scanner to use for input
     * @param prompt User prompt
     * @param low    low value for the range
     * @param high   high value for the range
     * @return an int value provided by the user within the specified range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retValue = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                pipe.nextLine(); // clear key buffer
                if(retValue >= low && retValue <= high)
                   done = true;
                else
                    System.out.println("\nNumber is out of range [" + low + " - " + high + "] not: " + retValue);
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid number not: " + trash);
            }
        }while (!done);

        return retValue;
    }



} // End of Class no code after this !!!