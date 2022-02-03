package online.meinkraft.customvillagertrades.trade;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Biome;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class CustomTrade implements Cloneable {

    private String key;
    private ItemStack result;
    private ItemStack firstIngredient;
    private ItemStack secondIngredient;
    private Integer maxUses;
    private Double priceMultiplier;
    private Integer villagerExperience;
    private Boolean giveExperienceToPlayer;

    private Double chance;
    private List<Villager.Profession> professions;
    private List<Integer> levels;
    private List<Villager.Type> villagerTypes;
    private List<Biome> biomes;
    
    private MerchantRecipe recipe;
    
    public CustomTrade(

        String key,

        ItemStack result,
        ItemStack firstIngredient,
        ItemStack secondIngredient,
        Integer maxUses,
        Double priceMultiplier,
        Integer villagerExperience,
        Boolean giveExperienceToPlayer,

        Double chance,
        List<Villager.Profession> professions,
        List<Integer> levels,
        List<Villager.Type> villagerTypes,
        List<Biome> biomes

    ) {

        this.key = key;

        this.result = result;
        this.firstIngredient = firstIngredient;
        this.secondIngredient = secondIngredient;
        this.maxUses = maxUses;
        this.priceMultiplier = priceMultiplier;
        this.villagerExperience = villagerExperience;
        this.giveExperienceToPlayer = giveExperienceToPlayer;

        this.chance = chance;
        this.professions = professions;
        this.levels = levels;
        this.villagerTypes = villagerTypes;
        this.biomes = biomes;
        
        // create recipe
        recipe = new MerchantRecipe(
            result,
            maxUses
        );

        recipe.addIngredient(firstIngredient);
        if(secondIngredient != null) recipe.addIngredient(secondIngredient);
        
        recipe.setPriceMultiplier(priceMultiplier.floatValue());

        recipe.setExperienceReward(giveExperienceToPlayer);
        recipe.setVillagerExperience(villagerExperience);

    }

    public String getKey() {
        return key;
    }

    public ItemStack getFirstIngredient() {
        return firstIngredient;
    }

    public ItemStack getSecondIngredient() {
        return secondIngredient;
    }

    public ItemStack getResult() {
        return result;
    }

    public Integer getMaxUses() {
        return maxUses;
    }

    public Double getPriceMultiplier() {
        return priceMultiplier;
    }

    public Double getChance() {
        return chance;
    }

    public List<Villager.Profession> getProfessions() {
        return professions;
    }

    public List<Integer> getLevels() {
        return levels;
    }

    public Boolean giveExperienceToPlayer() {
        return giveExperienceToPlayer;
    }

    public Integer getVillagerExperience() {
        return villagerExperience;
    }

    public MerchantRecipe getRecipe() {
        return recipe;
    }

    public List<Villager.Type> getVillagerTypes() {
        return villagerTypes;
    }

    public List<Biome> getBiomes() {
        return biomes;
    }

    public CustomTrade clone() {

        ItemStack result = null;
        ItemStack firstIngredient = null;
        ItemStack secondIngredient = null;

        result = this.result.clone();
        firstIngredient = this.firstIngredient.clone();
        if(this.secondIngredient != null) {
            secondIngredient = this.secondIngredient.clone();
        }

        List<Villager.Profession> professions = new ArrayList<>();
        professions.addAll(this.professions);

        List<Integer> levels = new ArrayList<>();
        levels.addAll(this.levels);

        List<Villager.Type> villagerTypes = new ArrayList<>();
        villagerTypes.addAll(this.villagerTypes);

        List<Biome> biomes = new ArrayList<>();
        biomes.addAll(this.biomes);

        return new CustomTrade(

            getKey(), 
            result, 
            firstIngredient, 
            secondIngredient, 
            maxUses, 
            priceMultiplier, 
            villagerExperience, 
            giveExperienceToPlayer, 
            chance, 
            professions, 
            levels, 
            villagerTypes, 
            biomes

        );

    }

    public void setFirstIngredient(ItemStack itemStack) {
        firstIngredient = itemStack;
    }

    public void setSecondIngredient(ItemStack itemStack) {
        secondIngredient = itemStack;
    }

    public void setResult(ItemStack itemStack) {
        result = itemStack;
    }
}