package ahodanenok.pokemons.importer;

import org.springframework.core.io.Resource;

public class JsonPokemonImport {

    private Resource resource;

    public void setFromResource(Resource resource) {
        this.resource = resource;
    }

    private void init() {
        if (resource == null) {
            throw new IllegalStateException("From resource is not provided");
        }
    }

    public void execute() {

    }
}
