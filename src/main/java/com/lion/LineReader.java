package com.lion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Getting and reading an external file
public class LineReader {
    // IO Exception cloause as Buffered Reader's readLine method is used
    // FileReader also requires a throws clause, but is overwritten by IOException
    List<String> readLines(String filename) throws IOException {
        List<String> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str;
        while ((str = br.readLine()) != null) {
            result.add(str);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\Miji\\Desktop\\hospitals.csv";
        LineReader lr = new LineReader();

        // reads the file by line and saves each line into a List<Stirng>
        List<String> lines = lr.readLines(filename); // notice the IOException
    }
}
