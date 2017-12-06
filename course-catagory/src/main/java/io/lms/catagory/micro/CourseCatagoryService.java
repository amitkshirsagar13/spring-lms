package io.lms.catagory.micro;

import java.util.List;

import org.springframework.stereotype.Component;

import io.lms.course.hibernate.CourseCatagoryRepository;
import io.lms.course.model.CourseCatagory;

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
public class CourseCatagoryService {

	// @Autowired
	private CourseCatagoryRepository courseCatagoryRepository;

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
