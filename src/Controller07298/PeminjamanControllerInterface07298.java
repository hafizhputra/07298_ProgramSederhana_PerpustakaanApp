package Controller07298;
import java.util.ArrayList;

import Entity07298.AnggotaEntity07298;
import Entity07298.BukuEntity07298;
import Entity07298.PeminjamanEntity07298;

public interface PeminjamanControllerInterface07298 {
   void insertPeminjaman07298(BukuEntity07298 buku, AnggotaEntity07298 anggota);
   void verifPengembalian07298(String idPeminjaman);
   ArrayList<PeminjamanEntity07298> showAllData07298();
   ArrayList<PeminjamanEntity07298> showDataByPeminjam07298(int id);
}
