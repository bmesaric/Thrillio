package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligable() {
		//Test 1 for horror genre --false
		Movie movie=BookmarkManager.getInstace().createMovie(3000,"Citizen Kane","",1941,new String[] {"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},MovieGenre.HORROR,8.5);
				
		boolean isKidFriendlyEligable=movie.isKidFriendlyEligable();
				
		assertFalse("For Horror genre - isKidFriendlyEligable() must return false",isKidFriendlyEligable);
		
		//Test 1 for Thrillers genre --false
		movie=BookmarkManager.getInstace().createMovie(3000,"Citizen Kane","",1941,new String[] {"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},MovieGenre.THRILLERS,8.5);
						
		isKidFriendlyEligable=movie.isKidFriendlyEligable();
						
		assertFalse("For Thrillers genre - isKidFriendlyEligable() must return false",isKidFriendlyEligable);
	}

}
