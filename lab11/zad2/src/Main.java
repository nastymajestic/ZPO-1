import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;

import javax.security.auth.login.Configuration;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
    }
}