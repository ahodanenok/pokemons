package ahodanenok.pokemons.importer;

import ahodanenok.pokemons.model.Pokemon;
import ahodanenok.pokemons.validation.PokemonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.validation.DataBinder;

import javax.json.*;
import java.io.IOException;

public class JsonPokemonImport {

    private Resource resource;
    private JsonReaderFactory jsonReaderFactory;
    private PokemonValidator pokemonValidator;

    @Autowired
    public void setPokemonValidator(PokemonValidator pokemonValidator) {
        this.pokemonValidator = pokemonValidator;
    }

    public void setJsonReaderFactory(JsonReaderFactory jsonReaderFactory) {
        this.jsonReaderFactory = jsonReaderFactory;
    }

    public void setFromResource(Resource resource) {
        this.resource = resource;
    }

    private void init() {
        if (resource == null) {
            throw new IllegalStateException("From resource is not provided");
        }
    }

    public void execute() {
        try (JsonReader reader = jsonReaderFactory.createReader(resource.getInputStream())) {
            JsonArray pokemons = reader.readArray();
            for (JsonValue p : pokemons) {
                importPokemon(p.asJsonObject());
            }
        } catch (IOException e) {
            // todo: error
            e.printStackTrace();
        }
    }

    private void importPokemon(JsonObject pokemon) {
        DataBinder binder = new DataBinder(new Pokemon(), "pokemon");
        binder.setIgnoreUnknownFields(false);
        binder.setIgnoreInvalidFields(false);
        binder.setValidator(pokemonValidator);
    }
}
