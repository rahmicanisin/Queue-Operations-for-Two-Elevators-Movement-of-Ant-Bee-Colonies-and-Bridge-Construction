package proje2;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Proje2 {
    
    static void bubbleSort(int[][] arr) { 
        /*asansörPQ için öncelik sırasanı ayarlanmada kullanılıyor.
        Sıralama yapılırken kişilerin bilgileri karışmaması için eş zamanlı değişme yapılıyor.*/
        int n = arr.length;  
        int temp = 0; 
        int temp1=0;
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  
                if(arr[j-1][1] > arr[j][1]){  
                    //swap elements 
                    //katlar için
                    temp = arr[j-1][1];  
                    arr[j-1][1] = arr[j][1];  
                    arr[j][1] = temp;
                    
                    //isimler için
                    temp1 = arr[j-1][0];  
                    arr[j-1][0] = arr[j][0];  
                    arr[j][0] = temp1;
                                                               
                }                         
            }  
        }
    }  
    
    static void menu(){
       Scanner scan=new Scanner(System.in);
       System.out.print("Çok Asansörlü Sistemde Kuyruk Simülasyonu için 1: "
               + "\nKarınca Sürüsü Hareketi ve Köprü Kurma için 2: "
               + "\nBaşlatmak istediğiniz proje numarası: ");
       int projeNo=scan.nextInt();
       int islem=0;int secim=0;
       IkiYonluListe liste=randomKisiUret(30, 50);
       switch(projeNo){
           
           case 1:while(islem!=-1){
               System.out.print("Proje 1.b için 1: "
                       + "\nProje 1.c için 2: "
                       + "\nProje 1.d için 3: "
                       + "\nProje 1.e için 4: "
                       + "\nProje 1.f için 5: "
                       + "\nÇıkış için -1: ");
               islem=scan.nextInt();
               IkiYonluListe listeFIFO=siraOlustur(0);
            IkiYonluListe listePQ=siraOlustur(1);
            IkiYonluListe[] fifoVePq=null;
            
            //randdom 30 için
            
            IkiYonluListe[] fifovepq=new IkiYonluListe[2];
            IkiYonluListe randomListeFIFO=new IkiYonluListe();
            IkiYonluListe randomListeFIFO1=new IkiYonluListe();
            IkiYonluListe   randomListePQ=new IkiYonluListe();
            IkiYonluListe   randomListePQ1=new IkiYonluListe();
            IkiYonluListe   randomListeFIFOvePQ=new IkiYonluListe();
         
         for(int t=0; t<30;t++){
             Calisan c1=(Calisan)liste.bastanSil().veri;
             Calisan cKopya=new Calisan(c1.numara, c1.isim, c1.cikacagiKat,c1.its);
             Calisan cKopya1=new Calisan(c1.numara, c1.isim, c1.cikacagiKat,c1.its);
             Calisan cKopya2=new Calisan(c1.numara, c1.isim, c1.cikacagiKat,c1.its);
             Calisan cKopya3=new Calisan(c1.numara, c1.isim, c1.cikacagiKat,c1.its);
             Calisan cKopya4=new Calisan(c1.numara, c1.isim, c1.cikacagiKat,c1.its);
             randomListeFIFO.sonaEkle(cKopya);
             randomListeFIFO1.sonaEkle(cKopya1);
             randomListePQ.sonaEkle(cKopya2);
             randomListePQ1.sonaEkle(cKopya3);
             randomListeFIFOvePQ.sonaEkle(cKopya4);///////random 30 için son
             liste.sonaEkle(c1);
         }
               switch(islem){
                   case 1:
                       
                System.out.println("asansörFIFO binen kişi bilgileri ve its");
                        listeFIFO=asansorFIFOCalisiyor(listeFIFO,"hiz1Kat",1);
                        System.out.println("\n============================================\n");
                        System.out.println("asansörPQ binen kişi bilgileri ve its");
                        listePQ=asansorPQCalisiyor(listePQ,"hiz1Kat",1);
                        System.out.println("\n============================================\n");
                        fifoVePq=asansorFIFOvePQcalisiyor(siraOlustur(0));
                       fifoVePq=asansorFIFOvePQcalisiyor(siraOlustur(0));
                       kazancHesapla(listeFIFO, listePQ, fifoVePq);
                       break;
                   
                   case 2:
                       projeBirC();
                       break;
                   
                   case 3:
                       randomListeFIFO.listele();//kişi bilgileri ekrana yazdırılıyor
            System.out.println("Asansor Hızları Normal İken============");
            randomListeFIFO=asansorFIFOCalisiyor(randomListeFIFO,"hiz1Kat",1);
            
            System.out.println("\n============================================");
            randomListePQ=duzenPQ(randomListePQ);
            randomListePQ=asansorPQCalisiyor(randomListePQ,"hiz1Kat",1);
            
            
            
            String sonuc=kazancHesapla(randomListeFIFO, randomListePQ);
            fifovepq=asansorFIFOvePQcalisiyor(randomListeFIFOvePQ);
            System.out.println("\nd.b maddesi kazanc hesaplama=====================");
            kazancHesapla(randomListeFIFO,randomListePQ,fifovepq);//madde d.b
            
                       break;
                   
                   case 4:
                       randomListeFIFO=asansorFIFOCalisiyor(randomListeFIFO,"hiz1Kat",0);
            
            randomListePQ=duzenPQ(randomListePQ);
            randomListePQ=asansorPQCalisiyor(randomListePQ,"hiz1Kat",0);
                       sonuc=kazancHesapla(randomListeFIFO, randomListePQ);
                       System.out.println("hız bir kat "+sonuc);//madde e
                       break;
                   
                   case 5:
                       //madde f
            System.out.println("");
            System.out.println("\nHız iki kat################################");
            randomListeFIFO1=asansorFIFOCalisiyor(randomListeFIFO1,"hiz2Kat",0);
           
            
            System.out.println("\n============================================");
            randomListePQ1=duzenPQ(randomListePQ1);
            randomListePQ1=asansorPQCalisiyor(randomListePQ1,"hiz2Kat",0);


            System.out.println("Asansörlerin Hızları İki Kat: "+kazancHesapla(randomListeFIFO1,randomListePQ1)+"\n"); 
                       break;
                  
                   case -1:break;
                   
                   default:System.out.println("Yanlış işlem no girildi.");
               }
           }
               break;
           
           case 2:
               while(secim!=-1){
               
                   Projeb.menu();
          
               }
               break;
           
           default:System.out.println("Yanlış proje no girdiğiniz.");
               
               
       }
   }

    public static void main(String[] args){
       
        menu();
       
    }
    
    public static IkiYonluListe siraOlustur(int asansor){
                
        int[][] kisiKat={{1,5},{2,3},{3,9},{4,7},{5,4},{6,4},{7,1},{8,2},{9,3},{10,2},{11,5},{12,6},{13,8},{14,1},{15,5},{16,7},{17,6},{18,3}};

        String[] isim={"Ata","Ada","Arzu","Aslı","Seda","Asya","Sedat","Soner","Ozan","Kerem","Feride","Hilal","Gamze","Yakup","Cihan","Sude","Haluk","İsmail"};
        if(asansor==1){//AsansörPQ için sıralı isimler
            bubbleSort(kisiKat);
            String[] isimSira={"Sedat","Yakup","Soner","Kerem","Ada","Ozan","İsmail","Seda","Asya","Ata","Feride","Cihan","Hilal","Haluk","Aslı","Sude","Gamze","Arzu"};
            isim=isimSira;
            
        }
        IkiYonluListe liste = new IkiYonluListe();
        for(int i=0;i<kisiKat.length;i++){
            /*Calisan sınıfından oluşturuluan nesneler çift bağlı listeye sondan ekleme yapılırak eklenir*/
            Calisan c1=new Calisan(kisiKat[i][0], isim[i], kisiKat[i][1],0);
            liste.sonaEkle(c1);    
        }
        return liste;
    }
    
    public static IkiYonluListe duzenPQ(IkiYonluListe liste){
        /*PQ düzenin sira oluşturmak için kullanılır.*/
        int tekrar=liste.say();
        
        int[][] kisiKat=new int[liste.say()][2];
        String[] isim=new String[200];//değiştirme
        
        for(int i=0;i<tekrar;i++){
            Calisan c=(Calisan)liste.bastanSil().veri;
            kisiKat[i][0]=c.numara;
            kisiKat[i][1]=c.cikacagiKat;
            isim[kisiKat[i][0]-1]=c.isim;
        }
        bubbleSort(kisiKat);/*bubblesort metodu ile PQ düzeni oluşturulur ve listeye eklenir.*/
        for(int i=0;i<tekrar;i++){
            Calisan c1=new Calisan(kisiKat[i][0], isim[kisiKat[i][0]-1], kisiKat[i][1],0);
            liste.sonaEkle(c1);    
        }
        
        return liste;
    }
    
    static IkiYonluListe[] asansorFIFOvePQcalisiyor(IkiYonluListe liste){
        /*Proje 1.b.iii
        İlk önce gelenler arasından random olarak kaç tane kişi seçilecek sayısı 
        random olarak belirlenir ve belirlenen random sayı kadar gelenler 
        arasından random kişi çekilir ve yeni sıraya eklenir.*/
        IkiYonluListe[] fifoVePq=new IkiYonluListe[2];
        
        IkiYonluListe randomListe = new IkiYonluListe();
       
        Random r=new Random();
       
        int toplamKisi=liste.say();
       
        int randomGececekSayi=r.nextInt(toplamKisi);//random geçeçek kişi sayısı
        ArrayList<Integer> sayi=new ArrayList(randomGececekSayi+1);int randomSira=0;
        for(int i=0; i<randomGececekSayi+1; i++){
            boolean yokMu=true;
            while(yokMu){
                randomSira =r.nextInt(toplamKisi)+1;//siradan random geçecek kişinin numarası random olarak belirleme
                if(!sayi.contains(randomSira) ){//daha önce o sayı gelmiş mi diye kontrol edilir.
                    yokMu=false;     
                    sayi.add(randomSira);
                }   
            } 
        }
        
        Collections.sort(sayi);//sayılar(kişi numaraları) küçükten büyüğe sıralanır.
        for(int i=0;i<sayi.size();i++){
            randomListe.sonaEkle(liste.seciliSil(sayi.get(i)).veri); 
        }
        
        System.out.println("Random Sıra asansörFIFO:");
        //oluşturulan siralar asansörlere parametre olarak verilir.
        fifoVePq[0]=asansorFIFOCalisiyor(liste,"hiz1Kat",1);
      
        System.out.println("Random Sıra asansörPQ:");
       
        
        randomListe = duzenPQ(randomListe);//duzenPQ ile öncelik sırası belirlenir.
        fifoVePq[1]=asansorPQCalisiyor(randomListe,"hiz1Kat",1);
        
        return fifoVePq;
    }
    
    static IkiYonluListe asansorFIFOCalisiyor(IkiYonluListe liste,String hizKati,int yazdir){
        /*Proje 1.b.i
        Gelen kişilerin hepsi AsansörFIFO sırasına geçirilir.*/
        IkiYonluListe listeFIFO=new IkiYonluListe();
        IkiYonluListe listeFIFO1=new IkiYonluListe();
        boolean bak=false;
        double OITS=0;
        int toplamSira=liste.say();
        int dortlu=toplamSira/4;
        int kalan=toplamSira-(dortlu*4);
        Calisan calisan=null;
        for(int i=0; i<dortlu+1; i++){//dortlü gruplar halinde asansöre alınır.
            ArrayList<Calisan> dortKisi=new ArrayList(4);
            for(int y=4; y>0; y--){
                if(i==dortlu && kalan==0){
                    break;
                }
                if(i==dortlu && y==4){
                    dortKisi=new ArrayList(4);
                    y=kalan;
                }
              
                if(i==dortlu && y==1){
                    calisan=(Calisan)liste.bastanSil().veri;
                    
                    dortKisi.add(calisan);
                }else if(i==dortlu-1 && y==1){
                    calisan=(Calisan)liste.bastanSil().veri;
                    dortKisi.add(calisan);
                }else {
                    calisan=(Calisan)liste.bastanSil().veri;
                    dortKisi.add(calisan);
                }
            }
            Collections.sort(dortKisi,Calisan.katSirala );//dortlu grup içinde kat sıralaması yapılır.
            for(int z=0; z<dortKisi.size();z++){//kişiler asansöre bindirilir.
                if(z==0){
                    AsansorFIFO fifo=new AsansorFIFO(0, dortKisi.get(z),hizKati);
                    
                    if(bak){
                        //her kişi için its hesaplanır
                        dortKisi.get(z).its+=((Calisan)listeFIFO.getSon().veri).its+((Calisan)listeFIFO.getSon().veri).cikacagiKat*fifo.hız+4;
                    }
                    listeFIFO.sonaEkle(dortKisi.get(z));
                }
                
                else{
                    AsansorFIFO fifo=new AsansorFIFO(dortKisi.get(z-1).cikacagiKat, dortKisi.get(z),hizKati);
                    //her kişi için its hesaplanır
                    dortKisi.get(z).its+=dortKisi.get(z-1).its;
                    bak=true;listeFIFO.sonaEkle(dortKisi.get(z));
                }
                //OITS için kişilerin its si toplanır ve en son toplam kişi sayısına bölünür.
                OITS+=(dortKisi.get(z).its);
            }
            

            if(yazdir==1){/*Asansörden inen kişilerin bilgileri yazdırılır.*/
                
                for(Calisan yaz: dortKisi){
                    listeFIFO1.sonaEkle(yaz);
                    System.out.println("#asansörFIFO# "+yaz);
                }
                System.out.println("");}
            
                
            }
        if (yazdir==1){System.out.println("asansörFIFO OITS: "+OITS/toplamSira);
        }
        return listeFIFO;
    }
    
    static IkiYonluListe asansorPQCalisiyor(IkiYonluListe liste,String hizKati,int yazdir){
        /*Proje 1.b.ii
        AsansörPQ için sıra oluşturulur.
        Sıradaki kişilerin its süreleri ve en sonda OITS  hesaplanır.*/
        IkiYonluListe listePQ=new IkiYonluListe();boolean bak=false;
        IkiYonluListe listePQKopya=new IkiYonluListe();
        ArrayList<Calisan> pQ=new ArrayList();
        double OITS=0;
        int toplamSira=liste.say();
        int dortlu=toplamSira/4;//dortlu grup sayısı bulunur.
        int kalan=toplamSira-(dortlu*4);
        Calisan calisan=null;
        for(int i=0; i<dortlu+1; i++){
            ArrayList<Calisan> dortKisi=new ArrayList(4);
            for(int y=4; y>0; y--){//kişiler dortlu gruplar halinde ayrılır
             
                if(i==dortlu && kalan==0){
                    break;
                }
                if(i==dortlu && y==4){
                    dortKisi=new ArrayList(kalan);
                    y=kalan;
                }
              
                if(i==dortlu && y==1){
                    calisan=(Calisan)liste.sondanSil().veri;
                    dortKisi.add(calisan);
                }
                else {
                    calisan=(Calisan)liste.bastanSil().veri;
                    dortKisi.add(calisan);
                }
            }
            double its=0;
            for(int z=0; z<dortKisi.size();z++){
                //alınan kişiler AsansörPQ metoduna parametre olarak verilir.
                if(z==0){
                    AsansorPQ  pq=new AsansorPQ(0, dortKisi.get(z),hizKati);
                    if(bak){
                        //asansöre binen kişilerin her biri için ayrı its süreleri hesaplanır.
                        dortKisi.get(z).its+=((Calisan)listePQ.getSon().veri).its+((Calisan)listePQ.getSon().veri).cikacagiKat*pq.hız+4;
                    }
                    listePQ.sonaEkle(dortKisi.get(z));
                }
                else {
                    AsansorPQ   pq=new AsansorPQ(dortKisi.get(z-1).cikacagiKat, dortKisi.get(z),hizKati);
                    
                    bak=true;
                    dortKisi.get(z).its+=dortKisi.get(z-1).its;
                    listePQ.sonaEkle(dortKisi.get(z));
                }
                //hesaplanan its süreleri OITS ye eklenir. En sonda toplam kişi 
                //sayısına bölünerek ortalama işlem tamamlama süresi bulunur.
                OITS+=(dortKisi.get(z).its);
            }
            
            for(int z=0; z<dortKisi.size();z++){
               
                if(z==0){
                    
                }
                pQ.add(dortKisi.get(z));
                listePQKopya.sonaEkle(dortKisi.get(z));
               
            }
    
            if(yazdir==1){
                /*Asansörden inen kişilerin bilgileri ekrana yazdırılır.*/
                
                for(Calisan yaz: dortKisi){
                    System.out.println("#asansörPQ# "+yaz);
                }
                System.out.println("");
            }
            
        }
        Collections.sort(pQ,Calisan.numaraSirala );//kişiler numara sırasına göre sıralanır.
        OITS=OITS/toplamSira;
        if(yazdir==1){//yukarda OITS toplam kişi sayına bölünür ve ekrana yazdırılır.
            System.out.println("asansörPQ OITS: "+OITS);
        }
        return listePQKopya;
     }
    
    public static void projeBirC(){
        /*Proje 1.c maddesindeki istenen işlemler yaplır.
        Tüm olasılıklar denerek OITS bulunur ve o OITS ye ait sıralar ekrana yazdırılır.*/
        double minOTS=900000;//minOITS yi bulmak için değiken büyük sayıya eşitlenir.
        IkiYonluListe liste=new IkiYonluListe();
        ArrayList<Calisan> FIFOtut=null;
        ArrayList<Calisan> PQtut=null;

        liste=siraOlustur(0);//çift bağlı liste yani asansör sırası siraOlustur(0) metodundan return edilir.
        
        
        int say=liste.say();

        IkiYonluListe listeKopya=new IkiYonluListe();
        say=liste.say();Calisan siradaki;
        int anaDongu=liste.say();
        /*Siraların yedeklerini almak için yeniden çift bağlı liste nesneleri oluşturulur.*/
        ArrayList<Calisan> FIFOSira=new ArrayList();
        ArrayList<Calisan> PQSira=new ArrayList();
        
        for(int i=0; i<18;i++){
            FIFOSira.clear();PQSira.clear();
            IkiYonluListe siraBir=new IkiYonluListe();
            IkiYonluListe siraIki=new IkiYonluListe();
            for(int k=0; k<say;k++){
                if(liste.say()>0){
                    siradaki=(Calisan)liste.bastanSil().veri;
                    PQSira.add(siradaki);
                    listeKopya.sonaEkle(siradaki);}
                }
            int dongu=liste.say();
            for(int y=0; y<i;y++){
                if(liste.say()>0){
                    siradaki=(Calisan)liste.bastanSil().veri;
                    FIFOSira.add(siradaki);
                    listeKopya.sonaEkle(siradaki);}
            } 
          
            for(Calisan ekleBir:PQSira){
                siraBir.sonaEkle(ekleBir);
            }
            
            for(Calisan ekleIki:FIFOSira){
                siraIki.sonaEkle(ekleIki);
            }
            /*farklı bir olasılık için listeler siliniyor.*/
            FIFOSira.clear();PQSira.clear();
            double OITS=0;
            /*Farklı bir sıra düzenine sahip asansör sıraları asansörlere ait metodlara parametre olarak veriliyor.*/
            siraBir=asansorPQCalisiyor(duzenPQ(siraBir), "",0);
            siraIki=asansorFIFOCalisiyor(siraIki,"",0);
            
            
            say--;
            

            liste=siraOlustur(0);
            
            double its=0;
            
            while(liste.say()>0){
                /*Farklı bir olasılığa ait asansör sıralarının toplam OITS'si hesaplanıyor.*/
                if(siraBir.say()>0){
                    Calisan c=((Calisan)siraBir.bastanSil().veri);
                    PQSira.add(c);
                    its+=c.its;
                    listeKopya.sonaEkle(c);
                }
                else if(siraIki.say()>0){
                    if(i!=0){
                    Calisan c1=((Calisan)siraIki.bastanSil().veri);
                    FIFOSira.add(c1);
                    its+=c1.its;
                    listeKopya.sonaEkle(c1);
                    }
                }
                liste.bastanSil();   
                
                
                
            }
            OITS=its/18;
            if(minOTS>OITS){/*Üretilen OITS min OITS den daha küçükse yeni minOITS yeni üretilen OITS olur.
                ve üretilirken kullanılan sıralar yani listeler tutulur. 
                Diğer olasılıklar denenmeye devam edilir.*/
                minOTS=OITS;
                FIFOtut=(ArrayList<Calisan>) FIFOSira.clone();
                PQtut=(ArrayList<Calisan>) PQSira.clone();
            }
            OITS=0;
            //yeniden sira oluşturulur.
            
            liste=siraOlustur(0);
           
            FIFOSira.clear();PQSira.clear();//yeni olasılık denemek için sıralar boşaltılır.
        }
        
        /*Tüm olasılıklar denendikden sonra minOITS ye ait olan asansör siralarında duran kişi bilgileri 
        ve kişilere ait ITS'ler ekrana yazdırılır.*/
        System.out.println("AsansörFIFO da olanlar:");
        for(Calisan yaz:FIFOtut){
            System.out.println("***"+yaz);
        }System.out.println("\nAsansörPQ da olanlar:");
        for(Calisan yaz:PQtut){
            System.out.println("***"+yaz);
        }
        System.out.println("min OİTS:"+minOTS);
        
        
    }
    
    static IkiYonluListe randomKisiUret(int uretilecekKisi,int toplamKat){
        /*Proje 1.d'de istenen kişiler ve çıkacak katlar üretiliyor.*/
        String[] isimler={"Ali","Ada","Aslı","Arzu","Gamze","Cem","Cengaver","Tarık","Ramazan","Ahmet","Beste",
        "Derya","Hakan","Arda","Zambak","Gül","Lale","Papatya","Menekşe","Deniz","Derya","Doruk","Kemal",
        "Ebru","Sezgin","Sergen","Serdar","Mustafa","Talat","İkram"};
        /*random sınıfı kullanılırak üretilen kişilerin sıfır ile parametre olarak gelen toplamKat 
        sayıları arasında random kat sayıları üretilip isimler dizisinden kişi ismi alınırak 
        calısan nesnesi üretilerek çift bağlı liste tipindeki listeye sondan eklenir.*/
        Random r=new Random();
        IkiYonluListe liste=new IkiYonluListe();
        for(int i=0;i<uretilecekKisi;i++){
            liste.sonaEkle(new Calisan(i+1, isimler[i],r.nextInt(toplamKat)+1, 0));
        }
        return liste;
    }
    
    static String kazancHesapla(IkiYonluListe FIFOSira,IkiYonluListe PQSira){
        /*Proje 1.e ve Proje 1.f için kullanılır.
        FIFOSira ve PQSira listeleri Asansörden inenlerden oluşturmaktadır.*/
        IkiYonluListe FIFOSiraKopya= FIFOSira;
        IkiYonluListe PQSiraKopya=PQSira;
       String sonuc="";
        int toplamKisi=30;
        double OITSFIFO=0;
        double OITSPQ=0;
        for(int f=0;f<30;f++){//kişilerin its süreleri alınır
            if(!FIFOSira.bosMu()){
                Calisan c=((Calisan)FIFOSiraKopya.bastanSil().veri);
                FIFOSira.sonaEkle(c);//liste tekrar kullanılacağından sondanekleme işlemi yapılır.
                OITSFIFO+=c.its;}
        }
        for(int i=0;i<30;i++){//kişilerin its süreleri alınır
            if(!PQSira.bosMu()){
                Calisan c=((Calisan)PQSira.bastanSil().veri);
                PQSira.sonaEkle(c);//liste tekrar kullanılacağından sondanekleme işlemi yapılır.
                OITSPQ+=c.its;}
        }
        /*İstenilen işlemin sonucu ekrana yazdırılır.*/
        System.out.println("\nD  seçeneğinde üretilen 30 adet kişi için bir tek asansörleri kullanırken OITS karşılastırılması:"
                + "\nAsansörFIFO Kullanıldığında OITS: "+OITSFIFO/30
                        + "\nAsansörPQ Kullanıldığında OITS: "+OITSPQ/30);
        /*Asansör kullanımında hangi asansörün ve ne kadar süre kazandırdığını hesalama*/
        double kazanc=(OITSFIFO/30)-(OITSPQ/30);
        if(kazanc>0){
            sonuc="AsansörPQ kullanıldığında OITS kazanç: "+(kazanc);
        }else
            sonuc="AsansörFIFO kullanıldığında OITS kazanç: "+((-1)*kazanc);
        
        return sonuc;
    }
    
    static void kazancHesapla(IkiYonluListe listeFIFO,IkiYonluListe listePQ,IkiYonluListe[] fifoVePq){
    /*Proje 1.b AsansörPQ ve random olarak asansörlere binen 
         kişilerin işlemlerini AsansörFIFO ya göre daha önce bitirdiğini bulma
         */
        IkiYonluListe listeFIFOKopya=new IkiYonluListe();
        System.out.println("\nKazanç hesaplama  --->> AsansörFIFO ve AsansöRPQ");
        int donguSayi=listeFIFO.say();
        for(int i=0;i<donguSayi;i++){
            Calisan cFIFO=(Calisan)listeFIFO.bastanSil().veri;
            listeFIFOKopya.sonaEkle(cFIFO);
            Calisan cPQ=(Calisan)listePQ.bastanSil().veri;
            if(cFIFO.its>cPQ.its){//kişilerin its süreleri karşılaştırılır ve kazanç hesaplanır
                System.out.println("\n#AsansörFIFO: "+cFIFO+"\nasansörPQ: "+cPQ+"\nKazanç: "+(cFIFO.its-cPQ.its));
            }
        }
        System.out.println("\nKazanç hesaplama  --->> AsansörFIFO VE random Asansör");
         
        Calisan cRandomPQ=new Calisan(0, "", 0,0);
        Calisan cRandomFIFO=new Calisan(0, "", 0,0);
        if(fifoVePq[1].say()>0){
            cRandomPQ=(Calisan)fifoVePq[1].bastanSil().veri;
        }
        if(fifoVePq[0].say()>0){
            cRandomFIFO=(Calisan)fifoVePq[0].bastanSil().veri;
        }
        
        for(int i=0;i<donguSayi;i++){
            Calisan cFIFO=(Calisan)listeFIFOKopya.bastanSil().veri;
            //süre kazancı sağlayan kişiler bulunur ve ne kadar 
            //kazanç sağladığı hesaplanarak kişi bilgileri ekrana yazdırılır.
            if(cFIFO.its>cRandomPQ.its && cFIFO.numara==cRandomPQ.numara){
                System.out.println("\n#asansörFIFO: "+cFIFO+"\nRandomAsansörPQ: "+cRandomPQ+"\nKazanç: "+(cFIFO.its-cRandomPQ.its));
                if(fifoVePq[1].say()>0){
                    cRandomPQ=(Calisan)fifoVePq[1].bastanSil().veri;
                }            
            }
            if(cFIFO.its>cRandomFIFO.its && cFIFO.numara==cRandomFIFO.numara){
                System.out.println("\n#asansörFIFO: "+cFIFO+"\nRandomAsansörFIFO: "+cRandomFIFO+"\nKazanç: "+(cFIFO.its-cRandomFIFO.its));
                if(fifoVePq[0].say()>0){
                    cRandomFIFO=(Calisan)fifoVePq[0].bastanSil().veri;   
                }
            }
        }        
    }
     
    
}

