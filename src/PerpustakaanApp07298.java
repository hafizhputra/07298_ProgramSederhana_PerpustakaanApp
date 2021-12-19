import java.util.Scanner;

import Controller07298.AdminControllerInterface07298;
import Controller07298.AdminControllerInterfaceImp;
import Controller07298.AnggotaControllerImp07298;
import Controller07298.AnggotaControllerInterface07298;
import Controller07298.BukuController07298;
import Controller07298.BukuControllerInterface07298;
import Controller07298.PeminjamanControllerImp;
import Controller07298.PeminjamanControllerInterface;
import Entity07298.AnggotaEntity07298;
import Entity07298.BukuEntity07298;

public class PerpustakaanApp07298 {
    public static Scanner input = new Scanner(System.in);
    public static AdminControllerInterface07298 adminCon = new AdminControllerInterfaceImp();
    public static AnggotaControllerInterface07298 anggotaCon = new AnggotaControllerImp07298();
    public static BukuControllerInterface07298 bukuCon = new BukuController07298();
    public static PeminjamanControllerInterface peminjamanCon = new PeminjamanControllerImp();
    public static String nama, password, noTelp, alamat;
    public static String username, pass;
    
    public static void main(String[] args) {
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
        anggotaCon.inserAnggota(nama, password, noTelp, alamat);
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
        if(adminCon.login(nama, password)){
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
        if(anggotaCon.login(nama, password) != 0){
            int id = anggotaCon.login(nama, password);
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
                    resetPassAnggota();
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
                    lihatDaftarPeminjam();
                    break;
                case 9:
                    verifikasiPengembalian();
                    break;
            }
        }while (pilih < 10);
    }
    
    public static void daftarAnggota(){
        int size = anggotaCon.showAllData().size();
        System.out.println("Data Daftar Anggota");
        for (int i = 0; i < size; i++){
            System.out.println("" +anggotaCon.showAllData().get(i).getId()+ ". "
            + " " +anggotaCon.showAllData().get(i).getNama()
            + " " +anggotaCon.showAllData().get(i).getPassword()
            + " " +anggotaCon.showAllData().get(i).getNoTelp()
            + " " +anggotaCon.showAllData().get(i).getAlamat()
            );
        }
    }
    
    public static void hapusAnggota(){
        daftarAnggota();
        System.out.print("Masukkan id yang akan di HAPUS : ");
        int id = input.nextInt();
        adminCon.hapusAnggota(id);
    }
    
    public static void resetPassAnggota(){
        daftarAnggota();
        System.out.print("Id yang akan di RESET  : ");
        int id = input.nextInt();
        adminCon.resetPassAnggota(id);
    }
    
    public static void daftarBuku(){
        int size = bukuCon.showAllData().size();
        for(int i = 0; i < size; i++){
            System.out.println((i+1)+ ". " +bukuCon.showAllData().get(i).getIsbn()+ " "
            + bukuCon.showAllData().get(i).getJudul()+ " "
            + bukuCon.showAllData().get(i).getPenerbit()+ " "
            + bukuCon.showAllData().get(i).getTerbit()+ " "
            + bukuCon.showAllData().get(i).getHalaman()+ " "
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
        bukuCon.insertBuku(isbn, judul, penerbit, halaman, tgl);
    }
    
    public static void hapusBuku(){
        daftarBuku();
        System.out.print("Kode ISBN : ");
        String isbn = input.next();
        bukuCon.deleteBuku(isbn);
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
                    bukuCon.updateBuku(1, isbn, judul);
                    break;
                case 2:
                    daftarBuku();
                    System.out.print("Penerbit Baru : ");
                    String penerbit = input.next();
                    penerbit += input.nextLine();
                    System.out.print("Isbn Buku : ");
                    isbn = input.next();
                    bukuCon.updateBuku(2, isbn, penerbit);
                    break;
            }
        }while (pilih < 3);
    }
    
public static void lihatDaftarPeminjam(){
        int size = peminjamanCon.showAllData().size();
        for (int i =0; i < size ; i++){
           String status = !peminjamanCon.showAllData().get(i).isStatusPeminjaman() ?"Masih dipinjam ":"Telah Kembali ";
           System.out.println((i+1)+". "+peminjamanCon.showAllData().get(i).getIdPeminjaman()+" "+
                peminjamanCon.showAllData().get(i).getBuku().getIsbn()+" "+
                peminjamanCon.showAllData().get(i).getBuku().getJudul()+" "+
                peminjamanCon.showAllData().get(i).getAnggota().getNama()+" "+
                peminjamanCon.showAllData().get(i).getTglPeminjaman()+" "+
                peminjamanCon.showAllData().get(i).getTglPengembalian()+" "+status);
    }
}
    
    public static void verifikasiPengembalian(){
        lihatDaftarPeminjam();
        System.out.println("Id Peminjam : ");
        String idPeminjaman = input.next();
        peminjamanCon.verifPengembalian(idPeminjaman);
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
        int size = peminjamanCon.showDataByPinjam(id).size();
        for (int i =0; i < size ; i++){
           String status = !peminjamanCon.showDataByPinjam(id).get(i).isStatusPeminjaman() ?"Masih dipinjam ":"Telah Kembali ";
           System.out.println((i+1)+". "+peminjamanCon.showDataByPinjam(id).get(i).getIdPeminjaman()+" "+
                peminjamanCon.showDataByPinjam(id).get(i).getBuku().getJudul()+" "+
                peminjamanCon.showDataByPinjam(id).get(i).getTglPeminjaman()+" "+
                peminjamanCon.showDataByPinjam(id).get(i).getTglPengembalian()+" "+
                status
           );
        }
    }
    
    public static void pinjamBuku(int id){
        daftarBuku();
        System.out.print("Isbn Buku : ");
        String isbn = input.next();
        BukuEntity07298 buku = bukuCon.getData(isbn);
        AnggotaEntity07298 anggota = anggotaCon.getData(id);
        peminjamanCon.insertPinjaman(buku, anggota);        
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
                dataAnggotaById(id);
                System.out.print("Password Baru : ");
                String password = input.next();
                anggotaCon.updateAku(1, password, id);
            }else if(pilih == 2){
                dataAnggotaById(id);
                System.out.print("Ubah Alamat : ");
                String alamat = input.next();
                anggotaCon.updateAku(2, alamat, id);
            }else if(pilih == 3){
                dataAnggotaById(id);
                System.out.print("Ubah No Telp : ");
                String noTelp = input.next();
                anggotaCon.updateAku(3, noTelp, id);
            }
        }while(pilih < 4);
    }
    
    public static void dataAnggotaById(int id){
        System.out.println(
                anggotaCon.getData(id).getNama()+ " " +
                anggotaCon.getData(id).getPassword()+ " " +
                anggotaCon.getData(id).getNoTelp()+ " " +
                anggotaCon.getData(id).getAlamat()
        );
    }
}
