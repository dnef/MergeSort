package mergeSort;

import java.util.ArrayList;
import java.util.List;

public class SplitCell {
    // разбиение строки на подстроки
    protected String[] SplitSub(String row) {
/*      //  если известно что в строках нет символа разделения который используется при replace
        String string = row.replaceAll("(\\d+)","*$1*");
        String[] arrString = sim.split("\\*");

*/
        //если пришла пустая строка, возвращаем пустой массив
        if (row.equals("")) {
            return new String[]{""};
        }
        //начинаем формирование подстрок
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(row.charAt(0));
        //List для хранения подстрок (не знаем сколько подстрок будет)
        List<String> list = new ArrayList<>();

        for (int i = 1; i < row.length(); i++) {
            //если предыдущий символ и текущий числа то склеиваем строку
            if (Character.isDigit(row.charAt(i - 1)) && Character.isDigit(row.charAt(i))) {
                stringBuilder.append(row.charAt(i));
            } else {
                //если предыдущий символ и текущий не числа то склеиваем строку
                if (!Character.isDigit(row.charAt(i - 1)) && !Character.isDigit(row.charAt(i))) {
                    stringBuilder.append(row.charAt(i));
                } else {
                    //если предыдущий символ не число, а текущий число: символы(подстроку) до текущего символа отправляем в list
                    // и начинаем формировать новую подстроку
                    if (!Character.isDigit(row.charAt(i - 1)) && Character.isDigit(row.charAt(i))) {
                        list.add(stringBuilder.toString());
                        stringBuilder.setLength(0);
                        stringBuilder.append(row.charAt(i));
                    } else {
                        //если предыдущий символ число, а текущий не число: символы(подстроку) до текущего символа отправляем в list
                        // и начинаем формировать новую подстроку
                        if (Character.isDigit(row.charAt(i - 1)) && !Character.isDigit(row.charAt(i))) {
                            list.add(stringBuilder.toString());
                            stringBuilder.setLength(0);
                            stringBuilder.append(row.charAt(i));
                        }


                    }
                }
            }
        }
        //добавляем в list последнюю подстроку в входной строке
        list.add(stringBuilder.toString());
        //создаем массив подстрок
        String[] cell = list.toArray(new String[list.size()]);

        return cell;
    }
}


