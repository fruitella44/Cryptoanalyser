package ua.com.javarush.darvin.module1;


import java.io.*;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static boolean start = true;

    public static void main(String[] args) {
        Main main = new Main();
        EncodeAndDecode encodeAndDecode = new EncodeAndDecode();

        if (start) {
            System.out.println("Запуск программы!\n___________________________");
            System.out.println("Выберите действие:");
            System.out.println("1 - шифровка текста");
            System.out.println("2 - расшифровка текста");
            System.out.println("3 - расшифровка с помощью brute force\n___________________________");
            main.scannerInt();
        } else {
            System.out.println("Ошибка запуска!");
        }

    }

    private int scannerInt() {
        Scanner console = new Scanner(System.in);
        int input = console.nextInt();

        try {
            if (start) {
                if (input == 1) {
                    System.out.println("Введите текст:");
                    scannerStringEncode();
                } else if (input == 2) {
                    System.out.println("Введите текст:");
                    scannerStringDecode();
                } else if (input == 3) {
                    System.out.println("Укажите путь к файлу:");
                    readFile();
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

    private String scannerStringEncode() {
        EncodeAndDecode encodeAndDecode = new EncodeAndDecode();
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OutputText.txt"))) {

            bufferedWriter.write(encodeAndDecode.encode(line, 3));
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException exception) {
            System.out.println("Не удалось прочитать текст " + exception);
        }

       return line;
    }

    private String scannerStringDecode() {
        EncodeAndDecode encodeAndDecode = new EncodeAndDecode();
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OutputText.txt"))) {

            bufferedWriter.write(encodeAndDecode.decode(line, 3));
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException exception) {
            System.out.println("Не удалось прочитать текст " + exception);
        }

        return line;
    }

    private String readFile() {
        try (FileReader fileReader = new FileReader("InputText");
             BufferedReader reader = new BufferedReader(fileReader)) {

            return reader.readLine();
        } catch (IOException exception) {
            System.out.println("Не удалось прочитать файл " + exception);
            return null;
        }
    }
}

