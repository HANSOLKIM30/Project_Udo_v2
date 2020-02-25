package com.wad.udo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 요청이 Controller로 가기 전 잡아서 로그인 여부를 조건을 확인하는 interceptor
public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
	
	// 세션에 loginInfo 속성이 존재하면 return true: 요청이 들어올 때마다 로그인 상태인지 확인하지 않아도 된다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 현재 요청에서 세션 객체 받기
		HttpSession session = request.getSession(false);
		
		// 세션이 비어있지 않고 세션에 loginInfo가 비어있지 않으면,
		if(session != null && session.getAttribute("loginInfo") != null) {
			// true 반환
			return true;
		}
		
		// 아니라면 메인 페이지로 이동
		response.sendRedirect(request.getContextPath() + "/member/login");
		
		return false;
	}
	
	// 컨트롤러가 수행되고 화면이 보여지기 직전에 수행되는 메서드
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        super.postHandle(request, response, handler, modelAndView);
    }
}
