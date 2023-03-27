package com.apirestful.api;

import com.apirestful.api.Service.PolizaService;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {

        @Autowired
        private PolizaService polizaService;     
        @Test
	public void contextLoads() throws SQLException {
            
            int test1 = polizaService.generarPoliza(4353, 1, 9090);
            assertTrue(test1 == 1);
            
	}
        

}
