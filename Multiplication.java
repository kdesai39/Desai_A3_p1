import java.security.SecureRandom;
import java.util.Scanner;

public class Multiplication {
    private static Scanner input = new Scanner(System.in);
    private static SecureRandom random = new SecureRandom();

    public static void main (String[] args) {
        int level, problem;
        float correctage;
        while (true) {
            System.out.printf("Enter the difficulty level of problems \n(1. single-digit numbers 2. two-digit numbers \n3. three digit numbers 4. four digit numbers): ");
            level = input.nextInt();
            if (level == 0) {
                break;
            }
            System.out.printf("Enter type of arithmetic problems to solve \n(1. addition problems only 2. subtraction problems only \n3. multiplication problems only 4. division problems only 5. random mixture of problems): ");
            problem = input.nextInt();
            System.out.println("");
            if (problem == 0) {
                break;
            }
            correctage = tenProbs(level, problem);
            if (correctage >= 0.75) {
                System.out.println("Congratulations, you are ready for the next level!");
            } else {
                System.out.println();
                System.out.println("Please ask your teacher for extra help.");
            }
            System.out.println("");
        }
    }


    public static float tenProbs(int level, int problem){
        int first, second, probInstance;
        boolean result;
        int totalCorrect = 0;
        int i;
        for (i = 0; i < 10; i++) {
            first = getRandom(level);
            second = getRandom(level);
            if (problem == 5) {
                probInstance = random.nextInt(3) + 1;
            } else {
                probInstance = problem;
            }
            result = printCompare(first, second, probInstance);
            if (result) {
                totalCorrect += 1;
            }
            while (result == false) {
                result = printCompare(first, second, probInstance);
            }
        }
        return (int) (totalCorrect / 10.0f);
    }

    public static int getRandom ( int difficulty){
        String lmtStr = "";
        for (int i = 0; i < difficulty; i++) {
            lmtStr += "9";
        }
        return random.nextInt(Integer.parseInt(lmtStr)) + 1;
    }

    public static boolean printCompare ( int first, int second, int probInstance){
        int correctAns, userAns;
        boolean result;
        correctAns = printProb(first, second, probInstance);
        userAns = input.nextInt();
        result = compareAns(userAns, correctAns);
        System.out.println(responses(result));
        System.out.println("");
        return result;
    }

    public static int printProb (int first, int second, int problem){
        int correctAns;
        if (problem == 1) {
            System.out.printf(first + " + " + second + " = ");
            correctAns = add(first, second);
        } else if (problem == 2) {
            System.out.printf(first + " - " + second + " = ");
            correctAns = sub(first, second);
        } else if (problem == 3) {
            System.out.printf(first + " * " + second + " = ");
            correctAns = multi(first, second);
        } else {
            System.out.printf(first + " / " + second + " = ");
            correctAns = divi(first, second);
        }
        return correctAns;
    }

    public static String responses ( boolean answerCorrect){
        int numAnswer = random.nextInt(3);
        String[] correctResponses = {"Very good!", "Excellent!", "Nice work!", "Keep up the good work!"};
        String[] wrongResponses = {"No. Please try again.", "Wrong. Try once more.", "Don't give up!", "No. Keep trying."};
        if (answerCorrect) {
            return correctResponses[numAnswer];
        } else {
            return wrongResponses[numAnswer];
        }
    }

    public static int add(int first, int second){
        return first + second;
    }
    public static int sub(int first, int second){
        return first - second;
    }
    public static int multi(int first, int second){
        return first * second;
    }
    public static int divi(int first, int second){
        return first / second;
    }

    public static boolean compareAns(int userAns, int correctAns){
        if(correctAns==userAns){
            return true;
        }
        else{
            return false;
        }
    }
}
