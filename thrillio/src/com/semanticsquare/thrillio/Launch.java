package com.semanticsquare.thrillio;

import java.util.List;

import com.semanticsquare.bgjobs.WebpageDownloaderTask;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import com.semanticsquare.thrillio.managers.UserManager;

public class Launch {

	private static List<User> users;
	private static List<List<Bookmark>> bookmarks;
	
	private static void loadData() {
		System.out.println("1. Loading data..");
		DataStore.loadData();
		
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		
		//System.out.println("Printing data...");
		//printUserData();
		//printBookmarkData();
		
	}
	
	private static void printBookmarkData() {
		for(List<Bookmark> bookmarklist:bookmarks) {
			for(Bookmark bookmark:bookmarklist) {
				System.out.println(bookmark);
			}
		}
		
	}

	private static void printUserData() {
		for(User user:users) {
			System.out.println(user);
		}
		
	}
	
	private static void start() {
		//System.out.println("\n2. Bookmarking ...");
		for(User user:users) {
			View.browse(user, bookmarks);
		}
	}

	public static void main(String[] args) {
		loadData();
		start();
		
		//runDownloaderJob();

	}

	private static void runDownloaderJob() {
		WebpageDownloaderTask task=new WebpageDownloaderTask(true);
		(new Thread(task)).start();
		
	}

	

	

}
