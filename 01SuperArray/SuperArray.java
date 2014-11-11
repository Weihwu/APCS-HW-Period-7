public class SuperArray{
    private Object[] superA;
    private int current;

    public SuperArray(){
	superA = new Object[10];
    }    
    public SuperArray(int size){
	superA = new Object[size];
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
    public void add(Object e){
	if (superA[superA.length-1] == null){
	    Object[] superB = new Object[superA.length];
	    superB = superA;
	    superB[current] = e;
	    superA = superB;
	    current++;
	}else{
	    add();
	    add(e);
	}
    }
    public void add(int index, Object o){
	if (superA[superA.length-1] == null){
	    Object[] superB = new Object[superA.length];
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
		Object holder = superA[index];
		superA[index] = null;
	    }else{
		Object[] superB = new Object[superA.length-1];
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
		if (superA[x] == null){
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
	Object[] superC = new Object[newCapacity];
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
	Object[] superB = new Object[superA.length];
	superA = superB;
    }
    public Object get(int indexOf){
	if (indexOf >= superA.length){
	    throw new IndexOutOfBoundsException();
	}else{
	    return superA[indexOf];
	}
    }
    public Object set(int index, Object e){
	if (index >= superA.length){
	    throw new IndexOutOfBoundsException();
	}else{
	    Object holder = superA[index];
	    superA[index] = e;
	    return holder;
	}
    }
}
    
