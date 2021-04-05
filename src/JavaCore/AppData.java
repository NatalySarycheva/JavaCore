package JavaCore;

import java.io.*;
import java.util.ArrayList;

public class AppData {
    private String[] header;
    private Integer[][] data;

    public AppData() {
        this.header = new String[]{"Value 1", "Value 2", "Value 3"};
        this.data = new Integer[][]{{7, 9, 12}, {2, 4, 8}};
    }

    public void save(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String headerStr = rowToString(header);
            writer.write(headerStr);
            for (Integer[] row : data) {
                String rowStr = rowToString(row);
                writer.write(rowStr);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> String rowToString(T[] row) {
        String result = "";
        for (int i = 0; i < row.length; i++) {
            result += row[i].toString();
            if (i != row.length - 1) {
                result += ";";
            }
        }
        result += "\n";
        return result;
    }

    public void load(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            this.header = stringToHeader(reader.readLine());
            String str;
            ArrayList<Integer[]> data = new ArrayList<>();
            while ((str = reader.readLine()) != null) {
                data.add(stringToRow(str));
            }
            this.data = data.toArray(new Integer[][]{{}});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] stringToHeader(String str) {
        return str.split(";");
    }

    private Integer[] stringToRow(String str) {
        String[] splittedStr = str.split(";");
        ArrayList<Integer> result = new ArrayList<>();
        for (String element:splittedStr) {
            result.add(Integer.valueOf(element));
        }
        return result.toArray(new Integer[]{});
    }
}