class AsansorFIFO{
    //AsanFIFO sınıfı
    double hız;
    int beklemeSuresi;
    int bulunduguKat;
    int cikacagiKat;
    Calisan c1;

    public AsansorFIFO(int bulunduguKat, Calisan c1,String hizKati) {
        //sınıfın constructor'u
        //asansör hız ayarı
        if("hiz2Kat".equals(hizKati)){ this.hız=2.5; }
        else{ this.hız = 5; }
            
        this.beklemeSuresi = 4;
        this.bulunduguKat = bulunduguKat;
        this.cikacagiKat = c1.cikacagiKat;
        this.c1= c1;
        if(cikacagiKat!=bulunduguKat){//its hesaplanarak nesneye eklenerek
            c1.its=(cikacagiKat-bulunduguKat)*hız+4;}
    }
    
}

class AsansorPQ{
    /*AsansorPQ sınıfı*/
    double hız;
    int beklemeSuresi;
    int bulunduguKat;
    Calisan c1;
    int cikacagiKat;
    public AsansorPQ(int bulunduguKat, Calisan c1,String hizKati) {
        //sınıfın constructor'u
        //asansör hız ayarı
        if("hiz2Kat".equals(hizKati)){ this.hız=1; }
        else{ this.hız = 2; }
        this.beklemeSuresi = 4;
        this.bulunduguKat = bulunduguKat;
        this.cikacagiKat = c1.cikacagiKat;
        this.c1= c1;
        if(cikacagiKat!=bulunduguKat){//its hesaplanarak nesneye eklenerek
            c1.its=Math.abs((cikacagiKat-bulunduguKat))*hız+4;}
    }
    
    
}

class Calisan{
    //Çalışan sınıfı
    int numara;
    String isim;
    int cikacagiKat;
    double its;

    public Calisan(int numara, String isim, int cikacagiKat,double its) {
        //sınıf constructor'ı
        this.numara = numara;
        this.isim = isim;
        this.cikacagiKat = cikacagiKat;
        this.its=its;
    }

    @Override
    public String toString() {
        return "Numara=" + numara + " İsim=" + isim + " Çıkacağı Kat=" + cikacagiKat + ", ITS=" + its;
    }

    public static Comparator<Calisan> katSirala = new Comparator<Calisan>() {
//gelen kişilerin kat sıralarına göre dizilim oluşturmak için
        @Override
	public int compare(Calisan c1, Calisan c2) {

	   int kat1 = c1.cikacagiKat;
	   int kat2 = c2.cikacagiKat;

	   return kat1-kat2;

	}};
    //gelen kişilerin numara siralarına göre dizilim oluşturmak için
    public static Comparator<Calisan> numaraSirala = new Comparator<Calisan>() {

        @Override
	public int compare(Calisan c1, Calisan c2) {

	   int no1 = c1.numara;
	   int no2 = c2.numara;
	   return no1-no2;

        }};
    
}