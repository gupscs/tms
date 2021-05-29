package br.silveira.tms.view;

import br.silveira.tms.dto.UserDto;

public class CommonView {
	
	private String locale = "pt_br";
	
	private UserDto userDto = new UserDto();

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	
	
	
	
	

}
