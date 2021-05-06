package woowastudy.tobyspringstudy.user.dao;

import woowastudy.tobyspringstudy.user.domain.User;

import java.sql.*;

public class UserDao {
    private ConnectionMaker connectionMaker; // Bean끼리는 ㄱㅊ

    // 인스턴스 변수를 가지도록 하면 심각한 문제가 발생한다.
    // private Connection c;
    // private User user;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeNewConnection();
        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();

    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeNewConnection();

        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}
