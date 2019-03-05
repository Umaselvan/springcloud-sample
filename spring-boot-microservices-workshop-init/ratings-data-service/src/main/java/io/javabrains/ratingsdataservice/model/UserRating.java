package io.javabrains.ratingsdataservice.model;

import java.util.List;

public class UserRating {
	
	private List<Rating> userRatings;
	
	
	public UserRating() {
		super();
	}
	
	
	public UserRating(List<Rating> userRatings) {
		super();
		this.userRatings = userRatings;
	}
	
	public List<Rating> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<Rating> userRatings) {
		this.userRatings = userRatings;
	}



	@Override
	public String toString() {
		return "UserRating [userRatings=" + userRatings + "]";
	}
	
	

}
