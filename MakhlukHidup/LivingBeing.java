// Kelas abstrak LivingBeing (makhluk hidup umum)
public abstract class LivingBeing {
    private String name;

    public LivingBeing(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Method konkret: sebagian makhluk hidup punya napas
    public void breathe() {
        System.out.println(name + " is breathing.");
    }

    // Method abstrak: setiap makhluk hidup tumbuh dengan cara berbeda
    public abstract void grow();
}