package game.modal.entities.player;

import game.modal.entities.resources.Gold;
import game.modal.entities.resources.Ore;
import game.modal.entities.resources.Wood;

import game.modal.entities.resources.ResourceGroup;

import game.modal.entities.units.RaceType;

import game.modal.entities.user.User;

import java.util.Objects;


public class Player {

    private User user;

    private RaceType race;

    private ResourceGroup balance = new ResourceGroup(
            new Ore(200),
            new Gold(200),
            new Wood(200)
    );

    public Player(User user, RaceType race) {
        this.user = user;
        this.race = race;
    }

    public User getUser() {
        return user;
    }

    public RaceType getRace() {
        return race;
    }

    public ResourceGroup getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return user.equals(player.user) &&
                race == player.race &&
                balance.equals(player.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, race, balance);
    }

    @Override
    public String toString() {
        return "Player(" +
                "user=" + user +
                ", race=" + race +
                ", balance=" + balance +
                ')';
    }
}
