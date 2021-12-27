package Controller07298;

public class AdminControllerInterfaceimpl07298 implements AdminControllerInterface07298 {
    @Override
    public boolean login07298(String nama, String password) {
      return AllObjectModel07298.adminModel.login07298(nama, password);
    }
    @Override
    public void hapusAnggota07298(int id) {
       AllObjectModel07298.anggotaModel.remove07298(id);
    }
    @Override
    public void resetPassAnggota07298(int id) {
        AllObjectModel07298.anggotaModel.resetPassword07298(id);
    }
}
