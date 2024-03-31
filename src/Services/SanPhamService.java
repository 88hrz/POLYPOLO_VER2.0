/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.KhoHang;
import Models.SP_ChatLieu;
import Models.SP_DanhMuc;
import Models.SP_KichCo;
import Models.SP_MauSac;
import Models.SP_NhanHang;
import Models.SanPham;
import Repositories.KhoHangRepo;
import Repositories.SP_ChatLieuRepo;
import Repositories.SP_DanhMucRepo;
import Repositories.SP_MauSacRepo;
import Repositories.SP_KichCoRepo;
import Repositories.SP_NhanHangRepo;
import Repositories.SanPhamRepository;
import ViewModels.SanPhamViewModel;
import java.util.ArrayList;

/**
 *
 * @author X1
 */
public class SanPhamService {
    SanPhamRepository spRepo = new SanPhamRepository();
    SP_DanhMucRepo dmRepo = new SP_DanhMucRepo();
    SP_MauSacRepo msRepo = new SP_MauSacRepo();
    SP_ChatLieuRepo chatLRepo = new SP_ChatLieuRepo();
    SP_KichCoRepo szRepo = new SP_KichCoRepo();
    SP_NhanHangRepo brandRepo = new SP_NhanHangRepo();
    KhoHangRepo khRepo = new KhoHangRepo();
    
    //CHECK ID
    public Boolean checkId(Integer id) {
        return spRepo.checkId(id);
    }
    public Boolean checkName(String tenSP){
        return spRepo.checkName(tenSP);
    }
    public boolean checkIdCat(Integer id) {
        return dmRepo.checkIdCat(id);
    }
    public boolean checkIdColor(Integer id) {
        return msRepo.checkIdColor(id);
    }
    public boolean checkIdSz(Integer id) {
        return szRepo.checkIdSz(id);
    }
    public boolean checkIdBrand(Integer id) {
        return brandRepo.checkIdBrand(id);
    }
    public boolean checkIdChatL(Integer id) {
        return chatLRepo.checkIdChatL(id);
    }
    public boolean checkIdKho(Integer id) {
        return khRepo.checkIdKho(id);
    }
    
    //IMPORT
    public String addImport(SanPham sp){
       Boolean check = spRepo.addSP(sp);
        if (check) {
            return "Import data thành công!";
        }else{
            return "Import data thất bại!";
        }
    }
    
    //GETLIST
    public ArrayList<SanPhamViewModel> getListSPVM(){
        return spRepo.getListSPVM();
    }
    public ArrayList<SP_DanhMuc> getListDM(){
        return dmRepo.getList();
    }
    public ArrayList<SP_ChatLieu> getListChatL(){
        return chatLRepo.getList();
    }
    public ArrayList<SP_MauSac> getListMauS(){
        return msRepo.getList();
    }
    public ArrayList<SP_KichCo> getListSz(){
        return szRepo.getList();
    }
    public ArrayList<SP_NhanHang> getListNH(){
        return brandRepo.getList();
    }
    public ArrayList<KhoHang> getListKhoHang(){
        return khRepo.getList();
    }
    public SanPhamViewModel getListViewModelByIdSP(Integer id) {
        return spRepo.getListViewModelByIdSP(id);
    }
    
    //HIDE - UNHIDE
    public Boolean hideSP(SanPham sp){
        return spRepo.hideSP(sp);
    }
    public Boolean unhideSP(SanPham sp){
        return spRepo.unhideSP(sp);
    }
    public ArrayList<SanPhamViewModel> getListHide(){
        return spRepo.getListHide();
    }
    
    //GETMODEL
    public SP_DanhMuc getIdByNameDanhMuc(String name){
        return dmRepo.getIdByName(name);
    }
    public SP_ChatLieu getIdByNameChatLieu(String name){
        return chatLRepo.getIdByName(name);
    }
    public SP_KichCo getIdByNameSz(String name){
        return szRepo.getIdByName(name);
    }
    public SP_MauSac getIdByNameMauSac(String name){
        return msRepo.getIdByName(name);
    }
    public SP_NhanHang getIdByNameBrand(String name){
        return brandRepo.getIdByName(name);
    }
    public ArrayList<SanPhamViewModel> getListViewModelById(Integer id) {
        return spRepo.getListViewModelById(id);
    }
    public KhoHang getIdByNameKhoHang(String name){
        return khRepo.getIdByName(name);
    }
    
    //CRUD
    public ArrayList<SanPham> getListSP(){
        return spRepo.getListSP();
    }
    public String addSP(SanPham sp){
        Boolean check = spRepo.addSP(sp);
        if (check) {
            return "Thêm mới sản phẩm thành công!";
        }else{
            return "Thêm mới sản phẩm thất bại :(";
        }
    }
    public String updateSP(SanPham sp){
        Boolean check = spRepo.updateSP(sp);
        if (check) {
            return "Update sản phẩm thành công gòii~";
        }else{
            return "Update sản phẩm thất bại!!";
        }
    }
    
