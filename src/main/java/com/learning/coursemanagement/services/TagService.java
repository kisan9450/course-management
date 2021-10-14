package com.learning.coursemanagement.services;

import com.learning.coursemanagement.domain.Tag;
import com.learning.coursemanagement.domain.repositories.TagRepository;
import com.learning.coursemanagement.entrypoints.dto.TagDTO;
import com.learning.coursemanagement.entrypoints.response.TagResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * New Tag Instructor application service.
 */
@Service
public class TagService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TagService.class);

	/**
	 * The Tag Instructor Repository for storing the entities.
	 */
	private TagRepository tagRepository;

	/**
	 * Constructor for {@link TagService}
	 * @param tagRepository injects {@link TagRepository}
	 */
	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	public TagResponse createTagRequest(TagDTO tagDTO) {
		Tag tag = new Tag(tagDTO.getTagId(), tagDTO.getTagName(), tagDTO.getActive());
		tag = tagRepository.addTag(tag);
		return TagResponse.createInstance(tag);

	}

	public TagResponse updateTagRequest(String tagId, TagDTO tagDTO) {
		Tag tag = new Tag(tagDTO.getTagId(), tagDTO.getTagName(), tagDTO.getActive());
		tag = tagRepository.updateTag(tagId, tag);
		return TagResponse.createInstance(tag);

	}

	public TagResponse deleteTagRequest(String tagId) {
		Tag tag = tagRepository.deleteTag(tagId);
		return TagResponse.createInstance(tag);

	}

	public TagResponse getTagRequest(String tagId) {
		Tag tag = tagRepository.getTag(tagId);
		return TagResponse.createInstance(tag);

	}

}