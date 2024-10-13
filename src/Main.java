import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ListIterator;

public class Main 
{
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args)
    {
        Album al1 = new Album("Album1", "ac/dc");
        al1.addSongs("TNT", 4.30);
        al1.addSongs("Highway to hell ", 3.40);
        al1.addSongs("TNT", 4.0);

        albums.add(al1);
        al1 = new Album("Album2", "Eminen");
        al1.addSongs("Rap god", 4.50);
        al1.addSongs("Not afraid", 3.50);
        al1.addSongs("Lose yourself", 4.0);
        albums.add(al1);

        LinkedList<Song> playList1 = new LinkedList<>();
        albums.get(0).addToPlaylists("TNT", playList1);
        albums.get(0).addToPlaylists("Highway to hell", playList1);
        albums.get(1).addToPlaylists("Rap god", playList1);
        albums.get(1).addToPlaylists("Lose yourself", playList1);

        play(playList1);
    }    
    private static void play(LinkedList<Song> playList)
    {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0)
        {
            System.out.println("This playlist has no song");
        }
        else
        {
            System.out.println("Now playing song "+listIterator.next().toString());
            printMenu();
        }
        while(!quit)
        {
            int action = sc.nextInt();
            sc.nextLine();
            switch(action)
            {
                case 0:
                System.out.println("Playlist completed");
                quit = true;
                break;
                case 1:
                if(!forward)
                {
                    if(listIterator.hasNext())
                    {
                        listIterator.next();
                    }
                    forward = true;
                }
                if(listIterator.hasNext())
                {
                    System.out.println("Now playing "+listIterator.next().toString());
                }
                else
                {
                    System.out.println("No song availabe here, reached to the end of the list");
                    forward = false;
                }
                break;
                case 2:
                if(forward)
                {
                    if(listIterator.hasPrevious())
                    {
                        listIterator.previous();
                    }
                    forward = false;
                }
                if(listIterator.hasPrevious())
                {
                    System.out.println("Now playing "+listIterator.previous().toString());
                }
                else
                {
                    System.out.println("We are the first song ");
                    forward = false;
                }
                break;
                case 3:
                if(forward)
                {
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now playing "+listIterator.previous().toString());
                        forward = false;
                    }
                    else 
                    {
                        System.out.println("We are the start of the song");
                    }
                }
                else
                {
                    if(listIterator.hasNext())
                    {
                        System.out.println("Now playing "+listIterator.next().toString());
                        forward = true;
                    }
                    else
                    {
                        System.out.println("We have reached the end of the list");
                    }
                }
                break;
                case 4:
                
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                if(playList.size() > 0)
                {
                    listIterator.remove();
                    if(listIterator.hasNext())
                    {
                        System.out.println("Now playing "+listIterator.next().toString());
                    }
                    else
                    {
                        if(listIterator.hasPrevious())
                        {
                            System.out.println("Now playing "+listIterator.previous().toString());
                        }
                    }
                }
            }
        }
        sc.close();
    }
    private static void printMenu()
    {
        System.out.println("Available options are : \n press");
        System.out.println("0 - to quit");
        System.out.println("1 - to play next song");
        System.out.println("2 - to play previous song");
        System.out.println("3 - to replay current song");
        System.out.println("4 - list of all the songs");
        System.out.println("5 - print all available options ");
        System.out.println("6 - to delete the song");
    }
    private static void printList(LinkedList<Song> playList)
    {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("--------------------------");
        while (iterator.hasNext()) 
        {
            System.out.println(iterator.next());    
        }
        System.out.println("--------------------------");
    }
}
