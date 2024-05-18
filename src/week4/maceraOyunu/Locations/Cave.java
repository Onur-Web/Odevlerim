package week4.maceraOyunu.Locations;

import week4.maceraOyunu.BattleLocation;
import week4.maceraOyunu.Monsters.Zombie;
import week4.maceraOyunu.Player.Player;

public class Cave extends BattleLocation {
    public Cave(Player player) {
        super(player, "Mağara", new Zombie(), "Yemek",3);
    }
}
