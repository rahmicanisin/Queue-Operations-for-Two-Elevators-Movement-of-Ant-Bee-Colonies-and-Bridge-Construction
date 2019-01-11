
package proje2;


public class LinkedList{
    
}

class Link {
    
    
	public Object veri; // Düğüme gelecek olan veri
        
	public Link sonraki; // Listede sonraki düğüm
	public Link onceki; // Listede önceki düğüm
	// -------------------------------------------------------------

	public Link(Object d) // Verinin standart geldiği yapılandırıcı
	{
		veri = d;
	}

	// -------------------------------------------------------------
	public void listele() // yazdırma fonksiyonu
	{
		System.out.print(veri + " ");
	}
	// -------------------------------------------------------------

    @Override
    public String toString() {
        return "Link{" + "veri=" + veri + '}';
    }
        
} 

class IkiYonluListe {
	private Link ilk; // ilk veriyi tutan referans
	private Link son; // son veriyi tutan referans
	// -------------------------------------------------------------

	public IkiYonluListe() // Liste yapılandırıcısı
	{
		ilk = null; //  Listeyi boş olarak tanımlıyoruz.
		son = null;
	}

	// -------------------------------------------------------------
	public boolean bosMu() // Liste doluluk kontrolü
	{
		return ilk == null;
	}

	// -------------------------------------------------------------
        
       
  
        
        
	public void basaEkle(Object dd) // Listenin başına ekleme fonksiyonu
	{
		Link yeniDugum = new Link(dd); // yeni düğüm oluşturuluyor

		if (bosMu()) // Listenin boşluk kontrolü
			son = yeniDugum;
		else
			ilk.onceki = yeniDugum; // Eski ilk ile yer değişiyor
		yeniDugum.sonraki = ilk; 
		ilk = yeniDugum; 
	}


	public void sonaEkle(Object dd) // Listenin sonuna ekleme fonksiyonu
	{
		Link yeniDugum = new Link(dd); // yeni düğüm oluşturuyoruz.
		if (bosMu()) //Listenin boşluk kontrolü
			ilk = yeniDugum; 
		else {
			son.sonraki = yeniDugum; // son ile yeni düğüm yer değişiyor.
			yeniDugum.onceki = son;
		}
		son = yeniDugum; 
	}


	public Link bastanSil() // Baştaki veri silme fonksiyonu
	{
		Link yedek = ilk;
		if (ilk.sonraki == null) // Eğer sadece 1 veri varsa
			son = null; // sonuncuyu boşa çıkartıyoruz.
		else
			ilk.sonraki.onceki = null; 
		ilk = ilk.sonraki; 
		return yedek;
	}

	// -------------------------------------------------------------
	public Link sondanSil() // Sondan silme fonksiyonu
	{ 
		Link yedek = son;
		if (ilk.sonraki == null) // Eğer sadece 1 veri varsa
			ilk = null; // ilk veri boşa çıkıyor
		else
			son.onceki.sonraki = null;
		son = son.onceki;
		return yedek;
	}

	public boolean arkasinaEkle(Calisan anahtar, Calisan dd) { 
		Link aktif = ilk;
		while (aktif.veri != anahtar) // Eşleşme bulunana kadar
		{
			aktif = aktif.sonraki; // her seferinde döngü döndürüyoruz
			if (aktif == null)
				return false; // Bulunmayınca false dönüyor
		}
		Link yeniDugum = new Link(dd); // Yeni düğüm oluşturuyoruz

		if (aktif == son) // Eğer son veri ise
		{
			yeniDugum.sonraki = null; // yeni düğüm boşa çıkıyor
			son = yeniDugum;
		} else
		{
			yeniDugum.sonraki = aktif.sonraki; 
						
			aktif.sonraki.onceki = yeniDugum;
		}
		yeniDugum.onceki = aktif; 
		aktif.sonraki = yeniDugum; 
		return true; 
	}
public Link goster(){
    
        Link aktif = ilk; 
   
		
                    ilk = aktif.sonraki;
                    return ilk;
                
	//aktif = aktif.sonraki; // Döngü sürekli bir sonrakine aktarılıyor
		
}
	public Link seciliSil(int numara) // Seçili sıradaki elemanı silmek için kullanılan fonksiyon
	{ 
		Link aktif = ilk; 
                
		while (((Calisan)aktif.veri).numara != numara) // Eşleşme bulana kadar
		{
			aktif = aktif.sonraki; // Döngü sürekli bir sonrakine aktarılıyor
			if (aktif == null)
				return null; // eşleşme bulunamadı
		}
		if (((Calisan)aktif.veri).numara == ((Calisan)ilk.veri).numara) 
			ilk = aktif.sonraki; 
		else 
				
			aktif.onceki.sonraki = aktif.sonraki;

		if (((Calisan)aktif.veri).numara == ((Calisan)son.veri).numara) 
			son = aktif.onceki; 
		else 
			aktif.sonraki.onceki = aktif.onceki;
		return aktif; // Bulunan değer döndürülüyor
	}

        
	public int say() {
		//System.out.print("Liste : ");
		Link aktif = ilk; 
                int sayac=0;
		while (aktif != null) // Listenin sonuna kadar kontrol ediliyor
		{
		//	aktif.listele(); // Veri yazdırılıyor
			aktif = aktif.sonraki; // Döngü döndürülüyor
                        sayac++;
		}
		//System.out.println("");
                return sayac;
	}
        
        public void listele() {
		//System.out.print("Liste : ");
		Link aktif = ilk; 
                System.out.println("\nRandom üretilen kişilerin bilgileri\n");
                while (aktif != null) // Listenin sonuna kadar kontrol ediliyor
		{
		//	aktif.listele(); // Veri yazdırılıyor
			 // Döngü döndürülüyor
                        System.out.println("+ "+aktif.veri);
                        aktif = aktif.sonraki;
		}
		
	}

    public Link getIlk() {
        return ilk;
    }

    public void setIlk(Link ilk) {
        this.ilk = ilk;
    }

    public Link getSon() {
        return son;
    }

    public void setSon(Link son) {
        this.son = son;
    }

} 