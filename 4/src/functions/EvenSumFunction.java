package functions;
import java.util.Arrays;

public class EvenSumFunction {
    public static int getEvenSum(final int[] numbers) {
        return Arrays.stream(numbers).filter(value -> value % 2 == 0).sum();
    }
}
