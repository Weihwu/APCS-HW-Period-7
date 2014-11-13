import java.util.*;

public class ArrayListMethods{
  
    public static void collapseDuplicates(ArrayList<Integer> L){
	ArrayList<Integer> array = new ArrayList<Integer>();
	int a = L.get(0);
	int i = 1;    
	while(i < array.size()){
	    if(L.get(i)==a){
		L.remove(i);
	    }
	    else{
		a = L.get(i);
		i++;
	    }
	}
    }

    public static void randomize(ArrayList<Integer> L){
	Random r = new Random();
	for(int i = L.size(); i > 0; i--){
	    int place = r.nextInt(i);
	    L.add(L.get(place), L.size()-1);
	    L.remove(place+1);
	}
    }
}