package ecommerce.controller;

import ecommerce.requestDTO.CostumerLoginRequestDTO;
import ecommerce.responseDTO.CostumerLoginResponseDTO;
import ecommerce.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
/**
    @PostMapping("/costumer")
    public static ResponseEntity<CostumerLoginResponseDTO> loginCostumer(@RequestBody CostumerLoginRequestDTO costumerLoginRequestDTO) {
        return LoginService.loginCostumerService(costumerLoginRequestDTO);
    }

    @PostMapping("/admin")
    public static void loginAdmin() {

    }
*/
}
