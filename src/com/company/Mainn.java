package com.company;

/**
 * Created by nezife on 12/19/15.
 */
public class Mainn {
    public static void main(String[] args) {
        Map<Character, Long> histogram = new TreeMap<>();
        Path txtDir = Paths.get(args[0]);
        System.out.println(txtDir);
    }
}
