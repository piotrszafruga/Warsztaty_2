package com.company.dao;

import com.company.models.Group;
import com.company.models.User;
import com.company.models.jdbcConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDao {
    private static final String CREATE_GROUP_QUERY = "INSERT INTO group SET name=?";
    private static final String READ_GROUP_QUERY = "SELECT * FROM group where id = ?";
    private static final String UPDATE_GROUP_QUERY = "UPDATE group SET name = ? where id = ?";
    private static final String DELETE_GROUP_QUERY = "DELETE FROM group WHERE id = ?";
    private static final String FIND_ALL_GROUP_QUERY = "SELECT * FROM group";

    public Group create(Group group) {
        try (Connection conn = jdbcConnection.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_GROUP_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, group.getName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                group.setId(resultSet.getInt(1));
            }
            return group;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Group read(int userId) {
        try (Connection conn = jdbcConnection.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_GROUP_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Group user = new Group();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Group group) {
        try (Connection conn = jdbcConnection.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_GROUP_QUERY);
            statement.setString(1, group.getName());
            statement.setInt(2, group.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int groupId) {
        try (Connection conn = jdbcConnection.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_GROUP_QUERY);
            statement.setInt(1, groupId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Group> findAll() {
        try (Connection conn = jdbcConnection.getConnection()) {
            List<Group> groups = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_GROUP_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Group group = new Group();
                group.setId(resultSet.getInt("id"));
                group.setName(resultSet.getString("name"));
                groups.add(group);
            }
            return groups;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
