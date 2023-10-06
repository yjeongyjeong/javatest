package ex02;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectExam {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
		
		List<String> list = words.stream()
		.filter(s -> s.length() < 5)
		.collect(Collectors.toList());
		
		System.out.println(list);
		
		
		//짝수와 홀수를 그룹화하여 맵에 저장
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

//		map은 key(묶어지는 이름), value(묶여지는 값들의 타입)
		Map<String, List<Integer>> evenOddMap = 
				numbers.stream()
				.collect(Collectors.groupingBy(n -> n%2==0 ? "짝수" : "홀수"));
//		map은 key, value	n%2==0인 애들은 "짝수"라는 키값을 가진 배열로 감
		System.out.println("짝수 : "+evenOddMap.get("짝수")); // 짝수라는 키에 있는 애들가져옴, 타입이 List인 경우 값을 가져오려면 get(인덱스넘버) 사용 근데 여기서 evenOddMap은 map타입이니까 get(키값)으로 그 키에 해당하는 value들을 가져오는데 value타입이 list라서 list형태로 출력됨  
		System.out.println("홀수 : "+evenOddMap.get("홀수"));
		
		
	}
}
