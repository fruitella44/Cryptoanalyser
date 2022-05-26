package ua.com.javarush.darvin.module1;


import java.io.*;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static boolean start = true;

    public static void main(String[] args) {
        Main main = new Main();
        main.scannerInt();

    }

    private int scannerInt() throws InputMismatchException {
        Scanner console = new Scanner(System.in);

        System.out.println("Запуск программы!\n___________________________");
        System.out.println("Выберите действие:");
        System.out.println("1 - шифровка текста");
        System.out.println("2 - расшифровка текста");
        System.out.println("3 - расшифровка с помощью brute force");
        System.out.println("0 - Выход\n___________________________");

        int input = console.nextInt();

        try {
            if (start) {
                if (input == 1) {
                    System.out.println("___________________________\nУкажите путь к файлу:");
                    scannerStringEncode();
                } else if (input == 2) {
                    System.out.println("___________________________\nУкажите путь к файлу:");
                    scannerStringDecode();
                } else if (input == 3) {
                    System.out.println("___________________________\nУкажите путь к файлу:");
                } else if (input == 0) {
                    System.out.println("Выход!\n___________________________");
                } else {
                    System.out.println("Неверная команда");
                    start = false;
                }
            }
        } catch (Exception exception) {
            System.out.println("Требуется ввести число!");
        }
        return input;
    }

    private static boolean scannerStringEncode() {
        EncodeAndDecode encodeAndDecode = new EncodeAndDecode();
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();
        Path writeFile = Path.of("E:\\Coding\\Java\\javarush-cryptoanalyser\\outputText.txt");


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(writeFile)))) {

            System.out.println("___________________________\nВведите номер ключа:");
            bufferedWriter.append(encodeAndDecode.encode(line, console.nextInt()));
            bufferedWriter.flush();
            return true;
        } catch (IOException exception) {
            System.out.println("Не удалось прочитать текст " + exception);
        }

       return false;
    }

    private static boolean scannerStringDecode() {
        EncodeAndDecode encodeAndDecode = new EncodeAndDecode();
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();
        Path writeFile = Path.of("E:\\Coding\\Java\\javarush-cryptoanalyser\\inputText.txt");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(writeFile)))) {

            System.out.println("___________________________\nВведите номер ключа:");
            bufferedWriter.append(encodeAndDecode.decode(line, console.nextInt()));
            bufferedWriter.flush();
            return true;
        } catch (IOException exception) {
            System.out.println("Не удалось прочитать текст " + exception);
        }

        return false;
    }

    public static StringBuilder readFile(String path) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            while(reader.ready()) {
                builder.append(reader.readLine());
                builder.append("\n");
            }

            builder.deleteCharAt(builder.length() - 1);
        } catch (IOException exception) {
            System.out.println("Не удалось прочитать файл " + exception);
            return null;
        }
        return builder;
    }
}

