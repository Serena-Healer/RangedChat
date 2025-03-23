package serena.rangedchat.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import serena.rangedchat.data.PlayerDataHandler;
import serena.rangedchat.system.Main;

public class ScreenEventListener implements Listener {

    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        PlayerDataHandler data = Main.getPlayerData((Player) event.getWhoClicked());
        if(data.currentScreen != null){
            event.setCancelled(data.currentScreen.onClick(event.getSlot(), event.getCurrentItem(), event.isLeftClick(), event.isShiftClick()));
        }
    }

    @EventHandler
    public void onCloseInventory(InventoryCloseEvent event){
        PlayerDataHandler data = Main.getPlayerData((Player) event.getPlayer());
        data.currentScreen = null;
    }
}
