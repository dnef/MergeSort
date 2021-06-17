import mergeSort.IStringRowsListSorter;
import mergeSort.Task1Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<String[]> rows = new LinkedList<>();
        rows.add(new String[]{"23", "b", "2dfads"});
        rows.add(new String[]{"24", "", "55dfads"});
        rows.add(new String[]{"25", "", "dfads"});
        rows.add(new String[]{"26", null, "dfads", "ffff"});
        rows.add(new String[]{"27", null, "df47р"});
        rows.add(new String[]{"28", "c"});
        rows.add(new String[]{"29", "a", "111"});
        rows.add(new String[]{"30", "a", "1"});
        rows.add(new String[]{"31", "c", "3"});
        rows.add(new String[]{"32", "a", ""});
        rows.add(new String[]{null, "a", ""});
        rows.add(new String[]{"33", "c"});
        rows.add(new String[]{"34", "", "dfadsааа"});
        rows.add(new String[]{"35", "", "dddddd"});
        rows.add(new String[]{"36", "", "dDddddd"});
        IStringRowsListSorter ts = Task1Impl.getInstance();
        ts.sort(rows, 2);
        for (String[] s : rows) {
            for (String ss : s)
                System.out.print(Arrays.asList(ss));
        }
        System.out.println();
        for (String[] st : rows) {
            for (String str : st) {
                System.out.print("\"" + str + "\"" + " ");
            }
            System.out.println();
        }
//        System.out.println();
//        rows.stream().forEach(r-> {
//            for (String str:r) {
//                System.out.print("\""+str+ "\"");
//            }
//            System.out.println();
//        });


    }
}
