package Controller07298;

import java.util.ArrayList;

import Entity07298.AnggotaEntity07298;

public class AnggotaControllerImp07298 implements AnggotaControllerInterface07298{

    @Override
    public void inserAnggota(String nama, String password, String noTelp, String alamat) {
        AnggotaEntity07298 anggota = new AnggotaEntity07298(nama, password, noTelp, alamat);
        AllObjectModel07298.anggotaModel.add(anggota);
    }

    @Override
    public int login(String nama, String password) {
        return AllObjectModel07298.anggotaModel.login(nama, password);
    }

    @Override
    public ArrayList<AnggotaEntity07298> showAllData() {
        return AllObjectModel07298.anggotaModel.getAll();
    }

    @Override
    public void updateAku(int pilihan, String data, int id) {
        if(pilihan == 1){
            AllObjectModel07298.anggotaModel.updatePassword(data, id);
        }else if(pilihan == 2){
            AllObjectModel07298.anggotaModel.updateAlamat(data, id);
        }else if(pilihan == 3){
            AllObjectModel07298.anggotaModel.updateNoTelp(data, id);
        }
    }

    @Override
    public AnggotaEntity07298 getData(int id) {
        return AllObjectModel07298.anggotaModel.getById(id);
    }
    
}
