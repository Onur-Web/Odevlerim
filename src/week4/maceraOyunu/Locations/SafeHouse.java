package week4.maceraOyunu.Locations;

import week4.maceraOyunu.Game;
import week4.maceraOyunu.Player.Player;

public class SafeHouse extends NormalLocation {

    private Game game;

    public SafeHouse(Player player, Game game) {
        super(player, "Güvenli Ev");
        this.game = game;
    }

    @Override
    public boolean onLocation() {
        System.out.println("---- Güvenli Evdesiniz ---");
        System.out.println("Dinlendiniz ve İyileştiniz");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());


        if (this.getPlayer().getInventory().isWood() && this.getPlayer().getInventory().isWater() && this.getPlayer().getInventory().isFood()) {
            System.out.println("Tebrikler oyunu kazandınız");
            this.game.setGameCompleted(true);
        }
        return true;
    }


}
