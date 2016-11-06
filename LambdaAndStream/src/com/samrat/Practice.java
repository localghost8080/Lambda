package com.samrat;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Practice {
	
	public static void main(String[] args) {
		FruitFactory<Apple> factory = new FruitFactory<>(); 
		List<Apple> listOfApples = factory.getFruitList(Apple.class, 50);
		
		//listOfApples.forEach(System.out::println);
		
		//listOfApples.stream().filter(s-> s.getColor()==Color.DARK_RED).forEach(System.out::println);
		//Map<Boolean, List<Apple>> group  = listOfApples.stream().collect(Collectors.groupingBy(item->item.getWeight()>105));
		//List<Apple> myList  = listOfApples.stream().filter(fil-> fil.getWeight()>115).sorted((i1,i2) ->i1.getWeight().compareTo(i2.getWeight()) ).collect(Collectors.toList());
		//myList.stream().forEach(System.out::println);
		
		Long startms  = new Date().getTime();
		Long emdms ;
		List<Juice> juiceList = null;
		juiceList=listOfApples.parallelStream()
				.filter(fil-> fil.getWeight()>115)
				.map(apple-> apple.getJuice())
				.collect(Collectors.toList());
		juiceList.forEach(System.out::println);
		emdms  = new Date().getTime();
		System.out.println("---------------------------");
		//System.out.println("--------------Library Collect--------------"+(emdms-startms));
		
		startms  = new Date().getTime();
		juiceList=listOfApples.parallelStream()
				.filter(fil-> fil.getWeight()>115)
				.collect(ArrayList<Juice>::new,(list,apple)->{list.add(apple.getJuice());},(list1,list2)->{list1.addAll(list2);});
		
		juiceList.forEach(System.out::println);
		emdms  = new Date().getTime();
		//System.out.println("--------------diy Collect--------------"+(emdms-startms));
		/*Equivalent code*/
		//System.out.println("----------Parallel------------------"+(emdms-startms));
		//startms  = new Date().getTime();
		/*List<Apple> heavyAppleList = new ArrayList<>();
		List<Juice> appleJuiceList = new ArrayList<>();
		for(Apple a:listOfApples ){
			if(a.getWeight()>115){
				heavyAppleList.add(a);
				
			}
		}
		for(Apple heavyApple : heavyAppleList ){
			appleJuiceList.add(heavyApple.getJuice());
		}
		*/
		/*for(Juice juice : appleJuiceList){
			System.out.println(juice);
		}*/
		//emdms  = new Date().getTime();
		//System.out.println("-----------Serial-----------------"+(emdms-startms));	
		
	}

	
}
