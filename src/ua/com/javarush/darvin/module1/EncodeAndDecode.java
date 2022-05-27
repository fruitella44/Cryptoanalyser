package ua.com.javarush.darvin.module1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecode {
    private static String alphabet  = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,«»\"\\:!? ";
    private char[] decodeBruteForce;

    StringBuilder encode(String line, int key) throws IOException {
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

    CharSequence bruteForce(String line) {
        List<Character> listAlphabet = new ArrayList<>();
        StringBuilder builder = new StringBuilder(Main.readFile(line).toString().toLowerCase());
        String str = builder.toString();
        String [] outputText = new String[0];
        char[] inputText = str.toCharArray();
        char[] charAlphabet = alphabet.toCharArray();

        for (int key = 0; key < charAlphabet.length; key++) {
            decodeBruteForce = new char[inputText.length];

            for (int j = 0; j < inputText.length; j++) {
                if (inputText[j] != ' ') {
                    decodeBruteForce[j] = charAlphabet[listAlphabet.indexOf(inputText[j] + key) % charAlphabet.length];
                } else {
                    decodeBruteForce[j] = ' ';
                }
            }
            outputText[key] = String.valueOf(decodeBruteForce);
        }
        return outputText.toString();
    }
}
