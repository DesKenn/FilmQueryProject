package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String user = "student";
	private static final String pass = "student";
	
	public void DatabaseAccessorObject() throws ClassNotFoundException{

		Class.forName("com.mysql.cj.jdbc.Driver");

	}
	@Override
	public Film findFilmById(int filmId) throws ClassNotFoundException, SQLException {

		Film film = new Film();
//		Film film =null;

		try {
		    String user = "student";
		    String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sqltext;
			sqltext = "SELECT film.id, film.title, film.description, film.release_year, film.language_id, film.length, film.rating FROM film"
					+ " WHERE film.id = ?"; /////
			PreparedStatement stmt = conn.prepareStatement(sqltext);
		    stmt.setInt(1, filmId);
		    System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				film.setId(rs.getInt(1));
				film.setTitle(rs.getString(2));
				film.setDescription(rs.getString(3));
				film.setReleaseYear(rs.getInt(4));
				film.setLangId(rs.getInt(5));
				film.setLength(rs.getInt(6));
				film.setRating(rs.getString(7));
				System.out.println(+ film.getId() +   film.getTitle() + film.getDescription()+  film.getReleaseYear() 
				 + film.getLangId() + film.getId());
				    }
			rs.close();
			stmt.close();
			rs.close();

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return film;

	}

	public Actor findActorById(int id) {

		Actor actor = new Actor();
//		Actor actor = null;
		try {
		    String user = "student";
		    String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sqltext;
			sqltext = "SELECT actor.id, first_name, last_name FROM actor "
					+ "WHERE actor.id =?"; /////
			PreparedStatement stmt = conn.prepareStatement(sqltext);
		    stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
//				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
				actor.setId(rs.getInt(1));
				actor.setFname(rs.getString(2));
				actor.setLname(rs.getString(3));
				System.out.println("The actor's Id is " + actor.getId() +". The actor's name is " + actor.getFname()+ " "+ actor.getLname());
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actor;

	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actor = new ArrayList <>();
		try {
		    String user = "student";
		    String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sqltext;
			sqltext = "SELECT actor.id, first_name, last_name FROM actor "
					+ "JOIN film_actor ON actor.id = film_actor.actor_id "
					+ "JOIN film ON film_actor.film_id = film.id"
					+ "WHERE film.id =?"; /////
			PreparedStatement stmt = conn.prepareStatement(sqltext);
		    stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			rs.close();
			stmt.close();
			rs.close();

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actor;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Unable to load database driver:");
			e.printStackTrace();
			System.err.println("Exiting.");
			System.exit(1); // No point in continuing.
		}
	}

}
