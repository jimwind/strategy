package me.mi.annotate;

import me.mi.strategy.CalPrice;

@PriceRegion(min=20000,max=30000)
public class SuperVip implements CalPrice {

	public double calPrice(double orignialPrice) {
		return orignialPrice * 0.8;
	}

}
