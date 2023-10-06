package ex03;

public class CurrentThreadName7 {

	public static void main(String[] args) throws InterruptedException {
				
		Thread t1 = new Thread(() -> { // +1
			for(int i = 0; i <5 ; i++) {
				System.out.println("Hello");;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}); 
		Thread t2 = new Thread(() -> { // -1
			for(int i = 0; i <5 ; i++) {
				System.out.println("World");;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			} 
		});

		t1.start();
		t2.start();
		
		t1.join(); // 종료할 때까지 기다린다는 의미
		t2.join();
		

//		+1을 1000번하고 -1을 1000번해서 결론은 0이 나와야 하는데 자원을 공유함+순서대로 일어나지 않음 => 문제발생(0이 아님)
//		=> synchronized를 추가해서 문제 해결 가능
//		현재 데이터를 사용하고 있는 해당 스레드를 제외하고 나머지 스레드들은 데이터에 접근 할 수 없도록 막는 개념
//		근데 남발하면 성능저하
	}
}
