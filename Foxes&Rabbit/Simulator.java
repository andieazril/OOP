import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Simulator {
    private List<Animal> animals;
    private Field field;
    private int step;
    private static final int FIELD_DEPTH = 10;
    private static final int FIELD_WIDTH = 10;
    private static final int INITIAL_RABBITS = 20;
    private static final int INITIAL_FOXES = 5;

    private static final Random rand = new Random();

    public Simulator() {
        animals = new ArrayList<>();
        field = new Field(FIELD_DEPTH, FIELD_WIDTH);
        populate();
        step = 0;
    }

    private void populate() {
        for (int i = 0; i < INITIAL_RABBITS; i++) {
            Location loc = randomFreeLocation();
            if (loc != null) {
                Rabbit rabbit = new Rabbit(field, loc);
                animals.add(rabbit);
            }
        }
        for (int i = 0; i < INITIAL_FOXES; i++) {
            Location loc = randomFreeLocation();
            if (loc != null) {
                Fox fox = new Fox(field, loc);
                animals.add(fox);
            }
        }
    }

    private Location randomFreeLocation() {
        for (int tries = 0; tries < 100; tries++) {
            int row = rand.nextInt(FIELD_DEPTH);
            int col = rand.nextInt(FIELD_WIDTH);
            Location loc = new Location(row, col);
            if (field.getObjectAt(loc) == null) {
                return loc;
            }
        }
        return null;
    }

    public void simulate(int numSteps) {
        for (int i = 0; i < numSteps; i++) {
            step++;
            simulateOneStep();
            printStats();
        }
    }

    private void simulateOneStep() {
        List<Animal> newAnimals = new ArrayList<>();

        Iterator<Animal> it = animals.iterator();
        while (it.hasNext()) {
            Animal animal = it.next();
            animal.act(newAnimals);
            if (!animal.isAlive()) {
                it.remove();
            }
        }

        animals.addAll(newAnimals);
    }

    private void printStats() {
        int rabbits = 0;
        int foxes = 0;
        for (Animal animal : animals) {
            if (animal instanceof Rabbit) rabbits++;
            else if (animal instanceof Fox) foxes++;
        }
        System.out.println("Step " + step + ": Rabbits=" + rabbits + ", Foxes=" + foxes);
    }

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        simulator.simulate(20);
    }
}