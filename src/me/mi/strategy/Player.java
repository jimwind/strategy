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
		//��һ�ַ�ʽ
//		if(totalAmount > 30000){
//			calPrice = new GoldVip();
//		} else if(totalAmount > 20000){
//			calPrice = new SuperVip();
//		} else if(totalAmount > 10000){
//			calPrice = new Vip();
//		}
		//�ڶ��ַ�ʽ ���򵥹���
//		calPrice = CalPriceFactory.createCalPrice(this);
		//�����ַ�ʽ��ע��
		calPrice = CalPriceFactory.getInstance().createCalPrice(this);
	}
	
	public double calLastAmount(){
		return calPrice.calPrice(amount);
	}
	
	public double getTotalAmount() {
        return totalAmount;
    }
}
