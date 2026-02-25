import java.util.*;
import java.util.stream.Collectors;

public class CollectionsDemo {

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();

        list.add(new Employee(101, "Alice", "Engineering"));
        list.add(new Employee(103, "Bob", "Marketing"));
        list.add(new Employee(102, "Charlie", "HR"));

        System.out.println("Original List:");
        list.forEach(System.out::println);

        Set<Employee> set = new HashSet<>(list);
        set.add(new Employee(101, "Alice", "Engineering"));

        System.out.println("\nUnique Employees: " + set.size());

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : list) {
            map.put(e.getId(), e);
        }

        System.out.println("\nEmployee 102: " + map.get(102));

        DataSorter<Employee> sorter = new DataSorter<>();

        List<Employee> sortedById = sorter.sortList(new ArrayList<>(list));
        System.out.println("\nSorted by ID:");
        sortedById.forEach(System.out::println);

        List<Employee> sortedByName = sorter.sortList(
                new ArrayList<>(list),
                Comparator.comparing(Employee::getName)
        );

        System.out.println("\nSorted by Name:");
        sortedByName.forEach(System.out::println);

        Map<String, List<Employee>> byDept =
                list.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\nEmployees by Department:");
        byDept.forEach((d, e) -> System.out.println(d + ": " + e.size()));
    }
}