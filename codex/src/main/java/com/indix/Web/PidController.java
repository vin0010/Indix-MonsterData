package com.indix.Web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.indix.Model.Product;
import com.indix.utils.ProductDAO;

@Controller
public class PidController {
	@Autowired
	ProductDAO dao;
	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because
	 * default request is GET
	 */

	/* It provides list of employees in model object */

	/*
	 * It displays object data into form for the given id. The @PathVariable
	 * puts URL data into variable.
	 */
	@RequestMapping(value = "/pid/{pid}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable int pid) throws JsonGenerationException, JsonMappingException, IOException {
		Product product = dao.get(pid);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(System.out, product);
		return null;
	}
}