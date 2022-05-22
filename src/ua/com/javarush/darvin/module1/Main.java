package ua.com.javarush.darvin.module1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    private static final boolean start = true;

    public static void main(String[] args) throws IOException {
        Cipher cipher = new Cipher();

        if (start) {
            System.out.println("Шифруем текст:");
            System.out.println(cipher.shift(scanner(), 3));
            System.out.println("_______________________");

            System.out.println("Считываем информацию с файла");
            getFilePath();
            System.out.println(cipher.shiftBack(scanner(), 35));
            System.out.println("_______________________");
        } else {
            System.out.println("Ошибка запуска");
        }

    }

    private static String scanner() {
        Path path = Path.of("outputText.txt");
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

    public static String getFilePath() throws IOException {
        Path path = Path.of("inputFile.txt");

        try (FileReader fileReader = new FileReader(String.valueOf(path));
             BufferedReader reader = new BufferedReader(fileReader)) {

            return  reader.readLine();
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
            return null;
        }
    }

}
