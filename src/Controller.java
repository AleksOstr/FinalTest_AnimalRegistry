import model.Registry;

import java.time.LocalDate;

public class Controller {
    Registry registry;

    public Controller(Registry registry) {
        this.registry = registry;
    }

    public void showPets() {
        registry.showPets();
    }

    public void showPackAnimals() {
        registry.showPackAnimals();
    }

    public void addNewAnimal(String animalName, String animalType, LocalDate animalBirthday) {
        registry.addNewAnimal(animalName, animalType, animalBirthday);
    }

    public void addPetCommand(String petName, String commandName) {
        registry.addCommandToPet(petName,commandName);
    }

    public void addPackAnimalCommand(String packAnimalName, String commandName) {
        registry.addCommandToPackAnimal(packAnimalName, commandName);
    }
}
