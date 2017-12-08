package io.lms.catagory.micro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.lms.hibernate.course.CourseCatagoryRepository;
import io.lms.model.Response;
import io.lms.model.course.CourseCatagory;
import io.lms.service.BaseService;

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
@Component
// @Import(CourseCatagoryRepository.class)
public class CourseCatagoryService extends BaseService {

	@Autowired
	private CourseCatagoryRepository courseCatagoryRepository;

	@HystrixCommand(fallbackMethod = "alternateControllerMethod", commandKey = "listCourseCatagory", groupKey = "CourseCatagoryController")
	public Response listCourseCatagory(String name) throws Exception {
		int r1 = (int) (Math.random() * 5) + 3;
		if (r1 > 6) {
			throw new Exception("Test Exception random in list");
		}
		return new Response().setPayload(getCourseCatagoryList(name));
	}

	public void saveCourseCatagory(CourseCatagory courseCatagory) {
		getCourseCatagoryRepository().saveResource(courseCatagory);
	}

	public CourseCatagory getCourseCatagory(CourseCatagory courseCatagory) {
		return (CourseCatagory) getCourseCatagoryRepository().find(courseCatagory);
	}

	public List<CourseCatagory> getCourseCatagoryList(String name) {
		return getCourseCatagoryRepository().getResourceList(null, name, null, null, true, true);
	}

	/**
	 * @return the courseCatagoryRepository
	 */
	public CourseCatagoryRepository getCourseCatagoryRepository() {
		return courseCatagoryRepository;
	}

	/**
	 * @param courseCatagoryRepository
	 *            the courseCatagoryRepository to set
	 */
	public void setCourseCatagoryRepository(CourseCatagoryRepository courseCatagoryRepository) {
		this.courseCatagoryRepository = courseCatagoryRepository;
	}

}
