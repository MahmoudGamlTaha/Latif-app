package com.commerce.backend.model.response.user;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.commerce.backend.model.dto.CityDTO;
import com.commerce.backend.model.dto.CountryDTO;
import com.commerce.backend.model.entity.Role;
import com.commerce.backend.model.entity.SubscriptionTypes;
import com.commerce.backend.model.entity.UserRole;
import com.commerce.backend.model.entity.UserSubscription;

import lombok.Data;

@Data
public class UserResponse {
	private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private CityDTO city;
    private CountryDTO country;
    private String state;
    private String zip;
    private String phone;
    private String username;
    private Boolean emailVerified;
    private Date    RegistrationDate;
    private String avatar;
    private Boolean active;
    private Set<Role> role;
    private Set<UserRole> roles;
    private Integer prodCount;
    private Boolean AdsPoserStatus;
    private Set<UserSubscription> subscriptions = new HashSet<>();
}
