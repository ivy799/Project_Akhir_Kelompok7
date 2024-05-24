package projek.model;
public class DataKota {
    private String namaKota,UrlGmbrwisata1,UrlGmbrwisata2,UrlGmbrwisata3;

    public DataKota(String namaKota, String urlGmbrwisata1, String urlGmbrwisata2, String urlGmbrwisata3) {
        this.namaKota = namaKota;
        UrlGmbrwisata1 = urlGmbrwisata1;
        UrlGmbrwisata2 = urlGmbrwisata2;
        UrlGmbrwisata3 = urlGmbrwisata3;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }

    public String getUrlGmbrwisata1() {
        return UrlGmbrwisata1;
    }

    public void setUrlGmbrwisata1(String urlGmbrwisata1) {
        UrlGmbrwisata1 = urlGmbrwisata1;
    }

    public String getUrlGmbrwisata2() {
        return UrlGmbrwisata2;
    }

    public void setUrlGmbrwisata2(String urlGmbrwisata2) {
        UrlGmbrwisata2 = urlGmbrwisata2;
    }

    public String getUrlGmbrwisata3() {
        return UrlGmbrwisata3;
    }

    public void setUrlGmbrwisata3(String urlGmbrwisata3) {
        UrlGmbrwisata3 = urlGmbrwisata3;
    }

    // @Override
    // public String toString() {
    //     return "DataKota{" +
    //             "namaKota='" + namaKota + '\'' +
    //             ", UrlGmbrwisata1='" + UrlGmbrwisata1 + '\'' +
    //             ", UrlGmbrwisata2='" + UrlGmbrwisata2 + '\'' +
    //             ", UrlGmbrwisata3='" + UrlGmbrwisata3 + '\'' +
    //             '}';
    // }

    

    
}
