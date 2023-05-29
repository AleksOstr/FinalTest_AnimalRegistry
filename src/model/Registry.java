package model;

import Databases.PackAnimalDatabase;
import Databases.PetDatabase;
import model.animals.Animal;
import model.animals.Command;
import model.animals.PackAnimal;
import model.animals.Pet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Registry {
    private PetDatabase petDB;
    private PackAnimalDatabase packAnimalDB;
    private Reader reader;

    public Registry(String availablePetsFileName, String availablePackAnimalsFilename) {
        this.petDB = new PetDatabase();
        this.packAnimalDB = new PackAnimalDatabase();
        this.reader = new Reader(availablePetsFileName, availablePackAnimalsFilename);
    }

    public void showPets() {
        petDB.showDatabase();
    }

    public void showPackAnimals() {
        packAnimalDB.showDatabase();
    }

    public void addNewAnimal(Animal animal) {
        ArrayList<String> availablePets = reader.getAvailablePets();
        ArrayList<String> availablePackAnimals = reader.getAvailablePackAnimals();
        if (availablePets.contains(animal.getAnimalType())) {
            petDB.add(new Pet(animal.getAnimalName(), animal.getAnimalType(), animal.getAnimalBirthday()));
        } else if (availablePackAnimals.contains(animal.getAnimalType())) {
            packAnimalDB.add(new PackAnimal(animal.getAnimalName(), animal.getAnimalType(), animal.getAnimalBirthday()));
        } else throw new RuntimeException("We don't know this animal type");
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

    private class Reader {
        String petsFileName;
        String packAnimalsFileName;

        public Reader(String petsFileName, String packAnimalsFileName) {
            this.petsFileName = petsFileName;
            this.packAnimalsFileName = packAnimalsFileName;
        }

        private String readline(String fileName) {
            try (BufferedReader bR = new BufferedReader(new FileReader(fileName))) {
                return bR.readLine();
            } catch (IOException e) {
                throw new RuntimeException("Something went wrong...");
            }
        }

        public ArrayList<String> getAvailablePets() {
            List<String> stringList = Arrays.asList(readline(petsFileName).split(";"));
            return new ArrayList<>(stringList);
        }

        public ArrayList<String> getAvailablePackAnimals() {
            List<String> stringList = Arrays.asList(readline(packAnimalsFileName).split(";"));
            return new ArrayList<>(stringList);
        }
    }
}
