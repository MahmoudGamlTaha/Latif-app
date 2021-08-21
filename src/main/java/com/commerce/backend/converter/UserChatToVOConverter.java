package com.commerce.backend.converter;
import java.util.HashMap;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.commerce.backend.dao.UserRepository;
import com.commerce.backend.model.dto.UserChatVO;
import com.commerce.backend.model.entity.User;
import com.commerce.backend.model.entity.UserChat;
@Component
public class UserChatToVOConverter implements Function<UserChat, UserChatVO> {
     
	@Autowired
     UserRepository userRepository; 
    
     HashMap<Long, User> hashMap = new HashMap<Long, User>();
     Long currentUserId;
    @Override
	public UserChatVO apply(UserChat userChat) {
		UserChatVO userChatVO = new UserChatVO();
		
		userChatVO.setId(userChat.getId());
		userChatVO.setMessage(userChat.getMessage());
		userChatVO.setReciverId(userChat.getReciverId());
		userChatVO.setItemId(userChat.getItemId());
		userChatVO.setRoom(userChat.getRoom());
		Long uId = userChat.getReciverId();
	    if(!hashMap.containsKey(uId)) {
	    
	    	if(uId == currentUserId) {
	    		uId = userChat.getSenderId();
	    	}
	    	User user =this.userRepository.findById(uId).orElse(null);
	    	hashMap.put(uId, user);
	    }
	    User userKey = hashMap.get(uId);
	    userChatVO.setReciverImage(userKey.getAvatar());
	    String lname = userKey.getLastName() == null ? "" : " " + userKey.getLastName();
	    userChatVO.setReciverName(userKey.getFirstName() + lname);
	    
	    if(hashMap.size()  > 3000) {
	    	hashMap.clear();
	    }
		userChatVO.setSenderId(userChat.getSenderId());
		userChatVO.setCreateAt(userChat.getCreateAt());
		return userChatVO;
	}
    public void setCurrentUserId(Long uid) {
    	this.currentUserId = uid;
    }

}
