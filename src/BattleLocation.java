import java.util.Random;

public class BattleLocation extends Location {
    private Enemy newEnemy;
    private String loot;
    private int maxEnemy;

    public BattleLocation(Player newPlayer, String name, Enemy newEnemy, String loot, int maxEnemy) {
        super(newPlayer, name);
        this.newEnemy = newEnemy;
        this.loot = loot;
        this.maxEnemy = maxEnemy;
    }

    @Override
    public boolean onLocation() {
        int maxEnemy = this.randomEnemy();
        System.out.println("You are here now!" + " " + this.getLocationName());
        System.out.println("Careful The Enemies Lives Here " + maxEnemy + " " + this.getNewEnemy().getEnemyName());
        System.out.println("Press F for fight or Press R for run..!");
        String actionCase = select.nextLine();
        actionCase = actionCase.toUpperCase();
        if (actionCase.equals("F")) {
            if (combat(maxEnemy)) {
                System.out.println(this.getLocationName() + " " + "You Survived..!");
                return true;
            }
        }
        if (this.getNewPlayer().getPlayerHealth() <= 0) {
            System.out.println("You died...RIP...!");
            return false;
        }
        return true;
    }

    public boolean combat(int maxEnemy) {
        for (int i = 1; i <= maxEnemy; i++) {
            this.getNewEnemy().setEnemyHealth(this.getNewEnemy().getDefaultEnemyHealth());
            playerStats();
            enemyStats(i);
            while (this.getNewPlayer().getPlayerHealth() > 0 && this.getNewEnemy().getEnemyHealth() > 0) {
                System.out.println("Press H for hit or Press R for run..! ");
                String selectCombat = select.nextLine().toUpperCase();
                if (selectCombat.equals("H")) {
                    System.out.println("You Hit The Enemy ! ");
                    this.getNewEnemy().setEnemyHealth(this.getNewEnemy().getEnemyHealth() - this.getNewPlayer().getTotalDamage());
                    afterHit();
                    if (this.getNewEnemy().getEnemyHealth() > 0) {
                        System.out.println();
                        System.out.println("Enemy Hit You ! ");
                        int enemyDamage = this.getNewEnemy().getEnemyDamage() - this.getNewPlayer().getInventory().getArmor().getArmorBlock();
                        if (enemyDamage < 0) {
                            enemyDamage = 0;
                        }
                        this.getNewPlayer().setPlayerHealth(this.getNewPlayer().getPlayerHealth() - enemyDamage);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }

            if (this.getNewEnemy().getEnemyHealth() < this.getNewPlayer().getPlayerHealth()) {
                System.out.println("You Killed The Enemy !");
                System.out.println("Loot : " + this.getNewEnemy().getEnemyGold() + " " + "Gold");
                this.getNewPlayer().setPlayerGold(this.getNewPlayer().getPlayerGold() + this.getNewEnemy().getEnemyGold());
                System.out.println("Your Loot : " + this.getNewPlayer().getPlayerGold());
            } else {
                return false;
            }

        }
        return true;
    }

    public void afterHit() {
        System.out.println("Your Health : " + this.getNewPlayer().getPlayerHealth());
        System.out.println(this.getNewEnemy().getEnemyName() + " Health : " + this.getNewEnemy().getEnemyHealth());
        System.out.println("----------------------");
    }

    public void enemyStats(int i) {
        System.out.println(i + "." + "Enemy Status : ");
        System.out.println("---------------------------------");
        System.out.println("Enemy Name : " + this.getNewEnemy().getEnemyName());
        System.out.println("Enemy Health : " + this.getNewEnemy().getEnemyHealth());
        System.out.println("Enemy Damage : " + this.getNewEnemy().getEnemyDamage());
        System.out.println("Enemy Gold : " + this.getNewEnemy().getEnemyGold());
    }

    public void playerStats() {
        System.out.println("Player Status : ");
        System.out.println("---------------------------------");
        System.out.println("Player Health : " + this.getNewPlayer().getPlayerHealth());
        System.out.println("Player Weapon : " + this.getNewPlayer().getInventory().getWeapon().getWeaponName());
        System.out.println("Player Armor : " + this.getNewPlayer().getInventory().getArmor().getArmorName());
        System.out.println("Player Block : " + this.getNewPlayer().getInventory().getArmor().getArmorBlock());
        System.out.println("Player Damage : " + this.getNewPlayer().getTotalDamage());
        System.out.println("Player Gold : " + this.getNewPlayer().getPlayerGold());
        System.out.println();

    }

    public int randomEnemy() {
        Random data = new Random();
        return data.nextInt(this.getMaxEnemy()) + 1;
    }

    public Enemy getNewEnemy() {
        return newEnemy;
    }

    public void setNewEnemy(Enemy newEnemy) {
        this.newEnemy = newEnemy;
    }

    public String getLoot() {
        return loot;
    }

    public void setLoot(String loot) {
        this.loot = loot;
    }

    public int getMaxEnemy() {
        return maxEnemy;
    }

    public void setMaxEnemy(int maxEnemy) {
        this.maxEnemy = maxEnemy;
    }
}
