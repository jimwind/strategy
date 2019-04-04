package me.mi.strategy.factory;

import me.mi.strategy.CalPrice;
import me.mi.strategy.GoldVip;
import me.mi.strategy.Original;
import me.mi.strategy.Player;
import me.mi.strategy.SuperVip;
import me.mi.strategy.Vip;

public class CalPriceFactory {
	private CalPriceFactory(){}
	
	public static CalPrice createCalPrice(Player customer){
		if(customer.getTotalAmount() > 30000){
			return new GoldVip();
		} else if(customer.getTotalAmount() > 20000){
			return new SuperVip();
		} else if(customer.getTotalAmount() > 10000){
			return new Vip();
		} else {
			return new Original();
		}
	}
}
