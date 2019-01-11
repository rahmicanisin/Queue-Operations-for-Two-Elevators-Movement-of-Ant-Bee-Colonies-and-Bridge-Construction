
package proje2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import static jdk.nashorn.internal.objects.NativeArray.pop;
import static jdk.nashorn.internal.objects.NativeArray.push;



public class Projeb  {

    //D şıkkında istenen 3 saniyelik ölçüm için
    static int sayac=0;
        //List ile hız ölçümü
    //bir saniyedeki işlem sayısını bulan metot
        public  static long hizList(ArrayList tuzak,List<bocekler> dizi,int[] cukurDerinlik,ArrayList cukurYer,int yolUzunluk) 
          { 
   
            long time1 = System.nanoTime(); 
   
                 islemDlist(tuzak, dizi, cukurDerinlik, cukurYer, yolUzunluk);
   
  		long time2 = System.nanoTime(); 
  		 
  		return(time2 - time1);
    
           
   
          } 
        //dizi ile hız ölçümü
         public  static long hizDizi(ArrayList tuzak,bocekler[] dizi,int[] cukurDerinlik,ArrayList cukurYer,int yolUzunluk) 
          { //bir saniyedeki işlem sayısını bulan metot
   
           long time1 = System.nanoTime(); 
   
                 islemDdizi(tuzak, dizi, cukurDerinlik, cukurYer, yolUzunluk);
   
  		long time2 = System.nanoTime(); 
  		 
  		return(time2 - time1);
   
          } 

    
    public static bocekler[] Diziolustur(int bocekSay,int can,String islem,String tur){
        Scanner giris=new Scanner(System.in);
        bocekler[] dizi=new bocekler[bocekSay];
        
        
        String isim=null;
        for(int i=0;i<bocekSay;i++){
            if(!islem.equalsIgnoreCase("a")){
                System.out.println(i+1+". karıncanın ismini giriniz:");
                isim=giris.next();
            }else{
                String[] isimler={"A","B","C","D","E"};
                isim=isimler[i];
            }    
            bocekler k=new bocekler(can,isim,tur);
            dizi[i]=k;
            
        }
        return dizi;
    }
    public static void menu(){
        System.out.println("Projenin a bölümünü çalıştırmak için 1 e basınız");
        System.out.println("Projenin b bölümünü çalıştırmak için 2 e basınız");
        System.out.println("Projenin c bölümünü çalıştırmak için 3 e basınız");
        System.out.println("Projenin d bölümünü çalıştırmak için 4 e basınız");
        System.out.println("Projenin e bölümünü çalıştırmak için 5 e basınız");
        System.out.print("seçiminiz:");
        Scanner giris=new Scanner(System.in);
        int secim=giris.nextInt();
        switch(secim){
            case 1:
                islemABC("a");
                break;
            case 2:
                islemABC("b");
                break;
            case 3:
                islemABC("c");
                break;
            case 4:
                System.out.println("Dizi ile hız ölçmek için 1 i seçin");
                System.out.println("List ile hız ölçmek için 2 yi seçin");
                int listeTur=giris.nextInt();
                if(listeTur==1){
                    ArrayList bilgiler=bilgiAl();
            
                    int yolUzunluk=(int)bilgiler.get(3);
           
                    ArrayList tuzak=(ArrayList)bilgiler.get(0);
                    Collections.sort(tuzak);
                    ArrayList cukurYer=(ArrayList)bilgiler.get(1);
                    int[] cukurDerinlik=(int[])bilgiler.get(2);
            
                    int karincaSay=(int)bilgiler.get(4);
                    bocekler[] dizi=Diziolustur(karincaSay,2 , "d", "Karınca");
                    
                    //metot bir saniyede yapılan işlem sayısını buluyor
                    long hiz=hizDizi(tuzak, dizi, cukurDerinlik, cukurYer,yolUzunluk);
                     hiz=300000000/hiz;
                    System.out.println("hız="+hiz);
                }else{
                    ArrayList bilgiler=bilgiAl();
            
                    int yolUzunluk=(int)bilgiler.get(3);
           
                    ArrayList tuzak=(ArrayList)bilgiler.get(0);
                    Collections.sort(tuzak);
                    ArrayList cukurYer=(ArrayList)bilgiler.get(1);
                    int[] cukurDerinlik=(int[])bilgiler.get(2);
            
                    int karincaSay=(int)bilgiler.get(4);
                                        
                    //metot bir saniyede yapılan işlem sayısını buluyor
                    List<bocekler> dizi=Listolustur(karincaSay, 2, "Karınca");
                    long hiz=hizList(tuzak, dizi, cukurDerinlik, cukurYer,yolUzunluk);
                    hiz=300000000/hiz;
                    System.out.println("hız="+(hiz));
                }
                break;
            case 5:
                islemE();
                break;
        }
            
    
    }



//Lİst tipinde tutmak için List oluşturulur
    public static List<bocekler> Listolustur(int karincaSay,int can,String tur){
        List<bocekler> list = new ArrayList<bocekler>();
        Scanner giris=new Scanner(System.in);

        
        for(int i=0;i<karincaSay;i++){
            System.out.println(i+1+". karıncanın ismini giriniz:");
            String isim=giris.next();
            bocekler k=new bocekler(can,isim,tur);
            list.add(k);
            
        }
        return list;
        
    }//d şıkkında istenen işlemler dizi ile yapılır
    public static void islemDdizi(ArrayList tuzak,bocekler[] dizi,int[] cukurDerinlik,ArrayList cukurYer,int yolUzunluk){
        for(int i=0;i<yolUzunluk;i++){
                if(tuzak.contains(i)){
             
                    dizi=tuzakDus(dizi);
                }else if(cukurYer.contains(i)){
                    dizi=cukuraDus(dizi, cukurDerinlik[cukurYer.indexOf(i)] );
                }
        }
    }//lisy ile işlem yapılır
    public static void islemDlist(ArrayList tuzak,List<bocekler> dizi,int[] cukurDerinlik,ArrayList cukurYer,int yolUzunluk){
        for(int i=0;i<yolUzunluk;i++){
                if(tuzak.contains(i)){
             
                    dizi=tuzakDusList(dizi);
                }else if(cukurYer.contains(i)){
                    dizi=cukuraDusList(dizi, cukurDerinlik[cukurYer.indexOf(i)] );
                }
        }
    }//e şıkkında istenen işlemler
    public static void islemE(){
        
        bocekler[] arilar=Diziolustur(3, 3,"a", "Arı");//sağlığı 3 olan 3 tane arı oluşturulur
        ArrayList bilgiler=bilgiAl();        //kullanıcıdan yol tuzak karınca ve cukur bilgileri alınır           
       //Yol bilgileri
        ArrayList tuzak=(ArrayList)bilgiler.get(0);
        Collections.sort(tuzak);
        ArrayList cukurYer=(ArrayList)bilgiler.get(1);
        int[] cukurDerinlik=(int[])bilgiler.get(2);
        int yolUzunluk=(int)bilgiler.get(3);
        int karincaSay=(int)bilgiler.get(4);
        bocekler [] karincalar=Diziolustur(karincaSay, 2, "e", "Karınca");
        int karincaDevam=1,ariDevam=1;
        if(yolUzunluk%2==0){
            yolUzunluk=yolUzunluk+1;
        }
        //yol kadar dönen for j arıların indeksi i karıncaların
        for(int i=0,j=yolUzunluk-1;i<yolUzunluk;i++,j--){
              //sona ulaşanlar için 
             if(j==0 && ariDevam==1){
                   System.out.println("Sona ulaşanlar;");
                   for(int l=0;l<arilar.length;l++){
                       System.out.println(arilar[l]);
                   }
                  break;
              }else if(i==yolUzunluk-1&&karincaDevam==1){
                  System.out.println("Sona ulaşanlar;");
                   for(int l=0;l<karincalar.length;l++){
                       System.out.println(karincalar[l]);
                   }
              }else if((karincalar.length==0)&&(arilar.length==0)){
                  System.out.println("Hepsi öldü");
              }
             //karşılaştıkları anda yapılacak işlemler
               if(j==i){
                   int devam=1;
                   while(devam==1){//karınca ve arının canı bir azaltılır
                   karincalar[0].canAzalt();
                   arilar[0].canAzalt();
                   //sağlığı 0 olanlar öldürülür listeden silinir
                   if(karincalar[0].getCan()==0){
                       karincalar=oldur(karincalar);
                   }
                   if(arilar[0].getCan()==0){
                       arilar=oldur(arilar);
                   }
                //ölen grubu bulmak için kontrol yapılır
                   if(arilar.length==0){
                       devam=0;
                       ariDevam=0;
                   }else if(karincalar.length==0){
                       devam=0;
                       karincaDevam=0;
                   }
                   }
               }
               //karıncalar tuzağa geldiğinde yapılacak işlemler
                if(tuzak.contains(i) && karincaDevam==1){
             
                    karincalar=tuzakDus(karincalar);
                  //karıncalar cukura gelince yapılacak işlemler  
                }else if(cukurYer.contains(i)&& karincaDevam==1){
                    karincalar=cukuraDus(karincalar, cukurDerinlik[cukurYer.indexOf(i)] );
                }///arılar tuzağa gelirse
                if(tuzak.contains(j) && ariDevam==1){
             
                    arilar=tuzakDus(arilar);
                    //arılar cukura gelirse
                }else if(cukurYer.contains(j)&&ariDevam==1){
                    arilar=cukuraDus(arilar, cukurDerinlik[cukurYer.indexOf(j)] );
                }
        }
                
    }// a b ve c şıkkındaki işlemler gerçekleştirilir
    public static void islemABC(String islem){
        Scanner giris=new Scanner(System.in);
            
            ArrayList<Integer> tuzak=new ArrayList();
             ArrayList cukurYer=new ArrayList();
             int [] cukurDerinlik=new int[3];
             int yolUzunluk=0;
             bocekler [] karincalar={};
             
            
             if(islem.equalsIgnoreCase("a")){ //a şıkkı için değerler   
             
                tuzak.add(6);
            cukurYer.add(2);
            cukurYer.add(4);
            cukurYer.add(8);
            cukurDerinlik[0]=3;
            cukurDerinlik[1]=2;
            cukurDerinlik[2]=4;
            yolUzunluk=10;
           karincalar=Diziolustur(5,1,islem,"Karınca");//dizi oluşturulur
        }else {//b ve c için kullanıcıdan bilgiler alınır
            ArrayList bilgiler=bilgiAl();
            System.out.println("Yolun uzunluğunu giriniz:");
             yolUzunluk=(int)bilgiler.get(3);
           
            tuzak=(ArrayList)bilgiler.get(0);
            Collections.sort(tuzak);
            cukurYer=(ArrayList)bilgiler.get(1);
            cukurDerinlik=(int[])bilgiler.get(2);
            
            int karincaSay=(int)bilgiler.get(4);
            int can=1;
            if(islem.equalsIgnoreCase("c")){//c için can 2 ye eşitlenir
                can=2;
            }
           
            
            karincalar=Diziolustur(karincaSay,can,islem,"Karınca");
            
        }
       
            for(int i=0;i<yolUzunluk;i++){//0 dan başlayarak yol kadar döner
                if(tuzak.contains(i)){//tuzağın olup olmadığı kontrol edilir
             
                    karincalar=tuzakDus(karincalar);
                }else if(cukurYer.contains(i)){//çukurun olup olmadığı kontrol edilir
                    karincalar=cukuraDus(karincalar, cukurDerinlik[cukurYer.indexOf(i)] );
                }
           
            }
              if(karincalar.length==0){//SOna ulaşan karınca yok ise
                 System.out.println("Yolun sonuna ulaşan karınca olmadı");
             }else{
            
            System.out.println("Cıkısırası:"); //sonuç yazdırılır    
         for(int k=0;k<karincalar.length;k++){
            
             System.out.print(karincalar[k]+" ");
         }
             }
    }
          
//Kullanıcıdan tuzak çukur ve karınca sayısı alınır listeye atılıp geri döndürülür
    public static ArrayList bilgiAl(){
        Scanner giris=new Scanner(System.in);
        ArrayList bilgiler=new ArrayList();
        ArrayList tuzak=new ArrayList();
        
        System.out.println("Tuzak sayısını giriniz:");
        int tuzakSay=giris.nextInt();
        for(int j=0;j<tuzakSay;j++){
            System.out.println(j+1+". Tuzağın yerini giriniz:");
            tuzak.add(giris.nextInt());
            
        }
        System.out.println("Çukur sayısını giriniz:");
        int cukurSay=giris.nextInt();
        int[] cukurDerinlik=new int[cukurSay];
        ArrayList cukurYer=new ArrayList();
        for(int i=0;i<cukurSay;i++){
            System.out.println(i+1+". çukurun yerini giriniz:");
            int cukurYeri=giris.nextInt();
            System.out.println(i+1+". çukurun derinliğini giriniz:");
            cukurYer.add(cukurYeri);
            cukurDerinlik[i]=giris.nextInt();
            
        }
        System.out.println("Yolun uzunluğunu giriniz:");
             int yolUzunluk=giris.nextInt();
         
            System.out.println("Karınca sayısını giriniz:");
            int karincaSay=giris.nextInt();
        bilgiler.add(tuzak);
        bilgiler.add(cukurYer);
        bilgiler.add(cukurDerinlik);
        bilgiler.add(yolUzunluk);
        bilgiler.add(karincaSay);
                
        return bilgiler;
    }//tuzağa gelindiğinde ölen olana kadar bütün elemanların canları azaltılır
    public static bocekler[] tuzakDus(bocekler[] Dizi){
        bocekler[] Dizikopya=Dizi;
        for(int j=0;j<Dizikopya.length;j++){
        Dizikopya[j].canAzalt();
            if(Dizikopya[j].getCan()==0){
                Dizikopya=oldur(Dizikopya);
                break;
            }
        }
        return Dizikopya;
    }
    //Lİst için
    ////tuzağa gelindiğinde ölen olana kadar bütün elemanların canları azaltılır
    public static List tuzakDusList(List Dizi){
        List<bocekler> Dizik=(List<bocekler>)Dizi;
        for(int j=0;j<Dizik.size();j++){
        Dizik.get(j).canAzalt();
            if(Dizik.get(j).getCan()==0){
                Dizik=oldurList(Dizik);
                break;
            }
        }
        return Dizik;
    }//List için listenin ilk elemanı silinir
    public static List oldurList(List<bocekler> oDizi){
        List<bocekler> kopya=(List<bocekler>)oDizi;
        for(int i=0;i<kopya.size();i++){
            kopya.add(i,oDizi.get(i+1));
        }
        return kopya;
    }//eleman listeden silinir
    public static bocekler[] oldur(bocekler[] oDizi){
        bocekler[] kopya=new bocekler[oDizi.length-1];
        for(int i=0;i<kopya.length;i++){
            kopya[i]=oDizi[i+1];
        }
        return kopya;
    }//listenin başından itibaren yığıta atılır listenin içinde kalanlar listenin 
    //başına alınır
      //Çukura gelindiğinde ilk elemandan başlayarak derinlik sayısı kadar  eleman 
    //yığıta atılır. Dizinin eleman sayısından az ise kalan elemanlar dizinin 
    //başına getirilir. Yığıttaki elemanlar listeye eklenir.
    public static bocekler[] cukuraDus(bocekler[] dizi,int derinlik){
        bocekler[] dizik=dizi;
        Stack cukur=new Stack();
        if(derinlik>dizi.length){
            derinlik=dizi.length;
        }
        for(int j=0;j<derinlik;j++){
            cukur.push(dizik[j]);
            if(j+derinlik<dizik.length){
            dizik[j]=dizik[j+derinlik];
            }
        }
         for(int j=dizik.length-derinlik;j<dizik.length;j++){
            if(j==(dizik.length-derinlik)){
                if(j==0){
                  dizik[j]=dizik[dizik.length-1];  
                }else{
            dizik[j-1]=dizik[dizik.length-1];
                }
            } 
           
             dizik[j]=(bocekler)cukur.pop();
            
            
        }
         return dizik;
    }
    //Çukura gelindiğinde ilk elemandan başlayarak derinlik sayısı kadar  eleman 
    //yığıta atılır. Dizinin eleman sayısından az ise kalan elemanlar dizinin 
    //başına getirilir. Yığıttaki elemanlar listeye eklenir.
    public static List<bocekler> cukuraDusList(List<bocekler> dizik,int derinlik){
       
        
        Stack cukur=new Stack();
         
        if(derinlik>dizik.size()){
            derinlik=dizik.size();
        }
        for(int j=0;j<derinlik;j++){
            bocekler a=dizik.get(j);
            System.out.println(a);
           push(cukur,a);
            if(j+derinlik<dizik.size()){
            dizik.add(j, dizik.get(j+derinlik));
            }
        }
         for(int j=dizik.size()-derinlik;j<dizik.size();j++){
            if(j==(dizik.size()-derinlik)){
                if(j==0){
                  dizik.add(j,dizik.get(dizik.size()-1));  
                }else{
            dizik.add(j-1,dizik.get(dizik.size()-1));
                }
            } 
           if(cukur.empty()){
             dizik.add(j,(bocekler)pop(cukur));
           }
            
        }
         return dizik;
    }
}
