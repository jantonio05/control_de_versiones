package Model;

import java.time.LocalDate;

public class Game {
    private String name, author, description;
    private Double price;
    private int peg;
    private LocalDate released;

    // Constructor without parameters
    public Game() {
    }

    // Constructor with parameters
    public Game(String name, String author, Double price, String description, int peg, LocalDate released) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.description = description;
        this.peg = peg;
        this.released = released;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getPeg() {
        return peg;
    }

    public void setPeg(int peg) {
        this.peg = peg;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    public void gameInfo() {
        System.out.println("~~~~~~~~~~ Model.Game info ~~~~~~~~~~\n\n\tName: [" + name + "]\n\tAuthor: [" + author + "]\n\tPrice: [" + price + "]\n\n~~~~~~~~~~ More info ~~~~~~~~~~\n\n\tReleased date: [" + released + "]\n\tPEG: [" + peg + "]\n\tDescription {" + description + "}");
    }
} // End class {Games}
