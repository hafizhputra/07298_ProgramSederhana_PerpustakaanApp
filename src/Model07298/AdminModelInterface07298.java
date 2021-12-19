package Model07298;

import java.sql.Connection;

import Helper07298.KoneksiDb07298;

public interface AdminModelInterface07298 {
    Connection conn = KoneksiDb07298.getConnection();
    
    boolean login(String nama, String password);
}
