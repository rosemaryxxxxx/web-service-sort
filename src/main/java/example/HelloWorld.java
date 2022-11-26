package example;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

@WebService()
public class HelloWorld {
  /**
   * 对客户端传输的字符串中的数值进行排序
   * @param s
   * @return
   */

  @WebMethod
  public String ascSort(String s) {
    s=s+",";
    ArrayList<Integer> integers = new ArrayList<Integer>();
    String sortedString = null;
    //获取每个“,”之间的数字
    int j = 0;
    for(int i = 0 ; i<s.length() ; i++){
      if(s.charAt(i) == ',' ){
        //把获取的数字转换成int类型
        integers.add(Integer.parseInt(s.substring(j,i)));
        j = i+1;
      }
    }
    //升序排序
    integers.sort(Comparator.naturalOrder());
    //拼接成String类型
    for(Integer integer : integers){
      sortedString = sortedString + integer.toString()  + ",";
    }
    return sortedString.substring(4,s.length()+3);
  }
  @WebMethod
  public String descSort(String s) {
    s=s+",";
    ArrayList<Integer> integers = new ArrayList<Integer>();
    String sortedString = null;
    //获取每个“,”之间的数字
    int j = 0;
    for(int i = 0 ; i<s.length() ; i++){
      if(s.charAt(i) == ',' ){
        //把获取的数字转换成int类型
        integers.add(Integer.parseInt(s.substring(j,i)));
        j = i+1;
      }
    }
    //升序排序
    integers.sort(Comparator.reverseOrder());
    //拼接成String类型
    for(Integer integer : integers){
      sortedString = sortedString + integer.toString()  + ",";
    }
    return sortedString.substring(4,s.length()+3);
  }




  public static void main(String[] argv) {
    Object implementor = new HelloWorld ();
    String address = "http://localhost:9000/HelloWorld";
    Endpoint.publish(address, implementor);
  }
}
