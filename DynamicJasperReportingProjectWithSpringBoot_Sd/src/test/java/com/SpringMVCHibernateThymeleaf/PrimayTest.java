package com.SpringMVCHibernateThymeleaf;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.SpringMVCHibernateThymeleaf.crud.Crud_Dto;
import com.SpringMVCHibernateThymeleaf.crud.Crud_service;
import com.SpringMVCHibernateThymeleaf.crud.Crud_user;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={Crud_service.class})
public class PrimayTest {
	@Autowired
	Crud_service crud_service;
	
	Crud_user  crud_user=new Crud_user();
	
	Crud_Dto crudDto=new Crud_Dto();
	Crud_Dto crudDto1= new Crud_Dto();
	List<Crud_Dto> listCrudDto=new ArrayList<>();
	
	
	@Test
	public void tessssss(){
		crudDto.setName("setName");
		crudDto.setValue("Razzak");
		crudDto1.setName("setAge");
		crudDto1.setValue("2");
		crud_user.setName("Razzak");
		crud_user.setAge("2");
		listCrudDto.add(crudDto);
		listCrudDto.add(crudDto1);
		
		try {
			assertThat(crud_service.savedata(listCrudDto)).isEqualTo(crud_user.toString());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	}
	

}
