package it.engineering.spring.mvc.ds.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.engineering.spring.mvc.ds.dto.ContactPersonDto;
import it.engineering.spring.mvc.ds.dto.ManufacturerDto;
import it.engineering.spring.mvc.ds.service.ContactPersonService;
import it.engineering.spring.mvc.ds.service.ManufacturerService;
import it.engineering.spring.mvc.ds.validator.ContactPersonValidator;

@Controller
@RequestMapping(path = {"/contact"})
public class ContactPersonController {

	private final ContactPersonService contactPersonService;
	private final ManufacturerService manufacturerService;
	
	@Autowired
	public ContactPersonController(ContactPersonService contactPersonService, ManufacturerService manufacturerService) {
		super();
		this.contactPersonService = contactPersonService;
		this.manufacturerService = manufacturerService;
	}
	
	@GetMapping(path = "/add")
	public ModelAndView add() throws Exception {
		ModelAndView modelAndView = new ModelAndView("contact/contact-add");
		return modelAndView;
	}
	
	@GetMapping(path = "/list")
	public ModelAndView list() throws Exception {
		List<ContactPersonDto> contacts = contactPersonService.getAll();
		ModelAndView modelAndView = new ModelAndView("contact/contact-list");
		modelAndView.addObject("contacts", contacts);		
		return modelAndView;
	}
	
	@GetMapping(path = "/details/id/{id}")
	public ModelAndView details(@PathVariable (name = "id") Long id) throws Exception {
		System.out.println("================================ DETAILS ==============================");
		System.out.println("ID: " + id);
		
		ContactPersonDto contactPersonDto = contactPersonService.findById(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contact/contact-details");
		modelAndView.addObject("contactPersonDto", contactPersonDto);
		
		return modelAndView;
	}
	
	@GetMapping(path = "/edit/id/{id}")
	public ModelAndView edit(@PathVariable (name = "id") Long id) throws Exception {
		System.out.println("================================ EDIT ==============================");
		System.out.println("ID: " + id);
		
		ContactPersonDto contactPersonDto = contactPersonService.findById(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contact/contact-edit");
		modelAndView.addObject("contactPersonDto", contactPersonDto);
		return modelAndView;
	}
	
	@PostMapping(path = "/confirm")
	public ModelAndView confirm(@Valid @ModelAttribute(name = "contactPersonDto")   ContactPersonDto contactPersonDto, 
								Errors errors) throws Exception {
		System.out.println("================================ CONFIRM ==============================");
		System.out.println("contactPersonDto:" + contactPersonDto);
		System.out.println("=======================================================================");
		
		String view = "contact/contact-add";
		ModelAndView modelAndView = new ModelAndView();
		if(errors.hasErrors()) {
			System.out.println("Imamo greske kod validacije...");
			if (contactPersonDto.getId()!=null) view = "contact/contact-edit";
		}else view = "contact/contact-confirm";
		
		modelAndView.setViewName(view);
		return modelAndView;
	}
	
	/*
	 * @GetMapping(path = "/delete") public String delete(HttpServletRequest
	 * request) { System.out.println("Contact id = " + request.getParameter("id"));
	 * ContactPersonDto contactPersonDto =
	 * contactPersonService.findById(Long.parseLong(request.getParameter("id"))); if
	 * (contactPersonDto==null) {
	 * 
	 * }else { request.setAttribute("contactPersonDto", contactPersonDto);
	 * contactPersonService.delete(contactPersonDto); } return "contact-list"; }
	 */
	
	@PostMapping(path = "/saveOrUpdate")
	public ModelAndView saveOrUpdate(@Valid @ModelAttribute(name = "contactPersonDto")  ContactPersonDto contactPersonDto, 
			Errors errors)throws Exception {
		System.out.println(contactPersonDto+"----------");
		ModelAndView modelAndView = new ModelAndView();
		
		String view = "contact/contact-add";
		
		if(errors.hasErrors()) {
			System.out.println("Imamo greske kod validacije");
			if(contactPersonDto.getId() != null) view = "contact/contact-edit";
		}else {
			if(contactPersonDto.getId() == null) {
				this.contactPersonService.save(contactPersonDto);
				view = "contact/contact-add";
			}else {
				contactPersonDto = this.contactPersonService.update(contactPersonDto);
				view = "contact/contact-add" ;
			}
		}
		modelAndView.setViewName(view);
		
		
		return modelAndView;
	}
	
	@ModelAttribute(name="manufactures")
	public List<ManufacturerDto> getManufactures()throws Exception{
		return this.manufacturerService.getAll();
	}
	
	@ModelAttribute(name = "contactPersonDto")
	private ContactPersonDto contactPersonDto() {
		System.out.println("*****************************************************");
		System.out.println("Kreiran je: @ModelAttribute(name = \"contactPersonDto\")");
		
		ContactPersonDto contactPersonDto = new ContactPersonDto();
		contactPersonDto.setFirstname("N/A");
		contactPersonDto.setLastname("N/A");
		return contactPersonDto;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("====================== @InitBinder ====================");
		System.out.println("public void initBinder(WebDataBinder binder)");
		binder.addValidators(new ContactPersonValidator());
		
	}
	
	
}
