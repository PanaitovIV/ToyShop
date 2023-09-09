import java.util.Scanner;

public class Toy {
    private int id;
    private String name;
    private int quantity;
    private double frequency;
    Scanner scan = new Scanner(System.in);

    public Toy(int id, String name, int quantity, double frequency){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}