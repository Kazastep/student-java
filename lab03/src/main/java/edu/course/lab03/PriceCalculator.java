package edu.course.lab03;

public class PriceCalculator {

    private DiscountPolicy policy;

    public PriceCalculator(DiscountPolicy policy){
        this.policy = policy;
    }

    public double calculate(double price) {
        if (price < 0){
            throw new IllegalArgumentException("Цена меньше нуля");
        }
        return policy.apply(price);
    }

}
