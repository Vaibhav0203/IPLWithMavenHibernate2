package entities;
//Player fields : id,email,firstName,lastName,dob,battingAvg,wicketsTaken;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ipl_players")
public class Player extends BaseEntity {
	@Column(length = 30,unique = true)
	private String email;
	@Column(length = 30,name="first_name")
	private String firstName;
	@Column(length = 30,name="last_name")
	private String lastName;
	private LocalDate dob;
	@Column(name="batting_avg")
	private double battingAvg;
	@Column(name="wickets_taken")
	private int wicketsTaken;
	//many to one , Player *----->1 Team
	@ManyToOne
	@JoinColumn(name="team_id")
	private Team myTeam;
	

	public Player() {
		// TODO Auto-generated constructor stub
	}

	public Player(String email, String firstName, String lastName, LocalDate dob, double battingAvg, int wicketsTaken) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	

	public Team getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(Team myTeam) {
		this.myTeam = myTeam;
	}

	@Override
	public String toString() {
		return "Player "+getId()+" [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}
	
}
