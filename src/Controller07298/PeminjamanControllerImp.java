package Controller07298;

import java.util.ArrayList;

import Entity07298.AnggotaEntity07298;
import Entity07298.BukuEntity07298;
import Entity07298.PeminjamanEntity07298;

public class PeminjamanControllerImp implements PeminjamanControllerInterface{

    @Override
    public void insertPinjaman(BukuEntity07298 buku, AnggotaEntity07298 anggota) {
        AllObjectModel07298.peminjamanModel.add(new PeminjamanEntity07298(buku, anggota));
    }

    @Override
    public void verifPengembalian(String idPeminjaman) {
        AllObjectModel07298.peminjamanModel.verifpengemalian(idPeminjaman);
    }

    @Override
    public ArrayList<PeminjamanEntity07298> showAllData() {
        return AllObjectModel07298.peminjamanModel.getAll();
    }

    @Override
    public ArrayList<PeminjamanEntity07298> showDataByPinjam(int id) {
        return AllObjectModel07298.peminjamanModel.getByPeminjam(id);
    }
    
}
