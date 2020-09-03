package ahodanenok.pokemons.validation;

import ahodanenok.pokemons.model.PokemonType;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PokemonTypeValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PokemonType.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PokemonType type = (PokemonType) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "pokemon.type.name.empty");
    }
}
