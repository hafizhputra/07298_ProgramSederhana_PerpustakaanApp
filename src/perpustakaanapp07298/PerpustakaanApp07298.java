package perpustakaanapp07298;
import java.util.Scanner;

import Controller07298.AdminControllerInterface07298;
import Controller07298.AdminControllerInterfaceimpl07298;
import Controller07298.AnggotaControllerInterface07298;
import Controller07298.AnggotaControllerInterfaceimpl07298;
import Controller07298.BukuControllerInterface07298;
import Controller07298.BukuControllerInterfaceimpl07298;
import Controller07298.PeminjamanControllerInterface07298;
import Controller07298.PeminjamanControllerInterfaceimpl07298;
import Entity07298.AnggotaEntity07298;
import Entity07298.BukuEntity07298;

public class PerpustakaanApp07298 {
    public static Scanner input = new Scanner(System.in); 
    public static AdminControllerInterface07298 adminController = new AdminControllerInterfaceimpl07298();
    public static AnggotaControllerInterface07298 anggotaController = new AnggotaControllerInterfaceimpl07298();
    public static BukuControllerInterface07298 bukuController = new BukuControllerInterfaceimpl07298();
    public static PeminjamanControllerInterface07298 peminjamanController = new PeminjamanControllerInterfaceimpl07298();
    public static String nama, password, noTelp, alamat;
    public static String username, pass;
    
    public static void main (String[] args){
        int pilih;
        do{
            System.out.println("SELAMAT DATANG");
            System.out.println("1. REGISTRASI");
            System.out.println("2. LOGIN");
            System.out.println("3. KELUAR");
            System.out.print("Pilihan : ");
            pilih = input.nextInt();
            switch(pilih){
                case 1:
                    registrasi();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("KELUAR");
                    break;
            }
        }while (pilih < 3);
    }
    
    public static void registrasi(){
        System.out.print("Nama      : ");
        nama = input.next();
        System.out.print("Password  : ");
        password = input.next();
        System.out.print("No Telpon : ");
        noTelp = input.next();
        System.out.print("Alamat    : ");
        alamat = input.next();
        anggotaController.insertAnggota07298(nama, password, noTelp, alamat);
    }
    
    public static void login(){
        int pilih;
        do{
            System.out.println("LOGIN AS ");
            System.out.println("1. Admin");
            System.out.println("2. Anggota");
            System.out.print("Pilihan : ");
            pilih = input.nextInt();
            switch(pilih){
                case 1:
                    loginAdmin();
                    break;
                case 2:
                    loginAnggota();
                    break;
            }
        }while (pilih < 3);
    }
    
    public static void loginAdmin(){
       System.out.print("Username : ");
        nama = input.next();
        System.out.print("Password : ");
        password = input.next();
        if(adminController.login07298(nama, password)){
            menuAdmin();
        }else{
            System.out.println("Username atau Password salah");
        }
    }
    
    public static void loginAnggota(){
        System.out.print("Username : ");
        nama = input.next();
        System.out.print("Password : ");
        password = input.next();
        if(anggotaController.login07298(nama, password) != 0){
            int id = anggotaController.login07298(nama, password);
            menuAnggota(id);
        }else{
            System.out.println("Username atau Password salah");
        }
    }
    public static void menuAdmin(){
        int pilih;
        do{
            System.out.println("MENU ADMIN");
            System.out.println("1. Lihat Daftar Anggota");
            System.out.println("2. Hapus Anggota");
            System.out.println("3. Reset Password Anggota");
            System.out.println("4. Lihat Daftar Buku");
            System.out.println("5. Tambah Daftar Buku");
            System.out.println("6. Hapus Daftar Buku");
            System.out.println("7. Ubah Informasi Buku");
            System.out.println("8. Lihat Daftar Peminjaman");
            System.out.println("9. Verifikasi Pengembalian");
            System.out.println("10. KELUAR");
            pilih = input.nextInt();
            switch(pilih){
                case 1:
                    daftarAnggota();
                    break;
                case 2:
                    hapusAnggota();
                    break;
                case 3:
                    resetPasswordAnggota();
                    break;
                case 4:
                    daftarBuku();
                    break;
                case 5:
                    tambahDaftarBuku();
                    break;
                case 6:
                    hapusBuku();
                    break;
                case 7:
                    ubahBuku();
                    break;
                case 8:
                    lihatDaftarPeminjaman();
                    break;
                case 9:
                    verifikasiPengembalian();
                    break;
            }
        }while (pilih < 10);
    }
    
