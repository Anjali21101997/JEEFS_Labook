package com.cg.ovs.LoginModuleTest;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify; 
import static org.mockito.Mockito.when; 
import java.util.stream.Collectors; 
import java.util.stream.Stream; 
import org.junit.Test; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest; 
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.ovs.domain.UserDetail;
import com.cg.ovs.repository.UserDetailRepository;
import com.cg.ovs.service.UserRegisterService;
@SpringBootTest
public class RegisterServiceImplTest {
        @Autowired
		private UserRegisterService userregisterService;
		@MockBean
		private UserDetailRepository userDetailRepository;
		@Test 
		public void saveUserTest() 
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



}