    //THUOCTINH
    public String addColor(SP_MauSac color) {
        Boolean check = msRepo.addColor(color);
        if (check) {
            return "Thêm thuộc tính màu sắc mới thành công!";
        } else {
            return "Thêm thuộc tính màu sắc mới thất bại :(";
        }
    }
    public String addBrand(SP_NhanHang brand) {
        Boolean check = brandRepo.addBrand(brand);
        if (check) {
            return "Thêm nhãn hàng mới thành công!";
        } else {
            return "Thêm nhãn hàng mới thất bại :(";
        }
    }
    public String addMaterial(SP_ChatLieu material) {
        Boolean check = chatLRepo.addMaterial(material);
        if (check) {
            return "Thêm thuộc tính chất liệu mới thành công!";
        } else {
            return "Thêm thuộc tính chất liệu mới thất bại :(";
        }
    }
    public String addSz(SP_KichCo sz) {
        Boolean check = szRepo.addSz(sz);
        if (check) {
            return "Thêm thuộc tính kích cỡ mới thành công!";
        } else {
            return "Thêm thuộc tính kích cỡ mới thất bại :(";
        }
    }
    public String addCat(SP_DanhMuc danhMuc) {
        Boolean check = dmRepo.addCat(danhMuc);
        if (check) {
            return "Thêm danh mục mới thành công!";
        } else {
            return "Thêm danh mục mới thất bại :(";
        }
    }
    
    public String updateBrand(SP_NhanHang brand) {
        Boolean check = brandRepo.updateBrand(brand);
        if (check) {
            return "Cập nhật thương hiệu thành công!";
        }else{
            return "Cập nhật thương hiệu thất bại :(";
        }
    }
    public String updateMaterial(SP_ChatLieu material) {
        Boolean check = chatLRepo.updateMaterial(material);
        if (check) {
            return "Cập nhật chất liệu thành công!";
        }else{
            return "Cập nhật chất liệu thất bại :(";
        }
    }
    public String updateDanhMuc(SP_DanhMuc danhMuc) {
        Boolean check = dmRepo.updateDanhMuc(danhMuc);
        if (check) {
            return "Cập nhật danh mục thành công!";
        }else{
            return "Cập nhật danh mục thất bại :(";
        }
    }
    public String updateSize(SP_KichCo sz) {
        Boolean check = szRepo.updateSize(sz);
        if (check) {
            return "Cập nhật kích cỡ thành công!";
        }else{
            return "Cập nhật kích cỡ thất bại :(";
        }
    }
    public String updateMauSac(SP_MauSac color) {
        Boolean check = msRepo.updateMauSac(color);
        if (check) {
            return "Cập nhật màu sắc thành công!";
        }else{
            return "Cập nhật màu sắc thất bại :(";
        }
    }
    
    public String hideBrand(SP_NhanHang brand) {
        Boolean check = brandRepo.hideBrand(brand);
        if (check) {
            return "Ẩn thương hiệu thành công!";
        }else{
            return "Ẩn thương hiệu thất bại :(";
        }
    }
    public String hideMaterial(SP_ChatLieu material) {
        Boolean check = chatLRepo.hideMaterial(material);
        if (check) {
            return "Ẩn chất liệu thành công!";
        }else{
            return "Ẩn chất liệu thất bại :(";
        }
    }
    public String hideDanhMuc(SP_DanhMuc danhMuc) {
        Boolean check = dmRepo.hideDanhMuc(danhMuc);
        if (check) {
            return "Ẩn danh mục thành công!";
        }else{
            return "Ẩn danh mục thất bại :(";
        }
    }
    public String hideSize(SP_KichCo sz) {
        Boolean check = szRepo.hideSize(sz);
        if (check) {
            return "Ẩn kích cỡ thành công!";
        }else{
            return "Ẩn kích cỡ thất bại :(";
        }
    }
    public String hideMauSac(SP_MauSac color) {
        Boolean check = msRepo.hideMauSac(color);
        if (check) {
            return "Ẩn màu sắc thành công!";
        }else{
            return "Ẩn màu sắc thất bại :(";
        }
    }
    
    public String unhideBrand(SP_NhanHang brand) {
        Boolean check = brandRepo.unhideBrand(brand);
        if (check) {
            return "Bỏ ẩn thương hiệu thành công!";
        }else{
            return "Bỏ ẩn thương hiệu thất bại :(";
        }
    }
    public String unhideMaterial(SP_ChatLieu material) {
        Boolean check = chatLRepo.unhideMaterial(material);
        if (check) {
            return "Bỏ ẩn chất liệu thành công!";
        }else{
            return "Bỏ ẩn chất liệu thất bại :(";
        }
    }
    public String unhideDanhMuc(SP_DanhMuc danhMuc) {
        Boolean check = dmRepo.unhideDanhMuc(danhMuc);
        if (check) {
            return "Bỏ ẩn danh mục thành công!";
        }else{
            return "Bỏ ẩn danh mục thất bại :(";
        }
    }
    public String unhideSize(SP_KichCo sz) {
        Boolean check = szRepo.unhideSize(sz);
        if (check) {
            return "Bỏ ẩn kích cỡ thành công!";
        }else{
            return "Bỏ ẩn kích cỡ thất bại :(";
        }
    }
    public String unhideMauSac(SP_MauSac color) {
        Boolean check = msRepo.unhideMauSac(color);
        if (check) {
            return "Bỏ ẩn màu sắc thành công!";
        }else{
            return "Bỏ ẩn màu sắc thất bại :(";
        }
    }
    
    public ArrayList<SP_NhanHang> getBrandHide(){
        return brandRepo.getListHide();
    }
    public ArrayList<SP_ChatLieu> getMaterialHide(){
        return chatLRepo.getListHide();
    }
    public ArrayList<SP_DanhMuc> getCatHide(){
        return dmRepo.getListHide();
    }
    public ArrayList<SP_KichCo> getSzHide(){
        return szRepo.getListHide();
    }
    public ArrayList<SP_MauSac> getColorHide(){
        return msRepo.getListHide();
    }
}
