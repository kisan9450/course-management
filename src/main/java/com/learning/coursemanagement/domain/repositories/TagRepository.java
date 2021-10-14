package com.learning.coursemanagement.domain.repositories;

import com.learning.coursemanagement.domain.Tag;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository {

	Tag addTag(Tag tag);

	Tag updateTag(String tagId, Tag tag);

	Tag deleteTag(String tagId);

	Tag getTag(String tagId);

}
