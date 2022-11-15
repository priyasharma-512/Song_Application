package spotify_package;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	
	private String name;
	private String artist;
	private ArrayList<song> songs;
	
	//constructors
	public Album(String name, String artist)
	{
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<>(); //coz initially there are no songs in arraylist while creation 
	}
	
	//find method
	public boolean findsong(String title)
	{
		//logic to find song in album
		// we dont write int or long or any other datatype coz the datatype fo songs array list is song
		//private ArrayList<song> songs; this one
		for(song checksong : this.songs)
		{
			//compare the title given and title already present using equals method if present then print song and return song
			if(checksong.getTitle().equals(title)) //title is of private sp we use getter method
			{
				System.out.print("Song found");
				return true;
			}		
		}
		//System.out.print("song not found");
		return false; // if we dont find the song
	}
	
	
	//add song method
	public boolean addsong(String title, double duration)
	{
		//first we need to check whether song is already there or not then only we can add it if not there 
		// to check this we have findsong method already we can use this
		if(findsong(title) == true)
		{
			System.out.print("Song already present");
			return false;
		}
		//if not then we need to add song to album
		//as the adding song is new song we need to create it and add it to list
		song newsong = new song(title,duration);
		this.songs.add(newsong);//using this keyword is optional
		return true;
		// we can also write this above statements as this.songs.add(song(title, duration)); no need to create another variable
	}
	//we can add a song to playlist if it is present in the album
	//if u know the name of the song u can add it to playlist using this method
	public boolean addToPlayList(String title, LinkedList<song> playlist)
	{
		//we can use find song function
		//if(findsong(title) == true)
			//playlist.add(null)
		// we cannot use this coz we want to have title and duration
		for(song checkedsong : this.songs)
		{
			if(checkedsong.getTitle().equals(title))
			{
				playlist.add(checkedsong);
			}
		}
		return false;	
	}
	
	//this is method overloading coz we already have same method but with diff parameters
	//this can be used if u only need number of the song
	public boolean addToPlayList(int tracknumber, LinkedList<song> playlist)
	{
		//we need to get the position of the song
		//arraylist is 0 based index
		//so position of 3rd song would be 2nd
		int index = tracknumber - 1;
		//check if index is valid or not i.e lies between 0 and n-1 where n is songs.size -1
		if(index >= 0 && index <= this.songs.size() - 1)
		{
			playlist.add(this.songs.get(index));
			return true;
		}
		return false;
	}
	
}
