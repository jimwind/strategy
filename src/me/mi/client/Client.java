package me.mi.client;

import me.mi.strategy.Player;

//https://blog.csdn.net/u012124438/article/details/70039943
public class Client {
	public static void main(String[] args){
		Player player = new Player();
		player.buy(5000D);
        System.out.println("�����Ҫ��Ǯ��" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("�����Ҫ��Ǯ��" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("�����Ҫ��Ǯ��" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("�����Ҫ��Ǯ��" + player.calLastAmount());
	}
}