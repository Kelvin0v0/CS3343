package CS3343.core;

import java.util.Scanner;

public class UsefulFuncs{

    public static char CharMenu(String values){     //function that makes sure user input is in the menu e.g. Menu = ('Q:quit,E:Exit') -> pass string "QE"
        Scanner scan = ScannerSingleton.getScanner();
        String in;
        char ch;
        while(true){
            in = scan.next();
            if(in.length()>1){
                System.out.println("Invalid Input");
                continue;
            }
            ch = in.charAt(0);
            for(int i=0;i<values.length();i++){
                if(ch == values.charAt(i)){
                    return ch;
                }
            }
        }
    }

    public static int IntMenu(int min, int max){  //similar to above - checks if input integer for a menu is in desired range
        Scanner scan = ScannerSingleton.getScanner();
        int in;
        while(true){
            in = scan.nextInt();
            if(in>=min && in<=max){
                return in;
            }
        }
    }
}