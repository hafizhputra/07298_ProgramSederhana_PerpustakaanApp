package Controller07298;

import java.util.ArrayList;

import Entity07298.AnggotaEntity07298;
import Entity07298.BukuEntity07298;
import Entity07298.PeminjamanEntity07298;

public interface PeminjamanControllerInterface {
    void insertPinjaman(BukuEntity07298 buku, AnggotaEntity07298 anggota);
    void verifPengembalian(String idPeminjaman);
    ArrayList<PeminjamanEntity07298> showAllData();
    ArrayList<PeminjamanEntity07298> showDataByPinjam(int id);
}
