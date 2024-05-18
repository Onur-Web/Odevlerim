package week4.maceraOyunu.Locations;

import week4.maceraOyunu.BattleLocation;
import week4.maceraOyunu.Monsters.Bear;
import week4.maceraOyunu.Player.Player;

public class River extends BattleLocation {
    public River(Player player) {
        super(player, "Nehir",new Bear(),"Su",2);
    }
}
