package assignment;
public class Problem1 {
    private final int maxHealth;
    private int currentHealth;

    public Problem1(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth; // Starts at max health
    }

    public void takeDamage(int amount) {
        if (amount < 0) return;
        this.currentHealth = Math.max(0, this.currentHealth - amount); // Clamps at 0
        System.out.println("takeDamage(" + amount + ") -> health = " + this.currentHealth);
    }

    public void heal(int amount) {
        if (amount < 0) return;
        this.currentHealth = Math.min(this.maxHealth, this.currentHealth + amount); // Clamps at maxHealth
        System.out.println("heal(" + amount + ") -> health = " + this.currentHealth);
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public static void main(String[] args) {
        Problem1 c = new Problem1(100);

        c.takeDamage(30);  // health = 70
        c.heal(50);        // health = 100 (capped)
        c.takeDamage(150); // health = 0 (floored)
    }
}