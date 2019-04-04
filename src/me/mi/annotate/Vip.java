package me.mi.annotate;

import me.mi.strategy.CalPrice;

@PriceRegion(max=20000)
public class Vip implements CalPrice {

	public double calPrice(double originalPrice) {
		return originalPrice * 0.9;
	}

}
