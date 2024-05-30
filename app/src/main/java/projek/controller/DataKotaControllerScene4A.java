package projek.controller;

import config.DBconfig;
import projek.model.DataKota;

public class DataKotaControllerScene4A extends DBconfig {
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

                String Scene4ATripDetail1 = resultSet.getString("Scene4ATripDetail1");
                String Scene4ATripDetail2 = resultSet.getString("Scene4ATripDetail2");
                String Scene4ATripDetail3 = resultSet.getString("Scene4ATripDetail3");

                String Scene4ATripName1 = resultSet.getString("Scene4ATripName1");
                String Scene4ATripName2 = resultSet.getString("Scene4ATripName2");
                String Scene4ATripName3 = resultSet.getString("Scene4ATripName3");

                String Scene4ATripImageUrl1 = resultSet.getString("Scene4ATripImageUrl1");
                String Scene4ATripImageUrl2 = resultSet.getString("Scene4ATripImageUrl2");
                String Scene4ATripImageUrl3 = resultSet.getString("Scene4ATripImageUrl3");

                String Scene4ATripRatingUrl1 = resultSet.getString("Scene4ATripRatingUrl1");
                String Scene4ATripRatingUrl2 = resultSet.getString("Scene4ATripRatingUrl2");
                String Scene4ATripRatingUrl3 = resultSet.getString("Scene4ATripRatingUrl3");

                dataKota = new DataKota(namaKota,
                                        Scene4ATripDetail1, Scene4ATripDetail2, Scene4ATripDetail3, 
                                        Scene4ATripName1, Scene4ATripName2, Scene4ATripName3,
                                        Scene4ATripImageUrl1, Scene4ATripImageUrl2, Scene4ATripImageUrl3, 
                                        Scene4ATripRatingUrl1, Scene4ATripRatingUrl2, Scene4ATripRatingUrl3);
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
