package ahodanenok.pokemons.cli.command;

import ahodanenok.pokemons.importer.JsonPokemonImport;
import ahodanenok.pokemons.importer.PokemonImportResult;
import ahodanenok.pokemons.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.Locale;

@Component
public class ImportCommand implements CliCommand, MessageSourceAware, Ordered {

    @Autowired
    private JsonPokemonImport pokemonImport;

    private MessageSource messageSource;

    private int order;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public int getOrder() {
        return order;
    }

    @Value("${command.import.order}")
    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String getMenuTitle() {
        return "Import";
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
