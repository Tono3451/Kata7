package software.ulpgc.kata7.io;

import software.ulpgc.kata7.model.ApiPokemon;

public interface PokemonDeserializer {
    ApiPokemon deserialize(String json);
}
