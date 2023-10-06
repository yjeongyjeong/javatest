package ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReduceExam {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		Integer sum = numbers.stream()
		.reduce(0, (a,b) -> a+b);
		System.out.println("sum : " + sum);
//		0이랑 1이 들어와서 3이되고 2가 들어와서 5가 되고 ... -> 두개의 값으로 하나씩 줄여나감
		//BinaryOperator : type T의 인자 두 개를 받고 동일한 type T 객체를 리턴하는 함수형 인터페이스
//		합치는 과정에서 타입이 바뀔경우 사용. map+reduce로 대체 가능하다
		
		System.out.println("-------------------");
		List<String> words = Arrays.asList("apple", "banana", "cherry","dete","elderberry");
		
		Integer totalLength = words.stream()
		.map(s -> s.length()) // s를 s의 길이로 바꾼다
		.reduce(0, (a,b)-> a+b); // 처음에 0으로 시작해서 apple의 5와 만나서 0+5 의 값이 a가 되고 그 다음 banana를 만나서 5+6 ... 으로 진행
		System.out.println(totalLength);
		System.out.println("-------------------");
		
		
//		10개의 값 랜덤으로 뽑고 제일 큰 값 찾기
		List<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i < 10 ; i++) {
			nums.add((int)(Math.random()*100));
		}
		
		for (Integer integer : nums) 
			System.out.print(integer + " ");
		System.out.println();
		
		Integer max = nums.stream()
		.reduce(Integer.MIN_VALUE, (a,b)->Integer.max(a, b));
		System.out.println("max : " + max);
//		max함수는 두 정수를 넣으면 큰 값을 반환함 => 이 기능을 reduce로 사용하면 한쪽은 계속 큰값이 남게되고 다른 수랑 비교하게 됨 마치 for를 사용해서 배열0번째를 max변수로 두고 둘이 비교해서 큰 값만 남기는 if문을 사용하는 것처럼.. 동일한 기능
		
		List<String> word = Arrays.asList("Hello", " " ,"World", "!");
		String combind = word.stream().reduce("", (a,b) -> a+b);
		System.out.println(combind);
		//전부 붙어서 나오지 않을까? Hello World!이렇게 => 맞았다!
//		살짝 누적합 구하는 느낌 문자든 숫자든 물론 -> 이후 연산에 따라 달라지겟지만 기존값이 남아있게 되는 게 포인트같음

//		sorted()를 사용한 데이터 정렬(오름차순)
		System.out.println("-------------------");
		int[] ar = {11,2,344,42,55};
		Arrays.stream(ar).sorted().forEach(i -> System.out.print(i + " "));
		
//		내림차순은 어케할까
//		Arrays.stream(ar).sorted(Comparator.reverseOrder()).forEach(i -> System.out.print(i + " "));
		
	}
}
