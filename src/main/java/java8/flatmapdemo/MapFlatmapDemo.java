package java8.flatmapdemo;

import java8.flatmapdemo.dto.User;
import java8.groupbydemo.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapFlatmapDemo {

    public static void main(String[] args) {

        List<User> origList = Stream.of(new User(1, "Kaushik", "Manager", 60000,
                                Arrays.asList("kd@gmail.com", "kd2@gmail.com")),
                        new User(2, "PreetiDeo", "Manager", 80000,
                                Arrays.asList("preeti1@gmail.com", "preeti2@gmail.com")),
                        new User(3, "Pankaj", "Dev", 30000,
                                Arrays.asList("pj1@gmail.com", "pj2@gmail.com")))
                .collect(Collectors.toList());

         System.out.println(origList);

         // converting orig list to flattened List of Strings

        List<String> flattenedList = origList.stream().flatMap(
                employee -> employee.getEmails().stream()).collect(Collectors.toList());
        System.out.println(flattenedList);


    }
}
