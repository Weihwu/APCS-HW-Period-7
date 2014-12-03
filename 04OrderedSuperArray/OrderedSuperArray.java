public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
	super();
    }

    public void add(String e){
	for(int x = 0; x < size(); x++){
	    if(get(x).compareTo(e) > 0){
		super.add(x, e);
		return;
	    }  
	}
	super.add(e);
    }
    public void add(int index, String e){
	add(e);
    }
    public String set(int index, String e){
	String holder  = get(index);
	remove(index);
	add(e);
	return holder;
    }
}


