package com.example.demo.tables;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Entity
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NotEmpty
    private String name;

    private int count;

    private boolean enabledForUser;

    public Topping() {
        this.enabledForUser = true;
    }

    public Topping(String name) {
        this.enabledForUser = true;
        this.name = name;
    }

    @ManyToMany(mappedBy = "toppings")
    private Set<Pizza> pizzas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isEnabledForUser() {return enabledForUser;}

    public void setEnabledForUser() {
        this.enabledForUser = !this.enabledForUser;
    }

    public Set<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Set<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", enabledForUser=" + enabledForUser +
                '}';
    }
}
