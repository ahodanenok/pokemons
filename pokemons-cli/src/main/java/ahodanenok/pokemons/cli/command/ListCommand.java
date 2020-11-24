package ahodanenok.pokemons.cli.command;

import org.springframework.stereotype.Component;

@Component
public class ListCommand implements CliCommand {

    @Override
    public void execute() {
        System.out.println("Pokemons list");
    }
}
