package JavaCore;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AppData appData = new AppData();
        appData.save("appData.csv");
        appData.load("appData.csv");
    }
}
