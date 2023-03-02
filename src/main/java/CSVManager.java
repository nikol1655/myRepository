import java.io.*;
import java.util.List;

public class CSVManager {

    public void startCSVOperations(){
        try {
            List<String> sortedList = sortList(getList());
            createCsvFile(sortedList);
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<String> sortList(List<String> list) {
        List<String> sortedList = list.stream().sorted().toList();
        sortedList.forEach(System.out::println);
        return sortedList;
    }

    private List<String> getList() throws FileNotFoundException {
        File file = new File("C:\\Users\\RK445CP\\OneDrive - EY\\Desktop\\exercice1.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines().toList();
    }



    private void createCsvFile(List<String> sortedList) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("exercice1.csv");

            fileWriter.append("id");
            fileWriter.append(',');
            fileWriter.append("Word");
            fileWriter.append('\n');

            int index = 1;


            for (String word : sortedList) {
                fileWriter.append((char) index);
                fileWriter.append(',');
                fileWriter.append(word);
                fileWriter.append('\n');
                index++;
            }

            fileWriter.write(fileWriter.toString());
            fileWriter.flush();
            fileWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
