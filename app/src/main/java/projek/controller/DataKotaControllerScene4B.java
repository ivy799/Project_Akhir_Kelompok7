package projek.controller;

import config.DBconfig;
import projek.model.DataKota;

public class DataKotaControllerScene4B extends DBconfig {
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

                String Scene4BUmkmImageUrl1 = resultSet.getString("Scene4BUmkmImageUrl1");
                String Scene4BUmkmImageUrl2 = resultSet.getString("Scene4BUmkmImageUrl2");
                String Scene4BUmkmImageUrl3 = resultSet.getString("Scene4BUmkmImageUrl3");

                String Scene4BUmkmName1 = resultSet.getString("Scene4BUmkmName1");
                String Scene4BUmkmName2 = resultSet.getString("Scene4BUmkmName2");
                String Scene4BUmkmName3 = resultSet.getString("Scene4BUmkmName3");

                String Scene4BUmkmRatingUrl1 = resultSet.getString("Scene4BUmkmRatingUrl1");
                String Scene4BUmkmRatingUrl2 = resultSet.getString("Scene4BUmkmRatingUrl2");
                String Scene4BUmkmRatingUrl3 = resultSet.getString("Scene4BUmkmRatingUrl3");

                String Scene4BLocationDetail1 = resultSet.getString("Scene4BLocationDetail1");
                String Scene4BLocationDetail2 = resultSet.getString("Scene4BLocationDetail2");
                String Scene4BLocationDetail3 = resultSet.getString("Scene4BLocationDetail3");

                String Scene4BProductDetail1 = resultSet.getString("Scene4BProductDetail1");
                String Scene4BProductDetail2 = resultSet.getString("Scene4BProductDetail2");
                String Scene4BProductDetail3 = resultSet.getString("Scene4BProductDetail3");

                String Scene4BContactDetail1 = resultSet.getString("Scene4BContactDetail1");
                String Scene4BContactDetail2 = resultSet.getString("Scene4BContactDetail2");
                String Scene4BContactDetail3 = resultSet.getString("Scene4BContactDetail3");

                dataKota = new DataKota(namaKota,Scene4BUmkmImageUrl1, Scene4BUmkmImageUrl2, Scene4BUmkmImageUrl3, 
                                        Scene4BUmkmName1, Scene4BUmkmName2, Scene4BUmkmName3,
                                        Scene4BUmkmRatingUrl1, Scene4BUmkmRatingUrl2, Scene4BUmkmRatingUrl3, 
                                        Scene4BLocationDetail1, Scene4BLocationDetail2, Scene4BLocationDetail3,
                                        Scene4BProductDetail1, Scene4BProductDetail2, Scene4BProductDetail3, 
                                        Scene4BContactDetail1, Scene4BContactDetail2, Scene4BContactDetail3);
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
