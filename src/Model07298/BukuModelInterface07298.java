package Model07298;

import java.sql.Connection;
import java.util.ArrayList;

import Entity07298.BukuEntity07298;
import Helper07298.KoneksiDb07298;

public interface BukuModelInterface07298 {
    Connection conn = KoneksiDb07298.getConnection();
    
    void add(BukuEntity07298 buku);
    void updateJudul(String isbn, String judul);
    void updatePenerbit(String isbn, String penerbit);
    void delete(String isbn);
    ArrayList<BukuEntity07298> getAll();
    BukuEntity07298 getById(String isbn);
}
