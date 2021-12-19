package Controller07298;

import java.util.ArrayList;

import Entity07298.BukuEntity07298;

public class BukuController07298 implements BukuControllerInterface07298{

    @Override
    public void insertBuku(String isbn, String judul, String penerbit, int terbit, int halaman) {
        AllObjectModel07298.bukuModel.add(new BukuEntity07298(isbn, judul, penerbit, terbit, halaman));
    }

    @Override
    public void deleteBuku(String isbn) {
        AllObjectModel07298.bukuModel.delete(isbn);
    }

    @Override
    public void updateBuku(int pilihan, String isbn, String data) {
        if(pilihan == 1){
            AllObjectModel07298.bukuModel.updateJudul(isbn, data);
        }else if(pilihan == 2){
            AllObjectModel07298.bukuModel.updatePenerbit(isbn, data);
        }
    }

    @Override
    public ArrayList<BukuEntity07298> showAllData() {
        return AllObjectModel07298.bukuModel.getAll();
    }

    @Override
    public BukuEntity07298 getData(String isbn) {
        return AllObjectModel07298.bukuModel.getById(isbn);
    }
   
}
