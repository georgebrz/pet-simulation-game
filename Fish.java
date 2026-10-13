public class Fish extends Pet {
    private final String waterType;

    public Fish(String name, String waterType, int tankSize) {
        super(name, "Fish");
        this.waterType = waterType;
    }

    public String getWaterType() {
        return waterType;
    }

    @Override
    public void feed() {
        if (getHunger() > 0) {
            setHunger(getHunger() - 20);
            System.out.println(getName() + " finished the food. Hunger has been reduced");
        } else {
            System.out.println(getName() + " is not hungry right now.");
        }
    }

    @Override
    public void play() {
        if (getHunger() <= 20 || getEnergy() <= 10) {
            System.out.println(getName() + " is too tired or hungry to play.");
        } else {
            setHappiness(getHappiness() + 10);
            setEnergy(getEnergy() - 10);
            System.out.println(getName() + " is happy! Happiness has been increased and Energy has been reduced.");
        }
    }

    @Override
    public void rest() {
        setEnergy(getEnergy() + 20);
        setHealth(getHealth() + 10);
        System.out.println(getName() + " took a nap and is feeling rested.");
    }

    public void swim() {
        System.out.println(getName() + " glides through the water calmly.");
    }
}


