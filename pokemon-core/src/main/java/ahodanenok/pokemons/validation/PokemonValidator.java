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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", new Object[] { "name" });
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "generation", "required", new Object[] { "generation" });

        if (pokemon.getName() != null && pokemon.getName().length() > 9) {
            errors.rejectValue("name", "maxlength", new Object[] { "name", 10 }, null);
        }

        if (pokemon.getTypes() != null) {
            validate(typeValidator, pokemon.getTypes(), "types", errors);
        }
    }

    private void validate(Validator validator, Object target, String path, Errors errors) {
        try {
            errors.pushNestedPath(path);
            ValidationUtils.invokeValidator(typeValidator, target, errors);
        } finally {
            errors.popNestedPath();
        }
    }
}
