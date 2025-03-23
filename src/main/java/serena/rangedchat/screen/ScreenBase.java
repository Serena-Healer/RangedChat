package serena.rangedchat.screen;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class ScreenBase {

    String name;
    Inventory inventory;
    public ScreenBase(Player player, int rows, String name){
        this.name = name;
        player.closeInventory();
        inventory = player.getServer().createInventory(player, rows * 9);
        player.openInventory(inventory);
    }

    public void update(){

    }

    //キャンセルするならtrue
    public abstract boolean onClick(int slot, ItemStack stack, boolean isLeft, boolean isShift);

}