    public static void daftarAnggota(){
        int size = anggotaController.showAllData07298().size();
        System.out.println("Data Daftar Anggota");
        for (int i = 0; i < size; i++){
            System.out.println("" +anggotaController.showAllData07298().get(i).getId()+ ". "
            + " " +anggotaController.showAllData07298().get(i).getNama()
            + " " +anggotaController.showAllData07298().get(i).getPassword()
            + " " +anggotaController.showAllData07298().get(i).getNoTelp()
            + " " +anggotaController.showAllData07298().get(i).getAlamat()
            );
        }
    }
    
    public static void hapusAnggota(){
        daftarAnggota();
        System.out.print("Masukkan id yang akan di HAPUS : ");
        int id = input.nextInt();
        adminController.hapusAnggota07298(id);
    }
    
    public static void resetPasswordAnggota(){
        daftarAnggota();
        System.out.print("Id yang akan di RESET  : ");
        int id = input.nextInt();
        adminController.resetPassAnggota07298(id);
    }
    
    public static void daftarBuku(){
        int size = bukuController.showAllData07298().size();
        for(int i = 0; i < size; i++){
            System.out.println((i+1)+ ". " +bukuController.showAllData07298().get(i).getIsbn()+ " "
            + bukuController.showAllData07298().get(i).getJudul()+ " "
            + bukuController.showAllData07298().get(i).getPenerbit()+ " "
            + bukuController.showAllData07298().get(i).getTerbit()+ " "
            + bukuController.showAllData07298().get(i).getHalaman()+ " "
            );
        }
    }
    
    public static void tambahDaftarBuku(){
        System.out.print("Isbn Buku            : ");
        String isbn = input.next();
        System.out.print("Judul Buku           : ");
        String judul = input.next();
        judul += input.nextLine();
        System.out.print("Penerbit Buku        : ");
        String penerbit = input.next();
        penerbit += input.nextLine();
        System.out.print("Jumblah Halaman Buku : ");
        int halaman = input.nextInt();
        System.out.print("Tahun Terbit Buku    : ");
        int tgl = input.nextInt();
        bukuController.insertBuku07298(isbn, judul, penerbit, halaman, tgl);
    } 
    
    public static void hapusBuku(){
        daftarBuku();
        System.out.print("Kode ISBN : ");
        String isbn = input.next();
        bukuController.deleteBuku07298(isbn);
    } 
    
    public static void ubahBuku(){
        int pilih;
        do{
            System.out.println("1. Ubah Judul Buku");
            System.out.println("2. Ubah Pnerbit Buku");
            System.out.println("3. Kembali ke Menu");
            System.out.print("Pilih : ");
            pilih = input.nextInt();
            switch(pilih){
                case 1:
                    daftarBuku();
                    System.out.println("Judul Baru : ");
                    String judul = input.next();
                    judul += input.nextLine();
                    System.out.print("Isbn Buku : ");
                    String isbn = input.next();
                    bukuController.updateBuku07298(1, judul, isbn);
                    break;
                case 2:
                    daftarBuku();
                    System.out.print("Penerbit Baru : ");
                    String penerbit = input.next();
                    penerbit += input.nextLine();
                    System.out.print("Isbn Buku : ");
                    isbn = input.next();
                    bukuController.updateBuku07298(2, penerbit, isbn);
                    break;
            }
        }while (pilih < 3);
    } 
    
