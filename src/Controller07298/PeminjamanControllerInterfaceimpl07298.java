package Controller07298;

import java.util.ArrayList;

import Entity07298.AnggotaEntity07298;
import Entity07298.BukuEntity07298;
import Entity07298.PeminjamanEntity07298;

public class PeminjamanControllerInterfaceimpl07298 implements PeminjamanControllerInterface07298{
    @Override
    public void insertPeminjaman07298(BukuEntity07298 buku, AnggotaEntity07298 anggota) {
        AllObjectModel07298.peminjamanModel.add(new PeminjamanEntity07298(buku,anggota));
    }
    @Override
    public void verifPengembalian07298(String idPeminjaman) {
        AllObjectModel07298.peminjamanModel.verifPengembalian(idPeminjaman);
    }
    @Override
    public ArrayList<PeminjamanEntity07298> showAllData07298() {
        return AllObjectModel07298.peminjamanModel.getAll();
    }
    @Override
    public ArrayList<PeminjamanEntity07298> showDataByPeminjam07298(int id) {
        return AllObjectModel07298.peminjamanModel.getByPeminjam(id);
    }   
}
