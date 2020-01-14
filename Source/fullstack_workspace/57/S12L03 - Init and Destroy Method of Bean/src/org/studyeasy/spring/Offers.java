package org.studyeasy.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("offers")
public class Offers {
	private String offer = new String("No current offers");

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}
    @PostConstruct
	public void initMe(){
		System.out.println("Init Me Method Called");
	}
	@PreDestroy
	public void doSomethingBeforeDestroy(){
		System.out.println("Do Something Before Destroy");
	}
}
