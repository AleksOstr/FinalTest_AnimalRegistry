package model.animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class PackAnimal extends Animal {
    private ArrayList<Command> commandsList = new ArrayList<>();

    public PackAnimal(String animalName, String animalType, LocalDate animalBirthday) {
        super(animalName, animalType, animalBirthday);
    }

    @Override
    public String getAnimalName() {
        return super.getAnimalName();
    }

    @Override
    public String getAnimalType() {
        return super.getAnimalType();
    }

    @Override
    public LocalDate getAnimalBirthday() {
        return super.getAnimalBirthday();
    }

    public void addCommand(Command command) {
        commandsList.add(command);
    }
}
