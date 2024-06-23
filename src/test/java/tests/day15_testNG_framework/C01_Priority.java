package tests.day15_testNG_framework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_Priority {
    int a=20;
    int b=10;

    @Test
    public void carpmaTesti(){
        // sayilarin carpiminin 100 'den büyük olduğunu test edin


        Assert.assertTrue(a*b>100);
    }

    @Test(priority = 22)
    public void toplamaTesti(){
        // sayilarin toplaminin pozitif bir sayi olduğunu test edin
        Assert.assertTrue((a+b)>0);
    }
    @Test(priority = 53)
    public void cikarmaTesti(){
        // a ile b nin farkinin mutlak değerinin 100'den kücük olduğunu test edin
        Assert.assertTrue((a-b)>-100 && (a-b)<100);
    }

    /*

           TestNG hiçbir mudahale olmazsa
           testleri isim sirasina göre caliştirir.


           testlerin calisma siralamasını istediğimiz şekilde dünezleebiliriz

           testlere vereceğimiz priotrity değerlerinden
           kucukten büyüğe doğru çalıştırır


           priority atamazsak testNG default olarak priority=0 alir.

           ayni priortiy degerine sahip, birden fazla test method'u varsa
           bunlar kendi içerisinde isim sirasina göre calişir

     */
}
