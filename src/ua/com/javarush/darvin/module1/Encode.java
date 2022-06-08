package ua.com.javarush.darvin.module1;

public class Encode {
    private static final String ALPHABET  = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,«»\"\\:!? ";

    public static StringBuilder encode(String line, int key) {
        StringBuilder inputText = new StringBuilder(Main.readFile(line).toString().toLowerCase());
        StringBuilder outputText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            int index = ALPHABET.indexOf(inputText.charAt(i));
            int shiftIndex = (index + key) % ALPHABET.length();
            char encoding = ALPHABET.charAt(shiftIndex);
            outputText.append(encoding);
        }

        return outputText;
    }
}
