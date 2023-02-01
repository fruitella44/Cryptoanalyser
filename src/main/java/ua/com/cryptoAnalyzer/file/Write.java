package ua.com.cryptoAnalyzer.file;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.com.cryptoAnalyzer.algorithm.BruteForce;
import ua.com.cryptoAnalyzer.algorithm.Decode;
import ua.com.cryptoAnalyzer.algorithm.Encode;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Write {
    private static final Logger LOGGER = LogManager.getLogger(Write.class);
    private final Scanner scanner = new Scanner(System.in);;
    private Encode encrypt;
    private Decode decrypt;
    private BruteForce brute;
    private String line;

    public Write(Encode encrypt, Decode decrypt, BruteForce brute, String line) {
        this.encrypt = encrypt;
        this.decrypt = decrypt;
        this.brute = brute;
        this.line = line;

        LOGGER.info("Initialized: [" + scanner + " " + encrypt + " " + decrypt + " " + brute + " " + line + "]");
    }


    public StringBuilder readFile(String path) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            LOGGER.debug("Reading file");

            while (reader.ready()) {
                builder.append(reader.readLine());
                builder.append("\n");

                LOGGER.debug("Appending into StringBuilder: " + builder.toString());
            }

            builder.deleteCharAt(builder.length() - 1);
            LOGGER.debug("Deleted last symbol from StringBuilder");
        } catch (IOException exception) {
            System.out.println("Не удалось прочитать файл " + exception);
            LOGGER.error("Error while reading file");
            return null;
        }

        return builder;
    }

    public boolean encode() {
        encrypt = new Encode();
        line = scanner.nextLine();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("outputText.txt"))) {
            LOGGER.debug("Read file name: " + Paths.get(line).getFileName());

            System.out.println("Введите номер ключа:");
            bufferedWriter.append(encrypt.algorithm(line, scanner.nextInt()));
            bufferedWriter.flush();

            LOGGER.debug("Writing encode text");
            return true;
        } catch (IOException exception) {
            System.out.println("Не удалось записать текст " + exception);
            LOGGER.error("Error while writing encode text");
        }

        return false;
    }

    public boolean decode() {
        decrypt = new Decode();
        line = scanner.nextLine();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inputText.txt"))) {
            LOGGER.debug("Read file name: " + Paths.get(line).getFileName());

            System.out.println("Введите номер ключа:");
            bufferedWriter.append(decrypt.algorithm(line, scanner.nextInt()));
            bufferedWriter.flush();

            LOGGER.debug("Writing decode text");
            return true;
        } catch (IOException exception) {
            System.out.println("Не удалось записать текст " + exception);
            LOGGER.error("Error while encrypt");
        }

        return false;
    }

    public boolean bruteForce() {
        brute = new BruteForce();
        line = scanner.nextLine();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inputText.txt"))) {
            LOGGER.debug("Read file name: " + Paths.get(line).getFileName());

            bufferedWriter.append(brute.algorithm(line, 1));
            bufferedWriter.flush();

            LOGGER.debug("Writing decrypt brute text");
            return true;
        } catch (IOException exception) {
            System.out.println("Не удалось записать текст " + exception);
            LOGGER.error("Error while writing bruteForce text");
        }

        return false;
    }

}
