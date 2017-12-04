package io.lms.micro.catagory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.lms.model.course.CourseCatagory;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName course-catagory
 * Creation date: Dec 4, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

@RestController
public class CourseCatagoryController {

	@Autowired
	private CourseCatagoryService courseCatagoryService;

	@RequestMapping(value = "/api/courseCatagory/save", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public List<CourseCatagory> save(@RequestBody final CourseCatagory courseCatagory) {
		getCourseCatagoryService().saveCourseCatagory(courseCatagory);

		return getCourseCatagoryService().getCourseCatagoryList("string");
	}

	@RequestMapping(value = "/api/courseCatagory/list", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public List<CourseCatagory> list(String name) {
		return getCourseCatagoryService().getCourseCatagoryList(name);
	}

	/**
	 * @return the courseCatagoryService
	 */
	public CourseCatagoryService getCourseCatagoryService() {
		return courseCatagoryService;
	}

	/**
	 * @param courseCatagoryService
	 *            the courseCatagoryService to set
	 */
	public void setCourseCatagoryService(CourseCatagoryService courseCatagoryService) {
		this.courseCatagoryService = courseCatagoryService;
	}
}
