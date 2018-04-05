import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest3 {

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
			RList list = rconn.eval("r3()").asList();
			System.out.println(list.size());
			String time [] =list.at("time").asStrings();
			double line2 [] =list.at("line2").asDoubles();
			double line3 [] =list.at("line3").asDoubles();
			double line4 [] =list.at("line4").asDoubles();
//			System.out.println("time\tline2\tline3\tline4");
//			for(int i=0; i<time.length;i++) {
//				System.out.println(time[i]+"\t"
//								  +(int)line2[i]+"\t"
//								  +(int)line3[i]+"\t"
//								  +(int)line4[i]);
//			}
//			문제1
//			결과
//			time	line2	line3	line4
//			6시	1000	2000	3000
//			7시	2000	3000	4000
//			8시	3000	4000	5000
//			9시	4000	5000	6000
//			10시	5000	6000	7000
//			문제2
//			[
//			 {time:["6시","7시","8시","9시","10시"],
//				 line2:[1000,2000,,,,].
//				 line3:[2000,3000,,,,].
//				 line4:[3000,4000,,,,].
//			 }
//			 ]
			JSONArray ja = new JSONArray();
			JSONObject jo = new JSONObject();
			JSONArray ja_time= new JSONArray();
			JSONArray ja_line2= new JSONArray();
			JSONArray ja_line3= new JSONArray();
			JSONArray ja_line4= new JSONArray();
			for(int i=0; i<list.size(); i++) {
				ja_time.add(time[i]);
				ja_line2.add((int)line2[i]);
				ja_line3.add((int)line3[i]);
				ja_line4.add((int)line4[i]);				
			}
			jo.put("time", ja_time);
			jo.put("line2", ja_line2);
			jo.put("line3", ja_line3);
			jo.put("line4", ja_line4);
			ja.add(jo);
			System.out.println(ja.toJSONString());
				

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
