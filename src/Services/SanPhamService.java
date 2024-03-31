/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.ChatLieu;
import Models.DanhMuc;
import Models.KichCo;
import Models.MauSac;
import Repositories.SP_ChatLieuRepo;
import Repositories.SP_DanhMucRepo;
import Repositories.SP_MauSacRepo;
import Repositories.SP_KichCoRepo;
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
    
    //GETLIST
    public ArrayList<SanPhamViewModel> getListSPVM(){
        return spRepo.getListSPVM();
    }
    public ArrayList<DanhMuc> getListDM(){
        return dmRepo.getList();
    }
    public ArrayList<ChatLieu> getListChatL(){
        return chatLRepo.getList();
    }
    public ArrayList<MauSac> getListMauS(){
        return msRepo.getList();
    }
    public ArrayList<KichCo> getListSz(){
        return szRepo.getList();
    }
    
}
