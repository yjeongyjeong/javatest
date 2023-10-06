package ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

class Student{
	private String name;
	private int java;
	
	//생성자
	public Student(String name, int java) {
		this.name = name;
		this.java = java;
	}
	//메서드
	public int getJava() {
		return java;
	}
}
public class StudentStream {
	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("조조", 92));
		students.add(new Student("유비", 77));
		students.add(new Student("손권", 91));
		//객체를 int형으로 바꾼 후 평균을 구하고 double로 반환
		double avg = students.stream()
					.mapToInt(s-> s.getJava())
					.average() //OptionalDouble : 값이 없을 때 예외처리까지 생각해서 나온 메서드
					.getAsDouble();
		System.out.printf("평균 : %.2f" , avg); // 소수점 2자리까지 출력
		System.out.println("\n-------------------------");
		
		OptionalDouble average = students.stream()
				.mapToInt(s-> s.getJava())
				.average(); //OptionalDouble : 값이 없을 때 예외처리까지 생각해서 나온 메서드
		System.out.println(average.getAsDouble());
		
	}
}
