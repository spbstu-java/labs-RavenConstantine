import functions.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 6);
        List<String> strings = Arrays.asList("Qwerty", "AsdfgH", "ZxCvBn");

        System.out.println("Среднее значение: " + AverageValueFunction.calculateAverage(nums));
        System.out.println("Строки c _new_ в верхнем регистре: " + UpperCaseFunction.transform(strings));
        System.out.println("Квадраты уникальных чисел: " + UniqueSquaresFunction.getUniqueSquares(nums));
        System.out.println("Последний элемент: " + LastElementFunction.getLast(nums));
        try {
            LastElementFunction.getLast(Arrays.asList());
        } catch (IllegalArgumentException exception) {
            System.out.println("Последний элемент (исключение): " + exception.getMessage());
        }
        System.out.println("Сумма чётных: " + EvenSumFunction.getEvenSum(new int[]{1, 2, 3, 4, 6}));
        System.out.println("Строки в Map: " + StringMapFunction.convertToMap(strings));
        
    }
}
