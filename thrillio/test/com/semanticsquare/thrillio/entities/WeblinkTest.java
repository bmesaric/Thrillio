package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.managers.BookmarkManager;

class WeblinkTest {

	@Test
	void testIsKidFriendlyEligable() {
		//Test 1 porn in url --false
		Weblink weblink=BookmarkManager.getInstace().createWeblink(2000,"Taming Tiger, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html","http://www.javaworld.com");
		
		boolean isKidFriendlyEligable=weblink.isKidFriendlyEligable();
		
		assertFalse("For porn in url - isKidFriendlyEligable() must return false",isKidFriendlyEligable);
		//Test 2 porn in title --false
		weblink=BookmarkManager.getInstace().createWeblink(2000,"Taming porn, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
		
		isKidFriendlyEligable=weblink.isKidFriendlyEligable();
		
		assertFalse("For porn in title - isKidFriendlyEligable() must return false",isKidFriendlyEligable);
		
		
		//Test 3 adult in host --false
		weblink=BookmarkManager.getInstace().createWeblink(2000,"Taming Tiger, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.adult.com");
		
		isKidFriendlyEligable=weblink.isKidFriendlyEligable();
		
		assertFalse("For adult in host - isKidFriendlyEligable() must return false",isKidFriendlyEligable);
		
		
		//Test 4 adult in url, but not in host part --true
		weblink=BookmarkManager.getInstace().createWeblink(2000,"Taming Tiger, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html","http://www.jawaworld.com");
		
		isKidFriendlyEligable=weblink.isKidFriendlyEligable();
		
		assertTrue("For adult in url, but not host part - isKidFriendlyEligable() must return true",isKidFriendlyEligable);
		
		
		
		//Test 5 adult in title only --true
		weblink=BookmarkManager.getInstace().createWeblink(2000,"Taming adult, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.jawaworld.com");
		
		isKidFriendlyEligable=weblink.isKidFriendlyEligable();
		
		assertTrue("For adult in title - isKidFriendlyEligable() must return true",isKidFriendlyEligable);
		
	}

}
