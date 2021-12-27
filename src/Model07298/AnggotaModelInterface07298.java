package Model07298;
import java.sql.*;
import java.util.ArrayList;

import Entity07298.AnggotaEntity07298;
import Helper07298.DbUtil07298;

public interface AnggotaModelInterface07298 {
  Connection conn = DbUtil07298.getConnection();
  
  void add(AnggotaEntity07298 anggota);
  void remove07298(int id);
  int login07298(String nama, String password);
  ArrayList<AnggotaEntity07298> getAll07298();
  AnggotaEntity07298 getById07298(int id);
  void resetPassword07298(int id);
  void updateNoTelp07298(String noTelp, int id);
  void updateAlamat07298(String alamat, int id);
  void updatePassword07298(String password, int id);
}
