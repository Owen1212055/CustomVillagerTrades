package online.meinkraft.customvillagertrades.trade;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.Base64;

public class ItemStackSerializer {

    public static ItemStack getItemStack(ConfigurationSection section, String tag) {
        return fromString(section.getString(tag));
    }

    public static String toString(ItemStack stack) {
        if (stack == null) {
            return null;
        }

        return Base64.getEncoder().encodeToString(stack.serializeAsBytes());
    }

    public static ItemStack fromString(String result) {
        if (result == null) {
            return null;
        }
        byte[] bytes = Base64.getDecoder().decode(result);

        return ItemStack.deserializeBytes(bytes);
    }
}
