package me.mi.strategy;

public class SuperVip implements CalPrice {

	public double calPrice(double originalPrice) {
		return originalPrice * 0.8;
	}

}
