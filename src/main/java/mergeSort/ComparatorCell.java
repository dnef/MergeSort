package mergeSort;

import java.util.*;

public class ComparatorCell {
// сравнение значений указанных ячеек если первая ячейка меньше второй возвращаем число меньше нуля
    public int compareMy(String[] rowList1, String[] rowList2, int columnIndex) {
        //переменная для подсчета результата сравнения
        int resultCompare = 0;
        if (rowList1.length > columnIndex && rowList2.length > columnIndex) {
            //если ячейки для сравнения пустые то они равны.
            if (rowList1[columnIndex] == null && rowList2[columnIndex] == null) {
                return 0;
            }
            //если первая для сравнения ячейка пустая то она меньше не пустой второй ячейки.
            if (rowList1[columnIndex] == null && rowList2[columnIndex] != null) {
                return -1;
            }
            //если вторая ячейка пустая , а первая нет то первая ячейка больше второй.
            if (rowList1[columnIndex] != null && rowList2[columnIndex] == null) {
                return 1;
            }
        }
//        if (rowList1.length < columnIndex && rowList2.length < columnIndex) {
//            return 1;
//        }
        //если ячейки для сравнения нет, то она null
        if (rowList1.length <= columnIndex) {
            return -1;
        }
        //если ячейка не существует, перестановку не делаем для сохранения порядка копируем ее в правую часть списка
        if (rowList2.length <= columnIndex) {
            return 1;
        }
        //если ячейки существуют сравниваем их
        if (rowList1.length >= columnIndex && rowList2.length >= columnIndex) {
            SplitCell splitCell = new SplitCell();
            //разбиение на подстроки
            String[] rowSplit1 = splitCell.SplitSub(rowList1[columnIndex]);
            String[] rowSplit2 = splitCell.SplitSub(rowList2[columnIndex]);
            resultCompare += rowSplit1.length - rowSplit2.length;
//            чтоб не выйти за границы подстроки, вычисляем самую меньшую
            int len = Math.min(rowSplit1.length, rowSplit2.length);
            //подсчет результата сравнения символов
            for (int r = 0; r < len; r++) {
                //если подстроки состоят из чисел
                if (isNumber(rowSplit1[r]) && isNumber(rowSplit2[r])) {
                    int numb1 = Integer.parseInt(rowSplit1[r]);
                    int numb2 = Integer.parseInt(rowSplit2[r]);
                    if (numb1 != numb2) {
                        resultCompare += (numb1 - numb2);
                    }
                } else {
                    //если подстроки не числа
                    resultCompare += (rowSplit1[r].compareTo(rowSplit2[r]));
                }
            }

        }
        return resultCompare;
    }

    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!Character.isDigit(c)) {
//            if (i != 0 || !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}


//    int size1=0;
//    int sss=0;
//        if(o1.length()>o2.length()){
//                size1=o2.length();
//                }else{size1=o1.length();}
//                for (int i=0;i<size1;i++){
//        if(o1.charAt(i)<=o2.charAt(i)){
//        sss++;
//        }
//        }