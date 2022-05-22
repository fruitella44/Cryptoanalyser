package ua.com.javarush.darvin.module1;

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

    private static String scanner () throws IOException {
        try (Scanner console = new Scanner(System.in)) {

            while (true) {
                Path path = Path.of(console.nextLine());

                if (Files.notExists(path)) {
                    Files.createFile(path);
                } else if (!Files.isRegularFile(path)) {
                    System.out.println("Некорректный файл");
                    continue;
                } else if (!Files.isDirectory(path)) {
                    System.out.println("Некорректно указана директория");
                    continue;
                } else if (Files.exists(path)) {
                    Path newPath = Path.of("newFile");
                    Files.createFile(newPath);
                    Files.move(path, newPath);
                    continue;
                } else { break; }
            }

        } catch (Exception exception) {
            System.out.println("Не удалось прочитать файл " + exception);
        }

        String write = Files.readString(path);
        return write;
    }
}
