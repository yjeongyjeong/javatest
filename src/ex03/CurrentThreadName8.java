package ex03;
//순서대로 찍히게 만들기

class Printer{
	private boolean isHelloTurn = true;
	synchronized public void printHello() {
		while(!isHelloTurn) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Hello");
		isHelloTurn = false;
		notify();
	}
	synchronized public void printWorld() {
		while(isHelloTurn) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("World");
		isHelloTurn = true;
		notify();
	}
}

public class CurrentThreadName8 {

	public static void main(String[] args) throws InterruptedException {
		Printer printer = new Printer();
		
		Thread t1 = new Thread(() -> { // +1
			for(int i = 0; i <10 ; i++) {
				printer.printHello();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}); 
		Thread t2 = new Thread(() -> { // -1
			for(int i = 0; i <10 ; i++) {
				printer.printWorld();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
			} 
		});

		t1.start();
		t2.start();
		

	}
}
