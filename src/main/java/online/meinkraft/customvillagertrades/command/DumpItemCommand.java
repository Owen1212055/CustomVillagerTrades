package online.meinkraft.customvillagertrades.command;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import online.meinkraft.customvillagertrades.CustomVillagerTrades;
import online.meinkraft.customvillagertrades.exception.VillagerNotMerchantException;
import online.meinkraft.customvillagertrades.trade.CustomTradeManager;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.Merchant;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class DumpItemCommand extends PluginCommand {

    public DumpItemCommand(CustomVillagerTrades plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(
                ChatColor.RED + 
                plugin.getMessage("playerOnlyCommand")
            );
            return false;
        }

        Player player = sender.getServer().getPlayer(sender.getName());
        String bytes = Base64.getEncoder().encodeToString(player.getInventory().getItemInMainHand().serializeAsBytes());

        Component text = Component.text(bytes);
        player.sendMessage(Component.text("Click to copy").hoverEvent(text).clickEvent(ClickEvent.copyToClipboard(bytes)));
        return true;

    }
    
}
