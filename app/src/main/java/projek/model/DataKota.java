package projek.model;

public class DataKota {
    private String namaKota,Scene3TripImageUrl1,Scene3TripImageUrl2,Scene3TripImageUrl3;

    

    public DataKota(String namaKota, String scene3TripImageUrl1, String scene3TripImageUrl2, String scene3TripImageUrl3) {
        this.namaKota = namaKota;
        Scene3TripImageUrl1 = scene3TripImageUrl1;
        Scene3TripImageUrl2 = scene3TripImageUrl2;
        Scene3TripImageUrl3 = scene3TripImageUrl3;
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



    public String getNamaKota() {
        return namaKota;
    }



    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }



    public String getScene3TripImageUrl1() {
        return Scene3TripImageUrl1;
    }



    public void setScene3TripImageUrl1(String scene3TripImageUrl1) {
        Scene3TripImageUrl1 = scene3TripImageUrl1;
    }



    public String getScene3TripImageUrl2() {
        return Scene3TripImageUrl2;
    }



    public void setScene3TripImageUrl2(String scene3TripImageUrl2) {
        Scene3TripImageUrl2 = scene3TripImageUrl2;
    }



    public String getScene3TripImageUrl3() {
        return Scene3TripImageUrl3;
    }



    public void setScene3TripImageUrl3(String scene3TripImageUrl3) {
        Scene3TripImageUrl3 = scene3TripImageUrl3;
    }

    

    
}
