public class OrderedSuperArray extends SuperArray{
    public void add(String e){
	if (size() == 0){
	    super.add(e);
	}else{
	    int index = 0;
	    int place = 0;
	    for(int x = 0; x < size(); x++){
		if (e.compareTo(get(x)) == -1){
		    super.add(index, e);
		}else if(e.compareTo(get(x)) <= 0){
		    place++;
		    index = 0;
		}else if(e.compareTo(get(x)) == 1){
		    super.add(index, e);
		    return;
		}
		index++;
	    }
	    super.add(e);
	}
    }
    public String set(int index, String e){
	String holder  = get(index);
	remove(index);
	add(e);
	return holder;
    }
}