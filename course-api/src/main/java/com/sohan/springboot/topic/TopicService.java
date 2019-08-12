package com.sohan.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
				new Topic("spring", "Spring Framework","Spring Description"),
				new Topic("java", "Core Java","Java Description"),
				new Topic("javascript", "Javascript Framework","Javascript Description")
				));
	
	public List<Topic> getAllTopic() {
		return topics;
	}

	public Topic getTopicById(String id) {
		return topics
					.stream()
					.filter(topic -> topic.getId()
									.equalsIgnoreCase(id))
					.findFirst()
					.get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		for(int i = 0; i < topics.size(); i++) {
			if(topics.get(i).getId().equals(id)) {
				topics.set(i, topic);
				break;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equalsIgnoreCase(id));
	}
}
