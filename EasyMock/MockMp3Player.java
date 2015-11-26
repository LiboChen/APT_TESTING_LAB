
import java.util.ArrayList;

public class MockMp3Player implements  Mp3Player{

  protected ArrayList<String> list = new ArrayList<String>();
  protected boolean on = false;
  protected double time_stamp = 0.0;
  protected int song_index =1;

  public void play(){
   if(list.size()>0)
    on = true;
   time_stamp=time_stamp+0.01;
  }


  public void pause(){
   on = false;
  }


  public void stop(){
   song_index = 1;
   on = false;

  }
  

  public double currentPosition(){
	return time_stamp;
  }


  public String currentSong(){
   return list.get(song_index);
  }


  public void next(){
   if(song_index<(list.size()-1))
	song_index++;
  }


  public void prev(){
  	if (song_index>0)
  	song_index--;
  }


  public boolean isPlaying(){
	return on;
  }

 
  public void loadSongs(ArrayList names){

		list=names;
	}
}
