package com.l7.compiler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BaseCompiler {
    private static String fileName = "Demo";

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName + ".java");
            Scanner sc = new Scanner(fileInputStream);
            ArrayList<String> listLine = new ArrayList<>();
            do {
                listLine.add(sc.nextLine());
            } while (sc.hasNextLine());
            processFile(listLine);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * using Lambda Expressions
     * @param listLines
     */
    private static void processFile(ArrayList<String> listLines) {
        int varCount =0;
        int constCount=0;
        int methCount=0;
        varCount+=(int) listLines.stream()
                .filter(s ->Pattern
                        .matches("(private)?(protected)?(public)? " +
                                "(int)?(String)?(boolean)?(byte)?(long)?(char)? [a-zA-Z]+;",s.trim()))
                .count();

        constCount+=(int) listLines.stream()
                .filter(s ->Pattern
                        .matches("(private)?(protected)?(public)? " +
                                "class "+fileName
                                +"\\("+"(int [a-zA-Z]+)?(int [a-zA-Z]+,String [a-zA-Z]+)?(String [a-zA-Z]+,int [a-zA-Z]+)?(String [a-zA-Z]+)?"
                                        +"\\)\\{",
                                s.trim()))
                .count();

        methCount+=(int) listLines.stream()
                .filter(s ->Pattern
                        .matches("(private)?(protected)?(public)? " +
                                "(int)?(String)?(boolean)?(byte)?(long)?(char)?(void)? [a-zA-Z]+"
                                +"\\("
                                        +"(int [a-zA-Z]+)?(int [a-zA-Z]+,String [a-zA-Z]+)?(String [a-zA-Z]+,int [a-zA-Z]+)?(String [a-zA-Z]+)?"
                                        + "\\)"+"( )?"+"\\{"
                                ,s.trim()))
                .count();


        System.out.println("Instance vars: "+varCount);
        System.out.println("Methods: "+methCount);
        System.out.println("Constructors: "+constCount);


    }
}
