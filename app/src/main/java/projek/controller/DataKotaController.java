package projek.controller;

import config.DBconfig;
import projek.model.DataKota;

public class DataKotaController extends DBconfig{
    public static DataKota getDataKota(String namaKotaYangDipencet) {
        DataKota dataKota = null;
        String query = "SELECT * FROM DataKota WHERE namaKota = ?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, namaKotaYangDipencet);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String namaKota = resultSet.getString("namaKota");
                String Scene3TripImageUrl1 = resultSet.getString("Scene3TripImageUrl1");
                String Scene3TripImageUrl2 = resultSet.getString("Scene3TripImageUrl2");
                String Scene3TripImageUrl3 = resultSet.getString("Scene3TripImageUrl3");

                dataKota = new DataKota(namaKota, Scene3TripImageUrl1, Scene3TripImageUrl2, Scene3TripImageUrl3);
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


