package com.samrat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FruitFactory<T extends Fruit> {

	public  T createFruit(Class<T> classtype){
		try {
			T fruit = classtype.newInstance();
			fruit.setWeight(getRandomWeight());
			fruit.setColor(getRandomColor());
			Juice juice = new Juice();
			juice.setQty(fruit.getWeight()/2);
			juice.setColor(fruit.getColor().name());
			fruit.setJuice(juice);
			return fruit;
		} catch (InstantiationException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		}
	}
	
	public List<T> getFruitList(Class<T> classtype , Integer size){
		List<T> fruitList= new ArrayList<T>(size);
		IntStream.range(0,size).forEach(i->fruitList.add(createFruit(classtype)));
		return fruitList;
	}


	private int getRandomWeight(){
		double  rand = Math.random()*250;
		int returnValue = new Double(Math.ceil(rand)).intValue();
		return returnValue;		

	}
	
	private Color getRandomColor(){
		Color c ;
		double rand = Math.random();
		if(rand<=0.25d){
			c=Color.RED;
		}else if(rand>0.25d && rand<=0.5d){
			c=Color.DARK_RED;
		}else if(rand>0.5d && rand <0.75d){
			c=Color.GREEN;
		}else{
			c=Color.YELLOW;
		}
		return c;
	}

}
