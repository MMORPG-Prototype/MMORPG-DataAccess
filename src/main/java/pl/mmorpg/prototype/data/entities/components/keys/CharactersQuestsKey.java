package pl.mmorpg.prototype.data.entities.components.keys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.mmorpg.prototype.data.entities.Character;
import pl.mmorpg.prototype.data.entities.Quest;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"character", "quest"})
public class CharactersQuestsKey implements Serializable
{
    @ManyToOne
    @JoinColumn(name="character_id")
    private Character character;
    
    @ManyToOne
    @JoinColumn(name="quest_id")
    private Quest quest;
}
