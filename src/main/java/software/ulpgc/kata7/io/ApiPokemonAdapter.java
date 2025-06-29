package software.ulpgc.kata7.io;

import software.ulpgc.kata7.model.ApiPokemon;
import software.ulpgc.kata7.model.Pokemon;

public class ApiPokemonAdapter implements PokemonAdapter{
    @Override
    public Pokemon adapt(ApiPokemon apiPokemon) {
        return adapt(apiPokemon.name(), apiPokemon.sprites());
    }

    private Pokemon adapt(String name, ApiPokemon.Sprites sprites) {
        return new Pokemon(name, getFromSpriteUrl(sprites));
    }

    private String getFromSpriteUrl(ApiPokemon.Sprites sprites) {
        return sprites.front_default();
    }
}
