package serena.rangedchat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import serena.rangedchat.data.Config;
import serena.rangedchat.events.EventListener;
import serena.rangedchat.events.ScreenEventListener;
import serena.rangedchat.system.Main;
import serena.rangedchat.util.Util;

public final class Templete extends JavaPlugin {

    public static String pluginName = "近アモチャット";
    public static String version = "0.1.0";
    public static Plugin INSTANCE;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
        Main.onTick();
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        getServer().getPluginManager().registerEvents(new ScreenEventListener(), this);
        System.out.println(pluginName + " " + version + " が正常に起動しました。");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("setdist")){
            Config.distance = Double.parseDouble(args[0]);
            Util.sendMessageToAll(ChatColor.GREEN + "チャット視認範囲が " + String.format("%.1f", Config.distance) + "[m] に設定されました。");
            return true;
        }
        if(command.getName().equals("setdisty")){
            Config.distanceY = Double.parseDouble(args[0]);
            Util.sendMessageToAll(ChatColor.GREEN + "チャット視認鉛直範囲が " + String.format("%.1f", Config.distanceY) + "[m] に設定されました。");
            return true;
        }
        if(command.getName().equals("specreceive")){
            Config.spectatorReceive = Boolean.parseBoolean(args[0]);
            Util.sendMessageToAll(ChatColor.GREEN + "スペクテイター視認が " + (Config.spectatorReceive ? "有効" : "無効") + " に設定されました。");
            return true;
        }
        if(command.getName().equals("specsend")){
            Config.spectatorSend = Boolean.parseBoolean(args[0]);
            Util.sendMessageToAll(ChatColor.GREEN + "スペクテイター送信が " + (Config.spectatorSend ? "有効" : "無効") + " に設定されました。");
            return true;
        }
        if(command.getName().equals("displaytarget")){
            Config.displayTargets = Boolean.parseBoolean(args[0]);
            Util.sendMessageToAll(ChatColor.GREEN + "対象プレイヤー表示が " + (Config.displayTargets ? "有効" : "無効") + " に設定されました。");
            return true;
        }
        if(command.getName().equals("targetchat")){
            Config.targetChat = Boolean.parseBoolean(args[0]);
            Util.sendMessageToAll(ChatColor.GREEN + "対象プレイヤーチャット表示が " + (Config.targetChat ? "有効" : "無効") + " に設定されました。");
            return true;
        }
        if(command.getName().equals("all")){
            Util.sendMessageToAll("<" + Util.getCustomPlayerName((Player) sender) + ChatColor.WHITE + ">" + ChatColor.AQUA + "【全体】" + ChatColor.WHITE + args[0]);
            return true;
        }
        if(command.getName().equals("info")){
            Player player = (Player) sender;
            player.sendMessage("");
            player.sendMessage(ChatColor.YELLOW + pluginName);
            player.sendMessage(ChatColor.WHITE + "             by ScellenaHealer " + ChatColor.GRAY + " Ver." + version);
            player.sendMessage("");
            player.sendMessage(ChatColor.YELLOW + "使い方");
            player.sendMessage("指定範囲内のプレイヤーにのみチャットが送信されるようになります。");
            player.sendMessage("チャットにカーソルを合わせるとそのチャットが");
            player.sendMessage("誰に送信されたか確認することができます。");
            player.sendMessage("");
            player.sendMessage(ChatColor.YELLOW + "コマンド一覧");
            player.sendMessage("/setdist N ... チャット有効距離を設定します。");
            player.sendMessage("/setdisty N ... チャット有効鉛直方向距離を設定します。");
            player.sendMessage("/specreceive S ... スペクテイターがチャットを常時受け取るか設定します。");
            player.sendMessage("/specsend S ... スペクテイターのチャットが他に聞こえるか設定します。");
            player.sendMessage("/targetchat S ... チャット送信対象を表示するか設定します。");
            player.sendMessage("/displaytarget S ... 画面右に送信対象を常時表示するか設定します。");
            player.sendMessage("/all S ... 全体にメッセージを送信します。");
            player.sendMessage("/info ... このヘルプを呼び出します。");
            return true;
        }
        return super.onCommand(sender, command, label, args);
    }

}
