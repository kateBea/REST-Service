package org.pizzabackend.pizzabackend.modelo;

public enum Masa {
    NORMAL { @Override public String toString() { return "Normal"; } },
    FINIZZIMA { @Override public String toString() { return "Finizzima"; } },
    ROLL { @Override public String toString() { return "Roll"; } },
    CHEDAROLL { @Override public String toString() { return "Chedaroll"; } },
    CABRAROLL { @Override public String toString() { return "Cabraroll"; } },
}
