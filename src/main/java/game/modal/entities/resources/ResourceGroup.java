package game.modal.entities.resources;


import game.exceptions.modal.entities.resources.ResourceTypeException;
import game.modal.entities.Copyable;

import java.util.Objects;


/**
 * ResourceGroup - contains resources
 * Gold, Ore, Wood and can be used like
 * price, balance of player and etc
 * @author Yura Vashkiv
 * @version 1.0
 * @since 07.05.2019
 */
public class ResourceGroup implements Copyable {

    private Ore ore;
    private Gold gold;
    private Wood wood;


    public ResourceGroup(Ore ore, Gold gold, Wood wood) {
        this.ore = ore;
        this.gold = gold;
        this.wood = wood;
    }


    public Ore getOre() {
        return ore;
    }


    public Gold getGold() {
        return gold;
    }


    public Wood getWood() {
        return wood;
    }


    public ResourceGroup add(ResourceGroup resourceGroup){
        try {
            this.gold.add(resourceGroup.gold);
            this.ore.add(resourceGroup.ore);
            this.wood.add(resourceGroup.wood);
        }catch (ResourceTypeException e){}
        return this;
    }


    public ResourceGroup sub(ResourceGroup resourceGroup){
        try {
            this.gold.sub(resourceGroup.gold);
            this.ore.sub(resourceGroup.ore);
            this.wood.sub(resourceGroup.wood);
        }catch (ResourceTypeException e){}
        return this;
    }


    public boolean greater(ResourceGroup resourceGroup){
        return this.gold.getValue() > resourceGroup.gold.getValue() &&
                this.ore.getValue() > resourceGroup.ore.getValue() &&
                this.wood.getValue() > resourceGroup.wood.getValue();
    }


    public boolean less(ResourceGroup resourceGroup){
        return this.gold.getValue() < resourceGroup.gold.getValue() &&
                this.ore.getValue() < resourceGroup.ore.getValue() &&
                this.wood.getValue() < resourceGroup.wood.getValue();
    }


    @Override
    public String toString() {
        return "ResourceGroup(" +
                "ore=" + ore +
                ", gold=" + gold +
                ", wood=" + wood +
                ')';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResourceGroup)) return false;
        ResourceGroup that = (ResourceGroup) o;
        return ore.equals(that.ore) &&
                gold.equals(that.gold) &&
                wood.equals(that.wood);
    }


    @Override
    public int hashCode() {
        return Objects.hash(ore, gold, wood);
    }


    @Override
    public ResourceGroup copy() {
        return new ResourceGroup(
                new Ore(ore.value),
                new Gold(gold.value),
                new Wood(wood.value)
        );
    }
}
