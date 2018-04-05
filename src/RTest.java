import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest {

	public static void main(String[] args) {
		RConnection rconn = null;
		try {
			rconn = new RConnection(); //로컬접속
			//rconn = new RConnection("70.12.114.130"); //리모트접속
		} catch (RserveException e) {
			System.out.println("R Connection Error");
		}
		System.out.println("R Connection OK");
		try {
			// 한글 문제 해결 한글이 깨지면 에러남
			rconn.setStringEncoding("utf8");
			rconn.eval("source('C:/Rproject/day09/r1.R',encoding='UTF-8')");
			int a= 100;
			int b=87;
			double data = rconn.eval("r1("+a+","+b+")").asDouble();
			// 위의 경로의 r1.R에서 r1()의 함수를 실행한다.
			
				System.out.println(data);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
