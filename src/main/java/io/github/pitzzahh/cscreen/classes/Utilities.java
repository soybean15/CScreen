package io.github.pitzzahh.cscreen.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Utilities {
    public static int getMax(String[] arr){
        return Arrays.stream(arr)
                .max(Comparator.comparingInt(String::length))
                .map(String::length)
                .orElse(arr[0].length());
    }


    public static int[] getMaxByColumn(List<List<String>> arr){
        int[] arrMax = new int[arr.get(0).size()];



        for (int j = 0; j < arr.get(0).size(); j++) {

            String[] temp = new String[arr.size()];

            for (int i = 0; i < arr.size(); i++) {
                temp[i] = arr.get(i).get(j);
            }

            arrMax[j] = getMax(temp);
        }
        return arrMax;
    }

    public static String[] createEmptyList(String[] arr){
        String[] newArr = new String[arr.length];
        Arrays.fill(newArr, " ");
        return newArr;
    }

    public static List<List<String>> addHeader (List<List<String>> arr, String[] columnHeader ){
        List<List<String>> newArr = new ArrayList<>();

        newArr.add(Arrays.asList(columnHeader));
        newArr.addAll(arr);


        return newArr;
    }



    public static String start(String str, int len) {
        String format = "%-" + len + "s";
        return String.format(format,str);
    }

    public static String end(String str, int len) {
        String format = "%" + len + "s";
        return String.format(format,str);
    }

    public static String center(String str, int len) {
        String format = String.format("%" + len + "s%s%" + len + "s", "", str, "");
        float mid = (format.length() / 2f);
        float start = mid - (len / 2f);
        float end = start + len;

        return format.substring((int) start, (int) end);

    }

    public static String alignedString(String str, int len, Position pos){
        if(pos == Position.START){
            return start(str,len+2);
        } else if (pos == Position.CENTER) {
            return center(str,len+2);
        } else if (pos == Position.END) {
            return end(str,len+2);
        }

        return start(str,len+2);
    }

    public static double isNumeric(String str) {
        try {
           return Double.parseDouble(str);

        } catch(NumberFormatException e){
            return 0;
        }
    }






}
