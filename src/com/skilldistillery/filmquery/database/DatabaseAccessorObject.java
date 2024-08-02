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

		Film film =null;

		try {
		    String user = "student";
		    String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sqltext;
			sqltext = "SELECT film.id, film.title, film.description, film.release_year, language.name, film.length, film.rating "
					+ "FROM film JOIN language ON language.id = film.language_id "
					+ " WHERE film.id = ?"; /////
			PreparedStatement stmt = conn.prepareStatement(sqltext);
		    stmt.setInt(1, filmId);
		    System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				 film = new Film();
				film.setId(rs.getInt(1));
				film.setTitle(rs.getString(2));
				film.setDescription(rs.getString(3));
				film.setReleaseYear(rs.getInt(4));
				film.setLanguage(rs.getString(5));
				film.setLength(rs.getInt(6));
				film.setRating(rs.getString(7));
				System.out.println(film.toString());
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

		Actor actor = null;
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
				actor = new Actor();
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
		List<Actor> actors = new ArrayList <>();
		try {
		    String user = "student";
		    String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sqltext;
			sqltext = "SELECT actor.id,film.title, first_name, last_name FROM actor "
					+ "JOIN film_actor ON actor.id = film_actor.actor_id "
					+ "JOIN film ON film_actor.film_id = film.id"
					+ " WHERE film.id =?"; /////
			PreparedStatement stmt = conn.prepareStatement(sqltext);
		    stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setId(rs.getInt(1));
			     String fname = rs.getString(3);
			     String lname = rs.getString(4);
			      Actor actor = new Actor( fname, lname,film.getFilmId());
			      actors.add(actor);
			     
			
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actors;
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

	@Override
	public List<Film> findByKeyword(String keyword) {
		List<Film> films = new ArrayList <>();

		try {
		    String user = "student";
		    String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sqltext;
			sqltext = " SELECT film.id, film.title, film.description, release_year, length, rating  FROM film WHERE title LIKE ? or description LIKE ?";
			keyword = "%"+ keyword + "%";
			PreparedStatement stmt = conn.prepareStatement(sqltext);
		    stmt.setString(1, keyword);
		    stmt.setString(2, keyword);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
			 Film film = new Film();
				film.setId(rs.getInt(1));
				film.setTitle(rs.getString(2));
				film.setDescription(rs.getString(3));
				film.setReleaseYear(rs.getInt(4));
				film.setLength(rs.getInt(5));
				film.setRating(rs.getString(6));
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return films;
	}

}
