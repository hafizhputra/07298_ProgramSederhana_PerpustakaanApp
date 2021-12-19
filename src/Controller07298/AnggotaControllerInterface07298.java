package Controller07298;

import java.util.ArrayList;

import Entity07298.AnggotaEntity07298;

public interface AnggotaControllerInterface07298 {
    void inserAnggota(String nama, String password, String noTelp, String alamat);
    int login(String nama, String password);
    ArrayList<AnggotaEntity07298> showAllData();
    AnggotaEntity07298 getData(int id);
    void updateAku(int pilihan, String data, int id);
    
}
