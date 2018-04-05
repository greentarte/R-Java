import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest {

	public static void main(String[] args) {
		RConnection rconn = null;
		try {
			rconn = new RConnection(); //��������
			//rconn = new RConnection("70.12.114.130"); //����Ʈ����
		} catch (RserveException e) {
			System.out.println("R Connection Error");
		}
		System.out.println("R Connection OK");
		try {
			// �ѱ� ���� �ذ� �ѱ��� ������ ������
			rconn.setStringEncoding("utf8");
			rconn.eval("source('C:/Rproject/day09/r1.R',encoding='UTF-8')");
			int a= 100;
			int b=87;
			double data = rconn.eval("r1("+a+","+b+")").asDouble();
			// ���� ����� r1.R���� r1()�� �Լ��� �����Ѵ�.
			
				System.out.println(data);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
