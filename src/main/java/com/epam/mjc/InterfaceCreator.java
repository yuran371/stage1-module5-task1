package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
    	List<String> list = new ArrayList<>(); 
    	Predicate<List<String>> pre = x -> {
    		
    	for (Iterator<String> iterator = ((List<String>) x).iterator(); iterator.hasNext();) {
			String str = iterator.next();
			if (Character.isUpperCase(str.charAt(0))) {
				list.add(str);
			}
			}
    	if (x.size()==list.size()) {
    		return true;
    	} 
		return false;
    	};
    	return pre;

    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
    	
    	Consumer<List<Integer>> con = x -> {
    		List<Integer> list = new ArrayList<>();
    		list.addAll(x);
    		for (Iterator<Integer> iterator = x.iterator(); iterator.hasNext();) {
				Integer ii = iterator.next();
				if (ii%2==0) {
					list.add(ii);
				}
				
			}
    		x.removeAll(list);
    		x.addAll(list);
    	};
    	return con;
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
    	List<String> list = new ArrayList<>(); 
    	List<String> listSplit = new ArrayList<>(); 
    	Supplier<List<String>> sup = () -> {
    		for (Iterator <String> it = values.iterator(); it.hasNext();) {
				String str = it.next();
				String[] wordsSplit = str.split("[\\W]+");
				
				if (Character.isUpperCase(str.charAt(0))&&str.endsWith(".")&&wordsSplit.length>3) {
					list.add(str);
				}
			}
    		return list;
    	};
    	return sup;
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
    	Function<List<String>, Map<String, Integer>> fun = x -> {
    		Map<String, Integer> map = new HashMap<String, Integer>();
    		for (Iterator iterator = x.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				int j=0;
				for (int i=0; i<string.length(); i++) {
					j++;
				}
				map.put(string, j);
			}
    		
			return map;
    	};
    	return fun;
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
    	BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction = (x, y) -> {
    		List<Integer> list = new ArrayList<>();
    		list.addAll(x);
    		list.addAll(y);
    		return list;
    	};
    	return biFunction;
    }
}
