package March22;

import java.util.Scanner;

class Geometry {
	public void permit(Shape ref) {
		ref.input();
		ref.compute();
		ref.disp();
	}

	public static void main(String[] args) {
//		Triangle t = new Triangle();
//		Rectangle r = new Rectangle();
//		Circle c = new Circle();
//		
//		t.input();
//		t.compute();
//		t.disp();
//		
//		r.input();
//		r.compute();
//		r.disp();
//		
//		c.input();
//		c.compute();
//		c.disp();
		
		Geometry g = new Geometry();
		g.permit(new Triangle());
		g.permit(new Rectangle());
		g.permit(new Circle());
	}
}

abstract class Shape {
	protected float area;
	
	abstract protected void input();
	abstract protected void compute();
	
	protected void disp() {
		System.out.println("Area is: " + this.area);
	}
}

class Triangle extends Shape {
	protected float height;
	protected float base;
	
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter height for triangle: ");
		this.height = scan.nextFloat();
		System.out.print("Enter base for triangle: ");
		this.base = scan.nextFloat();
	}
	
	public void compute() {
		this.area = 0.5f * this.base * this.height;
	}
}

class Rectangle extends Shape {
	protected float length;
	protected float breadth;
	
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter length for rectangle: ");
		this.length = scan.nextFloat();
		System.out.print("Enter breadth for rectangle: ");
		this.breadth = scan.nextFloat();
	}
	
	public void compute() {
		this.area = this.length * this.breadth;
	}
}

class Circle extends Shape {
	protected float radius;
	
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter radius for circle: ");
		this.radius = scan.nextFloat();
	}
	
	public void compute() {
		this.area = (float) (Math.PI * Math.pow(this.radius, 2));
	}
}
