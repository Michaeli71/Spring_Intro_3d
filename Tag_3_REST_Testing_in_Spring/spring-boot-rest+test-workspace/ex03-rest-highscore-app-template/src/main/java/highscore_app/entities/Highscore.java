package highscore_app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public final class Highscore {

	@Id
	@GeneratedValue
	private long id;

	private String name;
	private int points;
	private int level;
	private LocalDate day;

	private Highscore()
	{		
	}
	
	public Highscore(final String name, final int points, final int level, final LocalDate day) {
		this.name = name;
		this.points = points;
		this.level = level;
		this.day = day;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Highscore [id=" + id + ", name=" + name + ", points=" + points + ", level=" + level + ", day=" + day
				+ "]";
	}
}
