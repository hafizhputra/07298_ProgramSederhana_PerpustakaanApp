package Controller07298;
import java.util.ArrayList;

import Entity07298.AnggotaEntity07298;

public interface AnggotaControllerInterface07298 {
  void insertAnggota07298(String nama, String password, String noTelp, String alamat);  
  int login07298(String nama, String password);
  ArrayList<AnggotaEntity07298> showAllData07298();
  AnggotaEntity07298 getByDataId07298(int id);
  void updateAkun07298(int pilihan, String data, int id);
}
