
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // List of pets
        ArrayList<Pet> allPets = new ArrayList<>();
        String[] dogNames = { "Max", "Bella", "Buster", "Dexter", "Rex", "Leo", "Lady" };
        String[] catNames = { "Misty", "Whiskers", "Misty", "Tiger", "Fudge", "Marbles", "Simba" };
        String[] fishNames = { "Bubbles", "Harvey", "Blinky", "Larry", "Nemo", "Aqua", "Coral" };

        // Create pets
        for (int i = 0; i < 7; i++) {
            allPets.add(new Dog(dogNames[i], "Breed" + (i + 1), "Medium"));
            allPets.add(new Cat(catNames[i], "Short", i % 2 == 0));
            allPets.add(new Fish(fishNames[i], (i % 2 == 0 ? "Freshwater" : "Saltwater"), 10 + i));
        }

        // Create users
        String[] userNames = { "John", "Mike", "Sarah", "Eva", "Luke" };
        ArrayList<User> users = new ArrayList<>();
        for (String userName : userNames) {
            users.add(new User(userName));
        }

        // Assign 3 pets to users
        int petIndex = 0;
        for (User user : users) {
            for (int j = 0; j < 3 && petIndex < allPets.size(); j++) {
                user.addPet(allPets.get(petIndex));
                petIndex++;
            }
        }


        // Interactions
        for (User user : users) {
            System.out.println("\n- " + user.getName() + "'s Pets -");
            user.displayPets();

            // Specific interactions per user
            switch (user.getName()) {
                case "John":
                    user.interactWithPet("Max", "play");
                    break;
                case "Mike":
                    user.interactWithPet("Whiskers", "rest");
                    break;
                case "Sarah":
                    user.interactWithPet("Blinky", "feed");
                    break;
                case "Eva":
                    user.interactWithPet("Tiger", "play");
                    break;
                case "Luke":
                    user.interactWithPet("Nemo", "rest");
                    break;
            }

            user.getPets().forEach(Pet::handleSickState);
            user.checkAndRemoveDeadPets(allPets);

            System.out.println("\nNew pet levels:");
            user.displayPets();

        }

        System.out.println("\n- All Available Pets -");
        for (Pet p : allPets) {
            System.out.println(p.getName() + " (" + p.getType() + ")");
        }
    }
}
