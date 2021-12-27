package Model07298;
import java.sql.Connection;
import java.util.ArrayList;

import Entity07298.PeminjamanEntity07298;
import Helper07298.DbUtil07298;

public interface PeminjamanModelInterface07298 {
    Connection conn = DbUtil07298.getConnection();
    void add(PeminjamanEntity07298 peminjaman);
    void verifPengembalian(String peminjaman);
    ArrayList<PeminjamanEntity07298> getAll();
    ArrayList<PeminjamanEntity07298> getByPeminjam(int id);
}
