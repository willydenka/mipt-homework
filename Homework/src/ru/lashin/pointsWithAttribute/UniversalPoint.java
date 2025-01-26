package ru.lashin.pointsWithAttribute;

import java.awt.*;
import java.util.ArrayList;

public class UniversalPoint {
    private final ArrayList<Attribute> attributes = new ArrayList<>();

    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    public ArrayList<Attribute> getAttribute() {
        return new ArrayList<>(attributes);
    }

    public void deleteAttribute(Attribute attribute) {
        attributes.remove(attribute);
    }
}
