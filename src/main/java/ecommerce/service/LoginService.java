package ecommerce.service;

public class LoginService {
/**
    // ResponseEntity<CostumerLoginResponseDTO> instead CostumerLoginResponseDTO
    public static ResponseEntity<CostumerLoginResponseDTO> loginCostumerService(CostumerLoginRequestDTO costumerLoginRequestDTO) {
        CostumerLoginResponseDTO costumerLoginResponseDTO = new CostumerLoginResponseDTO();

        Costumer costumer = CostumerDAO.loginCostumer(costumerLoginRequestDTO.getEmail(), costumerLoginRequestDTO.getPassword());

        if (costumer.getName() != null && costumer.getEmail() != null) {
            costumerLoginResponseDTO.setName(costumer.getName());
            costumerLoginResponseDTO.setEmail(costumer.getEmail());
            return ResponseEntity.ok(costumerLoginResponseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
*/
}
