import java.util.ArrayList;
import java.util.LinkedList;

public class Album 
{
    @SuppressWarnings("unused")
    private String name;
    @SuppressWarnings("unused")
    private String artist;
    private ArrayList<Song> songs;
    public Album(String name, String artist)
    {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }    
    public Album()
    {}
    public boolean addSongs(String songTitle, double songDuration)
    {
        if(findSong(songTitle) == null)
        {
            songs.add(new Song(songTitle, songDuration));
            // System.out.println(songTitle+" Song successfully added to the list ");
            return true;
        }
        else
        {
            // System.out.println(songTitle+" Song already exist in the list ");
            return false;
        }
    }
    public Song findSong(String songTitle) 
    {
        for(Song checkedSong : songs)
        {
            if(checkedSong.getSongTitle() != null && checkedSong.getSongTitle().equals(songTitle)) 
            {
                return checkedSong;
            }
        }
        return null;
    }
    public boolean addToPlaylists(int trackNumber, LinkedList<Song> playList)
    {
        int index = trackNumber - 1;
        if(index > 0 && index < this.songs.size())
        {
            playList.add(this.songs.get(index));
            return true;
        }
        // System.out.println("This album does not have song with the tracknumber : "+trackNumber);
        return false;
    }
    public boolean addToPlaylists(String songTitle, LinkedList<Song> playList)
    {
        for(Song checkedSong : this.songs)
        {
            if(checkedSong.getSongTitle().equals(songTitle))
            {
                playList.add(checkedSong);
                return true;
            }
        }
        // System.out.println(songTitle+ " There is no such songs in album");
        return false;
    }
}
