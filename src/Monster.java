public class Monster extends Creature{
    public Monster(String name, int attackPoints, int protectPoints, int maxHealth, int minDamage, int maxDamage) {
        super(name, attackPoints, protectPoints, maxHealth, minDamage, maxDamage);
        System.out.println("Monster with the name of " + name + " has just spawned");
    }
}
