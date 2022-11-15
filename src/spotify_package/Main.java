package spotify_package;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//create instances of album
		Album album1 = new Album("album1","arigit singh");
		album1.addsong("alone", 5.2);
		album1.addsong("kesariya", 3.5);
		album1.addsong("ae dil hei mushkil", 5.3);
		
		//create a playlist initially empty
		LinkedList<song> myPlayList = new LinkedList<>();
		
		// add songs to playlist
		album1.addToPlayList("alone", myPlayList);
		album1.addToPlayList("kesariya", myPlayList);
		//System.out.print(album1.addToPlayList("xyz", myPlayList));
		
		//printList(myPlayList);
		
		play(myPlayList);
		
	}
	
	public static void play(LinkedList<song> playList)
	{
		//check if song is there or not
		//create an iterator
		Scanner sc = new Scanner(System.in);
		ListIterator<song> itr = (ListIterator<song>) playList.iterator();
		if(!itr.hasNext())
		{
			System.out.println("Playlist is empty");
			return ;
		}
		System.out.println("You are listening to the song " + itr.next().getTitle() + "\nEnjoy Uninterrupted Listening!!");
		showMenu();
		
		while(true)
		{
			int option = sc.nextInt();
			
			switch(option)
			{
			case 0: 
				System.out.print("Thank you for Listening!");
				return;
				
			case 1: 
				showMenu();
				break;
				
			case 2:
				printList(playList);
				break;
				
			//case 3:
				
				
			}
		}
	}
	
	public static void printList(LinkedList<song> playList)
	{
		ListIterator<song> itr = (ListIterator<song>) playList.iterator();
		while(itr.hasNext()) //we are traversing till we have the songs so use hasnext
		{
			System.out.println(itr.next());
		}
		return;
	}
	public static void showMenu()
	{
		System.out.println("0. Exit");
		System.out.println("1. printMenu");
		System.out.println("2. Show the list of all songs in playlist");
		System.out.println("3. Play next song");
		System.out.println("4. Play previous song");
		System.out.println("5. Repeat the song");
		System.out.println("6. Delete the song");
	}
}
