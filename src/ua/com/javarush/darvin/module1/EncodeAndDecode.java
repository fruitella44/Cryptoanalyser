package ua.com.javarush.darvin.module1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncodeAndDecode {
    private static String alphabet  = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,«»\"\\:!? ";

    String encode(String inputText, int key) {
        inputText = inputText.toLowerCase();
        String str = "";
        for (int i = 0; i < inputText.length(); i++) {
            int index = alphabet.indexOf(inputText.charAt(i));
            int shiftIndex = (index + key) % 43;
            char encoding = alphabet.charAt(shiftIndex);
            str = str + encoding;
        }

        return str;
    }

    String decode(String cText, int key) {
        cText = cText.toLowerCase();
        String pText = "";
        for (int i = 0; i < cText.length(); i++) {
            int index = alphabet.indexOf(cText.charAt(i));
            int shiftIndexBack = (index - key) % 43;

            if (shiftIndexBack < 0) {
                shiftIndexBack = alphabet.length() + shiftIndexBack;
            }

            char newChars = alphabet.charAt(shiftIndexBack);
            pText = pText + newChars;
        }

        return pText;
    }
}
