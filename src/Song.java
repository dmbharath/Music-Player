public class Song 
{
    private String songTitle;
    private double songDuration;
    public Song(String songTitle, double songDuration)
    {
        this.songTitle = songTitle;
        this.songDuration = songDuration;
    }
    public Song()
    {}
    public String getSongTitle()
    {
        return songTitle;
    }
    public double getDuration()
    {
        return songDuration;
    }
    @Override
    public String toString()
    {
        return "Song{"+
                "Title ='" +songTitle +'\'' +
                ", Duration = "+songDuration +'}';
    }
}