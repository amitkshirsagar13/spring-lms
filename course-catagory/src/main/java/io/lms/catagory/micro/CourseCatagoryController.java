package io.lms.catagory.micro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.lms.controller.BaseController;
import io.lms.model.Response;
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
public class CourseCatagoryController extends BaseController {

	@Autowired
	private CourseCatagoryService courseCatagoryService;

	@PreAuthorize("#oauth2.hasScope('write')")
	@RequestMapping(value = "/api/courseCatagory/save", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Response<List<CourseCatagory>> save(@RequestBody final CourseCatagory courseCatagory) throws Exception {
		getCourseCatagoryService().saveCourseCatagory(courseCatagory);
		return getCourseCatagoryService().listCourseCatagory(courseCatagory.getName());
	}

	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(value = "/api/courseCatagory/list", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Response<List<CourseCatagory>> list(String name) throws Exception {
		return getCourseCatagoryService().listCourseCatagory(name);
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
