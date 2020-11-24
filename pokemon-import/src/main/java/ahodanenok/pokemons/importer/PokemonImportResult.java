package ahodanenok.pokemons.importer;

import ahodanenok.pokemons.model.Pokemon;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.List;

public class PokemonImportResult {

    private List<Pokemon> imported;
    private List<Errors> errors;

    public PokemonImportResult() {
        this.imported = new ArrayList<>();
        this.errors = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.imported.add(pokemon);
    }

    public List<Pokemon> getImported() {
        return imported;
    }

    public void addErrors(Errors errors) {
        this.errors.add(errors);
    }

    public List<Errors> getErrors() {
        return errors;
    }
}
