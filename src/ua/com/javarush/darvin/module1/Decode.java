package ua.com.javarush.darvin.module1;

public class Decode extends Alphabet {
    ReadAndWrite read = new ReadAndWrite();

    public StringBuilder decode(String line, int key) {
        StringBuilder inputText = new StringBuilder(read.readFile(line).toString().toLowerCase());
        StringBuilder outputText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            int index = getALPHABET().indexOf(inputText.charAt(i));
            int shiftIndexBack = (index - key) % getALPHABET().length();

            if (shiftIndexBack < 0) {
                shiftIndexBack = getALPHABET().length() + shiftIndexBack;
            }

            char decoding = getALPHABET().charAt(shiftIndexBack);
            outputText.append(decoding);

        }

        return outputText;
    }

}
