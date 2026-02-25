import java.util.*;

public class DataSorter<T extends Comparable<T>> {

    public List<T> sortList(List<T> list) {
        Collections.sort(list);
        return list;
    }

    public List<T> sortList(List<T> list, Comparator<? super T> comparator) {
        list.sort(comparator);
        return list;
    }
}