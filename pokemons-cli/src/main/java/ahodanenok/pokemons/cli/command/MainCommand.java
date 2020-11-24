package ahodanenok.pokemons.cli.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Scanner;

@Component(value = "cliMain")
public class MainCommand implements CliCommand {

    private CliCommand list;
    private ImportCommand importCommand;

    @Autowired
    public void setList(ListCommand list) {
        this.list = list;
    }

    @Inject
    public void setImportCommand(ImportCommand importCommand) {
        this.importCommand = importCommand;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Pokemons");
            // todo: make dynamic, inject all instances of cli commands and generate menu from them
            System.out.println("1. Show list");
            System.out.println("2. Search");
            System.out.println("3. Add a new one");
            System.out.println("4. Import");
            System.out.println("q. Выход");

            System.out.print(">");
            if (!scanner.hasNextLine()) {
                break;
            }

            String action = scanner.nextLine().trim();
            if ("1".equals(action)) {
                System.out.println();
                list.execute();
            } else if ("4".equals(action)) {
                System.out.println();
                importCommand.execute();
            } else if ("q".equals(action)) {
                System.exit(0);
            }

        }
    }
}
