public class StudentApp {
	public static void main(String[] args) {
		HibernateManager hm = new HibernateManager();
		hm.connect();
//		hm.deleteData(3);
		hm.updateData(2, "Kennedy");
	}
}
