package lab1.lab1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Bai5 {
    @RequestMapping("/hcn")
    public String hinhChuNhat(
        Model model, 
        @RequestParam(name = "chieudai", required = false) Double chieudai,
        @RequestParam(name = "chieurong", required = false) Double chieurong
    ) {
        model.addAttribute("chieudai", chieudai);
        model.addAttribute("chieurong", chieurong);
        
        if (chieudai == null || chieurong == null) {
            model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin chiều dài và chiều rộng!");
        } else if (chieudai <= 0 || chieurong <= 0) {
            model.addAttribute("error", "Chiều dài và chiều rộng phải lớn hơn 0!");
        } else {
            double chuvihcn = (chieudai + chieurong) * 2;
            double dientichhcn = chieudai * chieurong;

        
            model.addAttribute("chuvihcn", chuvihcn);
            model.addAttribute("dientichhcn", dientichhcn);
        }
        return "bai5/hinhchunhat";
    }
}