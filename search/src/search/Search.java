package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Search {

	public Search() {
		super();
	}
	
	public void solve(Map<String, String> map) {	
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入关键字：");
		String keyword=scanner.nextLine();
		System.out.println("搜索的结果是：");
		for(String x:map.keySet()) {		
			if(map.get(x).indexOf(keyword,0)!=-1) {
				System.out.println(x+" ");
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String d1="i like to watch the sun set with my friend";
		String d2="the best places to watch the sunset";
		String d3="my friend watch the sun come up";
		Map<String,String> map=new HashMap<>();
		map.put("d1", d1);
		map.put("d2", d2);
		map.put("d3", d3);
		Search s1=new Search();
		s1.solve(map);
	}

}
