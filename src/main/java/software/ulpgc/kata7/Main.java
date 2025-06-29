package software.ulpgc.kata7;

import software.ulpgc.kata7.control.EnterNewPokemonCommand;
import software.ulpgc.kata7.view.MainFrame;

public class Main {
    public static void main(String[] args){
        MainFrame mainFrame = new MainFrame();
        mainFrame.put("send", new EnterNewPokemonCommand(mainFrame));
        mainFrame.setVisible(true);
    }
}
