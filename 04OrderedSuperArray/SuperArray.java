public class SuperArray{
    private String[] superA;
    private int current;

    public SuperArray(){
	this(10);
    }    
    public SuperArray(int size){	
	superA = new String[size];
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
    public void add(String e){
	if(size() == superA.length){
	    resize(current*2);
	}
	superA[current] = e;
	current++;
    }
    public void add(int index, String e){
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
    public String remove(int index){
	if (index < 0
	    || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	String holder = superA[index];
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
	String[] superB = new String[newCapacity];
	int max = Math.min(newCapacity, current);
	for(int x = 0; x < max; x++){
	    superB[x] = superA[x];
	}
	superA = superB;
    }
    public void clear(){
	current = 0;	   
    }
    public String get(int index){
	if (index < 0
	    || index > size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    return superA[index];
	}
    }
    public String set(int index, String e){
	if (index < 0
	    || index > size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    String holder = superA[index];
	    superA[index] = e;
	    return holder;
	}
    }
    public void insertionSort(){
	for(int x = 0; x < current; x++){
	    int place = x;
	    while (place > 0 && superA[place].compareTo(superA[place-1]) < 0 ){
		String holder = superA[place-1];
		superA[place-1] = superA[place];
		superA[place] = holder;
		place--;
	    }
	}
    }
}
    