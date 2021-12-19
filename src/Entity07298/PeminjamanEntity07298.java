package Entity07298;

import java.util.Date;

public class PeminjamanEntity07298 {
    private String idPeminjaman;
    private BukuEntity07298 buku;
    private AnggotaEntity07298 anggota;
    private Date tglPeminjaman;
    private Date tglPengembalian;
    private boolean statusPeminjaman;

    public PeminjamanEntity07298(BukuEntity07298 buku, AnggotaEntity07298 anggota) {
        this.buku = buku;
        this.anggota = anggota;
    }

    public PeminjamanEntity07298() {
    }

    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public BukuEntity07298 getBuku() {
        return buku;
    }

    public void setBuku(BukuEntity07298 buku) {
        this.buku = buku;
    }

    public AnggotaEntity07298 getAnggota() {
        return anggota;
    }

    public void setAnggota(AnggotaEntity07298 anggota) {
        this.anggota = anggota;
    }

    public Date getTglPeminjaman() {
        return tglPeminjaman;
    }

    public void setTglPeminjaman(Date tglPeminjaman) {
        this.tglPeminjaman = tglPeminjaman;
    }

    public Date getTglPengembalian() {
        return tglPengembalian;
    }

    public void setTglPengembalian(Date tglPengembalian) {
        this.tglPengembalian = tglPengembalian;
    }

    public boolean isStatusPeminjaman() {
        return statusPeminjaman;
    }

    public void setStatusPeminjaman(boolean statusPeminjaman) {
        this.statusPeminjaman = statusPeminjaman;
    }
    
    
}
