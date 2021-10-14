package com.learning.coursemanagement.services;

import com.learning.coursemanagement.domain.Subject;
import com.learning.coursemanagement.domain.repositories.SubjectRepository;
import com.learning.coursemanagement.entrypoints.dto.SubjectDTO;
import com.learning.coursemanagement.entrypoints.response.SubjectResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * New Subject Instructor application service.
 */
@Service
public class SubjectService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubjectService.class);

	/**
	 * The Subject Instructor Repository for storing the entities.
	 */
	private SubjectRepository subjectRepository;

	/**
	 * Constructor for {@link SubjectService}
	 * @param subjectRepository injects {@link SubjectRepository}
	 */
	public SubjectService(SubjectRepository subjectRepository) {
		this.subjectRepository = subjectRepository;
	}

	public SubjectResponse createSubjectRequest(SubjectDTO subjectDTO) {
		Subject subject = new Subject(subjectDTO.getSubjectId(), subjectDTO.getSubjectName(), subjectDTO.getActive());
		subject = subjectRepository.addSubject(subject);
		return SubjectResponse.createInstance(subject);

	}

	public SubjectResponse updateSubjectRequest(String subjectId, SubjectDTO subjectDTO) {
		Subject subject = new Subject(subjectDTO.getSubjectId(), subjectDTO.getSubjectName(), subjectDTO.getActive());
		subject = subjectRepository.updateSubject(subjectId, subject);
		return SubjectResponse.createInstance(subject);

	}

	public SubjectResponse deleteSubjectRequest(String subjectId) {
		Subject subject = subjectRepository.deleteSubject(subjectId);
		return SubjectResponse.createInstance(subject);

	}

	public SubjectResponse getSubjectRequest(String subjectId) {
		Subject subject = subjectRepository.getSubject(subjectId);
		return SubjectResponse.createInstance(subject);

	}

}