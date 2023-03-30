import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.List;

public class Main {
    static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        BasicConfigurator.configure();
        logger.warn("Application has started");
        logger.warn("Start sorting data");
        List<String> sortedList = sortList(getList());
        logger.warn("Starting creation of the file");
        createCsvFile(sortedList);
        logger.warn("Application has finished");

    }

    private static List<String> getList() throws FileNotFoundException {

        File file = new File("C:\\Users\\RK445CP\\OneDrive - EY\\Desktop\\exercice1.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines().toList();
    }

    private static List<String> sortList(List<String> list) {
        List<String> sortedList = list.stream().sorted().toList();
        sortedList.forEach(element -> logger.info(element));
        return sortedList;
    }

    private static void createCsvFile(List<String> sortedList) {
        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter("exercice1.csv");

            StringBuilder sb = new StringBuilder();
            sb.append("id");
            sb.append(';');
            sb.append("Word");
            sb.append('\n');

            int index = 1;


            for (String word : sortedList) {
                sb.append(index);
                sb.append(';');
                sb.append(word);
                sb.append('\n');
                index++;
            }

            printWriter.write(sb.toString());
            printWriter.close();


        } catch (FileNotFoundException e) {
            logger.error("File not found exception",e);
        }
    }

}




