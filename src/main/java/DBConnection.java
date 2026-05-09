package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // මෙන්න මේ method එක ඇතුළේ තමයි සම්බන්ධතාවය ඇති වෙන්නේ
    public static Connection connect() {
        Connection conn = null;
        try {
            // 1. MySQL Driver එක ලෝඩ් කරනවා
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Database එකේ විස්තර (URL, Username, Password)
            // 'wildlife_db' වෙනුවට ඔයාගේ database නම හරියටම දෙන්න
            String url = "jdbc:mysql://localhost:3306/wildlife_db";
            String user = "root";
            String password = ""; // password එකක් තියෙනවා නම් මෙතනට දෙන්න

            // 3. සම්බන්ධතාවය ඇති කරගන්නවා
            conn = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            // මොකක් හරි වැරැද්දක් වුණොත් ඒක මෙතනින් පෙන්වනවා
            System.out.println("Connection Failed: " + e.getMessage());
        }
        return conn;
    }
}