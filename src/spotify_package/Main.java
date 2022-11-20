package spotify_package;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//create instances of album
		Album album1 = new Album("album1","arigit singh");
		album1.addsong("song1", 5.2);
		album1.addsong("song2", 3.5);
		album1.addsong("song3", 5.3);
		album1.addsong("song4", 5.4);
		album1.addsong("song5", 4.2);
		album1.addsong("song6", 5.6);
		
		
		
		//create a playlist initially empty
		LinkedList<song> myPlayList = new LinkedList<>();
		
		// add songs to playlist
		album1.addToPlayList("song1", myPlayList);
		album1.addToPlayList("song2", myPlayList);
		album1.addToPlayList("song3", myPlayList);
		album1.addToPlayList("song4", myPlayList);
		album1.addToPlayList("song5", myPlayList);
		
		
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
		
		boolean forward = true;
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
				
			case 3:
				if(!forward)
				{
					if(itr.hasNext())
					itr.next();//move one place ahead to remove repetition
				}
					
				if(!itr.hasNext())
				{
					System.out.println("You have reached end of PlayList");
				}
				else
				{
					System.out.println("You are listening to " + itr.next());
				}
				forward = true;
				break;
				//if first we should check the Boolean and if the value is true then the previous action is next if it is false 
				//then previous action is previous option if next have Boolean false then 
				//we do next next and if prev have true value then also we do two prev right	
			case 4:
				if(forward)
				{
					if(itr.hasPrevious()) //before moving just check if there is a song or not in prevoius
					itr.previous();
				}
				if(!itr.hasPrevious())
				{
					System.out.println("You have reached the start of PlayList");
				}
				else
				{
					System.out.println("You are listening to " + itr.previous());
				}
				forward = false;
				break;
				// case 5 is to repeat the song
				
			case 5:
				if(forward)
				{
					if(itr.hasPrevious())
					{
						System.out.println("Now playing " +itr.previous().toString());
						forward = false;
					}
					else
					{
						System.out.println("We are at the start of the list");
					}
				}
				else
				{
					if(itr.hasNext())
					{
						System.out.println("Now playing "+itr.next().toString());
						forward = true;
					}
					else
					{
						System.out.println("We have reached to the end of the list");
					}
				}
				break;
			
			case 6:
				if(playList.size() > 0)
				{
					itr.remove();
					if(itr.hasNext())
					{
						System.out.println("Now playing " +itr.next().toString());
					}
					else
					{
						if(itr.hasPrevious())
						{
							System.out.println("Now playing " +itr.previous().toString());
						}
					}
				}
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
