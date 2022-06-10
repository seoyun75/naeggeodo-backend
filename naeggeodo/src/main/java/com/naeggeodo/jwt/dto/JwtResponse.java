package com.naeggeodo.jwt.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.naeggeodo.entity.user.Authority;
import com.naeggeodo.oauth.dto.SimpleUser;

import lombok.Builder;
import lombok.ToString;

@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class JwtResponse {
	private String accessToken;
	private String refreshToken;
	private String type;
//	private SimpleUser user;
	private String user_id;
	private String address;

	public JwtResponse(String accessToken, String refreshToken, String type, SimpleUser user) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.type = type;
//		this.user = user;
		this.user_id = user.getId();
		this.address = user.getAddress();
	}

}
 