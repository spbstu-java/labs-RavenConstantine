package functions;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringMapFunction {
    public static Map<Character, String> convertToMap(final List<String> values) {
        return values.stream().collect(Collectors.toMap(value -> value.charAt(0), value -> value.length() > 1 ? value.substring(1) : ""));
    }
}
