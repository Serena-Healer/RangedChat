package serena.rangedchat.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;
import serena.rangedchat.data.Config;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static void handleException(Throwable e){
        Throwable next = e;
        sendMessageToAll(ChatColor.YELLOW + "*==============================================*");
        while(next != null){
            sendMessageToAll(ChatColor.RED + "[Error]" + next + " : " + next.getMessage());
            sendMessageToAll(ChatColor.RED + "[Error] 発生箇所: " + next.getStackTrace()[0]);
            next = e.getCause();
        }
        sendMessageToAll(ChatColor.YELLOW + "*==============================================*");
        if(e != null)e.printStackTrace();
    }

    public static void sendMessageToAll(String msg){
        Bukkit.getOnlinePlayers().forEach(p -> {
            p.sendMessage(msg);
        });
    }

    public static List<Player> getPlayersInRange(Location loc, double range){
        List<Player> ans = new ArrayList<>();
        Bukkit.getOnlinePlayers().forEach(p -> {
            if(p.getLocation().distance(loc) < range)ans.add(p);
        });
        return ans;
    }

    public static List<Player> getPlayersCanSeeChat(Player player){
        List<Player> ans = new ArrayList<>();
        Bukkit.getOnlinePlayers().forEach(p -> {
            if(player.getGameMode() == GameMode.SPECTATOR){
                if ((Config.spectatorSend && p.getLocation().distance(player.getLocation()) <= Config.distance
                    && Math.abs(p.getLocation().getY() - player.getLocation().getY()) <= Config.distanceY) ||
                        (p.getGameMode() == GameMode.SPECTATOR && Config.spectatorReceive))
                    ans.add(p);
            }else {
                if ((p.getLocation().distance(player.getLocation()) <= Config.distance
                        && Math.abs(p.getLocation().getY() - player.getLocation().getY()) <= Config.distanceY) ||
                        (p.getGameMode() == GameMode.SPECTATOR && Config.spectatorReceive))
                    ans.add(p);
            }
        });
        return ans;
    }

    public static String getCustomPlayerName(Player player){
        String ans = "";
        Team team = Bukkit.getScoreboardManager().getMainScoreboard().getEntryTeam(player.getName());
        if(team != null){
            ans += team.getColor();
            ans += team.getPrefix();
        }
        ans += player.getDisplayName();
        if(team != null){
            ans += team.getSuffix();
        }
        return ans;
    }

}
