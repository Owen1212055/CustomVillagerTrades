package trade;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import be.seeseemelk.mockbukkit.MockBukkit;
import online.meinkraft.customvillagertrades.trade.VanillaTrade;

public class VanillaTradeTest {

    @BeforeAll
    public static void setUp()
    {
        MockBukkit.mock();
    }

    @AfterAll
    public static void tearDown()
    {
        MockBukkit.unmock();
    }

    @Test
    void createVanillaTrade() {

        //CustomTradeLoader.loadTrades(plugin);
        ItemStack stack = new ItemStack(Material.APPLE);
        MerchantRecipe recipe = new MerchantRecipe(stack, 1);
        assertInstanceOf(VanillaTrade.class, new VanillaTrade(1, recipe));
        
    }

    @Test
    void serializeItemStack() {

        ItemStack stack = new ItemStack(Material.APPLE);
        assertInstanceOf(Map.class, stack.serialize());
        
    }

}
