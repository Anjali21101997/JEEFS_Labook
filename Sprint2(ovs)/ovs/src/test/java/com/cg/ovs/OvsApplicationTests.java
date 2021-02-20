package com.cg.ovs;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.ovs.domain.Address;
import com.cg.ovs.domain.UserDetail;
import com.cg.ovs.exception.EmailNotFoundException;
import com.cg.ovs.repository.UserDetailRepository;
import com.cg.ovs.service.UserLoginService;
import com.cg.ovs.service.UserRegisterService;

@SpringBootTest
class OvsApplicationTests {
	 @Autowired
	private UserRegisterService userregisterService;
	 @Autowired
	 private UserLoginService userLoginService;
	 
		@MockBean
		private UserDetailRepository userDetailRepository;

	@Test
	void contextLoads() {
	}
	 
    @Test
    public void registerServiceImplTest() 
			{ 
				UserDetail userDetail = new UserDetail();
				userDetail.setId(23);
				userDetail.setContact("9506500618");
				userDetail.setEmailId("anjali2110@gmail.com");
				userDetail.setLoginName("ANJSINGH");
				userDetail.setRole(2);
				userDetail.setPassword("Anjali21");
				when(userDetailRepository.save(userDetail)).thenReturn(userDetail); 
				assertEquals(userDetail, userregisterService.saveOrUpdate(userDetail));
				}
    @Test()
    public void LoginServiceImplTestFindByEmailMethodReturnsUserDetailObject() 
    {
    	UserDetail userDetail = new UserDetail();
		userDetail.setId(23);
		userDetail.setContact("9506500618");
		userDetail.setEmailId("anjali2110@gmail.com");
		userDetail.setLoginName("ANJSINGH");
		userDetail.setRole(2);
		userDetail.setPassword("Anjali21");
		when(userDetailRepository.findByEmailId("anjali2110@gmail.com")).thenReturn(userDetail);
		assertEquals(userDetail,userLoginService.viewByEmail("anjali2110@gmail.com"));
    	
    }
    @Test()
    public void LoginServiceImplTestDeleteProfileMethodReturnsUserDetailObject() 
    {
    	UserDetail userDetail = new UserDetail();
		userDetail.setId(23);
		userDetail.setContact("9506500618");
		userDetail.setEmailId("anjali2110@gmail.com");
		userDetail.setLoginName("ANJSINGH");
		userDetail.setRole(2);
		userDetail.setPassword("Anjali21");
		when(userDetailRepository.findByEmailId("anjali2110@gmail.com")).thenReturn(userDetail);
		assertEquals("Sucessfully deleted anjali2110@gmail.com" ,userLoginService.deleteProfile("anjali2110@gmail.com"));
    }
   
}
