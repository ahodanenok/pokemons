package ahodanenok.pokemons.importer;

import org.springframework.beans.factory.FactoryBean;

import javax.json.Json;
import javax.json.JsonReaderFactory;
import java.util.Map;

public class JsonReaderFactoryBean implements FactoryBean<JsonReaderFactory> {

    private Map<String, ?> config;
    private JsonReaderFactory factory;

    public JsonReaderFactoryBean(Map<String, ?> config) {
        this.config = config;
    }

    @Override
    public JsonReaderFactory getObject() throws Exception {
        if (factory == null) {
            factory = Json.createReaderFactory(config);
        }

        return factory;
    }

    @Override
    public Class<?> getObjectType() {
        return JsonReaderFactory.class;
    }
}
