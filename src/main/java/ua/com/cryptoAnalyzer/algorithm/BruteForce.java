package ua.com.cryptoAnalyzer.algorithm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.com.cryptoAnalyzer.Alphabet;
import ua.com.cryptoAnalyzer.file.Write;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BruteForce extends Alphabet implements Algorithm {
    private static final Logger LOGGER = LogManager.getLogger(BruteForce.class);
    private Write write = new Write();
    private Decode decrypt = new Decode();
    private static final String[] FAMOUS_WORDS = {"и", "в", "не", "на", "я", "быть", "он", "с", "что", "а", "по",
            "это", "она", "этот", "к", "но", "они", "мы", "как", "из", "у", "который", "то", "за", "что", "свой",
            "весь", "год", "от", "так", "о", "для", "ты", "же", "все", "тот", "мочь", "вы", "человек", "его", "сказать",
            "только", "или", "ещё", "бы", "себя", "один", "как", "уже", "до", "время", "если", "сам", "когда", "другой",
            "вот", "говорить", "наш", "мой", "знать", "стать", "при", "чтобы", "дело", "жизнь", "кто", "первый", "очень",
            "два", "день", "ее", "новый", "рука", "даже", "во", "сто", "раз", "где", "там", "под", "можно", "ну",
            "какой", "после", "их", "работа", "без", "самый", "потом", "надо", "хотеть", "ли", "слово", "идти",
            "большой", "должен", "место", "иметь", "ничто"};

    public static final Pattern IGNORE_PUNCTUATION = Pattern.compile("[\\p{P} \\t\\n\\r]");

    public static List<String> getFamousWords() {
        LOGGER.info("Famous words added to Collection");
        return Arrays.asList(FAMOUS_WORDS);
    }


    @Override
    public StringBuilder algorithm(String line, int key) {
        StringBuilder outputText = new StringBuilder();

        while (key > 0 && key < getALPHABET().length()) {
            outputText.append(decrypt.algorithm(line, key));
            LOGGER.debug("Use decrypt algorithm,, using key: " + key);

            String[] words = outputText.toString().split(IGNORE_PUNCTUATION.toString());
            LOGGER.debug("Split words and remove punctuation");

            for (String word : words) {
                if (getFamousWords().contains(word)) {
                    LOGGER.debug("Word has found in Collection");
                    return outputText;
                }
            }

            key++;
            outputText = new StringBuilder();
        }

        LOGGER.debug("Text wrote successful");
        return outputText;
    }
}
