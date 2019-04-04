package me.mi.annotate;

import me.mi.strategy.CalPrice;

@PriceRegion(max = 10000)
public class Original implements CalPrice {

	public double calPrice(double orignialPrice) {
		return orignialPrice;
	}

}
