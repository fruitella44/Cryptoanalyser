package ua.com.cryptoAnalyzer.algorithm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.com.cryptoAnalyzer.Alphabet;
import ua.com.cryptoAnalyzer.file.Write;

public class Decode extends Alphabet implements Algorithm {
    private static final Logger LOGGER = LogManager.getLogger(Decode.class);
    private final Write read = new Write();

    @Override
    public StringBuilder algorithm(String line, int key) {
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

        LOGGER.debug("ShiftBack symbols with key " + key);
        return outputText;
    }
}
