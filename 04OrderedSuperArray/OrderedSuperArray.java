public class OrderedSuperArray extends SuperArray{
    
    public void add(String e){
	int index = 0;
	int place = 0;
	for(int x; x < superA.length; x++){
	    if (((x.charAt(place)).compareTo(superA[x].charAt(place))) == 1){
		add(index, e);
	    }else if((((x.charAt(place)).compareTo(superA[x].charAt(place))) == 0)){
		place++;
		index = 0;
	    }
	    index++;
	}
    }

}