package com.example.demo.tables;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
        this.name = name;
    }

    @ManyToMany
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

    public void setEnabledForUser(boolean enabledForUser) {
        this.enabledForUser = enabledForUser;
    }

    public Set<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Set<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
