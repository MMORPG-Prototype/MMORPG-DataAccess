package pl.mmorpg.prototype.data.jsonconfig;

import org.hibernate.usertype.UserType;
import pl.mmorpg.prototype.data.entities.components.EntityQuestTask;

public class EntityQuestTaskJsonUserType extends JsonUserType implements UserType
{
    @Override
    public Class<EntityQuestTask> returnedClass()
    {
        return EntityQuestTask.class;
    }

}
