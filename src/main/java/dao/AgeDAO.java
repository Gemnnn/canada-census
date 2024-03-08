package dao;

import models.AgeData;
import utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgeDAO {

    public List<AgeData> getPopulationDataByYear(int[] years, String username, String password) {
        List<AgeData> ageDataList = new ArrayList<>();
        String sql = "SELECT censusYear, SUM(male) AS totalMale, SUM(female) AS totalFemale " +
                "FROM age WHERE censusYear IN (?, ?) GROUP BY censusYear";

        try (Connection conn = DatabaseUtils.getConnection(username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, years[0]);
            stmt.setInt(2, years[1]);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ageDataList.add(new AgeData(
                        rs.getInt("censusYear"),
                        rs.getLong("totalMale"),
                        rs.getLong("totalFemale")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ageDataList;
    }
}
