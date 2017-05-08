package io.javabrains.springboot.starter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicsController {
	/*@RequestMapping("/topics")
	public String getAllTopics(){
		
		return "All Topics";
	}
*/
	@Autowired
	private TopicService topicService;
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		
		return topicService.getAllTopics();
}
	
	//Get request .Filtering based on id/
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id){
		
		System.out.println("topicService.getTopic(id)"+topicService.getTopic(id));
		return topicService.getTopic(id);
		
}
	//POST Request.Add new topic
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic){
		
		 topicService.addTopic(topic);
}	
	
	
	//PUT Request.UPDATE Existing topic
		@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
		public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
			
			 topicService.updateTopic(id,topic);
	}	
		
		//Delete Request.Delete Existing topic
				@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
				public void deleteTopic(@PathVariable String id){
					topicService.deleteTopic(id);
			}	
}