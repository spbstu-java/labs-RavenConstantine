import exceptions.*;

public class Main {
    public static void main(String[] args) {

        String dictPath = "dictionary.txt";
        Translator translator;
        try {
            translator = new Translator(dictPath);
        } catch (InvalidFileFormatException e) {
            System.err.println("Ошибка формата словаря: " + e.getMessage());
            return;
        } catch (FileReadException e) {
            System.err.println("Ошибка чтения словаря: " + e.getMessage());
            return;
        }
        System.out.println("Введите текст для перевода:");
        // dog look to the window, dog look forward
        String line = System.console().readLine();
        String translated = translator.Translate(line);
        System.out.println("Перевод: " + translated);
    }
}
