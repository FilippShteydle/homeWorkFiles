package com.shteydle.top.homeWorkFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Task04 {

    public static void writer(String path, String[] string) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(Arrays.toString(string) + "\n");
            writer.write(String.valueOf(getEvenNum(string)) + "\n");
            writer.write(String.valueOf(getOddNum(string)) + "\n");
            writer.write(Arrays.toString(reverce(string)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getEvenNum(String[] strings) {
        List<String> descEvenNumber = new ArrayList<>();
        for (String s : strings) {
            if (Integer.parseInt(s) % 2 == 0) {
                descEvenNumber.add(s);
            }
        }
        return descEvenNumber;
    }

    public static List<String> getOddNum(String[] strings) {
        List<String> descOddNumber = new ArrayList<>();
        for (String s : strings) {
            if (Integer.parseInt(s) % 2 != 0) {
                descOddNumber.add(s);
            }
        }
        return descOddNumber;
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу: ");
        String path = scanner.nextLine();
        System.out.println("Введите числа через пробел: ");
        String[] num = scanner.nextLine().split(" ");

        writer(path, num);
        scanner.close();
    }

    public static String[] reverce(String[] strings) {
        String[] stringReverce = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            stringReverce[stringReverce.length - 1 - i] = strings[i];
        }
        return stringReverce;
    }

    public static void main(String[] args) {
        run();
    }
}
