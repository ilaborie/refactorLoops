package io.github.ilaborie.loops.samples;

import java.util.Objects;

public class Element {

    private final String name;

    public Element(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Element{name='%s'}", name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(name, element.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

}
