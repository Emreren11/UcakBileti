import java.text.DecimalFormat;//Virgülden sonrasını düzenlemek için kullanılan kodun kütüphanesi
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);

        int km,age,trvlType;

        System.out.print("Mesafeyi km türünden giriniz: ");
        km=inp.nextInt();

        System.out.print("Yaşınızı giriniz: ");
        age=inp.nextInt();

        System.out.print("Yolculuk tipini giriniz (1=> Tek Yön, 2=> Gidiş dönüş): ");
        trvlType=inp.nextInt();
        System.out.print("\n"); // Sonuç için boşluk
        double price=km*0.1;
        double priceCut;
        if (km>0 && age>0 && (trvlType==1 || trvlType==2))
        {
            // Yaşa Göre İndirim Uygulayan Kodlar
            if(age<12)
            {
                priceCut=price/2;
            } else if (age>11 && age<24)
            {
                priceCut=price*0.90; // %10 indirim
            }else if (age>=65)
            {
                priceCut=price*0.70; //  %30 indirim
            }else
            {
                priceCut=price; // İndirim uygulanmayan kişiler
            }
            System.out.println(priceCut+"\n");

            // Yolculuk Tipine Göre İndirim Uygulayan Kodlar
            if(trvlType==2)
            {
                priceCut-=(priceCut/5); // İndirimli fiyat üzerinden %20 gidiş dönüş indirimi
                priceCut*=2;
                price*=2;
            }

            System.out.println("İndirim Yapılmamış Tutar "+ new DecimalFormat("#.##").format(price));
            System.out.println("İndirim Yapılmış Tutar "+ new DecimalFormat("#.##").format(priceCut));
            System.out.println("İndirim Tutarı: "+ new DecimalFormat("#.##").format((price-priceCut)) );
            // Virgülden sonra 2 basamak yazması için gereken format


        }
        else
            System.out.print("Hatalı Veri Girdiniz..!!");

    }
}