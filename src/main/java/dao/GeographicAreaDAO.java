package dao;

import models.GeographicArea;
import utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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



    public List<GeographicArea> findAllGeographicAreas(String username, String password) {
        List<GeographicArea> areas = new ArrayList<>();
        String sql = "SELECT geographicAreaID, name FROM geographicarea ORDER BY name"; // Simplified for dropdown

        try (Connection conn = DatabaseUtils.getConnection(username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                areas.add(new GeographicArea(rs.getString("name"), rs.getInt("geographicAreaID"), 0, 0)); // Dummy level and population
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return areas;
    }

    public Optional<GeographicArea> findAreaDetailsByGeographicAreaID(int geographicAreaID, String username, String password) {
        String sql = "SELECT g.name, g.geographicAreaID, g.level, a.combined AS totalPopulation " +
                "FROM geographicarea g " +
                "JOIN age a ON g.geographicAreaID = a.geographicArea " +
                "WHERE g.geographicAreaID = ? AND a.censusYear = 2021";

        try (Connection conn = DatabaseUtils.getConnection(username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, geographicAreaID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new GeographicArea(
                        rs.getString("name"),
                        rs.getInt("geographicAreaID"),
                        rs.getInt("level"),
                        rs.getInt("totalPopulation")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
