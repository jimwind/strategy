package me.mi.annotate;

import me.mi.strategy.CalPrice;

@PriceRegion(min=30000)
public class GoldVip implements CalPrice {

	public double calPrice(double orignialPrice) {
		return orignialPrice * 0.7;
	}

}
