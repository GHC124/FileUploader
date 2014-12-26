package com.ghc.fileuploader.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ghc.fileuploader.controller.util.Endpoint;
import com.ghc.fileuploader.dto.request.LoginRequest;
import com.ghc.fileuploader.dto.request.Request;
import com.ghc.fileuploader.dto.response.LoginResponse;
import com.ghc.fileuploader.dto.response.Response;
import com.ghc.fileuploader.dto.response.ValidateResponse;
import com.ghc.fileuploader.service.util.ServiceUtil;

@Controller
public class AuthenticationRestController {
	
	@RequestMapping(value = Endpoint.REST + ServiceUtil.LOGIN, method = {RequestMethod.POST})
	@ResponseBody
	public Response login(@RequestBody LoginRequest loginRequest){
		LoginResponse loginResponse = new LoginResponse();
		
		// TODO using database
		if("chungpv1".equalsIgnoreCase(loginRequest.getUsername())
				&& "123456".equalsIgnoreCase(loginRequest.getPassword())){
			loginResponse.setStatus(Response.STATUS_SUCCESS);
			loginResponse.setDisplayName("Chung");
			loginResponse.setTokenKey("123456789abc");
		}else{
			loginResponse.setStatus(Response.STATUS_FAIL);
		}
		
		return loginResponse;
	}
	
	@RequestMapping(value = Endpoint.REST + ServiceUtil.VALIDATE, method = {RequestMethod.GET})
	@ResponseBody
	public Response validate(@RequestBody Request request){
		ValidateResponse validateResponse = new ValidateResponse();
		
		// TODO using database and check time out
		if("chungpv1".equalsIgnoreCase(request.getUsername())
				&& "123456789abc".equalsIgnoreCase(request.getTokenKey())){
			validateResponse.setStatus(Response.STATUS_SUCCESS);
		}else{
			validateResponse.setStatus(Response.STATUS_FAIL);
		}
		
		return validateResponse;
	}
}
