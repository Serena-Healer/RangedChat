package serena.rangedchat.system;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import serena.rangedchat.Templete;
import serena.rangedchat.data.GameDataHandler;
import serena.rangedchat.data.PlayerDataHandler;
import serena.rangedchat.util.Util;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String, PlayerDataHandler> playerData = new HashMap<>();
    static GameDataHandler gameData = new GameDataHandler();

    public static void onTick(){
        try {
            Bukkit.getScheduler().scheduleSyncDelayedTask(Templete.INSTANCE, new Runnable() {
                @Override
                public void run() {
                    onTick();
                }
            }, 1);

            Bukkit.getOnlinePlayers().forEach(p -> {
                getPlayerData(p).onTick();
            });

            //毎ティック行う処理

        }catch(Exception e){
            Util.handleException(e);
        }
    }

    public static PlayerDataHandler getPlayerData(Player player){
        String name = player.getName();
        if(!playerData.containsKey(name)){
            playerData.put(name, new PlayerDataHandler(player));
        }
        playerData.get(name).owner = player;
        return playerData.get(name);
    }

    public static PlayerDataHandler getPlayerData(String name){
        if(!playerData.containsKey(name)){
            playerData.put(name, new PlayerDataHandler(Bukkit.getPlayer(name)));
        }
        return playerData.get(name);
    }

    public static GameDataHandler getGameData(){
        return gameData;
    }

}
