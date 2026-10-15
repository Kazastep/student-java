package edu.course.lab03;

public class PercentDiscount implements DiscountPolicy {

    private int percent;
    
    public PercentDiscount(int percent){
        if (0 > percent || percent > 100){
            throw new IllegalArgumentException("Некорректные проценты");
        }
        this.percent = percent;
    }

    @Override 
    public double apply(double price){
        if (price < 0){
            throw new IllegalArgumentException("Цена отрицательная");
        }
        double TotalPrice = price * (1 - percent / 100.0);
        return TotalPrice; 
    }

    public static void main(String[] args){
        double price = 100;
        int percent = 20;
        double TotalPrice = price * (1 - (percent / 100.0));
        System.out.println(TotalPrice);
    }
}
