
public abstract class Pet implements SickState {
    private final String name;
    private final String type;
    private int health; // 0–100
    private int hunger; // 0–100
    private int happiness; // 0–70
    private int energy; // 0–70

    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
        this.health = 50;
        this.hunger = 50;
        this.happiness = 50;
        this.energy = 50;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public int getHunger() {
        return hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getEnergy() {
        return energy;
    }

    // Setters
    public void setHealth(int value) {
        health = Math.max(0, Math.min(100, value));
    }

    public void setHunger(int value) {
        hunger = Math.max(0, Math.min(100, value));
    }

    public void setHappiness(int value) {
        happiness = Math.max(0, Math.min(70, value));
    }

    public void setEnergy(int value) {
        energy = Math.max(0, Math.min(70, value));
    }

    // Methods
    public abstract void feed();

    public abstract void play();

    public abstract void rest();

    public boolean isSick() {
        return health < 20;
    }

    public boolean isDead() {
        return health == 0;
    }


    @Override
    public void handleSickState() {
        if (isSick() && !isDead()) {
            System.out.println(name + " is sick! Please take care of their health.");
        }
    }


    public String getStatus() {
        return "Name: " + name +
                " | Type: " + type +
                " | Health: " + health +
                " | Hunger: " + hunger +
                " | Happiness: " + happiness +
                " | Energy: " + energy;
    }
}
