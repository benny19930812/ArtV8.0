package tw.group4.util;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tw.group4._35_.login.model.WebsiteMember;

@WebFilter("/*")
public class IdentityFilter implements Filter {

	public static String loginID;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
//		預設未登入的身份與視角
		String memberType = "visitor";
		loginID = "a/";
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
		
		if (Objects.nonNull(session.getAttribute("member"))) {
			WebsiteMember member = (WebsiteMember) session.getAttribute("member");
			memberType = member.getMemberType();
			switch (memberType) {
			case ("user"):
				loginID = "b/";
				break;
			case ("admin"):
				loginID = "c/";
				break;
			case ("userMemberArea"):
				loginID = "d/";
				break;
			case ("adminMemberArea"):
				loginID = "e/";
				break;
			case ("adminBackstage"):
				loginID = "f/";
				break;
			default:
				loginID = "a/";
			}
		}
		
		System.out.println("網站使用者身份: " + memberType + "，視角：" + loginID);

		chain.doFilter(request, response);

	}

}
