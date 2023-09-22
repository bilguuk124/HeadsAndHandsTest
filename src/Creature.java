public abstract class Creature {
    private String name;
    private int attackPoints;
    private int protectPoints;
    private int maxHealth;
    private int currentHealth;
    private int minDamage;
    private int maxDamage;
    private final int MINDICE = 1;
    private final int MAXDICE = 6;

    public Creature(String name, int attackPoints, int protectPoints, int maxHealth, int minDamage, int maxDamage){
        this.name = name;
        this.attackPoints = attackPoints;
        this.protectPoints = protectPoints;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    private boolean canAttack(Creature target){
        int attackModifier = this.attackPoints - (target.protectPoints + 1);
        attackModifier = attackModifier > 0 ? attackModifier : 1;
        int[] dice = new int[attackModifier];
        for (int i = 0 ; i < attackModifier; i ++){
            dice[i] = (int) (Math.random() * (MAXDICE - MINDICE + 1)) + MINDICE;
            System.out.printf("%2s", dice[i]);
            if (dice[i] >= 5) {
                System.out.println("        Dice with value of 5 or 6! The attack is successful");
                return true;
            };
        }
        return false;
    }

    public void attack(Creature target){
        if (!canAttack(target)) {
            System.out.println("    Too bad! " + name + " could not hit " + target.name);
            return;
        }
        int damage = (int) (Math.random() * (maxDamage - minDamage + 1)) + minDamage;
        target.getHit(damage);
        System.out.println(name + " has attacked " + target.name + " for " + damage + " damage!.");
    }

    public boolean isAlive(){
        if (this.currentHealth <= 0) {
            System.out.println(name + " is dead.");
            return false;
        } else
            return true;
    }

    public void getHit(int damage){
        this.currentHealth -= damage;
        if (currentHealth < 0) currentHealth = 0;
    }

    public String getName() {
        return name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getProtectPoints() {
        return protectPoints;
    }

    public void setProtectPoints(int protectPoints) {
        this.protectPoints = protectPoints;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void addCurrentHealth(){
        this.currentHealth += (int) (0.3 * maxHealth);
        if (currentHealth > maxHealth) currentHealth = maxHealth;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }



}
