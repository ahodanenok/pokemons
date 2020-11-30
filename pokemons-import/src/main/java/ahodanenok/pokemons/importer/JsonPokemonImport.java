package ahodanenok.pokemons.importer;

import ahodanenok.pokemons.model.Pokemon;
import ahodanenok.pokemons.validation.PokemonValidator;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.validation.BindingResult;
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

    public PokemonImportResult execute() {
        PokemonImportResult result = new PokemonImportResult();
        try (JsonReader reader = jsonReaderFactory.createReader(resource.getInputStream())) {
            JsonArray pokemons = reader.readArray();
            for (JsonValue p : pokemons) {
                JsonObject obj = p.asJsonObject();
                if (obj.equals(JsonValue.EMPTY_JSON_OBJECT)) {
                    continue;
                }

                BindingResult bindingResult = bind(obj);
                if (!bindingResult.hasErrors()) {
                    result.addPokemon((Pokemon) bindingResult.getTarget());
                } else {
                    result.addErrors(bindingResult);
                }
            }
        } catch (IOException e) {
            // todo: error
            e.printStackTrace();
        }

        return result;
    }

    private BindingResult bind(JsonObject pokemon) {
        MutablePropertyValues pvs = new MutablePropertyValues();
        pvs.add("number", pokemon.getString("Number"));
        pvs.add("name", pokemon.getString("Name"));
        pvs.add("description", pokemon.getString("About"));
        pvs.add("generation", pokemon.getString("Generation"));


        DataBinder binder = new DataBinder(new Pokemon(), "pokemon");
        binder.setIgnoreUnknownFields(false);
        binder.setIgnoreInvalidFields(false);
        binder.setValidator(pokemonValidator);
        binder.bind(pvs);
        binder.validate();

        return binder.getBindingResult();
    }
}
