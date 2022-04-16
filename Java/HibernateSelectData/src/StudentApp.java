public class StudentApp {
	public static void main(String[] args) {
		HibernateManager hm = new HibernateManager();
		hm.connect();
		hm.selectData(1);
	}
}
