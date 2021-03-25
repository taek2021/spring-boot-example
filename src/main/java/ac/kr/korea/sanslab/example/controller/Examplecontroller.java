package ac.kr.korea.sanslab.example.controller;

import ac.kr.korea.sanslab.example.constant.Constant;
import dto.Memberdto;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sun.font.EAttribute;

import javax.servlet.http.HttpServletRequest;


//
@RestController
public class Examplecontroller {

    private static final Logger logger = LoggerFactory.getLogger(Examplecontroller.class);
// 스프링 부트 프레임워크의 로거를 이용하기위해 선언

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView mv){

        logger.info("request-home");
        mv.setViewName("home");
        mv.addObject("memberDto", new Memberdto());
        return mv;
    }

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mv){
        logger.info("request-index");
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value ="/err", method = RequestMethod.GET)
    public String err(){
        logger.info("request-error");

        return "ERROR";
    }
    @RequestMapping(value ="/registration", method = RequestMethod.GET)
    public ModelAndView registration(ModelAndView mv){
        logger.info("registration");
        mv.setViewName("registration");
        return mv;
    }

    @RequestMapping(value = "/registration/process", method = RequestMethod.POST)
    public ModelAndView registrationProcess(ModelAndView mv, HttpServletRequest servletRequest) {
        String name = servletRequest.getParameter("name").trim();
        String password = servletRequest.getParameter("password").trim();
        logger.info("name: {}, password: {}, name, password");
        if (name != null && !name.equals("") &&
                password != null && !password.equals("")) {
            Constant.MAP_MEMBER.put(name, password);
            mv.setViewName("redirect:/");
        }
        else mv.setViewName("redirect:err");

//        if (name.equals("system") && password.equals("network"))
//            mv.setViewName("forward:");
//        else mv.setViewName("redirect:err");
        return mv;
    }
    @RequestMapping(value = "/sign-in/process", method = RequestMethod.POST)
    public ModelAndView signInProcess(ModelAndView mv, @ModelAttribute("memberDto") Memberdto memberdto) {
        String name = memberdto.getName().trim();
        String password = memberdto.getPassword().trim();
        logger.info("name: {}, password: {}", name, password);
        if ((name != null) && !name.equals("") && (password != null) && !password.equals("")) {
            if (Constant.MAP_MEMBER.get(name) != null && Constant.MAP_MEMBER.get(name).equals(password)) {
                mv.setViewName("redirect:/index");
            } else mv.setViewName("redirect:/err");
        } else mv.setViewName("redirect:/err");

        return mv;
    }


// 접근지정자(pubilic은 외부접근이 가능한 지정자. private로 하면 내부에서만 됨) 타입(string) 매개변수 (리스트) {바디}


    @RequestMapping(value="/menu", method = RequestMethod.GET)
    public ModelAndView menu(ModelAndView mv, HttpServletRequest servletRequest){
        String type = servletRequest.getParameter("type");
        logger.info("type: {}",type);
        if(type.equals("a"))
        {
           mv.setViewName("menu-a");
        }
        else if(type.equals("b")){
            mv.setViewName("menu-b");
        }

        else{
            mv.setViewName("/err");
        }

        return mv;
    }

}
