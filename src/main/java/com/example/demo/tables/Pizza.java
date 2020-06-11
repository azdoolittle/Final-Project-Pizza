package com.example.demo.tables;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Set;

@Entity
public class Pizza {
    private static final double initialPrice = 10.25;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double price;

    private LocalDateTime date;

    private String sauce;

    @NotNull
    @NotEmpty
    private String name;

    private boolean specialty;

    @ManyToMany(mappedBy = "pizzas")
    private Set<Topping> toppings;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    //Constructors
    public Pizza() {
        this.specialty = false;
        this.price = initialPrice;
        this.date = LocalDateTime.now();
    }

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        int toppings = this.findNumToppings();
        this.setPrice(initialPrice);
        if (toppings > 2) {
            for (int i = 2; i < toppings; i++) {
                price += .5;
            }
        }

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSpecialty() {return specialty; }

    public void setSpecialty(boolean specialty) {
        this.specialty = specialty;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(Set<Topping> toppings) {
        this.toppings = toppings;
    }

    //methods
    public int findNumToppings() {
        return toppings.size();
    }

    public String printDate() {
        String dateString = this.date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
        return dateString;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", price=" + price +
                ", date=" + this.printDate() +
                ", sauce='" + sauce + '\'' +
                ", name='" + name + '\'' +
                ", specialty=" + specialty +
                ", toppings=" + toppings +
                ", user=" + user +
                '}';
    }
}
