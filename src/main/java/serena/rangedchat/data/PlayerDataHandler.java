package serena.rangedchat.data;

import org.bukkit.entity.Player;
import serena.rangedchat.screen.ScreenBase;

public class PlayerDataHandler {

    public Player owner;
    ScoreboardHandler scoreboardHandler;
    private int sbTick = 0;
    public ScreenBase currentScreen = null;

    public PlayerDataHandler(Player owner){
        this.owner = owner;
        scoreboardHandler = new ScoreboardHandler(owner);
    }

    public void onTick(){
        sbTick++;
        if(sbTick >= 2){
            sbTick = 0;
            scoreboardHandler.update(owner);
        }
    }

}
