package actors;

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
}
