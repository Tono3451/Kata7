package software.ulpgc.kata7.io;

import software.ulpgc.kata7.model.ApiPokemon;
import software.ulpgc.kata7.model.Pokemon;

public interface PokemonAdapter {
    Pokemon adapt(ApiPokemon apiPokemon);
}
