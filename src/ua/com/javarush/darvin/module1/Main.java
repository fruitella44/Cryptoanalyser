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

    private int scannerInt() {
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
                    scannerEncode();
                } else if (input == 2) {
                    System.out.println("___________________________\nУкажите путь к файлу:");
                    scannerDecode();
                } else if (input == 3) {
                    System.out.println("___________________________\nУкажите путь к файлу:");
                    scannerBruteForce();
                } else if (input == 0) {
                    System.out.println("Выход!\n___________________________");
                } else {
                    System.out.println("Неверная команда");
                    start = false;
                }
            }
        } catch (InputMismatchException exception) {
            System.out.println("Требуется ввести число! " + exception);
        }
        return input;
    }

    private static boolean scannerEncode() {
        Encode encrypt = new Encode();
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\Coding\\Java\\javarush-cryptoanalyser\\outputText.txt"))) {

            System.out.println("___________________________\nВведите номер ключа:");
            bufferedWriter.append(encrypt.encode(line, console.nextInt()));
            bufferedWriter.flush();
            return true;
        } catch (IOException exception) {
            System.out.println("Не удалось прочитать текст " + exception);
        }

       return false;
    }

    private static boolean scannerDecode() {
        Decode decrypt = new Decode();
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\Coding\\Java\\javarush-cryptoanalyser\\inputText.txt"))) {

            System.out.println("___________________________\nВведите номер ключа:");
            bufferedWriter.append(decrypt.decode(line, console.nextInt()));
            bufferedWriter.flush();
            return true;
        } catch (IOException exception) {
            System.out.println("Не удалось прочитать текст " + exception);
        }

        return false;
    }

    private static boolean scannerBruteForce() {
        BruteForce brute = new BruteForce();
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\Coding\\Java\\javarush-cryptoanalyser\\inputText.txt"))) {

            bufferedWriter.append(brute.bruteForce(line, 1));
            bufferedWriter.flush();
            return true;
        }catch (IOException exception) {
            System.out.println("Не удалось прочитать текст " + exception);
        }

        return false;
    }

    public static StringBuilder readFile(String path) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            while (reader.ready()) {
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

