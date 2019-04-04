package me.mi.strategy;

import me.mi.annotate.factory.CalPriceFactory;

//import me.mi.strategy.factory.CalPriceFactory;

public class Player {
	private double totalAmount = 0d;
	private double amount = 0d;
	private CalPrice calPrice = new Original();
	
	public void buy(double amount){
		this.amount = amount;
		totalAmount += amount;
		//第一种方式
//		if(totalAmount > 30000){
//			calPrice = new GoldVip();
//		} else if(totalAmount > 20000){
//			calPrice = new SuperVip();
//		} else if(totalAmount > 10000){
//			calPrice = new Vip();
//		}
		//第二种方式 ：简单工厂
//		calPrice = CalPriceFactory.createCalPrice(this);
		//第三种方式：注解
		calPrice = CalPriceFactory.getInstance().createCalPrice(this);
	}
	
	public double calLastAmount(){
		return calPrice.calPrice(amount);
	}
	
	public double getTotalAmount() {
        return totalAmount;
    }
}
