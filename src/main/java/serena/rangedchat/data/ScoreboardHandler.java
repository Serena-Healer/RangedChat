package serena.rangedchat.data;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import serena.rangedchat.Templete;
import serena.rangedchat.util.Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ScoreboardHandler {

    Player owner;
    Scoreboard scoreboard;
    Objective obj;

    public ScoreboardHandler(Player player){
        this.owner = player;
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        owner.setScoreboard(scoreboard);
    }

    public void update(Player newOwner){
        this.owner = newOwner;
        obj = scoreboard.getObjective("display");
        if(obj != null) {
            obj.unregister();
        }
        obj = scoreboard.registerNewObjective("display", "dummy", Templete.pluginName + ChatColor.DARK_GRAY + " Ver." + Templete.version);
        if(Config.displayTargets){
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);
            owner.setScoreboard(scoreboard);
        }else{
            owner.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
        }

        List<String> strings = new ArrayList<>();

        //strings リストに表示文字列を追加
        List<Player> list = Util.getPlayersCanSeeChat(owner);
        AtomicInteger cnt = new AtomicInteger();

        list.forEach(l -> {
            if(l != owner){
                if(owner.getGameMode() == GameMode.SPECTATOR || l.getGameMode() != GameMode.SPECTATOR) {
                    cnt.getAndIncrement();
                }
            }
        });
        strings.add(ChatColor.YELLOW + "チャット送信先(" + (cnt) + ")");
        list.forEach(l -> {
            if(l != owner){
                if(owner.getGameMode() == GameMode.SPECTATOR || l.getGameMode() != GameMode.SPECTATOR) {
                    strings.add(Util.getCustomPlayerName(l));
                }
            }
        });

        Collection<String> stringDupeCheck = new HashSet<>();
        AtomicInteger i = new AtomicInteger(strings.size());
        Objective finalObj = obj;
        strings.forEach(s -> {
            StringBuilder sn = new StringBuilder(s);
            while(stringDupeCheck.contains(String.valueOf(sn))){
                sn.append(" ");
            }
            finalObj.getScore(String.valueOf(sn)).setScore(i.getAndDecrement());
            stringDupeCheck.add(String.valueOf(sn));
        });
    }

}
