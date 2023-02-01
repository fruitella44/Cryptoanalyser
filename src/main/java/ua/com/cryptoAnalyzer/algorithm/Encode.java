package ua.com.cryptoAnalyzer.algorithm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.com.cryptoAnalyzer.Alphabet;
import ua.com.cryptoAnalyzer.file.Write;

import java.nio.file.Path;

public class Encode extends Alphabet implements Algorithm {
    private static final Logger LOGGER = LogManager.getLogger(Decode.class);
    private final Write write = new Write();

    @Override
    public StringBuilder algorithm(String line, int key) {
        StringBuilder inputText = new StringBuilder(write.readFile(line).toString().toLowerCase());
        StringBuilder outputText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            int index = getALPHABET().indexOf(inputText.charAt(i));
            int shiftIndex = (index + key) % getALPHABET().length();
            char encoding = getALPHABET().charAt(shiftIndex);
            outputText.append(encoding);
        }

        LOGGER.debug("Shift symbols with key " + key);
        return outputText;
    }
}
