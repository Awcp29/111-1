package entity;
import java.sql.*;
//2021

public class Main {

    public static void main(String[] args) throws SQLException {
        // write your code here
        try {
            Connection conn = DriverManager.getConnection(CM.getProp("url"),CM.getProp("user"),CM.getProp("password"));
            Statement st = conn.createStatement();
            String sql = "select*from stuinfo";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.print("学号:" + rs.getNString("StuNum"));
                System.out.print(";");
                System.out.print("姓名:" + rs.getNString("name"));
                System.out.print(";");
                System.out.print("性别:" + rs.getNString("sex"));
                System.out.print(";");
                System.out.print("年龄:" + rs.getNString("age"));
                System.out.print(".");

            }
            rs.close();
            st.close();
            String sql2 = "insert into stuinfo(StuNum, name, age, sex)values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setString(1, "20201120479");
            ps.setString(2, "小于");
            ps.setBoolean(3, true);
            ps.setInt(4, 19);
            int result = ps.executeUpdate();

            if (result != 0) {
                System.out.println("插入成功！！！");
            }
            rs.close();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
