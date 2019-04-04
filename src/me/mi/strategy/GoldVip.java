package me.mi.strategy;

public class GoldVip implements CalPrice {

	public double calPrice(double origniaPrice) {
		return origniaPrice * 0.7;
	}

}
