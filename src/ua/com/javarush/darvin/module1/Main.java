package ua.com.javarush.darvin.module1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    private static Path path = Path.of("text.txt");

    public static void main(String[] args) throws IOException {
        Cipher cipher = new Cipher();

        System.out.println("Шифруем текст:");
        System.out.println(cipher.shift(scanner(), 3) + "\n_______________________");

        System.out.println("Расшифровываем текст:");
        System.out.println(cipher.shiftBack(scanner(), 35) + "\n_______________________");

    }

    private static String scanner () {
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(path)))) {

            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException exception) {
            System.out.println("Не удалось прочитать текст " + exception);
        }

        
        return line;
    }
}
