import java.io.File;
import java.io.IOException;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i=2568;
		File f = new File("http://localhost/Tmall01/img/productSingle_middle/"+i+".jpg");
//		try {
//			f2.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Integer ii=9;
		System.out.println(f.getPath());
		
		System.out.println(f.exists());
	}

}
