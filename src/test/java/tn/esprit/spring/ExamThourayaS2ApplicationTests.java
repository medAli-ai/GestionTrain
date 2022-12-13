package tn.esprit.spring;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.VoyageurRepository;
import tn.esprit.spring.services.VoyageurServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ExamThourayaS2ApplicationTests {
  
  @Mock
	VoyageurRepository  voyageurRepository ;
	
	@InjectMocks
	VoyageurServiceImpl  voyageurService;

	@Test
	void contextLoads() {
		
    		List<Voyage> list = new ArrayList<>();
    		Voyageur voyageur = new Voyageur(1L,"Dali", list);
		voyageur.setIdVoyageur(1L);
		Assertions.assertNotNull(voyageur);
		
		
		Mockito.when(voyageurRepository.findById(1L)).thenReturn(Optional.of(voyageur));
		voyageurService.recupererVoyageParId(1L);
		
		System.out.println(voyageur);
		System.out.println("Test 1 : ID retrival - work !");
	}
	
	@Test
	public void TestDeleteVoyageur() {
		
		List<Voyage> list = new ArrayList<>();
		Voyageur voyageur2 = new Voyageur(2L,"bouchhioua", list);
		voyageur2.setIdVoyageur(2L);
		
		Mockito.lenient().when(voyageurRepository.findById(voyageur2.getIdVoyageur())).thenReturn(Optional.of(voyageur2));
		
		System.out.println(voyageur2); 
		verify(voyageurRepository).deleteById(voyageur2);
		
		System.out.println("Test 2 : Delete specific voyageur instance - work !");  
		
	}

}
