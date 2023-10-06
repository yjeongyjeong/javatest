package ex01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
//컬렉션이나 배열에 저장된 요소를 반복처리하기 위해서 for나 iterator를 사용했는데 Stream으로도 할 수 있다!
public class FristStremaExam {
	public static void main(String[] args) {
		int[] ar = {1,2,3,4,5};
		IntStream stm1 = Arrays.stream(ar);
		IntStream stm2 = stm1.filter( n -> n%2==1 );
//		12345를 전달받아서 나머지가 0이면 (false)면 통과되지 않음
//		따라서 stm2에는 1,3,5만 들어잇음
//		int sum = stm2.sum();
		int sum = (int) stm2.count(); 
		System.out.println(sum); // 1+3+5 = 9
		
		int result = Arrays.stream(ar).filter( n -> n%2==0).sum();
		System.out.println(result);
//		중간연산(filter같은거)은 여러번 할 수 잇는데 최종연산(filter끝나고연산같은거)은 한번만 가능
		
		System.out.println("--------------------------------");
		String[] names = {"Toy", "BB", "Box", "CCCC", "Robot", "AAAA"};
		Arrays.stream(names)
		.filter(s -> s.length()>3) //길이값이 3이상만 통과
		.filter(s -> s.length()%2==1 ) //길이값이 홀수인것만 통과
		.forEach(s -> System.out.println(s));
//		arrays.stream -> 스트림에 띄워주는 느낌
//		필터 -> 최종연산전에 true false 값이 결과로 나오는 연산을 해서 true 값만 연산에 사용되도록 걸러줌(중간연산은 계속 기입해줄 수 있음)
//		forEach for문 도는 것처럼 모든 데이터 가져와서 연산
		
		System.out.println("--------------------------------");
		Arrays.stream(names)
		.map(s -> s.length())
		.forEach(s -> System.out.println(s));
		
		System.out.println("--------------------------------");
		int sum2 = Arrays.stream(names)
				.mapToInt(s-> s.length())
				.sum();
		System.out.println(sum2);
		
		System.out.println("--------------------------------");
		List<String> str = Arrays.asList("Toy", "BB", "Box", "CCCC", "Robot", "AAAA");
		int sum3 = str.stream().mapToInt(s -> s.length()).sum();
		System.out.println(sum3);
		
 

		
		
		
		/*		매개변수로 (IntPredicate predicate)를 받음 -> true false를 반환해주는 자바의 함수형 인터페이스 
 * 람다식 : 함수형 인터페이스를 구현함
 * 함수형 인터페이스			Descripter		Method
 * Predicate			T -> boolean	boolean test(T t)
 * => Returns a stream consisting of the elements of this stream that matchthe given predicate. 
		This is an intermediateoperation.
		Parameters:predicate a non-interfering, statelesspredicate to apply to each element to determine if itshould be includedReturns:the new stream
		*/
	}
}
