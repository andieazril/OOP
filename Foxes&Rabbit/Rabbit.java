import java.util.List;

public class Rabbit extends Animal {

    public Rabbit(Field field, Location location) {
        super(field, location);
    }

    @Override
    public void act(List<Animal> newAnimals) {
        if (!isAlive()) return;

        Location newLocation = getField().freeAdjacentLocation(getLocation());
        if (newLocation != null) {
            setLocation(newLocation);
        } else {
            setDead();
        }
    }
}