package com.indix.FileHandler;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.indix.Model.Product;
import com.indix.utils.MergerDAO;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class OpenCSVParserExample {

	public static void main(String[] args) throws IOException {

		List<Product> emps = parseCSVFileLineByLine();
		System.out.println("**********");
		parseCSVFileAsList();
		System.out.println("**********");
		parseCSVToBeanList();
		System.out.println("**********");
		writeCSVData(emps);
	}

	private static void parseCSVToBeanList() throws IOException {
		
		HeaderColumnNameTranslateMappingStrategy<Product> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<Product>();
		beanStrategy.setType(Product.class);
		
		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("ID", "id");
		columnMapping.put("Name", "name");
		columnMapping.put("Role", "role");
		//columnMapping.put("Salary", "salary");
		
		beanStrategy.setColumnMapping(columnMapping);
		
		CsvToBean<Product> csvToBean = new CsvToBean<Product>();
		//send dynamic file address
		CSVReader reader = new CSVReader(new FileReader("employees.csv"));
		List<Employee> emps = csvToBean.parse(beanStrategy, reader);
		System.out.println(emps);
	}

	private static void writeCSVData(List<Product> emps) throws IOException {
		StringWriter writer = new StringWriter();
		CSVWriter csvWriter = new CSVWriter(writer,'#');
		List<String[]> data  = toStringArray(emps);
		csvWriter.writeAll(data);
		csvWriter.close();
		System.out.println(writer);
	}

	private static List<String[]> toStringArray(List<Product> emps) {
		List<String[]> records = new ArrayList<String[]>();
		//add header record
		records.add(new String[]{"ID","Name","Role","Salary"});
		Iterator<Product> it = emps.iterator();
		while(it.hasNext()){
			Product emp = it.next();
			records.add(new String[]{emp.getId(),emp.getName(),emp.getRole(),emp.getSalary()});
		}
		return records;
	}

	public static void parseCSVFileLineByLine(String filename) throws IOException, SQLException {
		//create CSVReader object
		CSVReader reader = new CSVReader(new FileReader(filename), ',');
		
		List<Product> products = new ArrayList<Product>();
		//read line by line
		String[] record = null;
		//skip header row
		reader.readNext();
		int counter =0;
		while((record = reader.readNext()) != null){
			Product product = new Product();
			product.setpId(record[0]);
			product.setTitle(record[1]);
			product.setUpcs(Integer.parseInt(record[2]));
			product.setCategoryld(Integer.parseInt(record[3]));
			product.setStoreld(Integer.parseInt(record[4]));
			product.setSeller(record[5]);
			product.setDate(new Date(Long.parseLong(record[6])));
			product.setPrice(Float.parseFloat(record[7]));
			products.add(product);
			counter++;
			if(counter==1000){
				MergerDAO.write(products);
				counter=0;
				products= new ArrayList<Product>();
			}
		}
		reader.close();
	}
	
	private static void parseCSVFileAsList() throws IOException {
		//create CSVReader object
		CSVReader reader = new CSVReader(new FileReader("employees.csv"), ',');

		List<Product> emps = new ArrayList<Product>();
		//read all lines at once
		List<String[]> records = reader.readAll();
		
		Iterator<String[]> iterator = records.iterator();
		//skip header row
		iterator.next();
		
		while(iterator.hasNext()){
			String[] record = iterator.next();
			Product product = new Product();
			this.pId = pId;
			this.title = title;
			this.upcs = upcs;
			this.categoryld = categoryld;
			this.storeld = storeld;
			this.seller = seller;
			this.date = date;
			this.price = price;
			emps.add(product);
		}
		
		reader.close();
		
		//System.out.println(emps);
	}

}
