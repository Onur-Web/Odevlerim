package week4.maceraOyunu.Locations;

import week4.maceraOyunu.Player.Player;

public abstract class NormalLocation extends Location {

    public NormalLocation(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
