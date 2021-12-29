package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Lambda02 {public static void main(String[] args) {
		List <Integer> list=new ArrayList<>(Arrays.asList(12,13,65,-3,7,34,22,-60,42,15));
		

	
		ciftKareMax(list);
		System.out.println();
	    System.out.println("  ***    ");
	    toplaEl1(list);
	    System.out.println();
	    System.out.println("  ***    ");
	    toplaEl2(list);
	    System.out.println();
	    System.out.println("  ***    ");
	    ciftCarp1(list);
	    System.out.println();
	    System.out.println("  ***    ");
	    ciftCarp2(list);
	    System.out.println();
	    System.out.println("  ***    ");
	    enKucuk(list);
	    System.out.println();
	    System.out.println("  ***    ");
	    enKucuk(list);
	    System.out.println();
	    System.out.println("  ***    ");
	    minEl3(list);
	    System.out.println();
	    System.out.println("  ***    ");
	    minEl4(list);
	    System.out.println();
	    System.out.println("  ***    ");
	   
	    onBestenBuyukEnKucukTekSayi(list);
	    System.out.println();
	    System.out.println("  ***    ");
	     ciftKare(list);
	    System.out.println();
	    System.out.println("  ***    ");
	   tekKareBuyuktenKucuk(list);
	}
////List'in cift olan elelmanlarin karelerini aliniz ve en buyugunu yazdiriniz
	
	public static void ciftKareMax(List <Integer> list) {
     Optional<Integer>	maxEl	=list.stream().filter(Lambda01::ciftBul).map(t->t*t).reduce(Integer::max);
   //  int <Integer>	maxEl	=list.stream().filter(Lambda01::ciftBul).map(t->t*t).reduce(Integer::max); yanlis
     
     //reduce() returne edilen eleman null yada int den buyuk olur ihtimali icin jaa guvenlik olarak 
     //handle ederek optional class sart kosuyor
   //  Optional<Integer>	maxEl	=list.stream().filter(Lambda01::ciftBul).map(t->t*t).reduce(Math::max);
     //reduce(Math::max) da kullanilir ancak reduce(Integer::max) daha specific oldugu icin hizli calisir
     System.out.print(maxEl);
     }
	//listeki tum elemanlarin toplamini yazdiriniz
	//lambda expression
	public static void toplaEl1(List <Integer> list) {
		
	int toplam= list.stream().reduce(0,(x,y)->x+y);
	/*
	  x her zaman ilk degerini atanan degerden (0) alir.
	  y her zaman degerini list.stream() den alir(akis)
	  x ilk degerden sonraki degerlerini islemden alir
	  

	 */
	System.out.println(toplam);
	
	}
	
	public static void toplaEl2(List <Integer> list) {
		
		Optional<Integer>toplam=list.stream().reduce(Math::addExact);
		//Optional<Integer>toplam=list.stream().reduce(Integer::Sum);
		System.out.println(toplam);
	}
	//Listtekii cift elemanlarin carpimini yazdiiriniz
	//method reference
	public static void ciftCarp1(List<Integer> list){
	    Optional<Integer> carpim = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);
	    System.out.println(carpim);
	}
	//Listtekii cift elemanlarin carpimini yazdiiriniz
	//lambda expression
	public static void ciftCarp2(List<Integer> list){
	    int carpim = list.stream().filter(Lambda01::ciftBul).reduce(1, (x, y) -> x * y);
	    //pozitif deger uretiniz
	    int carpBoz = list.stream().filter(Lambda01::ciftBul).reduce(-1, (x, y) -> x * y); 
	    System.out.println(carpim);
	    System.out.println(carpBoz);
	}
	
	//List'teki elemanlardan en kucugunu 4 farklý yontem ile yazdiriniz
	public static void enKucuk(List<Integer> list){
		//1.yontem Math class
	Optional<Integer> minEl1= list.stream().reduce(Math::min);
	System.out.println(minEl1);
	
	
		//2.yontem Integer class
	Optional<Integer> minEl2=list.stream().reduce(Integer::min);
	System.out.println(minEl2);
	}
	//3. yontem kader class
	public static int enKucuk(int x, int y){
		
		return x<y ?x:y;// ternaryy
		 
	}	
	public static void minEl3(List<Integer> list){
		Optional<Integer> minEl3= list.stream().reduce(Lambda02::enKucuk);	
		System.out.println(minEl3);
		
		
	}
	public static void minEl4(List<Integer> list){
		Integer minEl4= list.stream().reduce(Integer.MAX_VALUE,(x,y)-> x<y  ? x:y);	
		System.out.println(minEl4);
	
	}
	//Listteki 15 ten buyuk en kucuk tek sayiyi yazdiriniz
	public static void onBestenBuyukEnKucukTekSayi(List<Integer> list){
		//list.stream().filter(t->t%2==1).filter(t->t>15).reduce(Integer::min);
		list.stream().//akisa girdi
		filter(t->t%2==1 & t>15).// tek ve 15 den buyuk sart saglandi
		reduce(Integer::min);
		System.out.println(list.stream().filter(t->t%2==1 & t>15).reduce(Integer::min));
	}
	public static void ciftKare(List<Integer> list){
		//listin cift elemanlarinin karelerini kucukten buyuge yazdiriniz
		 list.stream().
		 filter(Lambda01::ciftBul).
		 map(t->t*t).
		 sorted().//akisa giren elemanlari natural ordere gore sýrakar
		 forEach(Lambda01::printEl);
		
	}
	//listin tek elemanlarinin karelerini buyukten kucuge yazdirinix
	public static void tekKareBuyuktenKucuk(List<Integer> list){
		 list.stream().
		 filter(t->t%2!=0).
		 map(t->t*t).
		 sorted(Comparator.reverseOrder()).//akisa giren elemanlari natural ordere gore sýrakar
		 forEach(Lambda01::printEl);
		
	}
}
