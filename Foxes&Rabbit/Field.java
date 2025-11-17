import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {
    private int depth;
    private int width;
    private Object[][] field;

    private static final Random rand = new Random();

    public Field(int depth, int width) {
        this.depth = depth;
        this.width = width;
        field = new Object[depth][width];
    }

    public void place(Object animal, Location location) {
        field[location.getRow()][location.getCol()] = animal;
    }

    public Object getObjectAt(Location location) {
        return field[location.getRow()][location.getCol()];
    }

    public void clear(Location location) {
        field[location.getRow()][location.getCol()] = null;
    }

    public Location freeAdjacentLocation(Location location) {
        List<Location> free = new ArrayList<>();
        for (Location loc : adjacentLocations(location)) {
            if (getObjectAt(loc) == null) {
                free.add(loc);
            }
        }
        if (free.size() > 0) {
            return free.get(rand.nextInt(free.size()));
        } else {
            return null;
        }
    }

    public List<Location> adjacentLocations(Location location) {
        List<Location> locations = new ArrayList<>();
        int row = location.getRow();
        int col = location.getCol();

        for (int roffset = -1; roffset <= 1; roffset++) {
            for (int coffset = -1; coffset <= 1; coffset++) {
                if (roffset == 0 && coffset == 0) continue;
                int newRow = row + roffset;
                int newCol = col + coffset;
                if (withinBounds(newRow, newCol)) {
                    locations.add(new Location(newRow, newCol));
                }
            }
        }
        return locations;
    }

    private boolean withinBounds(int row, int col) {
        return row >= 0 && row < depth && col >= 0 && col < width;
    }
}
