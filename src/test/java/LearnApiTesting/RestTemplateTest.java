package LearnApiTesting;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {
	private RestTemplate restTemplate;
	private UserDTO user;
	private String url="http://dummy.restapiexample.com/api/v1/";
	private LinkedMultiValueMap<String,String> header= new LinkedMultiValueMap();
			
	@Before
	public void setUp() {
		restTemplate=new RestTemplate();
		user=new UserDTO("Babylon", "34","5555");
		header.set("Content-Type", "application/json");
		
	}
	@Test()
	public void testRestTemplateCreate()
	{
		HttpEntity entity = new HttpEntity(user, header);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url+"create",HttpMethod.POST,entity,String.class);
		System.out.println(responseEntity.getStatusCodeValue());
		System.out.println(responseEntity.getBody());
	
		
		
	}
	@Test
	public void testRestTemplateRead()
	{
		ResponseEntity<String> responseEntity = restTemplate.exchange(url+"employees",HttpMethod.GET,null,String.class);
		System.out.println(responseEntity.getStatusCodeValue());
		System.out.println(responseEntity.getBody());
	
		
		
	}
	@Test
	public void testRestTemplateUpdate()
	{
		HttpEntity entity = new HttpEntity(user, header);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url+"update/21",HttpMethod.PUT,entity,String.class);
		System.out.println(responseEntity.getStatusCodeValue());
		System.out.println(responseEntity.getBody());
		ResponseEntity<String> responseEntity_g = restTemplate.exchange(url+"employees",HttpMethod.GET,null,String.class);
		System.out.println(responseEntity_g.getStatusCodeValue());
		System.out.println(responseEntity_g.getBody());
	
		
		
	}
	@Test
	public void testRestTemplateRemove()
	{
		ResponseEntity<String> responseEntity = restTemplate.exchange(url+"delete/2",HttpMethod.DELETE,null,String.class);
		System.out.println(responseEntity.getStatusCodeValue());
		System.out.println(responseEntity.getBody());
		ResponseEntity<String> responseEntity_g = restTemplate.exchange(url+"employee/2",HttpMethod.GET,null,String.class);
		System.out.println(responseEntity_g.getStatusCodeValue());
		System.out.println(responseEntity_g.getBody());
		
		
	}
	
	

}
