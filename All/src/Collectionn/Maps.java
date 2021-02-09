package Collectionn;

import java.util.TreeMap;
import java.util.Map;
import java.util.Set;

public class Maps {
}

class TreeMapp{
    public static void main(String[] args) {
        TreeMap<Integer, Integer> squareTreeMap=new TreeMap<>();
        squareTreeMap.put(1,1);
        squareTreeMap.put(2,4);
        squareTreeMap.put(3,8);
        System.out.println(squareTreeMap.get(3));
        System.out.println("Collection View : "+squareTreeMap.entrySet());
        System.out.println("Collection View of keys : "+squareTreeMap.keySet());
        System.out.println("Collection View of Values : "+squareTreeMap.values());
        Set<Map.Entry<Integer, Integer>> mapEntrySet=squareTreeMap.entrySet();
        for(Map.Entry<Integer, Integer> me:mapEntrySet){
            System.out.println(me);
            System.out.println("Key : "+me.getKey());
            System.out.println("Value : "+me.getValue()+"\n");
        }
        squareTreeMap.put(3,squareTreeMap.get(3)+1);
        System.out.println(squareTreeMap.get(3));
        System.out.println("ceiling key of -9999 : "+squareTreeMap.ceilingKey(-9999));
    }
}