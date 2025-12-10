package functions;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class UpperCaseFunction {
    public static List<String> transform(final List<String> strings) {
        return strings.stream().map(value -> "_new_" + value.toUpperCase(Locale.ROOT)).collect(Collectors.toList());
    }
}
