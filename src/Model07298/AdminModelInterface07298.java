package Model07298;
import java.sql.Connection;

import Helper07298.DbUtil07298;

public interface AdminModelInterface07298 {
    Connection conn = DbUtil07298.getConnection();
    boolean login07298(String nama, String password);
}
