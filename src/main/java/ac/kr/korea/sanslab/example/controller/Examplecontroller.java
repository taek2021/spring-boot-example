package ac.kr.korea.sanslab.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Examplecontroller {

    private static final Logger logger = LoggerFactory.getLogger(Examplecontroller.class);
// 스프링 부트 프레임워크의 로거를 이용하기위해 선언

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView mv){

        logger.info("request-home");
        mv.setViewName("home");
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
