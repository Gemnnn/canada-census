package dao;

import beans.GeographicBean;
import utils.DatabaseUtils;

import java.sql.*;
import java.util.*;

public class GeographicAreaDAO {

    public Map<Integer, List<GeographicBean>> findAllAreasGroupedByLevel(String username, String password) {
        Map<Integer, List<GeographicBean>> areasByLevel = new HashMap<>();
        String sql = "SELECT Code, Level, Name FROM geographicarea ORDER BY Level, Name";

        try (Connection conn = DatabaseUtils.getConnection(username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                GeographicBean area = new GeographicBean();
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


    public List<GeographicBean> findAllGeographicAreas(String username, String password) {
        List<GeographicBean> areas = new ArrayList<>();
        String sql = "SELECT geographicAreaID, name FROM geographicarea ORDER BY name"; // Simplified for dropdown

        try (Connection conn = DatabaseUtils.getConnection(username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                areas.add(new GeographicBean(rs.getString("name"), 0, 0, 0, rs.getInt("geographicAreaID"))); // Dummy code, level and population
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return areas;
    }

    public Optional<GeographicBean> findAreaDetailsByGeographicAreaID(int geographicAreaID, String username, String password) {
        String sql = "SELECT g.name, g.code, g.level, a.combined AS totalPopulation, g.geographicAreaID " +
                "FROM geographicarea g " +
                "JOIN age a ON g.geographicAreaID = a.geographicArea " +
                "WHERE g.geographicAreaID = ? AND a.censusYear = 1 AND a.ageGroup = 1";

        try (Connection conn = DatabaseUtils.getConnection(username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, geographicAreaID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new GeographicBean(
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
