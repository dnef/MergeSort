package mergeSort;

import java.util.*;

/**
 * <h1>Задание №1</h1>
 * Реализуйте интерфейс {@link IStringRowsListSorter}.
 *
 * <p>Мы будем обращать внимание в первую очередь на структуру кода и владение стандартными средствами java.</p>
 */
public class Task1Impl implements IStringRowsListSorter {
    // ваша реализация должна работать, как singleton. даже при использовании из нескольких потоков.
    private Task1Impl() {
    }
    private static final IStringRowsListSorter INSTANCE = new Task1Impl();
    private static final SortList SORT_LIST = new SortList();
    public static IStringRowsListSorter getInstance(){
        return INSTANCE;
    }

    @Override
    public void sort(final List<String[]> rows, final int columnIndex) {
        // напишите здесь свою реализацию. Мы ждем от вас хорошо структурированного, документированного и понятного кода.
        //Вызываем метод сортировки слияния. С параметрами исходный не сортированный лист, начальный \ конечный индекс строки,
        // индекс в строке по которому производится сортировка.
        SORT_LIST.mergeSort(rows, 0, rows.size() - 1, columnIndex);
    }

}
