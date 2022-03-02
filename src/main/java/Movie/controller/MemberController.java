package Movie.controller;

import Movie.domain.Dto.MemberDto;
import Movie.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {
    @Autowired
    HttpServletRequest request;
    @GetMapping("/")
    public String main(Model model){

      return "main";
        }
    //회원가입페이지 연결
    @GetMapping("/member/signup")
    public String signup() {
        return "member/signup";
    }
    //로그인 페이지 연결
    @GetMapping("/member/login")
    public String login() {
        return "/member/login";
    }

    @Autowired
    MemberService memberService;
    @PostMapping("/member/signupcontroller")
    public String signupcontroller(MemberDto memberDto,
                                   @RequestParam("address1") String address1 ,
                                   @RequestParam("address2") String address2 ,
                                   @RequestParam("address3") String address3 ,
                                   @RequestParam("address4") String address4 ){
        memberDto.setMaddress(address1+"/"+address2+"/"+address3+"/"+address4);
        System.out.println("memberdto :"+memberDto);
        memberService.membersignup(memberDto);

        return "main";
    }

    @PostMapping("/member/logincontroller")
    @ResponseBody
    public String logincontroller(@RequestBody MemberDto memberDto){
        System.out.println("memberdto : "+memberDto);
        MemberDto logindto=memberService.login(memberDto);
        System.out.println(logindto);
        if(logindto !=null){
            HttpSession session = request.getSession();
            session.setAttribute("logindto",logindto);
            // session.getAttribute("logindto") ; // 세션 호출
            return "1";

        }else{
            return "2";
        }
    }

}
