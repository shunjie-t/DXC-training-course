package march23;

public class InterfaceInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface SuperInterface1 {}
interface SuperInterface2 {}

// interface can inherit more than one interfaces
interface SubInterface1 extends SuperInterface1 {}
interface SubInterface2 extends SuperInterface1, SuperInterface2 {}


/*
 * interface cannot interface with other interface
 * the code below will produce error
 * */
// interface SubInterface3 implements SuperInterface1 {}
