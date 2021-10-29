package ru.sapteh.dao.impl;

import ru.sapteh.dao.Dao;
import ru.sapteh.model.Auto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao<Auto, Integer> {

    private final Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }


    public Auto findById(Integer id) {
        String query = "SELECT * FROM user WHERE id=?";
        Auto user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = new Auto(
                        resultSet.getInt("id"),
                        resultSet.getString("model"),
                        resultSet.getString("mark"),
                        resultSet.getString("body_type"),
                        resultSet.getString("type_gasoline")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public List<Auto> findAll() {
        List<Auto> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(
                        new Auto(
                                resultSet.getInt("id"),
                                resultSet.getString("model"),
                                resultSet.getString("mark"),
                                resultSet.getString("body_type"),
                                resultSet.getString("type_gasoline")
                        )
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    public void save(Auto user) {
        String save = "INSERT INTO user (model, mark, body_type, type_gasoline) VALUES (?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(save);
            statement.setString(1, user.getModel());
            statement.setString(2, user.getMark());
            statement.setString(3, user.getBody_type());
            statement.setString(4, user.getType_gasoline());

            int result = statement.executeUpdate();
            System.out.println(result == 1 ? "Save success" : "Save failed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Auto user) {
        String update = "UPDATE user SET model=?, mark=?, body_type=?, type_gasoline=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setString(1, user.getModel());
            statement.setString(2, user.getMark());
            statement.setString(3, user.getBody_type());
            statement.setString(4, user.getType_gasoline());
            statement.setInt(5, user.getId());
            int result = statement.executeUpdate();
            System.out.println(result == 1 ? "Update success" : "Update failed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteById(Integer id) {
        String delete = "DELETE FROM user WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            System.out.println(result == 1 ? "Delete success" : "Delete failed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
