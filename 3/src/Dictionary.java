import exceptions.*;
import java.io.*;
import java.util.*;

public class Dictionary {
    public Map<String, String> entries = new LinkedHashMap<>();

    public Dictionary(String filename) throws FileReadException, InvalidFileFormatException {
        loadFromFile(filename);
    }

    private void loadFromFile(String filename) throws FileReadException, InvalidFileFormatException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int number = 1;

            while ((line = reader.readLine()) != null) {
                String raw = line.trim();
                if (raw.isEmpty() || raw.startsWith("#")) {
                    number++;
                    continue;
                }
                String[] parts = raw.split("\\|", 2);
                if (parts.length != 2) {
                    throw new InvalidFileFormatException("Неверный формат в строке " + number + ": " + line);
                }
                String word = parts[0].trim();
                String translation = parts[1].trim();
                if (word.isEmpty() || translation.isEmpty()) {
                    throw new InvalidFileFormatException("Неверный формат в строке " + number + ": " + line);
                }
                entries.put(word, translation);
                number++;
            }
            if (number == 1) {
                throw new InvalidFileFormatException("Файл словаря пуст или не содержит пар слово | перевод");
            }
        } catch (IOException ioe) {
            throw new FileReadException("Ошибка при чтении файла \"" + filename + "\": " + ioe.getMessage(), ioe);
        }
    }
}
