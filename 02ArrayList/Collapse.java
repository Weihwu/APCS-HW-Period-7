import java.util.ArrayList;

public class Collapse{
    ArrayList<Integer> array;
    public void collapseDuplicates(ArrayList<Integer> L){
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
}