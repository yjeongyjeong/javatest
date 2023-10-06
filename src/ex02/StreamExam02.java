package ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class PriceInfo{
	private String model;
	private int price;
	
	public PriceInfo(String model, int price) {
		this.model = model;
		this.price = price;
	}
	public int getPrice() { return price; }
	public String getModel() { return model; }
	
//	@Override
//	public String toString() {
//		return model;
//	}
}

public class StreamExam02 {
	public static void main(String[] args) {
		List<PriceInfo> lists = new ArrayList<PriceInfo>();
//		어떤 대상이든 상관없이 데이터의 주소가 배열에 들어감 (대상을 제한하려면 위 코드처럼 <받을애> 해줌)
		lists.add(new PriceInfo("Toy", 500)); // 타입을 제한했기 때문에 priceInfo만, 그 중에서도 string과 int를 받는 애들이 들어감
		lists.add(new PriceInfo("Robot", 1500));
		lists.add(new PriceInfo("Box", 700));
		
//		500원 이상인 제품 가격의 합
		int sum = lists.stream().filter(p -> p.getPrice()>500).mapToInt(t -> t.getPrice()).sum();
		System.out.println(sum);
		System.out.println("--------------------------");
		
		/* 0. List 데이터 3개 추가
		 * 1. PriceInfo 클래스 멤버변수 model getter생성
		 * 2. 필터링 조건 : model이 참조하는 문자열 길이가 4 이상이면 해당 인스턴스 통과
		 * 3. 맵핑 방법 : PriceInfo 인스턴스 -> string 인스턴스(모델링)
		 * 4. forEach로 2,3 조건 만족하는 인스턴스만 출력
		 * */
		
		lists.add(new PriceInfo("Doll", 900));
		lists.add(new PriceInfo("Plate", 1000));
		lists.add(new PriceInfo("Bottle", 1200));
		
		 Stream<PriceInfo> str = lists.stream().filter(s -> s.getModel().length()>4);
		 str.forEach(s -> System.out.println(s.toString()));
		//주소값이 출력되어서 toStirng을 오버라이딩함.. 이게 맞나싶다....
		 
		 
		 System.out.println("---------------------");
		 
		 lists.stream()
		 .filter(s -> s.getModel().length() > 4)
		 .map( m -> m.getModel())
		 .forEach(s -> System.out.println(s));
		 
//		 리스트로 받아서 출력할 수도 있음

/* 
map(Function<? super PriceInfo, ? extends String> mapper)

Returns a stream consisting of the results of applying the given function to the elements of this stream. 

This is an intermediate operation.
Type Parameters: <R> The element type of the new stream
Parameters: mapper a non-interfering, stateless function to apply to each element
Returns: the new stream
 * 
 * */
		 
	}


}
