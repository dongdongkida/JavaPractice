import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MediaPlayer {
    private String name;
    private LinkedList<Song> playlist;


    public MediaPlayer(String name, LinkedList<Song> playlist) {
        this.name = name;
        this.playlist = playlist;
    }

    public void playing() {
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = this.playlist.listIterator();
        Scanner scanner = new Scanner(System.in);
        showMenu();
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(this.playlist.isEmpty()) {
                System.out.println("No song in your playlist3.");
            }else {
                switch (choice) {
                    case 0:
                        System.out.println("Quiting ... ");
                        quit = true;
                        break;
                    case 1:
                        if (forward) {
                            if (listIterator.hasPrevious()) {
                                loopPlaying(false, listIterator); //if played forward, play backward;
                            } else {
                                listIterator.next();// if at start of list, move cursor one step back, then play backward
                                loopPlaying(false, listIterator);
                            }
                            forward = false;

                        } else {
                            if (listIterator.hasNext()) {
                                loopPlaying(true, listIterator); // if played backward, play forward;
                            } else {
                                listIterator.previous();
                                loopPlaying(true, listIterator);
                            }
                            forward = true;
                        }
                        break;
                    case 2:
                        if (!forward) {
                            if (listIterator.hasNext()) {
                                listIterator.next();
                            }
                            forward = true;
                        }
                        listIterator = loopListIterator(true, listIterator);
                        loopPlaying(true, listIterator);
                        break;
                    case 3:
                        if (forward) {
                            if (listIterator.hasPrevious()) {
                                listIterator.previous();
                            }
                            forward = false;
                        }
                        listIterator = loopListIterator(false, listIterator);
                        loopPlaying(false, listIterator);
                        break;
                    case 4:
                    if(playlist.size()>0) {
                        if(forward){
                            if(listIterator.previousIndex() == -1) {
                                String songName = listIterator.next().getTitle();
                                listIterator.remove();
                                System.out.println(songName + " deleted");
                            } else {
                                String songName = listIterator.previous().getTitle();
                                listIterator.remove();
                                System.out.println(songName + " deleted");
                                forward = false;
                            }
                        } else {
                            if(listIterator.nextIndex() == this.playlist.size()) {
                                String songName = this.playlist.listIterator().next().getTitle();
                                listIterator.remove();
                                System.out.println(songName + " deleted");
                                forward = true;
                            } else {
                                String songName = listIterator.next().getTitle();
                                listIterator.remove();
                                System.out.println(songName + " deleted");
                                forward = true;
                            }
                        }



                    }
                    break;
                    case 5:
                        printList(playlist);
                        break;
                    default:
                        showMenu();
                        break;
                }
            }
        }
    }

    private ListIterator<Song> loopListIterator (boolean forward, ListIterator<Song> listIterator) {
        if(forward) {
            if (listIterator.hasNext()) {
                return listIterator;
            } else {
                System.out.println("End of playlist");
                return this.playlist.listIterator(); //move cursor to start of list
            }
        } else {
            if(listIterator.hasPrevious()) {
                return listIterator;
            } else {
                System.out.println("Start of playlist");
                listIterator = this.playlist.listIterator(this.playlist.size()); // mover cursor to end of list
                return listIterator;
            }
        }
    }
    private void loopPlaying (boolean forward, ListIterator<Song> listIterator) {
        if(forward) {
            Song song =listIterator.next();
                System.out.println("Currently playing " + song.toString());
        } else {
            Song song = listIterator.previous();
                System.out.println("Currently playing " + song.getTitle() + "   " + song.getDurationOfSong());
        }
    }


    private void showMenu () {
        System.out.println("Welcome to " + this.name);
        System.out.println("Please enter the number in front of option to continue\n" +
                "0. Quit\n" +
                "1. Play the current song\n" +
                "2. Skip forward\n" +
                "3. Skip backward\n" +
                "4. Remove current song from playlist\n" +
                "5. Show playlist\n");
    }

    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("==============================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("==============================");
    }
}


