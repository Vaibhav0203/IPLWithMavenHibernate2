package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Team fields :id name ,abbreviation, owner,maxAge,battingAvg,wicketsTaken
@Entity
@Table(name = "ipl_teams")
public class Team extends BaseEntity {
	@Column(length = 30, unique = true)
	private String name;
	@Column(length = 10, unique = true)
	private String abbreviation;
	@Column(length = 30)
	private String owner;
	@Column(name = "max_age")
	private int maxAge;
	@Column(name = "min_batting_avg")
	private double minBattingAvg;
	@Column(name = "min_wickets_taken")
	private int minWicketsTaken;
	// one to many association between entities Team 1---->* Player
	@OneToMany(mappedBy = "myTeam", cascade = CascadeType.ALL, 
			orphanRemoval = true)
	private List<Player> players = new ArrayList<>();

	public Team() {
		// TODO Auto-generated constructor stub
	}

	public Team(String name, String abbreviation, String owner, int maxAge, double minBattingAvg, int minWicketsTaken) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public double getMinBattingAvg() {
		return minBattingAvg;
	}

	public void setMinBattingAvg(double minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}

	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}

	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	//add helper methods : to link n de link bi dir asso between Team n player
	//addPlayer , removePlayer
	public void addPlayer(Player p)
	{
		players.add(p);//parent --> child
		p.setMyTeam(this);//child --> parent
	}
	public void removePlayer(Player p)
	{
		players.remove(p);
		p.setMyTeam(null);
	}


	@Override
	public String toString() {
		return "Team " + getId() + " [name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", minBattingAvg=" + minBattingAvg + ", minWicketsTaken=" + minWicketsTaken
				+ "]";
	}

}
