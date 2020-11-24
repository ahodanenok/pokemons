package ahodanenok.pokemons.cli.command;

import org.springframework.stereotype.Component;

@Component
public interface CliCommand {

    // todo: return status code?
    void execute();
}
