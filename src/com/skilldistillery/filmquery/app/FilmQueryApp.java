package com.skilldistillery.filmquery.app;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		FilmQueryApp app = new FilmQueryApp();

//		app.test();
		app.launch();
	}

	private void test() throws ClassNotFoundException, SQLException {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

	private void launch() throws ClassNotFoundException, SQLException {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) throws ClassNotFoundException, SQLException {
		Scanner kb = new Scanner(System.in);
		boolean keepGoing = true;
		
		do {
			System.out.println("Enter a number 1,2, or 3") ;
			System.out.println("1: find a film by the ID number");
			System.out.println("2: find a actor by their ID number");
			System.out.println("3: find a actors by the film ID number");
			int userInput = kb.nextInt();
			switch (userInput) {
			case 1:
				System.out.println("Enter a film id: ");
				int filmId = kb.nextInt();
				Film film = db.findFilmById(filmId);
				System.out.println(film);
			case 2:
				System.out.println("Enter a actor id: ");
				int actorId = kb.nextInt();
				Actor actor = db.findActorById(actorId);
				System.out.println(actor);
			case 3:
				System.out.println("Enter a film id: ");
				int filmIdActors = kb.nextInt();
				List<Actor> actors =db.findActorsByFilmId(filmIdActors);
				System.out.println(actors);
			default: 
				System.out.println("Quiting appplication");
				
			}
			
		}while (keepGoing);
	}

}
