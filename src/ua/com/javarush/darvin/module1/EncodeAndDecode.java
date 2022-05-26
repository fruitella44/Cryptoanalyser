package ua.com.javarush.darvin.module1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncodeAndDecode {
    private static String alphabet  = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,«»\"\\:!? ";

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
}
