package dao;

import beans.GeographicAreaBean;
import utils.DatabaseUtils;

import java.sql.*;
import java.util.*;

public class GeographicAreaDAO {

    public Map<Integer, List<GeographicAreaBean>> findAllAreasGroupedByLevel(String username, String password) {
        Map<Integer, List<GeographicAreaBean>> areasByLevel = new HashMap<>();
        String sql = "SELECT Code, Level, Name FROM geographicarea ORDER BY Level, Name";

        try (Connection conn = DatabaseUtils.getConnection(username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                GeographicAreaBean area = new GeographicAreaBean();
                area.setName(rs.getString("Name"));
                area.setCode(rs.getInt("Code"));
                area.setLevel(rs.getInt("Level"));

                areasByLevel.computeIfAbsent(rs.getInt("Level"), k -> new ArrayList<>()).add(area);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return areasByLevel;
    }


    public List<GeographicAreaBean> findAllGeographicAreas(String username, String password) {
        List<GeographicAreaBean> areas = new ArrayList<>();
        String sql = "SELECT geographicAreaID, name FROM geographicarea ORDER BY name"; // Simplified for dropdown

        try (Connection conn = DatabaseUtils.getConnection(username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                areas.add(new GeographicAreaBean(rs.getString("name"), 0, 0, 0, rs.getInt("geographicAreaID"))); // Dummy code, level and population
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return areas;
    }

    public Optional<GeographicAreaBean> findAreaDetailsByGeographicAreaID(int geographicAreaID, String username, String password) {
        String sql = "SELECT g.name, g.code, g.level, a.combined AS totalPopulation, g.geographicAreaID " +
                "FROM geographicarea g " +
                "JOIN age a ON g.geographicAreaID = a.geographicArea " +
                "WHERE g.geographicAreaID = ? AND a.censusYear = 1 AND a.ageGroup = 1";

        try (Connection conn = DatabaseUtils.getConnection(username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, geographicAreaID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new GeographicAreaBean(
                        rs.getString("name"),
                        rs.getInt("code"),
                        rs.getInt("level"),
                        rs.getInt("totalPopulation"),
                        rs.getInt("geographicAreaID")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
