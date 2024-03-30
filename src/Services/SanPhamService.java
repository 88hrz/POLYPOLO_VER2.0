/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Repositories.SanPhamRepository;
import ViewModels.SanPhamViewModel;
import java.util.ArrayList;

/**
 *
 * @author X1
 */
public class SanPhamService {
    SanPhamRepository spRepo = new SanPhamRepository();
    
    public ArrayList<SanPhamViewModel> getListSPVM(){
        return spRepo.getListSPVM();
    }
}
