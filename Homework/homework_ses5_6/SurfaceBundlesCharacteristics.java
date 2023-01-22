package homework_ses5_6;

public class SurfaceBundlesCharacteristics {
	
	public static void main(String[] args) {

	SurfaceBundles SurfaceGo2 = new SurfaceBundles();
	SurfaceBundles SurfacePro7Plus = new SurfaceBundles();
	SurfaceBundles SurfaceBook = new SurfaceBundles();
	
	SurfaceGo2.display = 10.4;
	SurfaceGo2.ram = 4;
	SurfaceGo2.DiskSpace = 1;
	SurfaceGo2.price = 25.523f;
	
	SurfacePro7Plus.display = 152.1;
	SurfacePro7Plus.ram = 2;
	SurfacePro7Plus.DiskSpace = 125;
	SurfacePro7Plus.price = 12f;
			
	
	SurfaceBook.display = 1.2;
	SurfaceBook.ram = 7;
	SurfaceBook.DiskSpace = 12;
	SurfaceBook.price = 1.73f;
	
	
	String MyUserid= "MyUserid";
	String MyPassword = "123";
	
	if (Authorization(MyUserid,MyPassword)) System.out.print("authentication passed");
	else System.out.print("authentication failed");
	
	}
	
	public static boolean Authorization(String username, String password) {
	
		if ((username.equals("MyUserid"))&&(password.equals("MyPassword"))) return true;
		else return false;
		
	}
	
}