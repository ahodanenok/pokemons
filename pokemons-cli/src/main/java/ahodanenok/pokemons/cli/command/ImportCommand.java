package ahodanenok.pokemons.cli.command;

import ahodanenok.pokemons.importer.JsonPokemonImport;
import ahodanenok.pokemons.importer.PokemonImportResult;
import ahodanenok.pokemons.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.Locale;

@Component
public class ImportCommand implements CliCommand, MessageSourceAware {

    @Autowired
    private JsonPokemonImport pokemonImport;

    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void execute() {
        PokemonImportResult results = pokemonImport.execute();

        System.out.println("Imported:");
        for (Pokemon p : results.getImported()) {
            System.out.printf("  %03d: %s%n", p.getNumber(), p.getName());
        }

        System.out.println("Errors:");
        for (Errors errors : results.getErrors()) {
            System.out.println("  " + errors.getFieldValue("name"));
            for (ObjectError error : errors.getAllErrors()) {
                System.out.println("    " + messageSource.getMessage(error, Locale.forLanguageTag("ru")));
            }

            System.out.println();
        }
    }
}
