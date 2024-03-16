package dao;

import beans.AgeBean;
import utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgeDAO {
public List<AgeBean> getPopulationDataByYear(String username, String password) {
        List<AgeBean> ageBeanList = new ArrayList<>();

        // These are the codes referencing all ages and Canada in the Canada Census DB
        final int ALL_AGES_CODE = 1;
        final int CANADA_CODE = 1;

        String sql = "SELECT c.censusYear, male, female FROM age AS a " +
                "JOIN censusyear AS c ON c.censusYearID = a.censusYear " +
                "WHERE a.ageGroup = ? AND a.geographicArea = ?";

        try (Connection conn = DatabaseUtils.getConnection(username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ALL_AGES_CODE);
            stmt.setInt(2, CANADA_CODE);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ageBeanList.add(new AgeBean(
                        rs.getInt("censusYear"),
                        rs.getLong("male"),
                        rs.getLong("female")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ageBeanList;
    }
}
