package ex03;

class Counter1{
	int count = 0;
	
	synchronized public void increment() { count++; }
	synchronized public void decrement() { count--; }
	
	public int getCount() { return count; }
}

public class CurrentThreadName5 {
	public static Counter1 cnt = new Counter1(); //static이라 밖으로 빼줌

	public static void main(String[] args) throws InterruptedException {
		
		
		Runnable task1 =() -> { // +1
			for(int i = 0; i <1000 ; i++) {
				cnt.increment();
			}
		};
		Runnable task2 =() -> { // -1
			for(int i = 0; i <1000 ; i++) {
				cnt.decrement();
			} 
		};
		
		Thread t1 = new Thread(task1); 
		Thread t2 = new Thread(task2);

		t1.start();
		t2.start();
		
		t1.join(); // 종료할 때까지 기다린다는 의미
		t2.join();
		
		System.out.println("count : " + cnt.getCount());

//		+1을 1000번하고 -1을 1000번해서 결론은 0이 나와야 하는데 자원을 공유함+순서대로 일어나지 않음 => 문제발생(0이 아님)
//		=> synchronized를 추가해서 문제 해결 가능
//		현재 데이터를 사용하고 있는 해당 스레드를 제외하고 나머지 스레드들은 데이터에 접근 할 수 없도록 막는 개념
//		근데 남발하면 성능저하
	}
}
