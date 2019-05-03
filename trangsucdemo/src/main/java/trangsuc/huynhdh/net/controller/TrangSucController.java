package trangsuc.huynhdh.net.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import trangsuc.huynhdh.net.domain.TrangSucEntity;
import trangsuc.huynhdh.net.service.TrangSucService;


@Controller
public class TrangSucController {

	@Autowired
	private TrangSucService trangSucService;

	@RequestMapping("/")
	public String index(Model model) {
		List<TrangSucEntity> trangSuc = trangSucService.getAllTrangSuc();
		System.out.println("Looking in the index controller.........");
		model.addAttribute("trangSuc", trangSuc);

		return "index";
	}

	@RequestMapping(value = "addTrangSuc")
	public String addTrangSuc(Model model) {
		model.addAttribute("user", new TrangSucEntity());
		return "addTrangSuc";
	}

	@RequestMapping(value = "/editTrangSuc", method = RequestMethod.GET)
	public String editUser(@RequestParam("id") Long trangSucId, Model model) {
		Optional<TrangSucEntity> trangSucEdit = trangSucService.findTrangSucById(trangSucId);
		trangSucEdit.ifPresent(trangSuc -> model.addAttribute("trangSuc", trangSuc));
		return "editTrangSuc";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(TrangSucEntity trangSuc) {
		trangSucService.saveTrangSuc(trangSuc);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteTrangSuc(@RequestParam("id") Long trangSucId, Model model) {
		trangSucService.deleteTrangSuc(trangSucId);
		return "redirect:/";
	}
}
