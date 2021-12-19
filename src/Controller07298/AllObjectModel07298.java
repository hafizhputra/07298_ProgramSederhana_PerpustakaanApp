package Controller07298;

import Model07298.AdminModelInterface07298;
import Model07298.AdminModelInterfaceImp07298;
import Model07298.AnggotaModelInterface07298;
import Model07298.AnggotaModelInterfaceImp;
import Model07298.BukuModelEntity07298;
import Model07298.BukuModelInterface07298;
import Model07298.PeminjamanModelInterface;
import Model07298.PeminjamanModelInterfaceImp;

public class AllObjectModel07298 {
    public static AdminModelInterface07298 adminModel = new AdminModelInterfaceImp07298();
    public static AnggotaModelInterface07298 anggotaModel = new AnggotaModelInterfaceImp();
    public static BukuModelInterface07298 bukuModel = new BukuModelEntity07298();
    public static PeminjamanModelInterface peminjamanModel = new PeminjamanModelInterfaceImp();
}
