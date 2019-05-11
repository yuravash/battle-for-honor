package game.modal.factories.characteristics;

import game.modal.entities.units.Characteristics;

import java.util.ArrayList;


public class CharacteristicsFactory {

    final private ArrayList<Characteristics> cache = new ArrayList<>();

    private static CharacteristicsFactory factory = new CharacteristicsFactory();

    private CharacteristicsFactory(){}

    public static CharacteristicsFactory getInstance(){
        return factory;
    }

    public Characteristics getCharacteristics(int damage, int radiusOfAttack, int travelDistance){
        for (Characteristics obj : cache) {
            if (obj.getDamage() == damage &&
                obj.getRadiusOfAttack() == radiusOfAttack &&
                obj.getTravelDistance() == travelDistance){
                return obj;
            }
        }
        Characteristics newCharacteristics = new Characteristics(damage, radiusOfAttack, travelDistance);
        cache.add(newCharacteristics);
        return newCharacteristics;
    }
}
