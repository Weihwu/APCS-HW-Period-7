import java.util.*;

public class ArrayListMethods{
  
    public static void collapseDuplicates(ArrayList<Integer> L){
	int a = L.get(0);
	int i = 1;    
	while(i < L.size()){
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
	for(int i = 0; i < L.size(); i++){
	    int place = r.nextInt(L.size()-i)+i;
	    L.add(0, L.get(place));
	    L.remove(place+1);
	}
    }

    public static void main(String[]args){
	ArrayList<Integer> array = new ArrayList<Integer>();
	for (int x = 0; x < 10; x++){
	    array.add(x);
	    array.add(x);
	    array.add(x);
	}
	System.out.println(array);
	collapseDuplicates(array);
	System.out.println(array);
	randomize(array);
	System.out.println(array);
	randomize(array);
	System.out.println(array);
    }
}