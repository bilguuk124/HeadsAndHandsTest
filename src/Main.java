public class Main {
    public static void main(String[] args) {
        Player player = new Player("Pikachu", 30, 10, 100, 10, 50);
        Monster monster = new Monster("Zombie", 30, 10, 100, 10, 50);

        while(player.isAlive() && monster.isAlive()){
            player.attack(monster);
            if (!monster.isAlive()) break;

            monster.attack(player);
            if (!player.isAlive()) break;

            if (player.getCurrentHealth() < (player.getMaxHealth() / 2)) player.heal();
        }

        if (player.isAlive()){
            System.out.println("Player " + player.getName() + " wins!");
        }
        else{
            System.out.println("Monster "  + monster.getName() + " wins!");
        }
    }
}