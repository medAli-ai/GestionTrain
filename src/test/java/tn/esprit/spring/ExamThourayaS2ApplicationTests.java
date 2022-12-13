package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.repository.VoyageurRepository;
import tn.esprit.spring.services.VoyageurServiceImpl;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ExamThourayaS2ApplicationTests {
  
  @Mock
	VoyageurRepository  voyageurRepository ;
	
	@InjectMocks
	VoyageurServiceImpl  voyageurService;

	@Test
	void contextLoads() {
    
    		Voyageur voyageur = new Voyageur(null,123,"Dali Bouchhioua");
		voyageur.setIdVoyageur(1L);
		
		
		Mockito.when(voyageurRepository.findById(1L)).thenReturn(Optional.of(voyageur));
		voyageurService.recupererVoyageParId(1L);
		Assertions.assertNotNull(voyageur);
		
		System.out.println(voyageur);
		System.out.println("Test 1 : ID retrival - work !");
	}

}
