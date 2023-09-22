public class Player extends Creature{

    private int healthVials = 4;
    public Player(String name, int attackPoints, int protectPoints, int maxHealth, int minDamage, int maxDamage) {
        super(name, attackPoints, protectPoints, maxHealth, minDamage, maxDamage);
        System.out.println("Player has spawned with the name of " + name);
    }

    public void heal(){
        if (healthVials > 0) {
            healthVials --;
            addCurrentHealth();
            System.out.println("Player " +getName() + " has just healed himself by " + (int)(0.3 * getMaxHealth()));
        }
        else {
            System.out.println("No health vials in inventory");
        }
    }

    public int getHealthVials() {
        return healthVials;
    }

    public void setHealthVials(int healthVials) {
        this.healthVials = healthVials;
    }


}
