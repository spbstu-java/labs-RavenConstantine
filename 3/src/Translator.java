import exceptions.*;

public class Translator {
    private Dictionary dictionary;

    public Translator(String dictionaryFile) throws FileReadException, InvalidFileFormatException {
        this.dictionary = new Dictionary(dictionaryFile);
    }

    public String Translate(String inputText) {
        if (inputText == null || inputText.trim().isEmpty()) {
            return "Текст пуст";
        }
        String[] tokens = inputText.split("\\s+");
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < tokens.length) {
            String translation = null;
            int wordCount = 0;
            String punctuation = "";

            StringBuilder phraseBuilder = new StringBuilder();
            for (int j = i; j < tokens.length; j++) {
                if (phraseBuilder.length() > 0) phraseBuilder.append(" ");
                phraseBuilder.append(tokens[j].replaceAll("\\pP", ""));
                String str = phraseBuilder.toString();
                if (str.isEmpty()) {
                    break;
                }
                if (dictionary.entries.containsKey(str)) {
                    int wc = j - i + 1;
                    if (wc > wordCount) {
                        wordCount = wc;
                        translation = dictionary.entries.get(str);
                        int idx = tokens[j].length() - 1;
                        while (idx >= 0 && !Character.isLetterOrDigit(tokens[j].charAt(idx))) {
                            idx--;
                        }
                        punctuation = tokens[j].substring(idx + 1);
                    }
                }
            }
            if (translation != null) {
                if (result.length() > 0) result.append(" ");
                translation = translation + punctuation;
                result.append(translation);
                i += wordCount;
            } else {
                if (result.length() > 0) result.append(" ");
                result.append(tokens[i]);
                i++;
            }
        }
        return result.toString();
    }
}