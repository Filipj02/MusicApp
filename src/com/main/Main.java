package com.main;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {


        Album album = new Album("Album1", "AC/DC");
        album.addSong("TNT", 4.5);
        album.addSong("Highway to hell", 3.5);
        album.addSong("ThunderStruck", 5.0);
        albums.add(album);

        album = new Album("Album2", "Eminem");

        album.addSong("Rap god", 4.0);
        album.addSong("Not Afraid", 2.5);
        album.addSong("Lose yourself", 5.5);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("TNT", playList_1);
        albums.get(0).addToPlayList("Highway to hell", playList_1);
        albums.get(1).addToPlayList("Rap god", playList_1);
        albums.get(0).addToPlayList("Lose yourself", playList_1);

        play(playList_1);
    }

    private static void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.size() == 0 ){
            System.out.println("this playlist is empty ");
        }else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("PlayList complete");
                    quit = true;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing" + listIterator.next().toString());
                    } else {
                        System.out.println("no song available ");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();

                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("No previous song ");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        } else System.out.println(" We are at the start of the list");
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("now playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("we have reached the end of list ");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playlist.size() > 0 ){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("now playing " + listIterator.next().toString());


                        }else {
                            if (listIterator.hasPrevious()) {
                                System.out.println("Now playing" + listIterator.previous().toString());
                            }
                        }
                    }

            }

            }
        }



    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song \n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song \n");
    }
    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("--------------------------------");

        while(iterator.hasNext()){
            System.out.println(iterator.next());

        }
        System.out.println("--------------------------------");
    }
}
