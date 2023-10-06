package ex03;

public class CurrentThreadName2 {
	public static void main(String[] args) {
		//일종의 인터페이스를 하나 만든 상태
		Runnable task =() -> {
			int n1= 10;
			int n2= 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + ":" + (n1 + n2));
		};
		
		Thread t = new Thread(task, "Mythread"); //스레드 이름줌
		t.start(); //start라는 동작을 위에서 받음(재정의한상태)...?ㅜ?
		
		System.out.println("end : " + Thread.currentThread().getName());

/* 출력하면
 * end : main
 * Mythread:30
 * 
 * 이렇게 나오는데 그 이유는 스레드 생성하고 출력하려는데 그 사이 main이 끝나서
 * */
		
	}
}
