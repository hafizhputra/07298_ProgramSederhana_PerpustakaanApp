package Controller07298;
import java.util.ArrayList;

import Entity07298.AnggotaEntity07298;


public class AnggotaControllerInterfaceimpl07298 implements AnggotaControllerInterface07298{
    @Override
    public void insertAnggota07298(String nama, String password, String noTelp, String alamat) {
        AnggotaEntity07298 anggota = new AnggotaEntity07298(nama, password, noTelp, alamat);
        AllObjectModel07298.anggotaModel.add(anggota);
    }
    @Override
    public int login07298(String nama, String password) {
      return AllObjectModel07298.anggotaModel.login07298(nama,password);  
    }
    @Override
    public ArrayList<AnggotaEntity07298> showAllData07298() {
      return AllObjectModel07298.anggotaModel.getAll07298();
    }
    @Override
    public AnggotaEntity07298 getByDataId07298(int id) {
      return AllObjectModel07298.anggotaModel.getById07298(id);
    }
    @Override
    public void updateAkun07298(int pilihan, String data, int id) {
        if (pilihan == 1){
            AllObjectModel07298.anggotaModel.updatePassword07298(data, id);
        }else if (pilihan == 2){
            AllObjectModel07298.anggotaModel.updateAlamat07298(data, id);
        }else if (pilihan == 3){
            AllObjectModel07298.anggotaModel.updateNoTelp07298(data, id);
        }
    }   
}
