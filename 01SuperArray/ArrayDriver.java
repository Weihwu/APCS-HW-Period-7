public class ArrayDriver{
    public static void main(String[]args){
	SuperArray L = new SuperArray();
	int a1 = new Integer(3);
	int a2 = new Integer(4);
	int a3 = new Integer(5);
	int a4 = new Integer(6);
	int a5 = new Integer(7);
	int a6 = new Integer(8);
	int a7 = new Integer(9);
	int a8 = new Integer(10);
	int a9 = new Integer(11);
	int a10 = new Integer(12);
	int a11 = new Integer(13);
	L.add(a1);
	L.add(a2);
	L.add(a3);
	L.add(a4);
	L.add(a5);	
	L.add(a6);
	System.out.println(L.size());
	System.out.println(L);
	L.add(a7);
	L.add(a8);
	L.add(a9);
	L.add(a10);
	System.out.println(L.size());
	System.out.println(L);
	L.add(a11);
	System.out.println(L.size());
	System.out.println(L);
	L.resize(16);
	System.out.println(L.size());
	System.out.println(L);
	L.resize(7);
	System.out.println(L.size());
	System.out.println(L);
	System.out.println(L.get(3));
	L.set(2, "W");
	System.out.println(L.size());
	System.out.println(L);
	try{
	    L.set(21, "W");
	}
	catch (IndexOutOfBoundsException e){
	    System.out.println("Something went wrong.");
	}
	try{
	    L.get(21);
	}
	catch (IndexOutOfBoundsException e){
	    System.out.println("Something went wrong.");
	}
	L.add();
	System.out.println(L.size());
	System.out.println(L);
	L.remove(4);
	System.out.println(L.size());
	System.out.println(L);
	L.resize(16);
	L.remove(5);
	System.out.println(L.size());
	System.out.println(L);
	try{
	    L.remove(21);
	}
	catch (IndexOutOfBoundsException e){
	    System.out.println("Something went wrong.");
	}
	L.clear();
	System.out.println(L.size());
	System.out.println(L);
    }
}
