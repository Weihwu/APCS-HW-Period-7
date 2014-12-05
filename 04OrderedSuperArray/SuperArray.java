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

    /** This is your DOCUMENT Mr.K. The test is in the driver. */
    public void insertionSort(){

	/** For loop to scroll through the elements of the list to be sorted */
	for(int x = 0; x < current; x++){

	    /** Variable place to save the location of the element being examined at a specific moment */
	    int place = x;

	    /** The while loop skips the first element, since it is already sorted. From the place of the suspect element, the while loop goes down the list, back down to 0, and switches the elements, 2 at a time, to be in the correct order. */
	    while (place > 0 && superA[place].compareTo(superA[place-1]) < 0 ){

		/** A temporary String variable to hold the element to be replaced. */
		String holder = superA[place-1];

		/** The element in the higher location number is placed into the location one before it. */
		superA[place-1] = superA[place];

		/** From the temporary variable we had before, the replaced element is remembered and placed into the higher location number. */
		superA[place] = holder;

		/** The suspect element location is moved down a spot to see if the next two elements are in the correct place. */
		place--;
	    }
	}
    }
    public int find(String e){
	if ((e.compareTo(superA[superA.length/2])) == 0){
	    for(int x = (superA.length/2)-1; x >= 0; x--){
		if(!(e.equals(superA[x]))){
		    return x+1;
		}
	    }
	}else if((e.compareTo(superA[superA.length/2])) > 1){
	    String[] superB = new String[superA.length/2];
	    int superBPlace = 0;
	    int superAPlace = superA.length/2;
	    while(superBPlace < superA.length/2){
		superB[superBPlace] = superA[superAPlace];
		superBPlace++;
		superAPlace++;
		superA = superB;
	    }
	}else if((e.compareTo(superA[superA.length/2])) < 1){
	    String[] superB = new String[superA.length/2];
	    int superBPlace = 0;
	    int superAPlace = 0;
	    while(superBPlace < superA.length/2){
		superB[superBPlace] = superA[superAPlace];
		superBPlace++;
		superAPlace++;
		superA = superB;
	    }
	}
	return find(e);
    }
}
    
