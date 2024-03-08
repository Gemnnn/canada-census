package dao;

import models.GeographicArea;
import utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeographicAreaDAO {

    public List<GeographicArea> findAllByLevel(int level, String username, String password) {
        List<GeographicArea> areas = new ArrayList<>();
        String sql = "SELECT name, level FROM geographicarea WHERE level = ?";

        try (Connection conn = DatabaseUtils.getConnection(username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, level);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                GeographicArea area = new GeographicArea();
                area.setName(rs.getString("name"));
                area.setLevel(rs.getInt("level"));
                areas.add(area);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return areas;
    }
}
