import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest2 {

	public static void main(String[] args) {
		RConnection rconn = null;
		try {
			rconn = new RConnection();
		} catch (RserveException e) {
			System.out.println("R Connection Error");
		}
		System.out.println("R Connection OK");
		try {
			// 한글 문제 해결 한글이 깨지면 에러남
			rconn.setStringEncoding("utf8");
			rconn.eval("source('C:/Rproject/day09/r1.R',encoding='UTF-8')");
		
			double data[] = rconn.eval("r2()").asDoubles();
			//[{name:"data",datas:[1,2,3,4,5,..10]}]
			JSONArray ja = new JSONArray();
			JSONObject jo = new JSONObject();
			
			JSONArray ja_sub = new JSONArray();
			for(double d: data) {
				ja_sub.add(d);
			}
			jo.put("datas", ja_sub);
			jo.put("name", "data");
			ja.add(jo);
				
			System.out.println(ja.toJSONString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
