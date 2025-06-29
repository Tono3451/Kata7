package software.ulpgc.kata7.io;

import software.ulpgc.kata7.model.Pokemon;

public interface PokemonLoader {
    Pokemon load(String pokemon);
}
