package me.mi.annotate.factory;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import me.mi.annotate.PriceRegion;
import me.mi.strategy.CalPrice;
import me.mi.strategy.Player;

public class CalPriceFactory {
	private static final String CAL_PRICE_PACKAGE = "me.mi.annotate";
	private ClassLoader classLoader = getClass().getClassLoader();
	private List<Class<? extends CalPrice>> calPriceList;
	
	public CalPrice createCalPrice(Player player){
		for(Class<? extends CalPrice> clazz: calPriceList) {
			PriceRegion validRegion = handleAnnotation(clazz);
			
			if(player.getTotalAmount() > validRegion.min() 
					&& player.getTotalAmount() < validRegion.max()){
				try{
					return clazz.newInstance();
				} catch(Exception e){
					throw new RuntimeException("");
				}
			}
		}
		throw new RuntimeException("");
	}
	
	private PriceRegion handleAnnotation(Class<? extends CalPrice> clazz){
		Annotation[] annotations = clazz.getDeclaredAnnotations();
		if(annotations == null || annotations.length == 0){
			return null;
		}
		for(int i=0; i<annotations.length; i++){
			if(annotations[i] instanceof PriceRegion){
				return (PriceRegion) annotations[i];
			}
		}
		return null;
	}
	
	private CalPriceFactory(){
		init();
	}
	
	private void init(){
		calPriceList = new ArrayList<Class<? extends CalPrice>>();
		File[] resources = getResources();
		Class<CalPrice> calPriceClazz = null;
		try {
			calPriceClazz = (Class<CalPrice>)classLoader.loadClass(CalPrice.class.getName());
		} catch(ClassNotFoundException e){
			throw new RuntimeException("");
		}
		for(int i=0; i<resources.length; i++){
			try {
				Class<?> clazz = classLoader.loadClass(CAL_PRICE_PACKAGE +"." + resources[i].getName().replace(".class", ""));
				if(CalPrice.class.isAssignableFrom(clazz) && clazz != calPriceClazz){
					calPriceList.add((Class<? extends CalPrice>)clazz);
				}
			} catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		}
	}
	
	private File[] getResources(){
		try {
			File file = new File(classLoader.getResource(CAL_PRICE_PACKAGE.replace(".", "/")).toURI());
			return file.listFiles(new FileFilter(){

				public boolean accept(File pathname) {
					if(pathname.getName().endsWith(".class")){
						return true;
					}
					return false;
				}
				
			});
		} catch(URISyntaxException e){
			throw new RuntimeException("");
		}
	}
	
	public static CalPriceFactory getInstance(){
		return CalPriceFactoryInstance.instance;
	}
	private static class CalPriceFactoryInstance{
		private static CalPriceFactory instance = new CalPriceFactory();
	}
	
	
	
}
