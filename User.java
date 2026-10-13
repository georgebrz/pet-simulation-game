import java.util.ArrayList;

public class User {
    private final String name;
    private final ArrayList<Pet> pets;

    public User(String name) {
        this.name = name;
        pets = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public boolean addPet(Pet pet) {
        if (pets.size() >= 3) {
            System.out.println("You can only have 3 pets.");
            return false;
        }
        pets.add(pet);
        return true;
    }

    public void removePet(String petName) {
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getName().equals(petName)) {
                pets.remove(i);
                System.out.println(petName + " has been removed.");
                return;
            }
        }
        System.out.println("Pet not found.");
    }

    public void displayPets() {
        System.out.println(name + " has " + pets.size() + " pet(s):");
        for (Pet p : pets) {
            System.out.println("Name: " + p.getName() +
                    " | Type: " + p.getType() +
                    " | Health: " + p.getHealth() +
                    " | Hunger: " + p.getHunger() +
                    " | Happiness: " + p.getHappiness() +
                    " | Energy: " + p.getEnergy());
        }
    }

    public void modifyPet(String petName, String attribute, int value) {
        for (Pet p : pets) {
            if (p.getName().equals(petName)) {
                switch (attribute) {
                    case "health":
                        p.setHealth(value);
                        break;
                    case "hunger":
                        p.setHunger(value);
                        break;
                    case "happiness":
                        p.setHappiness(value);
                        break;
                    case "energy":
                        p.setEnergy(value);
                        break;
                    default:
                        System.out.println("Unknown attribute.");
                        break;
                }
                return;
            }
        }
        System.out.println("Pet not found.");
    }

    public void interactWithPet(String petName, String action) {
        for (Pet p : pets) {
            if (p.getName().equals(petName)) {
                switch (action) {
                    case "feed":
                        p.feed();
                        break;
                    case "play":
                        p.play();
                        break;
                    case "rest":
                        p.rest();
                        break;
                    default:
                        System.out.println("Invalid action.");
                        break;
                }
                return;
            }
        }
        System.out.println("Pet not found.");
    }


    public void checkAndRemoveDeadPets(ArrayList<Pet> availableList) {
        ArrayList<Pet> toRemove = new ArrayList<>();
        for (Pet p : pets) {
            if (p.isDead()) {
                System.out.println(p.getName() + " has died and was removed.");
                toRemove.add(p);
                availableList.add(p);
            }
        }
        pets.removeAll(toRemove);
    }
}
