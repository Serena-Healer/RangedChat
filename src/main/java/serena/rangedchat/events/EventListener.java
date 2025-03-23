package serena.rangedchat.events;

import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Content;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import serena.rangedchat.data.Config;
import serena.rangedchat.util.Util;

import java.util.ArrayList;
import java.util.List;

public class EventListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        List<Player> playerList = new ArrayList<>();
        List<Player> playerListSpec = Util.getPlayersCanSeeChat(player);
        playerListSpec.forEach(p -> {
            if(p.getGameMode() != GameMode.SPECTATOR)playerList.add(p);
        });
        playerList.remove(player);
        playerListSpec.remove(player);
        net.md_5.bungee.api.chat.TextComponent text = new net.md_5.bungee.api.chat.TextComponent();
        net.md_5.bungee.api.chat.TextComponent textSpec = new net.md_5.bungee.api.chat.TextComponent();
        text.setText("<" + Util.getCustomPlayerName(player) + ChatColor.WHITE + "> " + event.getMessage());
        textSpec.setText("<" + Util.getCustomPlayerName(player) + ChatColor.WHITE + "> " + event.getMessage());
        List<Content> list = new ArrayList<>();
        List<Content> listSpec = new ArrayList<>();
        list.add(new Text(ChatColor.YELLOW + "チャットが送信された対象\n"));
        listSpec.add(new Text(ChatColor.YELLOW + "チャットが送信された対象\n"));
        list.add(new Text(Util.getCustomPlayerName(player) + ChatColor.GREEN + " (送信者)"));
        listSpec.add(new Text(Util.getCustomPlayerName(player) + ChatColor.GREEN + " (送信者)"));
        if(playerList.size() >= 1)list.add(new Text("\n"));
        if(playerListSpec.size() >= 1)listSpec.add(new Text("\n"));
        for(int j=0; j<playerList.size(); j++){
            list.add(new Text(Util.getCustomPlayerName(playerList.get(j))));
            if(j != playerList.size() - 1)list.add(new Text("\n"));
        }
        for(int j=0; j<playerListSpec.size(); j++){
            listSpec.add(new Text(Util.getCustomPlayerName(playerListSpec.get(j))));
            if(playerListSpec.get(j).getGameMode() == GameMode.SPECTATOR) {
                listSpec.add(new Text(ChatColor.GRAY + " (観戦者)"));
            }
            if (j != playerListSpec.size() - 1) listSpec.add(new Text("\n"));
        }
        list.add(new Text("\n" + ChatColor.DARK_GRAY + "一覧にはスペクテイターを含めません"));
        if(Config.targetChat){
            text.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, list));
        }
        textSpec.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, listSpec));
        playerListSpec.add(player);
        playerListSpec.forEach(p -> {
            if(p.getGameMode() == GameMode.SPECTATOR){
                p.spigot().sendMessage(textSpec);
            }else {
                p.spigot().sendMessage(text);
            }
        });
        event.setCancelled(true);
    }

}
