package functions;
import java.util.Collection;

public class LastElementFunction {
    public static <T> T getLast(final Collection<T> values) {
        return values.stream().reduce((first, second) -> second).orElseThrow(() -> new IllegalArgumentException("Коллекция пуста"));
    }
}
