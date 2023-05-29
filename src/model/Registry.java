package model;

import Databases.PackAnimalDatabase;
import Databases.PetDatabase;
import model.animals.Command;
import model.animals.PackAnimal;
import model.animals.Pet;


public class Registry {
    private PetDatabase petDB = new PetDatabase();
    private PackAnimalDatabase packAnimalDB = new PackAnimalDatabase();

    public void showPets() {
        petDB.showDatabase();
    }

    public void showPackAnimals() {
        packAnimalDB.showDatabase();
    }

    private void addPet(Pet pet) {
        petDB.add(pet);
    }

    private void addPackAnimal(PackAnimal packAnimal) {
        packAnimalDB.add(packAnimal);
    }

    public void addCommandToPet(String targetPetName, String commandName) {
        for (Pet pet : petDB.getDatabase()) {
            if (pet.getAnimalName().equals(targetPetName)) {
                pet.addCommand(new Command(commandName));
                return;
            }
        }
        throw new RuntimeException("Pet not found");
    }

    public void addCommandToPackAnimal(String targetPackAnimalName, String commandName) {
        for (PackAnimal packAnimal : packAnimalDB.getDatabase()) {
            if (packAnimal.getAnimalName().equals(targetPackAnimalName)) {
                packAnimal.addCommand(new Command(commandName));
                return;
            }
        }
        throw new RuntimeException("Pack animal not found");
    }

    private Pet findPetByName(String targetPetName) {
        for (Pet pet : petDB.getDatabase()) {
            if (pet.getAnimalName().equals(targetPetName)) {
                return pet;
            }
        }
        throw new RuntimeException("Pet not found");
    }

    private PackAnimal findPackAnimalByName(String targetPackAnimalName) {
        for (PackAnimal packAnimal : packAnimalDB.getDatabase()) {
            if (packAnimal.getAnimalName().equals(targetPackAnimalName)) {
                return packAnimal;
            }
        }
        throw new RuntimeException("Pack animal not found");
    }

    public void showPetCommands(String petName) {
        findPetByName(petName).showCommands();
    }

    public void showPackAnimalCommands(String packAnimalName) {
        findPackAnimalByName(packAnimalName).showCommands();
    }
}
