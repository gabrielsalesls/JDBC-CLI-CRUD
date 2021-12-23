package gabrielsalesls.dao;

import gabrielsalesls.model.User;

import java.sql.*;

public class UserDAO {

    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(User user) throws SQLException {
        String sql = "INSERT INTO User (name, email, country, gender) VALUES (?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setString(4, user.getGender());

            int rowsInserted = preparedStatement.executeUpdate();
            if(rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        }
    }

    public void listUsers() {
        String sql = "SELECT * FROM user";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                Integer id = result.getInt(1);
                String name = result.getString(2);
                String email = result.getString(3);
                String gender = result.getString(4);
                String country = result.getString(5);

                String output = "User #%d: %s - %s - %s - %s %n";
                System.out.printf(output, id, name, email, gender, country);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteUserById(int id){
        String sql = "DELETE FROM user WHERE id=?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();
            if(rowsDeleted > 0) {
                String output = "User with id: %d deleted %n";
                System.out.printf(output, id);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Entrada Invalida");
        }
    }

    public void deleteAll() {
        String sql = "DELETE FROM USER";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            int rowsDeleted = preparedStatement.executeUpdate();
            if(rowsDeleted > 0) {
                String output = "%d rows deleted!";
                System.out.printf(output, rowsDeleted);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateUser(User user, int id) {
        String sql = "update user set name = ?, email = ?, country = ?, gender = ? where id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setString(4, user.getGender());
            preparedStatement.setInt(5, id);

            int rowUpdated = preparedStatement.executeUpdate();
            if(rowUpdated > 0) {
                System.out.println("An existing user was updated successfully");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
