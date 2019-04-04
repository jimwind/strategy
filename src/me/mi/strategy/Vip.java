package me.mi.strategy;

public class Vip implements CalPrice {

	public double calPrice(double orignialPrice) {
		return orignialPrice * 0.9;
	}

}
