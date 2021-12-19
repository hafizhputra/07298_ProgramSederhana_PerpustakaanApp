package Controller07298;

public class AdminControllerInterfaceImp implements AdminControllerInterface07298{

    @Override
    public boolean login(String nama, String password) {
        return AllObjectModel07298.adminModel.login(nama, password);
    }

    @Override
    public void hapusAnggota(int id) {
        AllObjectModel07298.anggotaModel.remove(id);
    }

    @Override
    public void resetPassAnggota(int id) {
        AllObjectModel07298.anggotaModel.resetPassword(id);
    }
    
}
