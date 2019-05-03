package trangsuc.huynhdh.net.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import trangsuc.huynhdh.net.domain.Jewelry;
import trangsuc.huynhdh.net.repository.JewelryRepository;
import trangsuc.huynhdh.net.service.JewelryService;

@Controller
public class JewelryController {
	@Autowired
	private JewelryService jewelryService;

	@Autowired
	private JewelryRepository jewelryRepository;

	String NULL = null;
	
	String baseUrl = null;

	/**
	 * Home page
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping(value = { "/", "/jewelry" })
	public String home(HttpServletRequest request, Model model) {
		int pageNumber = 1;
		PagedListHolder<?> pages = null;
		pages = (PagedListHolder<?>) request.getSession().getAttribute("jewelrylst");
		int pagesize = 20;
		List<Jewelry> list = (List<Jewelry>) jewelryService.findAll();
		System.out.println(list.size());
		if (pages == null) {
			pages = new PagedListHolder<>(list);
			pages.setPageSize(pagesize);
		} else {
			final int goToPage = pageNumber - 1;
			if (goToPage <= pages.getPageCount() && goToPage >= 0) {
				pages.setPage(goToPage);
			}
		}
		request.getSession().setAttribute("jewelrylst", pages);
		int current = pages.getPage() + 1;
		int begin = Math.max(1, current - list.size());
		int end = Math.min(begin + 5, pages.getPageCount());
		int totalPageCount = pages.getPageCount();
		baseUrl = "/jewelry/page/";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("aass", pages);

		return "jewelry";
	}

	/**
	 * View pagging
	 * 
	 * @param request
	 * @param pageNumber
	 * @param model
	 * @return
	 */
	@GetMapping("/jewelry/page/{pageNumber}")
	public String showJewelryPage(HttpServletRequest request, @PathVariable int pageNumber, Model model) {
		PagedListHolder<?> pages = null;
		pages = (PagedListHolder<?>) request.getSession().getAttribute("jewelrys");
		int pagesize = 20;
		List<Jewelry> list = (List<Jewelry>) jewelryService.findAll();
		System.out.println(list.size());
		if (pages == null) {
			pages = new PagedListHolder<>(list);
			pages.setPageSize(pagesize);
		} else {
			final int goToPage = pageNumber - 1;
			if (goToPage <= pages.getPageCount() && goToPage >= 0) {
				pages.setPage(goToPage);
			}
		}
		request.getSession().setAttribute("jewelrys", pages);
		int current = pages.getPage() + 1;
		int begin = Math.max(1, current - list.size());
		int end = Math.min(begin + 5, pages.getPageCount());
		int totalPageCount = pages.getPageCount();
		baseUrl = "/jewelry/page/";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("aass", pages);

		return "jewelry";
	}

	/**
	 * Rendirect mapping
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/jewelry/import")
	public String rendirect() {
		return "import";
	}

	/**
	 * Import excel
	 * 
	 * @param request
	 * @param pageNumber
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/jewelry/importexcel")
	public String importJewelry(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {
		List<Jewelry> tempJewelryLst = new ArrayList<Jewelry>();
		XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		String price = null;
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			Jewelry tempJewelry = new Jewelry();
			System.err.println("Row" + i);
			XSSFRow row = worksheet.getRow(i);

			tempJewelry.setId((int) row.getCell(0).getNumericCellValue());
			tempJewelry.setGroup(row.getCell(1) != null ? row.getCell(1).getStringCellValue() : "");
			tempJewelry.setType(row.getCell(2) != null ? row.getCell(2).getStringCellValue() : "");
			tempJewelry.setName(row.getCell(3) != null ? row.getCell(3).getStringCellValue() : "");
			// convert cell numeric to string
			Cell cell = row.getCell(4);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			// convert cell numeric to string;
			price = cell.getStringCellValue() != null ? cell.getStringCellValue() : "";
			tempJewelry.setPrice(price);
			tempJewelry.setDescription(row.getCell(5) != null ? row.getCell(5).getStringCellValue() : "");
			tempJewelry.setImage(row.getCell(6) != null ? row.getCell(6).getStringCellValue() : "");
			tempJewelry.setCollection(row.getCell(7) != null ? row.getCell(7).getStringCellValue() : "");
			tempJewelry.setStonetype(row.getCell(8) != null ? row.getCell(8).getStringCellValue() : "");
			tempJewelry.setStonecolor(row.getCell(9) != null ? row.getCell(9).getStringCellValue() : "");
			tempJewelry.setStoneshape(row.getCell(10) != null ? row.getCell(10).getStringCellValue() : "");
			tempJewelryLst.add(tempJewelry);
		}
		jewelryRepository.saveAll(tempJewelryLst);
		return "redirect:/";
	}

}
