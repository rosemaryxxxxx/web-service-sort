import example.HelloWorld;

import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.Comparator;

public class webServiceTest {
    public static String ascSort(String s){
        s=s+",";
        ArrayList<Integer> integers = new ArrayList<Integer>();
        String sortedString = null;
        //获取每个“,”之间的数字
        int j = 0;
        for(int i = 0 ; i<s.length() ; i++){
            if(s.charAt(i) == ',' ){
                integers.add(Integer.parseInt(s.substring(j,i)));
                j = i+1;
            }
        }
        integers.sort(Comparator.naturalOrder());
        for(Integer integer : integers){
            sortedString = sortedString + integer.toString()  + ",";
        }
        return sortedString;
    }

    public static void main(String[] argv) {
        String s = "99999,55,54,333,26666,1";
        System.out.println(ascSort(s).substring(4,s.length()+3));
    }
}
