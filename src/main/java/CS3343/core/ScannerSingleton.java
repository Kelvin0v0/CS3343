package CS3343.core;

import java.util.Scanner;

//singleton
public class ScannerSingleton {

    private final static Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return ScannerSingleton.scanner;
    }


}