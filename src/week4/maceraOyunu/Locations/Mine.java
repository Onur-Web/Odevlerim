package week4.maceraOyunu.Locations;

import week4.maceraOyunu.BattleLocation;
import week4.maceraOyunu.Monsters.Snake;
import week4.maceraOyunu.Player.Player;

public class Mine extends BattleLocation {
    public Mine(Player player) {
        super(player, "Maden", new Snake(), "Para, Silah veya Zırh", 5);
    }
}
