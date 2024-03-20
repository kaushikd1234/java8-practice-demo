package java8.groupbydemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.maxBy;

public class GroupByDemoExample {

    public static void main(String[] args) {

        List<Employee> employees = Stream.of(
                        new Employee(1, "Kaushik", "Manager", 60000),
                        new Employee(2, "Preeti", "Manager", 70000),
                        new Employee(3, "Vikas", "DEV", 55000),
                        new Employee(4, "Pankaj", "DEV", 50000),
                        new Employee(5, "Divya", "HR", 600000),
                        new Employee(6, "Ankita", "HR", 100000))
                .collect(Collectors.toList());

        // want to sort it for highest salary department wise

        Map<String, Employee> map = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment, collectingAndThen(
                        maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)
        ));

        System.out.println(map);


    }
}
