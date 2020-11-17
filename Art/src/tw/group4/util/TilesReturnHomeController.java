package tw.group4.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4._35_.login.model.WebsiteMember;

@Controller
public class TilesReturnHomeController {
	
    @RequestMapping(path = { "/" }, method = RequestMethod.GET)
    public String returnHome() {
        return IdentityFilter.loginID+"index/index";
    }
    
    @RequestMapping(path = { "/a" }, method = RequestMethod.GET)
    public String returnHomeA() {
    	return IdentityFilter.loginID+"index/index";
//    	return "homePageA";
    }
    
    @RequestMapping(path = { "/b" }, method = RequestMethod.GET)
    public String returnHomeB() {
    	return IdentityFilter.loginID+"index/index";
//    	return "homePageB";
    }
    
    @RequestMapping(path = { "/c" }, method = RequestMethod.GET)
    public String returnHomeC() {
    	return IdentityFilter.loginID+"index/index";
//    	return "homePageC";
    }
    
    @RequestMapping(path = { "/d" }, method = RequestMethod.GET)
    public String returnHomeD() {
    	return IdentityFilter.loginID+"index/index";
//    	return "homePageD";
    }
    
    @RequestMapping(path = { "/e" }, method = RequestMethod.GET)
    public String returnHomeE() {
    	return IdentityFilter.loginID+"index/index";
//    	return "homePageE";
    }
    
    @RequestMapping(path = { "/**/index.html", "/f" }, method = RequestMethod.GET)
    public String returnBackstageHome() {
    	return IdentityFilter.loginID+"index/index";
//    	return "homePageF";
    }
    
//    以下方法是控管進出會員專區和後台身分狀態改變
    
    @RequestMapping(path = { "/userEnterMemberArea" }, method = RequestMethod.GET)
    public String userEnterMemberArea(HttpServletRequest request) {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
		
//		把既有的session內member抓出來，更新memberType
		WebsiteMember member = (WebsiteMember)session.getAttribute("member");
    	member.setMemberType("userMemberArea");
    	session.setAttribute("member", member);
    	
//    	redirect是為了讓filter可以重送請求，更新使用者身份
    	return "redirect:/";
//    	return "redirect:/35/returnHomePageD";
    }
    
    @GetMapping("/35/returnHomePageD")
    public String returnHomePageD() {
//		LoginFilter.loginID = "d/";
    	return "homePageD";
    }
    
    @RequestMapping(path = { "/userLeaveMemberArea" }, method = RequestMethod.GET)
    public String userLeaveMemberArea(HttpServletRequest request) {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
		
//		把既有的session內member抓出來，更新memberType
		WebsiteMember member = (WebsiteMember)session.getAttribute("member");
    	member.setMemberType("user");
    	session.setAttribute("member", member);
    	
//    	redirect是為了讓filter可以重送請求，更新使用者身份
    	return "redirect:/";
//    	return "redirect:/35/returnHomePageB";
    }
    
    @GetMapping("/35/returnHomePageB")
    public String returnHomePageB() {
//    	LoginFilter.loginID = "b/";
    	return "homePageB";
    }
    
    @RequestMapping(path = { "/adminEnterMemberArea" }, method = RequestMethod.GET)
    public String adminEnterMemberArea(HttpServletRequest request) {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
		
//		把既有的session內member抓出來，更新memberType
		WebsiteMember member = (WebsiteMember)session.getAttribute("member");
    	member.setMemberType("adminMemberArea");
    	session.setAttribute("member", member);
    	
//    	redirect是為了讓filter可以重送請求，更新使用者身份
    	return "redirect:/";
//    	return "redirect:/35/returnHomePageE";
    }
    
    @GetMapping("/35/returnHomePageE")
    public String returnHomePageE() {
//    	LoginFilter.loginID = "e/";
    	return "homePageE";
    }
    
    @RequestMapping(path = { "/adminLeaveMemberArea", "/adminLeaveBackstage" }, method = RequestMethod.GET)
    public String adminLeaveMemberArea(HttpServletRequest request) {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
		
//		把既有的session內member抓出來，更新memberType
		WebsiteMember member = (WebsiteMember)session.getAttribute("member");
    	member.setMemberType("admin");
    	session.setAttribute("member", member);
    	
//    	redirect是為了讓filter可以重送請求，更新使用者身份
    	return "redirect:/";
//    	return "redirect:/35/returnHomePageC";
    }
    
    @GetMapping("/35/returnHomePageC")
    public String returnHomePageC() {
//    	LoginFilter.loginID = "c/";
    	return "homePageC";
    }
    
    @RequestMapping(path = { "/adminEnterBackstage" }, method = RequestMethod.GET)
    public String adminEnterBackstage(HttpServletRequest request) {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
		
//		把既有的session內member抓出來，更新memberType
		WebsiteMember member = (WebsiteMember)session.getAttribute("member");
    	member.setMemberType("adminBackstage");
    	session.setAttribute("member", member);
    	
//    	redirect是為了讓filter可以重送請求，更新使用者身份
    	return "redirect:/";
//    	return "redirect:/35/returnHomePageF";
    }
    
    @GetMapping("/35/returnHomePageF")
    public String returnHomePageF() {
//    	LoginFilter.loginID = "f/";
    	return "homePageF";
    }
    
}
