package ru.danilscheglov.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String brand;
    private final String model;
    private final String configurationName;

    private final List<String> exterior;
    private final List<String> interior;
    private final List<String> comfort;
    private final List<String> safety;
    private final List<String> multimedia;
    private final List<String> performance;

    private final double basePrice;
    private final double totalPrice;

    private Car(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.configurationName = builder.configurationName;
        this.exterior = new ArrayList<>(builder.exterior);
        this.interior = new ArrayList<>(builder.interior);
        this.comfort = new ArrayList<>(builder.comfort);
        this.safety = new ArrayList<>(builder.safety);
        this.multimedia = new ArrayList<>(builder.multimedia);
        this.performance = new ArrayList<>(builder.performance);
        this.basePrice = builder.basePrice;
        this.totalPrice = builder.totalPrice;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getConfigurationName() {
        return configurationName;
    }

    public List<String> getExterior() {
        return new ArrayList<>(exterior);
    }

    public List<String> getInterior() {
        return new ArrayList<>(interior);
    }

    public List<String> getComfort() {
        return new ArrayList<>(comfort);
    }

    public List<String> getSafety() {
        return new ArrayList<>(safety);
    }

    public List<String> getMultimedia() {
        return new ArrayList<>(multimedia);
    }

    public List<String> getPerformance() {
        return new ArrayList<>(performance);
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %s - %s (€%.2f)", brand, model, configurationName, totalPrice);
    }

    public static class Builder {
        private String brand;
        private String model;
        private String configurationName;

        private List<String> exterior = new ArrayList<>();
        private List<String> interior = new ArrayList<>();
        private List<String> comfort = new ArrayList<>();
        private List<String> safety = new ArrayList<>();
        private List<String> multimedia = new ArrayList<>();
        private List<String> performance = new ArrayList<>();

        private double basePrice;
        private double totalPrice;

        public Builder(String brand, String model, String configurationName, double basePrice) {
            this.brand = brand;
            this.model = model;
            this.configurationName = configurationName;
            this.basePrice = basePrice;
            this.totalPrice = basePrice;
        }

        public Builder addExteriorOption(String option, double price) {
            exterior.add(option);
            totalPrice += price;
            return this;
        }

        public Builder addInteriorOption(String option, double price) {
            interior.add(option);
            totalPrice += price;
            return this;
        }

        public Builder addComfortOption(String option, double price) {
            comfort.add(option);
            totalPrice += price;
            return this;
        }

        public Builder addSafetyOption(String option, double price) {
            safety.add(option);
            totalPrice += price;
            return this;
        }

        public Builder addMultimediaOption(String option, double price) {
            multimedia.add(option);
            totalPrice += price;
            return this;
        }

        public Builder addPerformanceOption(String option, double price) {
            performance.add(option);
            totalPrice += price;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

