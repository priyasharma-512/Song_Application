package spotify_package;

public class song {
	
	//attributes for song
	private String title;
	private double duration;
	
	//create constructor for song class
	// we used paramitarised constructor coz its easy to set values for title and duration
	public song(String title, Double duration)
	{
		this.title = title;
		this.duration = duration;
	}
	
	//write getter and setter methods
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle()
	{
		this.title = title;
	}
	
	public Double getDuration()
	{
		return duration;
	}
	
	public void setDuration()
	{
		this.duration = duration;
	}
	
	// we are overriding tostring method
	//we want to print title and duration
	//there is default like Song song = new song("arijit", "12.3")
	//here if we want to print the sysout(s) -> this gives me address of song coz when this is called it goes to s.tostring but as I want to print title and song i override this tostring method
	public String toString()
	{
		return "song{" + 
					"Title = '" +title + '\'' +
					", duration = " + duration +
					'}';
				}
	}
	
