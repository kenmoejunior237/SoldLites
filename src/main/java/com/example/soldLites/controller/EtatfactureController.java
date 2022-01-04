package com.example.soldLites.controller;

import java.io.FileInputStream;
import java.util.Collection;
import java.util.HashMap;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.soldLites.service.RayonService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.*;

@Controller
public class EtatfactureController {
	
	RayonService rayonService;

	@GetMapping("/pdf")
	public String generatePDF() throws Exception, JRException {
		JRBeanCollectionDataSource jRBeanCollectionDataSource = new JRBeanCollectionDataSource(  rayonService.generatedRayonList());
		JasperReport compileReport =  JasperCompileManager.compileReport(new FileInputStream("src/main/resources/EtatFacture.jrxml"));
		HashMap<String, Object> map = new HashMap<>();
		JasperPrint report = JasperFillManager.fillReport(compileReport, map,jRBeanCollectionDataSource);
		JasperExportManager.exportReportToPdfFile(report, "etet.pdf");
		return "generated";
		
	}
}
