package tn.esprit.spring;

import org.junit.jupiter.api.Test;
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
    
    SecteurActivite secteur = new SecteurActivite(1L,"123","commercial",null);
		secteur.setIdSecteurActivite(1L);
		
		
		Mockito.when(SecteurRepository.findById(1L)).thenReturn(Optional.of(secteur));
		SecteurService.retrieveSecteurActivite(1L);
		Assertions.assertNotNull(secteur);
		
		System.out.println(secteur);
		System.out.println("Test 1 : ID retrival - work !");
	}

}
