package ua.com.javarush.darvin.module1;

public class Decode {
    private static final String ALPHABET  = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,«»\"\\:!? ";

    public static StringBuilder decode(String line, int key) {
        StringBuilder inputText = new StringBuilder(Main.readFile(line).toString().toLowerCase());
        StringBuilder outputText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            int index = ALPHABET.indexOf(inputText.charAt(i));
            int shiftIndexBack = (index - key) % 43;

            if (shiftIndexBack < 0) {
                shiftIndexBack = ALPHABET.length() + shiftIndexBack;
            }

            char decoding = ALPHABET.charAt(shiftIndexBack);
            outputText.append(decoding);

        }

        return outputText;
    }

}
