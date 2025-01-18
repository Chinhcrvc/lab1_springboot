package lab1.lab1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("login")
public class Bai4 {
    
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;

    @GetMapping("/form")
    public String form(Model model){
        return "login/login";
    }

    @PostMapping("/check")
    public String login(
        Model model, 
        @RequestParam("uname") String uname, 
        @RequestParam("pass") String pass
        ) {
        // String uname = request.getParameter("uname");
        // String pass = request.getParameter("pass");
        String message;
        if(uname == null || pass == null || uname.isEmpty() || pass.isEmpty()){
            message = "Vui lòng điền đầy đủ thông tin!";
        }else if(uname.equals("poly") && pass.equals("123")){
           message = "Login thành công!";
        }else{
            message = "Login thất bại!";
        }
        model.addAttribute("message", message);        
        return "login/login";
    }    
    
}