    public static void lihatDaftarPeminjaman(){
        int size = peminjamanController.showAllData07298().size();
        for (int i =0; i < size ; i++){
           String status = !peminjamanController.showAllData07298().get(i).isStatusPeminjaman() ?"Masih dipinjam ":"Telah Kembali ";
           System.out.println((i+1)+". "+peminjamanController.showAllData07298().get(i).getIdPeminjaman()+" "+
                peminjamanController.showAllData07298().get(i).getBuku().getIsbn()+" "+
                peminjamanController.showAllData07298().get(i).getBuku().getJudul()+" "+
                peminjamanController.showAllData07298().get(i).getAnggota().getNama()+" "+
                peminjamanController.showAllData07298().get(i).getTglPeminjaman()+" "+
                peminjamanController.showAllData07298().get(i).getTglpengembalian()+" "+status);
        }
    } 
    
    public static void verifikasiPengembalian(){
        lihatDaftarPeminjaman();
        System.out.println("Id Peminjam : ");
        String idPeminjaman = input.next();
        peminjamanController.verifPengembalian07298(idPeminjaman);
    } 
    
    public static void menuAnggota(int id){
        int pilih;
        do{
            System.out.println("id");
            System.out.println("1. Lihat Riwayat Peminjaman");
            System.out.println("2. Lakukan Peminjaman");
            System.out.println("3. Edit Data Diri");
            System.out.println("4. Keluar");
            System.out.print("Pilih : ");
            pilih = input.nextInt();
            switch(pilih){
                case 1:
                    lihatRiwayatPeminjaman(id);
                    break;
                case 2:
                    pinjamBuku(id);
                    break;
                case 3:
                    editDataAnggota(id);
                    break;
            }
        }while(pilih < 4);
    } 
    
    public static void lihatRiwayatPeminjaman(int id){
        int size = peminjamanController.showDataByPeminjam07298(id).size();
        for (int i =0; i < size ; i++){
           String status = !peminjamanController.showDataByPeminjam07298(id).get(i).isStatusPeminjaman() ? "Masih dipinjam ":"Telah Kembali ";
           System.out.println((i+1)+". "+peminjamanController.showDataByPeminjam07298(id).get(i).getIdPeminjaman()+" "+
                peminjamanController.showDataByPeminjam07298(id).get(i).getBuku().getJudul()+" "+
                peminjamanController.showDataByPeminjam07298(id).get(i).getTglPeminjaman()+" "+
                peminjamanController.showDataByPeminjam07298(id).get(i).getTglpengembalian()+" "+
                status
           );
        }
    } 
    
    public static void pinjamBuku(int id){
        daftarBuku();
        System.out.print("Isbn Buku : ");
        String isbn = input.next();
        BukuEntity07298 buku = bukuController.getData07298(isbn);
        AnggotaEntity07298 anggota = anggotaController.getByDataId07298(id);
        peminjamanController.insertPeminjaman07298(buku, anggota); 
    } 
    
    public static void editDataAnggota(int id){
        int pilih;
        do{
            System.out.println("1. Ubah Password");
            System.out.println("2. Ubah Alamat");
            System.out.println("3. Ubah No Telp");
            System.out.println("4. Keluar");
            System.out.print("Pilih : ");
            pilih = input.nextInt();
            if(pilih == 1){
                dataPenggunaById(id);
                System.out.print("Password Baru : ");
                String password = input.next();
                anggotaController.updateAkun07298(1, password, id);
            }else if(pilih == 2){
                dataPenggunaById(id);
                System.out.print("Ubah Alamat : ");
                String alamat = input.next();
                anggotaController.updateAkun07298(2, alamat, id);
            }else if(pilih == 3){
                dataPenggunaById(id);
                System.out.print("Ubah No Telp : ");
                String noTelp = input.next();
                anggotaController.updateAkun07298(3, noTelp, id);
            }
        }while(pilih < 4);

    } 
    public static void dataPenggunaById(int id){
        System.out.println(
                anggotaController.getByDataId07298(id).getNama()+ " " +
                anggotaController.getByDataId07298(id).getPassword()+ " " +
                anggotaController.getByDataId07298(id).getNoTelp()+ " " +
                anggotaController.getByDataId07298(id).getAlamat()
        );
    }
}