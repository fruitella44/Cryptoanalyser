package ua.com.javarush.darvin.module1;

import java.util.Arrays;
import java.util.List;

public class EncodeAndDecode {
    private static String alphabet  = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,«»\"\\:!? ";
    private static Character[] charAlphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    private char[] decodeText;
    private String[] outputText;
    private List<Character> listAlphabet;

    StringBuilder encode(String line, int key) {
        StringBuilder inputText = new StringBuilder(Main.readFile(line).toString().toLowerCase());
        StringBuilder outputText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            int index = alphabet.indexOf(inputText.charAt(i));
            int shiftIndex = (index + key) % 43;
            char encoding = alphabet.charAt(shiftIndex);
            outputText.append(encoding);
        }

        return outputText;
    }

    StringBuilder decode(String line, int key) {
        StringBuilder inputText = new StringBuilder(Main.readFile(line).toString().toLowerCase());
        StringBuilder outputText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            int index = alphabet.indexOf(inputText.charAt(i));
            int shiftIndexBack = (index - key) % 43;

            if (shiftIndexBack < 0) {
                shiftIndexBack = alphabet.length() + shiftIndexBack;
            }

            char newChars = alphabet.charAt(shiftIndexBack);
            outputText.append(newChars);

        }

        return outputText;
    }

    public EncodeAndDecode() {
        listAlphabet = Arrays.asList(charAlphabet);
        outputText = new String[charAlphabet.length];
    }

    String bruteForce(String line) {
        StringBuilder inputText = new StringBuilder(Main.readFile(line).toString().toLowerCase());
        String str = inputText.toString();
        char[] chars = str.toCharArray();

        for (int key = 0; key < charAlphabet.length; key++) {
            decodeText = new char[chars.length];

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != ' ') {
                    decodeText[i] = charAlphabet[listAlphabet.indexOf(chars[i] + key) % charAlphabet.length];
                } else {
                    decodeText[i] = ' ';
                }
            }
            outputText[key] = String.valueOf(decodeText);
        }

         return outputText.toString();
    }
}
