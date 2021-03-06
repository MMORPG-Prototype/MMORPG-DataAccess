package pl.mmorpg.prototype.data.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.mmorpg.prototype.data.entities.components.EntityQuestTask;
import pl.mmorpg.prototype.data.entities.jointables.CharactersQuests;

@Entity(name = "Quest")
@Table(name = "quests")
@Data
@EqualsAndHashCode(of="id")
public class Quest
{ 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", nullable = false, unique=true)
	private String name;

	@Column(name = "description", nullable = false)
	private String description;

	@Type(type = "pl.mmorpg.prototype.data.jsonconfig.EntityQuestTaskJsonUserType")
	@Column(name="quest_task", nullable = false, length = 10000)
	private EntityQuestTask questTask;
	
	@Column(name="gold_reward")
    private Integer goldReward = 0;

	@OneToMany(mappedBy = "quest", orphanRemoval = true, cascade = CascadeType.ALL)
    private Collection<QuestItemReward> itemsReward = new ArrayList<>(); 
	
	@OneToMany(mappedBy="key.quest")
    private Set<CharactersQuests> characters;
}

