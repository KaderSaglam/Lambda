package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda04 {

	public static void main(String[] args) {
		
	//simdi obje yapiyoruz
		TechPro trGunduz=new TechPro("yaz","TR gunduz",97,124);
		TechPro engGunduz=new TechPro("kis","ENG gunduz",95,131);
		TechPro trGece=new TechPro("bahar","TR gece",98,143);
		TechPro engGece =new TechPro("sonbahar","ENG gece",93,151);
		
		List<TechPro>list=new ArrayList<>(Arrays.asList(trGunduz,engGunduz,trGece, engGece));
		//bu classta return type calýscagiz yani biseyler dondurecek
		
		System.out.println(batchOrt92Byk(list));
		 System.out.println();
		System.out.println("  ***    ");
	System.out.println(ogrcSayisi110Az(list));
		System.out.println();
		System.out.println("  ***    ");
	}
	
	//task 02-->batch ortalamalarinin 92 den buyuk olani kontrol eden pr create ediniz.
public static boolean batchOrt92Byk(List<TechPro>list) {
	
return	list.
		stream().
		allMatch(t->t.getBatchOrt()>92);//Akisdaki  her eleman  batchort field'a gore eslesmesi kontrol edildi
//true donderdi yani hepsi 92 den buyukmus	
//hepsinin batch ortalamasýna bakmak icin allMatch kullandik	
}
//task 02-->ogrc sayilarinin hic birinin  110 den az olmadigini  kontrol eden pr create ediniz.
public static boolean ogrcSayisi110Az(List<TechPro> list) {
    return list.
            stream().
           // noneMatch(t -> t.getOgrcSayisi()< 110);//hic biri 110 dan kuck degildir
            allMatch(t -> t.getOgrcSayisi()>=110);//her biri 110dan buyuktur
}
//task 03-->batch'lerde herhangi birinde "bahar" olup olmadigini  kontrol eden pr create ediniz.
public static boolean herhangiBirBaharKontrol(List<TechPro> list) {
    return list.
            stream().anyMatch(t->t.getBatch().equals("bahar"));
}
//task 04-->batch'leri ogr sayilarina gore b->k siralayiniz.
}
