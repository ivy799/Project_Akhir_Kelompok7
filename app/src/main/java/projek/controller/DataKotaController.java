package projek.controller;

import config.DBconfig;
import projek.model.DataKota;

public class DataKotaController extends DBconfig{
    public static DataKota geDataKota(String namaKotaYangDipencet) {
        DataKota dataKota = null;
        String query = "SELECT * FROM DataKota WHERE namaKota = ?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, namaKotaYangDipencet);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String namaKota = resultSet.getString("namaKota");
                String UrlGmbrwisata1 = resultSet.getString("UrlGmbrwisata1");
                String UrlGmbrwisata2 = resultSet.getString("UrlGmbrwisata2");
                String UrlGmbrwisata3 = resultSet.getString("UrlGmbrwisata3");

                dataKota = new DataKota(namaKota, UrlGmbrwisata1, UrlGmbrwisata2, UrlGmbrwisata3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dataKota;
    }
}


