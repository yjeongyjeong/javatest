package ex02;

import java.util.Arrays;
import java.util.List;

public class ReduceExam02 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
/* 홀수의 곱을 계산하는 스트림식을 구현
 * filter와 reduce를 사용
 * */		
		Integer cal = numbers.stream()
		.filter(i -> i%2==1) // 홀수만 남게 함( i%2 != 0 ) 이라고도 가능
		.reduce(1, (a,b)->a*b); // 곱하기니까 1부터 시작해서 1*3 3*5 15*7 105*9 가 진행됨
		//더하기처럼 순서가 상관없는 계산이라서 가능..하다고 생각
		System.out.println(cal);
		
		//정답 확인
		System.out.println(1*3*5*7*9);
	}
}
