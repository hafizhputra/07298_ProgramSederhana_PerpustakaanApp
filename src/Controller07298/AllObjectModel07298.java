package Controller07298;
import Model07298.AdminModelInterface07298;
import Model07298.AdminModelInterfaceimpl07298;
import Model07298.AnggotaModelInterface07298;
import Model07298.AnggotaModelInterfaceimpl07298;
import Model07298.BukuModelInterface07298;
import Model07298.BukuModelInterfaceimpl07298;
import Model07298.PeminjamanModelInterface07298;
import Model07298.PeminjamanModelInterfaceimpl07298;

public class AllObjectModel07298 {
    public static AdminModelInterface07298 adminModel = new AdminModelInterfaceimpl07298();
    public static AnggotaModelInterface07298 anggotaModel = new AnggotaModelInterfaceimpl07298();
    public static BukuModelInterface07298 bukuModel = new BukuModelInterfaceimpl07298();
    public static PeminjamanModelInterface07298 peminjamanModel = new PeminjamanModelInterfaceimpl07298();
}
