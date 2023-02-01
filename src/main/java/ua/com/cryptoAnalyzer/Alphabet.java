package ua.com.cryptoAnalyzer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.nio.file.Path;


public class Alphabet {
    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,«»\"\\:!? ";

    public String getALPHABET() {
        return ALPHABET;
    }
}
