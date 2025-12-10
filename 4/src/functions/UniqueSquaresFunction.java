package functions;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueSquaresFunction {
    public static List<Integer> getUniqueSquares(final List<Integer> numbers) {
        return numbers.stream().filter(value -> numbers.stream().filter(v -> v.equals(value)).count() == 1).map(value -> value * value).collect(Collectors.toList());
    }
}
