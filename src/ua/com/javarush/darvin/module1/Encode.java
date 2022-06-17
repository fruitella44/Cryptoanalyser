package ua.com.javarush.darvin.module1;

public class Encode extends Alphabet {
    ReadAndWrite read = new ReadAndWrite();

    public StringBuilder encode(String line, int key) {
        StringBuilder inputText = new StringBuilder(read.readFile(line).toString().toLowerCase());
        StringBuilder outputText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            int index = getALPHABET().indexOf(inputText.charAt(i));
            int shiftIndex = (index + key) % getALPHABET().length();
            char encoding = getALPHABET().charAt(shiftIndex);
            outputText.append(encoding);
        }

        return outputText;
    }
}
