package functions;
import java.util.List;

public class AverageValueFunction {
    public static double calculateAverage(final List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }
}
