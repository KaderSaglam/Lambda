package lambda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;



public class Lambda01 {
	
	
	/*
	   1) Lambda "Functional Programming"
	      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
	   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
	   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
	   ve hatasiz code yazma acilarindan cok faydalidir.
	   4) Lambda sadece collections'larda(List, Queue Set) ve array'lerde kullanilabilir ancak map'lerde kullanýlmaz.
	      Lambda kullanmak hatasýz code kullanmaktýr.
	*/

	public static void main(String[] args) {
		
		List <Integer> list=new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55));
		//method creat edecem maine cagirip calistircam
		 printElstructured(list);//method call
	        System.out.println();
	        System.out.println("   ***   ");
	        printElFunctional(list);//lambda expression
	        System.out.println();
	        System.out.println("   ***   ");
	        printElFunctionall(list);//method reference
	        System.out.println();
	        System.out.println("   ***   ");
	        printCiftElStuructured(list);
	        System.out.println();
	        System.out.println("   ***   ");
	        printCiftElFunctionall(list);
	        System.out.println();
	        System.out.println("   ***   ");
	        printCiftElFunctional2(list);
	        System.out.println();
	        System.out.println("  ***    ");
	        printCiftAltmisKucuk(list);
	        System.out.println();
	        System.out.println("  ***    ");
	        ciftOlanlarinKaresi(list);
	        System.out.println();
	        System.out.println("  ***    ");
	       tekOlanlarinKuplerininBirFazlasi(list);
	       System.out.println();
	        System.out.println("  ***    ");
	        ciftOlanlarinKarakokleri(list);
	       System.out.println();
	        System.out.println("  ***    ");
	       enBuyukElemen(list);
	       System.out.println();
	        System.out.println("  ***    ");
	        printCiftElFunctional2(list);
	        System.out.println();
	        System.out.println("  ***    ");
	       enKucukElemen(list);
			
	}
//structured Programming ile  list elemanlarinin tamamini yazdiriniz
	public static void printElstructured(List<Integer>list) {
	for (Integer w : list) {
		System.out.print(w+" ");
		
		
	}	
}
	
	
	//Functional Programming ile  list elemanlarinin tamamini yazdiriniz
	public static void printElFunctional(List<Integer>list) {
		list.stream().forEach(t-> System.out.print(t+" "));//lamda ifadesi
	//	stream() : datalari yukardan asagiya akýs sekline getirir
		//for each(): datanain paramateresine göre her bir elemani isler
		//t->lambda operatoru
		//lambda expression yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir
		
		}
	//Method Reference --> kendi create ettigimiz veya java'dan aldigimiz method ile 
	// ClassName::MethodName----->ezberlenecek
	public static void printEl(int t) {//refere  edilecek methodcreate ettim  refarans almak icin olusturrdum
		System.out.print(t+" ");
	}
	
	public static void printElFunctionall(List<Integer>list) {
		list.stream().forEach(Lambda01::printEl);//yazdirdim methodu iste lambda budur
		//once selale yaptim sonra icerdeki isleme tabi tutuyorum
		
		//86. satirda yaptigim = lamda01 classýni goruyor ordan methoda götruyor redere ediyor  o method sadece yazdiriyor orda da yaziliyor 
		//her biri dedigi icin hepsine  yapiyor
		
		
	}	
	
		//Structed Programming ile  list elemanlarinin cift elemanlarini  ayni satirda aralarinnda bosluk býrakarak yazdiriniz
			
	public static void printCiftElStuructured(List<Integer> list) {
		for (Integer w: list) {
			if (w%2==0) {
				System.out.print(w+" ");
				
			}
			
		}
		
		}
	//Functional Programming ile  list elemanlarinin cift elemanlarini  ayni satirda aralarinnda bosluk býrakarak yazdiriniz
	
	public static void printCiftElFunctionall(List<Integer> list) {
		list.stream().filter(t-> t%2==0).forEach(Lambda01::printEl);//2 tane method refere
		
		//filter()  -->icerisindeki elemanlari istenen sarta gore filtreleme yapar
	}
	
	
	
	public static boolean ciftBul(int i) {//refere edilecek tohum method create edildi
		
		
		return i%2==0;
		
	}
	public static void printCiftElFunctional2(List<Integer> list) {
		list.stream().filter(t-> t%2==0).forEach(Lambda01::ciftBul);
	
	
	}
	
	//Functional Programming ile list elemanlarinin 
	//cift olanalrinin 60 dan kucuk olanlarýný ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void printCiftAltmisKucuk(List<Integer>list) {
		list.stream().filter(t->t%2==0 & t<60).forEach(Lambda01::printEl);
	}
	 //Functional Programming ile list elemanlarinin  tek olanalrini veya 20 dan buyuk
    // olanlarýný ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void tekYirmidenBuyukPrint(List<Integer>list) {
		list.
		stream().
		filter(t->t%2==1||t>20).
		forEach(Lambda01::printEl);
		
	}
	//Functional Programming ile list elemanlarinin  cift olanlarinin
	// karelerini ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void ciftOlanlarinKaresi(List<Integer>list) {
		list.
		stream().
		filter(Lambda01::ciftBul).
		map(t->t*t).
		forEach(Lambda01::printEl);
		// map() -->bir ara islemde kulanilir. elemanlari istenen isleme gore degistirmek ubdate etmek icin kullanilir
	}
	//Functional Programming ile list elemanlarinin  tek olanlarinin
	// kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz
	public static void tekOlanlarinKuplerininBirFazlasi(List<Integer>list) {
		list.stream().filter(t->t%2==1).map(t->(t*t*t)+1).forEach(Lambda01::printEl);
	}
	
	//Functional Programming ile list elemanlarinin  cif olanlarinin
		// karakoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void ciftOlanlarinKarakokleri(List<Integer>list) {
		list.
		stream().
		filter(Lambda01::ciftBul).
		map(Math::sqrt).
		forEach(t-> System.out.print(t+" "));
		
		//burada sonuc double ciktigi icin kendimiz yazdik
	//Math diye bir class var
		//squareroot=sqrt
				//sguare=kare
				//root=kok
	}	
	
	//list'in en buyuk elemanini yazdiriniz
	public static void enBuyukElemen(List<Integer>list) {
	Optional<Integer>	maxEl= list.stream().reduce(Math::max);
		System.out.println(maxEl);
	}
	//list'in en buyuk elemanini yazdiriniz
	public static void enKucukElemen(List<Integer>list) {
		Optional<Integer>minEl=	list.stream().reduce(Math::min);
		System.out.println(minEl);
		//reduce()-->azaltmak...bir cok datayi  tek bir dataya(max min carp topla vs islemlerde)cevirmek icin kullanilir
	}
	
}

