import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        long number = 0;
        String userAnswer = "";
        List<Long> numbers = getSortedListFromUser(number, userAnswer);
        System.out.println("The 3rd decile is: " + countDecile(numbers, 3));
        System.out.println("The 6th decile is: " + countDecile(numbers, 6));

    }

    private static long countDecile(List<Long> numbers, double decile) {

        int index = (int) Math.ceil(decile / 10 * numbers.size());
        return numbers.get(index - 1);
    }

    private static List<Long> getSortedListFromUser(long number, String userAnswer) {
        List<Long> numbers = new ArrayList<>();
        do {
            System.out.println("Type the number from 1 to 1000");
            number = scanner.nextInt();
            if (number >= 1 && number <= 1000) {
                numbers.add(number);
                System.out.println("Type END if you want to finish");
                scanner.nextLine();
                userAnswer = scanner.nextLine();
            } else {
                System.out.println("You have put the wrong number");
            }

        } while (!userAnswer.equals("END"));

        Collections.sort(numbers);
        return numbers;
    }

}
