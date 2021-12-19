package Model07298;

import java.sql.*;
import java.util.ArrayList;

import Entity07298.AnggotaEntity07298;
import Helper07298.KoneksiDb07298;

public interface AnggotaModelInterface07298 {
    Connection conn = KoneksiDb07298.getConnection();
    
    void add(AnggotaEntity07298 anggota);
    void remove(int id);
    int login(String nama, String password);
    ArrayList<AnggotaEntity07298> getAll();
    AnggotaEntity07298 getById(int id);
    void resetPassword(int id);
    void updateNoTelp(String noTelp, int id);
    void updateAlamat(String alamat, int id);
    void updatePassword(String password, int id);
}
