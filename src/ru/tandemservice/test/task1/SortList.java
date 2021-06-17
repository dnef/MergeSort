package ru.tandemservice.test.task1;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class SortList {
    public static ComparatorCell comparatorCell = new ComparatorCell();

    // сортировка методом слияния https://kvodo.ru/mergesort.html массив рекурсивно разбивается пополам,
    // и каждая из половин делиться до тех пор, пока размер очередного подмассива не станет равным единице;
    //mergesoft - рекурсия для взятия из листа меньшего набора строк. Выход из рекурсии при end <= start.
    // В метод merge передаются начальные и конечные индексы элементов листа , этими кусками заполняются временные листы
    //затем происходит сортировка временных листов и слияние этих листов

    //рекурсия деления листа
    static void mergeSort(final List<String[]> rows, int start, int end, final int columnIndex) {
        int middle = (start + end) / 2;
        if (end <= start) return;
        mergeSort(rows, start, middle, columnIndex);
        mergeSort(rows, middle + 1, end, columnIndex);
        merge(rows, start, middle, end, columnIndex);

    }
//Сортировка и слияние
    private static void merge(final List<String[]> rows, int start, int middle, int end, final int columnIndex) {
        //размеры левой и правой части массива
        int lengthStart = middle - start + 1;
        int lengthEnd = end - middle;

        List<String[]> listLeft = new LinkedList<>();
        List<String[]> listRigth = new LinkedList<>();
        //заполнение временных листов
        for (int i = 0; i < lengthStart; i++) {
            listLeft.add(rows.get(start + i));
        }
        for (int j = 0; j < lengthEnd; j++) {
            listRigth.add(rows.get(middle + 1 + j));
        }
        //текущий индекс временного листа
        int listLeftIndex, listRightIndex;
        listLeftIndex = 0;
        listRightIndex = 0;

        // копируем из listLeft и listRigth обратно в исходный лист
        for (int i = start; i < end + 1; i++) {
            // если остаются нескопированные элементы в listRigth и listLeft, копируем минимальный
            if (listLeftIndex < lengthStart && listRightIndex < lengthEnd) {
                if (comparatorCell.compareMy(listLeft.get(listLeftIndex), listRigth.get(listRightIndex), columnIndex) < 0) {
                    rows.set(i, listLeft.get(listLeftIndex));
                    listLeftIndex++;
                } else {
                    rows.set(i, listRigth.get(listRightIndex));
                    listRightIndex++;
                }
                // если все элементы были скопированы из  listRigth, скопировать остальные из listLeft
            } else {
                if (listLeftIndex < lengthStart) {
                    rows.set(i, listLeft.get(listLeftIndex));
                    listLeftIndex++;
                    // если все элементы были скопированы из listLeft, скопировать остальные из listRigth
                } else {
                    if (listRightIndex < lengthEnd) {
                        rows.set(i, listRigth.get(listRightIndex));
                        listRightIndex++;
                    }
                }
            }

        }
    }
}
