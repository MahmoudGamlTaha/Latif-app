package com.commerce.backend.converter.user;

import com.commerce.backend.model.dto.CityDTO;
import com.commerce.backend.model.dto.CountryDTO;
import com.commerce.backend.model.dto.CountryVO;
import com.commerce.backend.model.entity.Cites;
import com.commerce.backend.model.entity.Country;
import com.commerce.backend.model.entity.User;
import com.commerce.backend.model.response.user.UserResponse;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserResponseConverter implements Function<User, UserResponse> {
    @Override
    public UserResponse apply(User user) {
    	UserResponse userResponse = null;
    	if(user != null) {
	        userResponse = new UserResponse();
	        userResponse.setEmail(user.getEmail());
	        userResponse.setFirstName(user.getFirstName());
	        String lname = user.getLastName() == null? "" : user.getLastName();
	        userResponse.setLastName(lname);
	        String address = user.getAddress() == null? "" : user.getAddress();
	        userResponse.setAddress(address);
	        Cites city = user.getCity();
	        CityDTO cityDto = this.applyCityDto(city);
	        if(city!= null) {
	        	CountryDTO countryDto =this.applyCountryDto(city.getCountry());
	        	userResponse.setCountry(countryDto);
	        }
	        userResponse.setCity(cityDto);
	        userResponse.setState(user.getState());
	        userResponse.setZip(user.getZip());
	        userResponse.setPhone(user.getMobile());
	        userResponse.setUsername(user.getUsername());
	       
	        userResponse.setEmailVerified(user.getEmailVerified());
	        userResponse.setId(user.getId());
	        userResponse.setRegistrationDate(user.getRegistrationDate());
	        userResponse.setAvatar(user.getAvatar());
	        userResponse.setActive(user.isActive());
	     //   userResponse.setRole(user.getRoles());
	        if(user.getAds() != null) {
	        userResponse.setProdCount(user.getAds().size());
	        }
    	}
        return userResponse;
    	
    }
    private CityDTO applyCityDto(Cites city) {
    	CityDTO cityDto = new CityDTO();
    	if(city == null) {
    		return cityDto;
    	}
    	cityDto.setId(city.getId());
    	cityDto.setCityAr(city.getCityAr());
    	cityDto.setCityEn(city.getCityEn());
    	return cityDto;
    }
    private CountryDTO applyCountryDto(Country country) {
    	CountryDTO countryVo = new CountryDTO();
    	if(country == null) {
    		return countryVo;
    	}
    	countryVo.setNameAr(country.getNameAr());
    	countryVo.setNameEn(country.getNameEn());
        countryVo.setId(country.getId());
    	return countryVo;
    }
}
