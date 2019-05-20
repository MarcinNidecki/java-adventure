package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bigmac {

    private String bun;
    private int burgers;
    private String sauce;
    private List<String> ingredients = new ArrayList<>();



    private Bigmac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public static class BigmacBuilder {
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {

            final String SESAME_BUN = "SESAME PLAIN_BUN";
            final String PLAIN_BUN = "PLAIN BUN";
            if(bun.equals(SESAME_BUN) || bun.equals(PLAIN_BUN))  {
                this.bun = bun;
            } else {
                throw new IllegalStateException("Bun can be only with sesame or just plain!");
            }
            return this;
        }

        public BigmacBuilder burgers(int burgersQuantity) {

            final int MIN_BURGER = 0;
            final int MAX_BURGER = 4;
            if (burgersQuantity> MAX_BURGER || burgersQuantity<MIN_BURGER) {
                throw new IllegalStateException("Burgers quantity should be in range between " +
                        MIN_BURGER + " and " + MAX_BURGER);
            } else {
                this.burgers = burgersQuantity;
            }

            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            final String STANDARD = "STANDARD";
            final String THOUSAND_ISLAND = "THOUSAND ISLAND";
            final String BARBECUE = "BARBECUE";
            if(sauce.equals(STANDARD) || sauce.equals(THOUSAND_ISLAND) || sauce.equals(BARBECUE))  {
                this.sauce = sauce;
            } else {
                throw new IllegalStateException("Sauce can be only standard, 1000 island or barbecue!");
            }
            return this;
        }

        public BigmacBuilder ingredients(String ingredient) {
            List<String> allowedIngredients = Arrays.asList("lettuce", "onion", "bacon", "cucumber", "chilli peppers", "mushrooms", "shrimps", "cheese");
            if(allowedIngredients.contains(ingredient)) {
                ingredients.add(ingredient);
            } else {
                throw new IllegalStateException("You can choose only lettuce, onion, bacon, cucumber, chilli peppers, mushrooms, shrimps, cheese.");
            }

            return this;
        }
        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
