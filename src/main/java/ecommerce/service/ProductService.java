package ecommerce.service;

import ecommerce.requestDTO.ProductRequestDTO;
import ecommerce.responseDTO.ProductResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
/**
    public static void serviceCreate(ProductRequestDTO productRequestDTO) {
        Product product = null;

        if(productRequestDTO != null) {
            product = new Product();
            product.setName(productRequestDTO.getName());
            product.setDescription(productRequestDTO.getDescription());
            product.setPrice(productRequestDTO.getPrice());
            product.setQuantity(productRequestDTO.getQuantity());
            ProductDAO.create(product);
        }
    }

    public static ProductResponseDTO serviceReadById(Long id) {
        ProductResponseDTO productResponseDTO = null;
        Product product = ProductDAO.read(id);

        if(product != null){
            productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setName(product.getName());
            productResponseDTO.setDescription(product.getDescription());
            productResponseDTO.setPrice(product.getPrice());
        }
    return productResponseDTO;
    }

    public static List<ProductResponseDTO> serviceListAll() {
        List<ProductResponseDTO> productResponseList = new ArrayList<ProductResponseDTO>();

        for(Product p: ProductDAO.readAll()){
            ProductResponseDTO productResponse = new ProductResponseDTO();
            productResponse.setName(p.getName());
            productResponse.setDescription(p.getDescription());
            productResponse.setPrice(p.getPrice());
            productResponseList.add(productResponse);
        }
        return productResponseList;
    }

    public static void serviceUpdate(ProductRequestDTO productRequestDTO, long id) {
            Product product = ProductDAO.read(id);

            if(product != null) {
                product.setName(productRequestDTO.getName());
                product.setDescription(productRequestDTO.getDescription());
                product.setPrice(productRequestDTO.getPrice());
                product.setQuantity(productRequestDTO.getQuantity());
                ProductDAO.update(product);
            }
    }

    public static void serviceDelete(long id) {
        ProductDAO.delete(id);
    }
*/
}
