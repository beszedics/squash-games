package pti.sb_squash_games.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "results")
public class Result {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "first_user")
	private User firstUser;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "second_user")
	private User secondUser;
	
	@Column(name = "first_user_score")
	private Integer firstUserScore;
	
	@Column(name = "second_user_score")
	private Integer secondUserScore;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "winner")
	private User winner;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getFirstUser() {
		return firstUser;
	}

	public void setFirstUser(User firstUser) {
		this.firstUser = firstUser;
	}

	public User getSecondUser() {
		return secondUser;
	}

	public void setSecondUser(User secondUser) {
		this.secondUser = secondUser;
	}

	public Integer getFirstUserScore() {
		return firstUserScore;
	}

	public void setFirsUserScore(Integer firstUserScore) {
		this.firstUserScore = firstUserScore;
	}

	public Integer getSecondUserScore() {
		return secondUserScore;
	}

	public void setSecondUserScore(Integer secondUserScore) {
		this.secondUserScore = secondUserScore;
	}

	public User getWinner() {
		return winner;
	}

	public void setWinner(User winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", firstUserScore=" + firstUserScore + ", secondUserScore=" + secondUserScore
				+ ", winner=" + winner + "]";
	}	
}
