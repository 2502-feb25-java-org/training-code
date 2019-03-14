package com.revature;

interface CreditCard{
    double discount(double creditScore);//declaration
}
interface Bank extends CreditCard{
    double getRateofInterest();
    // default void test(){// works for Java 8 and above
    // }
}
class ChaseBank implements Bank{//Multiple inheritance
    @Override
    public double discount(double creditScore) {
        double discountValue;
        if(creditScore>6.8)
            return discountValue=15.0;
        else
            return discountValue=7.5;

    }
    @Override
    public double getRateofInterest() {
           return 3.2;
    }
}