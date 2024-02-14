package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = EshopApplication.class)
class EshopApplicationTests {

	@Autowired
	EshopApplication eshopApplication;

	@Test
	void contextLoads() {
		assertNotNull(eshopApplication);
	}
}
