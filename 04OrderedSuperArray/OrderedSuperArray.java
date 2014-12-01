public class OrderedSuperArray{
    private String[] superA;
    private int current;

    public OrderedSuperArray(){
	superA = new String[10];
    }    
    public OrderedSuperArray(int size){
	superA = new String[size];
    }

    public String toString(){
	String str = "[";
	for(int x = 0; x < superA.length; x++){
	    str += " " + superA[x];
	}
	str += " ]";
	return str;
    }
    public void add(){
	resize(superA.length+1);
    }
    public void add(String e){
	if (superA[superA.length-1].equals("")){
	    String[] superB = new String[superA.length];
	    superB = superA;
	    superB[current] = e;
	    superA = superB;
	    current++;
	}else{
	    add();
	    add(e);
	}
    }
    public void add(int index, String o){
	if (superA[superA.length-1] .equals("")){
	    String[] superB = new String[superA.length];
	    for (int x = 0; x < index; x++){
		superB[x] = superA[x];
	    }
	    superB[index] = o;
	    for (int x = index + 1; x < superB.length; x++){
		superB[x] = superA[x];
	    }
	    superA = superB;
	}else{
	    add();
	    add(index,o);
	}
    }
    public void remove(int index){
	if (index < superA.length){
	    if (superA.length <= 10){
		String holder = superA[index];
		superA[index] = null;
	    }else{
		String[] superB = new String[superA.length-1];
		for (int x = 0; x < index; x++){
		    superB[x] = superA[x];
		}
		for (int x = index; x < superB.length; x++){
		    superB[x] = superA[x+1];
		}
		superA = superB;
	    }
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public int size(){
	int sizeA = 0;
	if (superA.length <= 10){
	    for (int x = 0; x < superA.length; x++){
		if (superA[x].equals("")){
		    break;
		}
		sizeA++;
	    }
	}else{
	    return superA.length;
	}
	return sizeA++;
    }
    public void resize(int newCapacity){
	String[] superC = new String[newCapacity];
	if (superA.length <= newCapacity){
	    for(int x = 0; x < superA.length; x++){
		superC[x] = superA[x];
	    }
	}else{
	     for(int x = 0; x < newCapacity; x++){
		 superC[x] = superA[x];
	     }
	}
	superA = superC;
    }
    public void clear(){
	String[] superB;
	if (superA.length <= 10){
	    superB = new String[superA.length];
	}else{
	    superB = new String[10];
	}
	superA = superB;
	current = 0;	   
    }
    public String get(int indexOf){
	if (indexOf >= superA.length){
	    throw new IndexOutOfBoundsException();
	}else{
	    return superA[indexOf];
	}
    }
    public String set(int index, String e){
	if (index >= superA.length){
	    throw new IndexOutOfBoundsException();
	}else{
	    String holder = superA[index];
	    superA[index] = e;
	    return holder;
	}
    }
}
    