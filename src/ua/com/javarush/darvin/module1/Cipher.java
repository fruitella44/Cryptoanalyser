package ua.com.javarush.darvin.module1;

public class Cipher {

    StringBuilder shift(String message, int pullRight) {
        StringBuilder builder = new StringBuilder();
        char[] chars = message.toCharArray();

        for (char symbols : chars) {
            if (symbols != '.' && symbols != ',' && symbols != '«' && symbols != '»' && symbols != '"' &&
                    symbols != '\'' && symbols != ':' && symbols != '!' && symbols != '?' && symbols != ' ') {

                int originalAlphabet = symbols - 'а';
                int changedAlphabet = (originalAlphabet + pullRight) % 32;
                char newSymbols = (char) ('а' + changedAlphabet);
                builder.append(newSymbols);
            } else {
                builder.append(symbols);
            }
        }

        return builder;
    }

    StringBuilder shiftBack(String message, int pullRight) {
        return shift(message, 32 - (pullRight % 32));
    }
}
