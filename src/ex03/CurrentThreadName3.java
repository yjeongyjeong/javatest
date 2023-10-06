package ex03;

public class CurrentThreadName3 {
	public static void main(String[] args) {
		
		Runnable task1 =() -> { //짝수 출력
			for(int i = 0; i <20 ; i++) {
				if(i%2 == 0)
					System.out.printf(i + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		};
		Runnable task2 =() -> { //홀수 출력
			for(int i = 0; i <20 ; i++) {
				if(i%2 == 1)
					System.out.printf(i + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			}
		};
		
		Thread t1 = new Thread(task1); 
		Thread t2 = new Thread(task2);
// thread는 순서대로 돌지 않음.. sleep 없애면 숫자 뒤죽박죽		
		t1.start();
		t2.start();
		System.out.println("end : " + Thread.currentThread().getName());

/* 출력하면
 * end : main
 * Mythread:30
 * 
 * 이렇게 나오는데 그 이유는 스레드 생성하고 출력하려는데 그 사이 main이 끝나서
 * */
		
	}
}
