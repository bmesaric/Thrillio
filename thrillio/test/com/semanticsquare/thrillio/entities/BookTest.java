package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.managers.BookmarkManager;

class BookTest {

	@Test
	void testIsKidFriendlyEligable() {
		//Test 1 
		Book book=BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String [] {"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
												
		boolean isKidFriendlyEligable=book.isKidFriendlyEligable();
						
		assertFalse("For Philosophy genre - isKidFriendlyEligable() must return false",isKidFriendlyEligable);
				
		//Test 2 
		book=BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String [] {"Henry David Thoreau"}, BookGenre.SELF_HELP, 4.3);
								
		isKidFriendlyEligable=book.isKidFriendlyEligable();
								
		assertFalse("For Self help genre - isKidFriendlyEligable() must return false",isKidFriendlyEligable);
	}

}
