package java8.binarysearch;

import java.util.stream.IntStream;

public class BinarySearchDemo {

    private static int searchTree(int[] array, int target) {

        return IntStream.rangeClosed(1, array.length)
                .filter(element -> array[element] == target)
                .findFirst().orElseThrow();
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 11, 400, 35, 70};
        int target = 70;
        System.out.println(searchTree(array, target));
    }
}
