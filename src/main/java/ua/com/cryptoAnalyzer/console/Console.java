package ua.com.cryptoAnalyzer.console;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.com.cryptoAnalyzer.file.Write;

import java.util.InputMismatchException;
import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Console {
    private static final Logger LOGGER = LogManager.getLogger(Console.class);
    private boolean START = true;
    private final Write write = new Write();
    private Scanner scanner;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean inputCommand() {
        if (START) {
            LOGGER.info("Run application");
            scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Выберите действие:\n" +
                        "1 - " + Commands.Encode + "\n" +
                        "2 - " + Commands.Decode + "\n" +
                        "3 - " + Commands.Bruteforce + "\n" +
                        "0 - " + Commands.Exit + "\n" +
                        "___________________________");

                LOGGER.info("Choose one option");

                try {
                    int input = Integer.parseInt(scanner.nextLine());

                    if (input == 1) {
                        LOGGER.debug("User picked encode");
                        System.out.println("Введите название файла:");
                        write.encode();
                    } else if (input == 2) {
                        LOGGER.debug("User picked decode");
                        System.out.println("Введите название файла:");
                        write.decode();
                    } else if (input == 3) {
                        LOGGER.debug("User picked bruteforce");
                        System.out.println("Введите название файла:");
                        write.bruteForce();
                    } else if (input == 0) {
                        LOGGER.debug("User picked exit");
                        System.out.println(Commands.Exit);
                        break;
                    } else {
                        LOGGER.debug("User picked wrong command");
                        throw new RuntimeException("Неверная команда!");
                    }

                } catch (InputMismatchException exception) {
                    System.out.println("Требуется ввести число! " + exception);
                    LOGGER.error("Wrong input");
                }
            }
        }

        LOGGER.info("Application closed");
        return !START;
    }
}
