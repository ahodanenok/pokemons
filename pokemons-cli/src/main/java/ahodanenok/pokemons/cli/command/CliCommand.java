package ahodanenok.pokemons.cli.command;

import org.springframework.stereotype.Component;

@Component
public interface CliCommand {

    default String getMenuTitle() {
        return null;
    }

    // todo: return status code?
    void execute();
}
