package ua.com.javarush.darvin.module1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteForce {
    private static final String ALPHABET  = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,«»\"\\:!? ";
    private static final String[] famousWords = {"и", "в", "не", "на", "я", "быть", "он", "с", "что", "а", "по",
            "это", "она", "этот", "к", "но", "они", "мы", "как", "из", "у", "который", "то", "за", "что", "свой",
            "весь", "год", "от", "так", "о", "для", "ты", "же", "все", "тот", "мочь", "вы", "человек", "его", "сказать",
            "только", "или", "ещё", "бы", "себя", "один", "как", "уже", "до", "время", "если", "сам", "когда", "другой",
            "вот", "говорить", "наш", "мой", "знать", "стать", "при", "чтобы", "дело", "жизнь", "кто", "первый", "очень",
            "два", "день", "ее", "новый", "рука", "даже", "во", "сто", "раз", "где", "там", "под", "можно", "ну",
            "какой", "после", "их", "работа", "без", "самый", "потом", "надо", "хотеть", "ли", "слово", "идти",
            "большой", "должен", "место", "иметь", "ничто"};

    public static List<String> getFamousWords() {
        return Arrays.asList(famousWords);
    }

    public static StringBuilder bruteForce(String line, int key) {
        //1 - Перебор всех ключей
        //2 - Занести в коллекцию часто 100 распространненых слов на русском языке
        //3 - В момент перебора всех ключей сделать условие на сравнение со словом из листа, для выхода цикла

        StringBuilder inputText = new StringBuilder(Main.readFile(line).toString().toLowerCase());
        StringBuilder outputText = new StringBuilder();

        while (key > 0 && key < 43) {

            for (int i = 0; i < inputText.length(); i++) {
                int index = ALPHABET.indexOf(inputText.charAt(i));
                int shiftIndexBack = (index - key) % 43;

                if (shiftIndexBack < 0) {
                    shiftIndexBack = ALPHABET.length() + shiftIndexBack;
                }

                char newChars = ALPHABET.charAt(shiftIndexBack);
                outputText.append(newChars);
            }

            String[] splitString = outputText.toString().split("[\\p{P} \\t\\n\\r]");

            for (String word : splitString) {
                if (getFamousWords().contains(word)) {
                    return outputText;
                }
            }
            key++;
            outputText = new StringBuilder();
        }

        return outputText;
    }

}
