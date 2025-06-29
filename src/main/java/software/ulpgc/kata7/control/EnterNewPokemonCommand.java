package software.ulpgc.kata7.control;

import software.ulpgc.kata7.io.*;
import software.ulpgc.kata7.model.Pokemon;
import software.ulpgc.kata7.view.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class EnterNewPokemonCommand implements Command {
    private final MainFrame mainFrame;
    private final PokemonLoader pokemonLoader;

    public EnterNewPokemonCommand(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.pokemonLoader = new ApiPokemonLoader(
                new ApiPokemonReader(),
                new ApiPokemonDeserializer(),
                new ApiPokemonAdapter()
        );
    }

    @Override
    public void execute() {
        String pokemonName = mainFrame.getTextInput();
        Pokemon pokemon = pokemonLoader.load(pokemonName);
        mainFrame.updatePokemonInfo(pokemon.name(), stringToImageIcon(pokemon.imageUrl()));
    }

    private ImageIcon stringToImageIcon(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            BufferedImage bufferedImage = ImageIO.read(url);

            if (bufferedImage == null) {
                return null;
            }

            Image scaledImage = bufferedImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
