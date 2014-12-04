public class SuperArray{
    private Object[] superA;
    private int current;

    public SuperArray(){
	this(10);
    }    
    public SuperArray(int size){	
	superA = new Object[size];
	current = 0;
    }

    public String toString(){
	String str = "[";
	for(int x = 0; x < current; x++){
	    str += " " + superA[x];
	}
	str += " ]";
	return str;
    }
    public void add(int e){
	if(size() == superA.length){
	    resize(current*2);
	}
	superA[current] = e;
	current++;
    }
    public void add(int index, int e){
	if (index < 0
	    || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	if(size() == superA.length){
	    resize(current * 2);
	}
	for(int x = superA.length - 1; x > index; x--){
	    superA[x] = superA[x-1];
	}
	superA[index] = e;
	current++;
    }
    public Object remove(int index){
	if (index < 0
	    || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	Object holder = superA[index];
	while(index < size()-1){
	    superA[index] = superA[index + 1];
	    index++;
	}
	current--;
	if(current < superA.length/4){
	    resize(superA.length/2);
	}
	return holder;
    }
    public int size(){
	return current;
    }
    public void resize(int newCapacity){
	Object[] superB = new Object[newCapacity];
	int max = Math.min(newCapacity, current);
	for(int x = 0; x < max; x++){
	    superB[x] = superA[x];
	}
	superA = superB;
    }
    public void clear(){
	current = 0;	   
    }
    public Object get(int index){
	if (index < 0
	    || index > size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    return superA[index];
	}
    }
    public Object set(int index, String e){
	if (index < 0
	    || index > size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    Object holder = superA[index];
	    superA[index] = e;
	    return holder;
	}
    }
    public Object find(Object e){
	for(int x = 0; x < superA.length; x++){
	    if(e.equals(superA[x])){
		return x;
	    }
	}
	return null;
    }
}

    
