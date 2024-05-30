package projek.controller;

import config.DBconfig;
import projek.model.DataKota;

public class DataKotaControllerScene3 extends DBconfig {
    public static DataKota getDataKota(String namaKotaYangDipencet) {
        DataKota dataKota = null;
        String query = "SELECT * FROM A WHERE namaKota = ?";
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

                String Scene3TripName1 = resultSet.getString("Scene3TripName1");
                String Scene3TripName2 = resultSet.getString("Scene3TripName2");
                String Scene3TripName3 = resultSet.getString("Scene3TripName3");

                String Scene3UmkmImageUrl1 = resultSet.getString("Scene3UmkmImageUrl1");
                String Scene3UmkmImageUrl2 = resultSet.getString("Scene3UmkmImageUrl2");
                String Scene3UmkmImageUrl3 = resultSet.getString("Scene3UmkmImageUrl3");

                String Scene3UmkmName1 = resultSet.getString("Scene3UmkmName1");
                String Scene3UmkmName2 = resultSet.getString("Scene3UmkmName2");
                String Scene3UmkmName3 = resultSet.getString("Scene3UmkmName3");

                String Scene3HistoryImageUrl1 = resultSet.getString("Scene3HistoryImageUrl1");
                String Scene3HistoryImageUrl2 = resultSet.getString("Scene3HistoryImageUrl2");
                String Scene3HistoryImageUrl3 = resultSet.getString("Scene3HistoryImageUrl3");

                String Scene3TraditionImageUrl1 = resultSet.getString("Scene3TraditionImageUrl1");
                String Scene3TraditionImageUrl2 = resultSet.getString("Scene3TraditionImageUrl2");
                String Scene3TraditionImageUrl3 = resultSet.getString("Scene3TraditionImageUrl3");

                String Scene3FoodImageUrl1 = resultSet.getString("Scene3FoodImageUrl1");
                String Scene3FoodImageUrl2 = resultSet.getString("Scene3FoodImageUrl2");
                String Scene3FoodImageUrl3 = resultSet.getString("Scene3FoodImageUrl3");

                String Scene3HistoryText1 = resultSet.getString("Scene3HistoryText1");
                String Scene3HistoryText2 = resultSet.getString("Scene3HistoryText2");
                String Scene3HistoryText3 = resultSet.getString("Scene3HistoryText3");

                String Scene3TraditionText1 = resultSet.getString("Scene3TraditionText1");
                String Scene3TraditionText2 = resultSet.getString("Scene3TraditionText2");
                String Scene3TraditionText3 = resultSet.getString("Scene3TraditionText3");

                String Scene3FoodText1 = resultSet.getString("Scene3FoodText1");
                String Scene3FoodText2 = resultSet.getString("Scene3FoodText2");
                String Scene3FoodText3 = resultSet.getString("Scene3FoodText3");

                dataKota = new DataKota(namaKota, 
                                        Scene3TripImageUrl1, Scene3TripImageUrl2, Scene3TripImageUrl3, 
                                        Scene3TripName1, Scene3TripName2, Scene3TripName3,
                                        Scene3UmkmImageUrl1, Scene3UmkmImageUrl2, Scene3UmkmImageUrl3, 
                                        Scene3UmkmName1, Scene3UmkmName2, Scene3UmkmName3,
                                        Scene3HistoryImageUrl1, Scene3HistoryImageUrl2, Scene3HistoryImageUrl3, 
                                        Scene3TraditionImageUrl1, Scene3TraditionImageUrl2, Scene3TraditionImageUrl3, 
                                        Scene3FoodImageUrl1, Scene3FoodImageUrl2, Scene3FoodImageUrl3, 
                                        Scene3HistoryText1, Scene3HistoryText2, Scene3HistoryText3,
                                        Scene3TraditionText1, Scene3TraditionText2, Scene3TraditionText3, 
                                        Scene3FoodText1, Scene3FoodText2, Scene3FoodText3);
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
