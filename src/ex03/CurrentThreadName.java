package ex03;

public class CurrentThreadName {
	public static void main(String[] args) {
//		스레드는 프로세스의 코드에 정의된 절차에 따라 CPU에 작업을 요청하는 실행단위
		Thread thread = Thread.currentThread();
		String name = thread.getName();
		System.out.println("스레드 이름 : "+name);
		
	}
}
