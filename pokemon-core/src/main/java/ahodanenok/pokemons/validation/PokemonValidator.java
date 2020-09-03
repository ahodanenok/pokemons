package ahodanenok.pokemons.validation;

import ahodanenok.pokemons.model.Pokemon;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PokemonValidator implements Validator {

    private PokemonTypeValidator typeValidator;

    public PokemonValidator(PokemonTypeValidator typeValidator) {
        this.typeValidator = typeValidator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Pokemon.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Pokemon pokemon = (Pokemon) target;

        try {
            errors.pushNestedPath("types");
            ValidationUtils.invokeValidator(typeValidator, pokemon, errors);
        } finally {
            errors.popNestedPath();
        }
    }
}
