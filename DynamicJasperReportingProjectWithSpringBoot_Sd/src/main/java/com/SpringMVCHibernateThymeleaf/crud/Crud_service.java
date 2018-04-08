package com.SpringMVCHibernateThymeleaf.crud;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Service
public class Crud_service {
	/*@Autowired
	Crud_repository c_repository;*/

	// public List<Crud_user>browsUser(){
	// return c_repository.findAll();
	// }

	public String savedata(List<Crud_Dto> user) throws NoSuchMethodException {
		
		try {

			Object cruduserObj = new Crud_user();
			String methodName = "";
			for (Crud_Dto p : user) {
				
				methodName = (String) p.getName();
				Method setNameMethod = cruduserObj.getClass().getMethod(methodName,String.class);
				setNameMethod.invoke(cruduserObj, p.getValue());
				System.out.println("HEY "+cruduserObj.toString());

			}
			//c_repository.save((Crud_user) cruduserObj);
			System.out.println(cruduserObj.toString());
			return  cruduserObj.toString();

		} catch (Exception e) {
			e.getMessage();
		}
		return null;
		

	}

	/*public List<Crud_user> browsUser() {
		// TODO Auto-generated method stub
		return c_repository.findAll();
	}*/

	@Transactional
	public JasperPrint generateOfferMemo(String user) {

		List<String> customerName = new ArrayList<>();
		customerName.add(user);
		Map<String, Object> parameterMap = new HashMap<>();
		parameterMap.put("name", user);
		/*parameterMap.put("loanTypeInsRate", loanEntity.getLoanTypeEntity().getInterestRate());
		parameterMap.put("loanAmount", loanEntity.getAppliedLoanAmount());
		parameterMap.put("loanTenor", loanEntity.getAppliedLoanTenor());
		parameterMap.put("branch", loanEntity.getBranchEntity().getBranchName());
		parameterMap.put("header", header);*/

		return settingUpJasper("/report/demo.jrxml", parameterMap, null);
	}

	public JasperPrint settingUpJasper(String reportNameWithPath, Map parameterMap, JRDataSource jrDataSource) {
		System.out.println("path: " + reportNameWithPath);
		InputStream jasperStream = this.getClass().getResourceAsStream(reportNameWithPath);
		System.out.println(jasperStream.toString());
		System.out.println("path: " + reportNameWithPath);
		JasperDesign jasperDesign = null;
		JasperReport jasperReport = null;
		try {
			jasperDesign = JRXmlLoader.load(jasperStream);
			jasperReport = JasperCompileManager.compileReport(jasperDesign);
			// jasperReport.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);
			JasperPrint jasperPrint;
			if (jrDataSource == null) {
				jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap);
			} else {
				jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, jrDataSource);
			}
			return jasperPrint;
		} catch (JRException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void whenConvertingToFile_thenCorrect(InputStream inputStream) throws IOException {

		byte[] buffer = new byte[inputStream.available()];
		inputStream.read(buffer);

		File targetFile = new File("C:\\Users\\Asad\\Desktop\\demo.txt");
		OutputStream outStream = new FileOutputStream(targetFile);
		outStream.write(buffer);
	}

	public int addtest(int p, int q) {

		return p + q;

	}

}
