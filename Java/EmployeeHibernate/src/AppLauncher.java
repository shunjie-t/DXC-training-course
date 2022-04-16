public class AppLauncher {
	public static void main(String[] args) {
		HibernateManager hm = new HibernateManager();
		hm.connect();
		
//		hm.insert(new Employee(1,"Sally","Hopkins","sally.hopkins@dxc.com"));
//		hm.insert(new Employee(2,"Freddy","Jones","freddy.jones@dxc.com"));
//		hm.insert(new Employee(3,"Alice","Smith","alice.smith@dxc.com"));
//		hm.insert(new Employee(4,"Catherine","Johnson","catherine.johnson@dxc.com"));
		
		hm.select(1);
		System.out.println("");
		hm.select(2);
		System.out.println("");
		hm.select(3);
		System.out.println("");
		hm.select(4);
		System.out.println("");
		hm.selectAllData();
		System.out.println("");
		hm.selectByName();
	}
}
