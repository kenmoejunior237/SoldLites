package com.example.soldLites.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.soldLites.model.Rayon;
import com.example.soldLites.repository.RayonRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class RayonService {

	@Autowired
	private RayonRepository rayonRepository; 
	
	public List<Rayon> generatedRayonList(){
		return Arrays.asList(
				new Rayon("pomme"),
				new Rayon("jus"),
				new Rayon("chocolat"));
	}
	
	public Iterable<Rayon> getAllRayon(){
		return rayonRepository.findAll();
	}

	public Optional<Rayon> getRayonById(long id){
		return rayonRepository.findById(id);
	}
	
	public Rayon addRayon(Rayon rayon) {
		return rayonRepository.save(rayon);
	}
	public void deleteRayonById(long id) {
		rayonRepository.deleteById(id);
	}
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException{
		String path = "C:\\Users\\tantque\\Desktop\\Report";
		List<Rayon> rayon = rayonRepository.findAll();
		//load file and compile it
		File file = ResourceUtils.getFile("classpath:EtatFacture.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(rayon);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy","java Techie");
		JasperPrint jasperPring = JasperFillManager.fillReport(jasperReport, parameters, datasource);
		if(reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPring, path+"\\EtatFacture.html");
		}
		if(reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToHtmlFile(jasperPring, path+"\\EtatFacture.pdf");
		}
		
		return "report genereted in path: " +path;
	}

	

	public Rayon updateRayon(long id) {
		Optional<Rayon> optional = rayonRepository.findById(id);
		Rayon rayon = null;
		if(optional.isPresent()) {
			rayon = optional.get();
		}else {
			throw new RuntimeException("Rayon not found for id : : "+id);
		}
		return rayon;
	}
}
