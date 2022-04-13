package actors;

/**
 * Actor Messages Type
 * 
 * @author Darshak Kachchhi, Mansi Lakhani, Apekshaba Gohil
 */

import models.SearchResult;

import java.util.LinkedHashMap;
import java.util.List;

public class Messages {
    public static final class SearchPageActorMessage{
        public final String query;
        public SearchPageActorMessage( String query) {
            this.query = query;
        }
    }

    public static final class LocalStatsActorMessage{
        public final String projectId;
        public LocalStatsActorMessage( String projectId) {
            this.projectId = projectId;
        }
    }

    public static final class GlobalStatsActorMessage{
        public GlobalStatsActorMessage( ) {
        }
    }

    public static final class ProfileDataActorMessage{
        public final Integer ownerId;
        public ProfileDataActorMessage( int ownerId ) {
            this.ownerId = ownerId;
        }
    }

    public static final class ProfileInfoActorMessage{
        public final Integer ownerId;
        public ProfileInfoActorMessage( int ownerId ) {
            this.ownerId = ownerId;
        }
    }

    public static final class SkillsSearchActorMessage{
        public final int query;
        public SkillsSearchActorMessage(int query){
            this.query = query;
        }
    }


}
