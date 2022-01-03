package lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Lambda06 {

	public static void main(String[] args) throws IOException {
		 //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");
        Files.
                lines(Paths.get("src\\lambda\\haluk.txt")).//file erisip  file satirlari akis alindi
//lines satir
                forEach(System.out::println);


        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.
                lines(Paths.get("src\\lambda\\haluk.txt")).//file erisip  file satirlari akis alindi
                map(String::toUpperCase).//akısdaki satirlarin byk hrf ile update edildi
                forEach(System.out::println);


        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        Files.
                lines(Paths.get("src\\lambda\\haluk.txt")).//file erisip  file satirlari akis alindi
                limit(1).//ilk satir alindi
                map(String::toLowerCase).
                forEach(System.out::println);


        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println(Files.
                lines(Paths.get("src\\lambda\\haluk.txt")).//file erisip  file satirlari akis alindi
                        filter(t -> t.contains("basari")).//basari icerme sarti
                        //akıstaki elemanlara bak her bir satiri t ye ata icinde basari var mibak
                        count());


        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("src\\lambda\\haluk.txt")).//file erisip  file satirlari akis alindi
                        map(t -> t.split(" ")).//" " gore satirlardaki elemanlari parcalayip array'a atadi
                        flatMap(Arrays::stream).//Arrays clasından stream() ile array elemanlarindan yeni bir akıs olusturdu
                        distinct().//yeni akısdaki array elemanlari tekrarsız hale getirildi
                // toList());
                        collect(Collectors.toList()));//yeni akısdaki array tekrarsız elemanlari liste atandi


        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        Files.
                lines(Paths.
                        get("src\\lambda\\haluk.txt")).
                map(t -> t.
                        toLowerCase().
                        split(" ")).
                flatMap(Arrays::stream).
                sorted().
                forEach(System.out::println);


        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        Files.
                lines(Paths.
                        get("src\\lambda\\haluk.txt")).
                map(t -> t.
                        toLowerCase().
                        split(" ")).
                flatMap(Arrays::stream).
                sorted().
                forEach(System.out::println);

        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.
                        get("src\\lambda\\haluk.txt")).
                map(t -> t.
                        split("")).
                flatMap(Arrays::stream).
                filter(t -> t.
                        equals("a")).
                count());

        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        Files.
                lines(Paths.
                        get("src\\lambda\\haluk.txt")).
                map(t -> t.
                        split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.
                        contains("a")).
                forEach(System.out::println);

        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.
                        get("src\\lambda\\haluk.txt")).
                map(t -> t.
                        replaceAll("\\W", "").//array veririr
                                replaceAll("\\d", "").//array veririr
                                split("")).
                flatMap(Arrays::stream).
                //distinct().
                        count());

        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.
                        get("src\\lambda\\haluk.txt")).
                map(t -> t.
                        replaceAll("[.!?,\\-]", "").
                        split(" ")).
                flatMap(Arrays::stream).
                distinct().
                count());

}}