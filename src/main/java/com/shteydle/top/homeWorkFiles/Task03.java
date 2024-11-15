package com.shteydle.top.homeWorkFiles;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task03 {

    private static final String path = "D:\\homeWorks\\homeWorkFiles\\mas.txt";


    public static void mass() {

        List<int[]> arr = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                arr.add(createInteger(line.split(" ")));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        print(arr);
    }

    public static void print(List<int[]> arr) {

        int[] allMin = new int[arr.size()];
        int[] allMax = new int[arr.size()];
        int allSum = 0;
        int count = 0;
        for (int[] i : arr){
            System.out.println("Массив: " + Arrays.toString(i));
            System.out.print("Min: " + getMin(i) + ", Max: " + getMax(i) + ", Summa: " + getSum(i) + "\n");
            allMin[count] = getMin(i);
            allMax[count] = getMax(i);
            count++;
            allSum += getSum(i);
        }
        System.out.println("Минимум среди всех массивов: " + getMin(allMin));
        System.out.println("Максимум среди всех массивов: " + getMax(allMax));
        System.out.println("Общая сумма всех массивов: " + allSum);
    }

    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static int[] createInteger(String[] string) {

        int[] numbers = new int[string.length];
        for (int i = 0; i < string.length; i++){
            numbers[i] = Integer.parseInt(string[i]);
        }
        return numbers;
        }

    public static void main(String[] args) {
        mass();
    }


}
