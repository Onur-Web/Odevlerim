package week4.maceraOyunu.Locations;

import week4.maceraOyunu.BattleLocation;
import week4.maceraOyunu.Monsters.Vampire;
import week4.maceraOyunu.Player.Player;

public class Forest extends BattleLocation {
    public Forest(Player player) {
        super(player, "Orman", new Vampire(), "Odun",3);
    }
}
