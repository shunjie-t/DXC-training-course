package March30;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListIteratorVSIterator {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);
		System.out.println(al);
		
		for(int a : al) {
			System.out.println(a);
		}
		
		Iterator<Integer> it = al.iterator();
		while(it.hasNext()) {
			// Iterator can only iterate forwards
			System.out.println(it.next());
		}
		
		// iterator cannot add objects into arraylist
		it.next();
		// it.add(2000);
		
		ListIterator<Integer> li = al.listIterator(al.size());
		while(li.hasPrevious()) {
			// ListIterator can iterate backwards and forwards
			System.out.println(li.previous());
		}
		
		li.next();
		// ListIterator can add objects at it's current position
		li.add(1000);
		System.out.println(al);		
	}

}
