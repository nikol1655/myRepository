import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Logger logger = Logger.getLogger(Main.class);
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.warn("Application has started");

        long number = 0;
        String userAnswer = "";
        logger.warn("Get sorted list from user");
        List<Long> numbers = getSortedListFromUser(number, userAnswer);
        logger.info("The 3rd decile is: " + countDecile(numbers, 3));
        logger.info("The 6th decile is: " + countDecile(numbers, 6));

        logger.warn("Application has finished");

    }

    private static long countDecile(List<Long> numbers, double decile) {

        int index = (int) Math.ceil(decile / 10 * numbers.size());
        return numbers.get(index - 1);
    }

    private static List<Long> getSortedListFromUser(long number, String userAnswer) {
        List<Long> numbers = new ArrayList<>();
        do {
            logger.info("Type the number from 1 to 1000");
            number = scanner.nextInt();
            if (number >= 1 && number <= 1000) {
                numbers.add(number);
                logger.info("Type END if you want to finish");
                scanner.nextLine();
                userAnswer = scanner.nextLine();
            } else {
                logger.info("You have put the wrong number");
            }

        } while (!userAnswer.equals("END"));

        Collections.sort(numbers);
        return numbers;
    }

}
