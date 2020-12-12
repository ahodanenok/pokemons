package ahodanenok.pokemons.cli.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component(value = "cliMain")
public class MainCommand implements CliCommand {

    private List<CliCommand> commands;

    @Autowired
    public void setCommands(List<CliCommand> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Pokemons");
            for (int i = 0; i < commands.size(); i++) {
                CliCommand command = commands.get(i);
                if (command.getMenuTitle() != null) {
                    System.out.printf("%d. %s%n", i + 1, command.getMenuTitle());
                }
            }
            System.out.println("q. Exit");

            System.out.print(">");
            if (!scanner.hasNextLine()) {
                break;
            }

            String action = scanner.nextLine().trim();

            if ("q".equals(action)) {
                System.exit(0);
                return;
            }

            int commandIdx;
            try {
                commandIdx = Integer.parseInt(action) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Unknown command: " + action);
                System.out.println();
                continue;
            }

            if (commandIdx < 0 || commandIdx >= commands.size()) {
                System.out.println("Unknown command: " + action);
                System.out.println();
                continue;
            }

            CliCommand command = commands.get(commandIdx);
            command.execute();
        }
    }
}
