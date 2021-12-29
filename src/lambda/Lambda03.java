package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

	public static void main(String[] args) {
	List<String> list = new ArrayList<>(Arrays.asList("mehmet","emre","nilgun","cincix","kader","emine","islam","islam",
			"kokorec"));
	BuyukHarfTekrarsizSira(list);
	 System.out.println();
	   System.out.println("  ***    ");
	    krkSyisiTekrarsizTersSirali(list);
	  System.out.println();
	System.out.println("  ***    ");
	krkSyisiKucuktenBuyuk(list);
	System.out.println();
	System.out.println("  ***    ");
	 krkSyisiBuyuktenKucuk(list);
	 System.out.println();
		System.out.println("  ***    ");
	 ciftSayiliElemanlarinKareleri(list);
	 System.out.println();
		System.out.println("  ***    ");
	 harfSayisi7Kontrol(list);
	 System.out.println();
		System.out.println("  ***    ");
	 wBaslamaKontrol(list);
	 System.out.println();
		System.out.println("  ***    ");
	 xBitisKontrol(list);
	 System.out.println();
		System.out.println("  ***    ");
		karakterEnBuyukEl(list);
		System.out.println();
		System.out.println("  ***    ");
		karakterEnBuyukEl2(list);
		System.out.println();
		System.out.println("  ***    ");
		ilkElemanHaricSonHarfineGoreSirali(list);
		
	}
	//list elemanlarini alfabetik  buyuk harf ve tekrarsiz yazdiriniz
	public static void BuyukHarfTekrarsizSira(List<String> list) {
	list.stream().
	map(t->t.toUpperCase()).
	sorted().//alfabetik sira
	distinct().//tekrarsiz
	//distinc() methodu akistaki elelmnlari tekrarsiz yapar
	forEach(t->System.out.print(t+ " "));//yazdirildi
	}
//list elemanlarin karakter sayisini ters sirali olarak tekrarsiz yazdiriniz
	public static void krkSyisiTekrarsizTersSirali(List<String> list) {
		list.stream().
		map(t->t.length()).//string dta karrakter sayisina update edildi
		sorted(Comparator.reverseOrder()).
		distinct().//tekrarsiz
		forEach(Lambda01::printEl);// parametre de integer data da integer
	}
	//List elemanlarini  karakter sayisina  gore kucukten buyuge gore yazdiriniz
	public static void krkSyisiKucuktenBuyuk(List<String> list) {
		list.stream().
		sorted(Comparator.comparing(t->t.length())).//karsilastirma methodunu elemanlarin boyutuna gore uygula
		//eleman karakter sayisina gore ozel siralama yapar
		forEach(t->System.out.print(t+ " "));
	}
	public static void krkSyisiBuyuktenKucuk(List<String> list) {
		//list elemalarinin son harfine  gore ters sirali yazddriniz
		list.stream().
		sorted(Comparator.comparing(t->t.toString().
				charAt(t.toString().length()-1)).//elemanin length()-1--->son indexinin karakterini ters siralar z-->a
				reversed()).
				//karsilastirma methodunu elemanlarin boyutuna gore uygula
		forEach(t->System.out.print(t+ " "));
	}
	//cift sayili elemanlarin karakter sayilarinin  karelerini hesaplayan  ,tekrarsiz   buyukten kucuge sirali  yazniz
	public static void ciftSayiliElemanlarinKareleri(List<String> list) {
		list.stream().
		filter(t->t.length()%2==0).
		map(t->t.length()*t.length()).filter(Lambda01::ciftBul).distinct().sorted(Comparator.
				reverseOrder()).forEach(Lambda01::printEl);
}
	//list elemanlarinin karakter sayisini 7 ve7 den az olma durumunu kontrol ediniz
	public static void harfSayisi7Kontrol(List<String> list) {
	/*	boolean kontrol=list.stream().
		allMatch(t->t.length()<=7);//hepsi eslesiyor mu?
		//her bir elemani kucuk esit 7 ye eslesmesine bakti
		if (kontrol) {
			System.out.println("list elemanlari 7 harfden buyuk degil");
			
		} else {
System.out.println("list elemanlari 7 harfden buyuk");
		}
		System.out.println(kontrol);*/
		System.out.println(list.stream().allMatch(t->t.length()<=7)?"list elemanlari 7 den buyuk degil":"7 den buyuk");
		                                 //her bir elemani  eslestir
	}
	//list elemanlarinin "w" ile baslamasini kontrol ediniz
	public static void wBaslamaKontrol(List<String> list) {	
		System.out.println(list.stream().noneMatch(t->t.startsWith("w"))?"w ile baslayan isim ayaga kalksin ":"w ile baslayan isim olur mu");
		                          //hic eslesmez bir tane varsa false calisir
                         //hic bir turkce isimi w ile baslayamaz
	
	
	}   
	//anymatch()= en az biri
	//list elemanlarinin "x" ile biten en az bir elemani  kontrol ediniz 
	public static void xBitisKontrol(List<String> list) {	
	System.out.println(list.stream().anyMatch(t->t.endsWith("x"))?"x ile biten isim ayaga kalksin":"x ile biten isim olur mu");
	//  noneMatch(t -> t.startsWith("w"))--->  "hicbiri W ile baslamiyor" : "birileri W ile basliyor"
	//  allMatch(t -> t.startsWith("w")) --->  "hepsi W ile basliyor" : "bir tanesi W ile baslamiyor"
	//  anyMatch(t -> t.startsWith("w")) --->  "herhangibiri W ile basliyor" : "hicbiri W ile baslamiyor"
	}
	//karakter sayisi en buyuk elemani yazdiriniz
	public static void karakterEnBuyukEl(List<String> list) {	
	System.out.println(list.stream()
			.sorted(Comparator.comparing(t-> t.toString().length()).//karakter uzunluguna gore siraladi ve karsilastrdi
				reversed()).//ters siraladi
		findFirst());//ilk elemani aldi
	}
	public static void karakterEnBuyukEl2(List<String> list) {	
		Stream<String>sonIsim=list.
		stream().sorted(Comparator.comparing(t-> t.toString().length()).reversed()).
		limit(5);//limit(a) akýsdan cýkan elemanlari parametresine gore ilk a elemani alir
		//strng tipinde variable  veriyor
		System.out.println(Arrays.toString(sonIsim.toArray()));
		//array yazdýrdým sonisimde arraya cevrildi // to array yerine to list yaparsam liste cevrilir
	}
	//list elemanlari son harfine  gore siralayip ilk  eleman haric kalan elemanlari yazdiriniz
	public static void ilkElemanHaricSonHarfineGoreSirali(List<String> list) {	
		list.stream().sorted(Comparator.comparing(t->t.toString().charAt(t.length() - 1))).
		skip(1).//akistan cikan elemanlarin 1. parametreyi atlar
		forEach(t->System.out.print (t+" "));
		
	}

}
