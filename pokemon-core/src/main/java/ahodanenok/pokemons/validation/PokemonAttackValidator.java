package ahodanenok.pokemons.validation;

import ahodanenok.pokemons.model.PokemonAttack;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PokemonAttackValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PokemonAttack.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
