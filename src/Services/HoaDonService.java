/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.HoaDonChiTiet;
import Models.HoaDon;
import Models.KhachHang;
import Models.NhanSu;
import Models.SanPhamChiTiet;
import Repositories.HoaDonRepository;
import Repositories.KhachHangRepository;
import Repositories.NhanSuRepo;
import Repositories.PhieuNhapRepository;
import Repositories.SanPhamRepository;
import ViewModels.HD_GioHangViewModel;
import ViewModels.HD_InvoiceViewModel;
import ViewModels.HD_SanPhamViewModel;
import ViewModels.KhachHangViewModel;
import ViewModels.PN_SanPhamViewModel;
import ViewModels.SanPhamViewModel;
import java.util.ArrayList;

/**
 *
 * @author X1
 */
public class HoaDonService {
    HoaDonRepository hdRepo = new HoaDonRepository();
    NhanSuRepo nsRepo = new NhanSuRepo();
    SanPhamRepository spRepo = new SanPhamRepository();
    PhieuNhapRepository pnRepo = new PhieuNhapRepository();
    KhachHangRepository khRepo = new KhachHangRepository();
    
    //INVOICE 
    public ArrayList<HD_InvoiceViewModel> getListKHById(Integer id){
        return hdRepo.getListKHById(id);
    }
    public ArrayList<HD_GioHangViewModel> printInvoiceById(Integer id) {
        return hdRepo.printInvoiceById(id);
    }
    
    //ACTION
    public Boolean checkExists(Integer idSPCT, Integer id){
        return hdRepo.checkExists(idSPCT, id);
    }
    
    public Integer getTotalP(int id) {
        return hdRepo.getTotalP(id);
    }
    
    public String mergeSP(Integer soL, Integer id, Integer idSPCT){
        Boolean check = hdRepo.mergeSP(soL, id, idSPCT);
        if (check) {
            return "Thêm sản phẩm vào giỏ hàng thành công!!";
        }else{
            return "Thêm sản phẩm vào giỏ hàng thất bại :(";
        }
    }
    
    public String addHD(HoaDon hd){
        Boolean check = hdRepo.addHD(hd);
        if (check) {
            return "Tạo hóa đơn mới thành công!";
        }else{
            return "Tạo hóa đơn mới thất bại :(";
        }
    }
    
    public String addHDCT(HoaDonChiTiet hdct) {
        Boolean check = hdRepo.addHDCT(hdct);
        if (check) {
            return "Thêm sản phẩm vào giỏ hàng thành công!";
        }else{
            return "Thêm sản phẩm thất bại :(";
        }
    }
    
    public String updateSP(Integer id, Integer soL){
        Boolean check = hdRepo.updateSP(id, soL);
        if (check) {
            return "Thêm sản phẩm vào giỏ hàng thành công!!";
        }else{
            return "Thêm sản phẩm vào giỏ hàng thất bại :(";
        }
    }
    
    public HoaDon getTotal(Integer id){
        return hdRepo.getTotal(id);
    }
    public Double getVATFee(Integer id) {
        return hdRepo.getVATFee(id);
    }
    
    public Boolean setTongT (int idHD){
        return hdRepo.setTongT(idHD);
    }
    
    public Boolean checkKH(String sdt){
        return hdRepo.checkKH(sdt);
    }
    
    public KhachHang getKHBySDT(String sdt){
        return khRepo.getKHBySDT(sdt);
    }
    
    public String delSingle(int id, int idSPCT){
        Boolean check = hdRepo.delSingle(id, idSPCT);
        if (check) {
            return "Xóa sản phẩm thành công!";
        }else{
            return "Xóa sản phẩm thất bại!";
        }
    }
    
    public String emptyBasket(int id){
        Boolean check = hdRepo.emptyBasket(id);
        if (check) {
            return "Xóa giỏ hàng thành công!";
        }else{
            return "Xóa giỏ hàng thất bại :(";
        }
    }
    
    public String updateThanhToan(int id){
        Boolean check = hdRepo.updateThanhToan(id);
        if (check) {
            return "Thanh toán thành công!";
        }else{
            return "Thanh toán thất bại :(";
        }
    }
    
    public SanPhamChiTiet getSPById(Integer id){
        return spRepo.getListById(id);
    }
    
    //SEARCH
    public KhachHang getListKHBySDT(String sdt){
        return hdRepo.getListKHBySDT(sdt);
    }
    
    //GETMODEL
    public HoaDon getModel(){
        return hdRepo.getModel();
    }
    public ArrayList<HoaDonChiTiet> getListHDCT(){
        return hdRepo.getListHDCT();
    }
    public ArrayList<KhachHang> getListKH(){
        return khRepo.getListKH();
    }
    public NhanSu getNSById(Integer id) {
        return nsRepo.getListById(id);
    }
    public HoaDon getByHoaDon(Integer id){
        return hdRepo.getByHoaDon(id);
    }
    public HoaDonChiTiet getByHDCT(int id){
        return hdRepo.getByHDCT(id);
    }
    
    //GETLIST
    public ArrayList<HoaDonChiTiet> getListHDCTById(int id){
        return hdRepo.getListHDCTById(id);
    }
    public ArrayList<NhanSu> getListNS(){
        return nsRepo.getListNS();
    }
    public ArrayList<HoaDon> getAllHoaDon(){
        return hdRepo.getAllHoaDon();
    }
    public NhanSu getIdByNameNS(String name) {
        return nsRepo.getIdByName(name);
    }
    public ArrayList<HoaDon> getHD(String trangT){
        return hdRepo.getHoaDon(trangT);
    }
    public ArrayList<HD_SanPhamViewModel> getListSanPham(){
        return hdRepo.getListSanPham();
    }
    public ArrayList<HD_GioHangViewModel> getListGioHangById(Integer id){
        return hdRepo.getListGioHangById(id);
    }
    public SanPhamViewModel getSPByIdSP(Integer id) {
        return spRepo.getSPByIdSPCT(id);
    }
    public ArrayList<PN_SanPhamViewModel> getListSPViewModel(){
        return pnRepo.getListSPViewModel();
    }
}
