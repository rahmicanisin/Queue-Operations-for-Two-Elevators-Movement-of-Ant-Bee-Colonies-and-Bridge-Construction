package proje2;


public class bocekler {
    private int can;
    private String isim,tur;
    public bocekler(int can,String ad,String tur){
        this.can=can;
        this.isim=ad;
        this.tur=tur;
    }
    @Override
    public String toString(){
    return tur+" "+isim;    
    }
    public void canAzalt(){
        this.can=can-1;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }
    
}
